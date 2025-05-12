package tests;

import Model.GroupData;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Model.ContactData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contact().getCountContact() == 0) {
            app.contact().createContact(new ContactData()
                    .withFistName("FirstName")
                    .withLastName("LastName")
                    .withMiddleName("MiddleName")
                    .withPhoto("src/test/resources/images/avatar.jpg")
                    .withAddress("Address")
                    .withPhonesHome("phones")
                    .withEmail("email"));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contact().removalContact(oldContacts.get(index));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        var newContacts = app.hbm().getContactList();
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    public void RemoveContactInGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        if (app.contact().getCountContact() == 0) {
            app.contact().createContact(new ContactData()
                    .withFistName("FirstName")
                    .withLastName("LastName")
                    .withMiddleName("MiddleName")
                    .withPhoto("src/test/resources/images/avatar.jpg")
                    .withAddress("Address")
                    .withPhonesHome("phones")
                    .withEmail("email"));
        }
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        if (oldRelated.isEmpty()) {
            var contacts = app.hbm().getContactList();
            var rnd = new Random();
            var index = rnd.nextInt(contacts.size());
            app.contact().addContactIngroups(contacts.get(index), group);
        }
        var rnd = new Random();
        var newRelated = app.hbm().getContactsInGroup(group);
        var index = rnd.nextInt(newRelated.size());
        var resultRemovalContact = app.hbm().getContactsInGroup(group).get(index);
        app.contact().removalContactInGroup(newRelated.get(index), group);
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        var expectedRelated = app.hbm().getContactsInGroup(group);
        expectedRelated.sort(compareById);
        var actualRelated = new ArrayList<>(newRelated);
        actualRelated.remove(resultRemovalContact);
        actualRelated.sort(compareById);
        Assertions.assertEquals(expectedRelated, actualRelated);
    }

    @Test
    public void canRemoveAllContact() {
        if (app.contact().getCountContact() == 0) {
            app.contact().createContact(new ContactData()
                    .withFistName("FirstName")
                    .withLastName("LastName")
                    .withMiddleName("MiddleName")
                    .withPhoto("src/test/resources/images/avatar.jpg")
                    .withAddress("Address")
                    .withPhonesHome("phones")
                    .withEmail("email"));
        }
        app.contact().removalAllContact();
        Assertions.assertEquals(0, app.contact().getCountContact());
    }
}