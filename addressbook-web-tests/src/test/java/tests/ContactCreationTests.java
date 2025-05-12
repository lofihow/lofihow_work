package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import common.CommonFunction;
import Model.ContactData;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ContactCreationTests extends TestBase {


    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
//        (List.of(new ContactData().withFistName("FirstName").withLastName("LastName").withAddress("Address").withPhoto("src/test/resources/images/avatar.jpg").withPhonesHome("phones").withEmail("email"),
//                new ContactData("", "First_name", "Middle_name", "Last_name", "Nickname", "address", "src/test/resources/images/avatar.jpg", "Telephone", "email")));
//        for (int i = 0; i < 7; i++) {
//            result.add(new ContactData("", CommonFunction.randomString(i * 2), CommonFunction.randomString(i * 2), CommonFunction.randomString(i * 2), CommonFunction.randomString(i * 2), CommonFunction.randomString(i * 2),randomFile("src/test/resources/images"), CommonFunction.randomString(i * 2), CommonFunction.randomString(i * 2)));
//        }
        var mapper = new JsonMapper();
        var value = mapper.readValue(new File("contacts.json"), new TypeReference<List<ContactData>>() {
        });
        result.addAll(value);
        return result;
    }

    public static List<ContactData> singleRandomContact() {
        return List.of(new ContactData()
                .withFistName(CommonFunction.randomString(5))
                .withLastName(CommonFunction.randomString(10))
                .withAddress(CommonFunction.randomString(10))
                .withMiddleName(CommonFunction.randomString(10))
                .withNickName(CommonFunction.randomString(10))
                .withPhoto("src/test/resources/images/avatar.jpg"));
    }

    @ParameterizedTest
    @MethodSource("singleRandomContact")
    public void canCreateMultipleGroups(ContactData contact) {
        var oldGroups = app.hbm().getContactList();
//        var oldGroups = app.contact().getList();
        app.contact().createContact(contact);
        var newGroups = app.hbm().getContactList();
//        var newGroups = app.contact().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(contact.withId(newGroups.get(newGroups.size() - 1).id()).withPhoto(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);
    }

    @ParameterizedTest
    @MethodSource("singleRandomContact")
    public void canCreateContactInGroup(ContactData contact) {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contact().createContact(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);

        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newRelated.sort(compareById);
        var expectedList = new ArrayList<>(oldRelated);
        expectedList.add(contact.withId(newRelated.get(newRelated.size() - 1).id()).withPhoto(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newRelated, expectedList);
    }

    @Test
    public void addContactInGroup() {
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
        var contactsAdd = app.hbm().getContactList();
        for (ContactData contactData : oldRelated) {
            contactsAdd.remove(contactData);
            if (contactsAdd.isEmpty()){
                app.contact().createContact(new ContactData()
                        .withFistName("FirstName")
                        .withLastName("LastName")
                        .withMiddleName("MiddleName")
                        .withPhoto("src/test/resources/images/avatar.jpg")
                        .withAddress("Address")
                        .withPhonesHome("phones")
                        .withEmail("email"));
                contactsAdd = app.hbm().getContactList();
                for (ContactData contactDataNew : oldRelated) {
                    contactsAdd.remove(contactDataNew);
                }
            }
        }
        var rnd = new Random();
        var index = rnd.nextInt(contactsAdd.size());
        app.contact().addContactIngroups(contactsAdd.get(index), group);
        var resultContactRelated = contactsAdd.get(index);
        var expectedRelated = app.hbm().getContactsInGroup(group);

        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        expectedRelated.sort(compareById);
        var actualList = new ArrayList<>(oldRelated);
        actualList.add(resultContactRelated);
        actualList.sort(compareById);
        Assertions.assertEquals(expectedRelated, actualList);
    }
}