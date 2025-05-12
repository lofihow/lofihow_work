package manager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import manager.hbm.ContactRecord;
import manager.hbm.GroupRecord;
import Model.ContactData;
import Model.GroupData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    public HibernateHelper (ApplicationManager manager){
        super(manager);


        sessionFactory = new Configuration()
                .addAnnotatedClass(ContactRecord.class)
                .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook?zeroDateTimeBehavior=convertToNull")
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    static List<GroupData> convertList(List<GroupRecord> records){
        return records.stream().map(HibernateHelper::convert).collect(Collectors.toList());
    }

    private static GroupData convert(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    private static GroupRecord convert(GroupData data) {
        var id = data.id();
        if ("".equals(id)){
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }
    @Step
    public List<GroupData> getGroupList(){
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }

    public long getGroupCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupRecord", Long.class).getSingleResult();
        });
    }
    @Step
    public void createGroup(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(groupData));
            session.getTransaction().commit();
        });
    }

    static List<ContactData> converContactList(List<ContactRecord> records){
        return records.stream().map(HibernateHelper::convert).collect(Collectors.toList());
    }
    private static ContactData convert(ContactRecord record) {
        return new ContactData().withId(""+record.id)
                .withFistName(record.firstname)
                .withMiddleName(record.middlename)
                .withLastName(record.lastname)
                .withNickName(record.nickname)
                .withAddress(record.address)
                .withHome(record.home)
                .withMobile(record.mobile)
                .withWork(record.work)
                .withSecondary(record.phone2)
                .withEmail(record.email)
                .withEmailSecond(record.email2)
                .withEmailThree(record.email3);
    }

    private static ContactRecord convert(ContactData data) {
        var id = data.id();
        if ("".equals(id)){
            id = "0";
        }
        return new ContactRecord(Integer.parseInt(id), data.firstName(), data.middleName(),data.lastName(),data.nickName(),data.address());
    }

    public List<ContactData> getContactList(){
        return converContactList(sessionFactory.fromSession(session -> {
            return session.createQuery("from ContactRecord", ContactRecord.class).list();
        }));
    }

    public List<ContactData> getContactsInGroup(GroupData group) {
        return sessionFactory.fromSession(session -> {
            return converContactList (session.get(GroupRecord.class,group.id()).contacts);
        });
    }
}