package tests;

import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Model.ContactData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {
    @Test
    void canModifyContact(){
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
        var oldContact = app.hbm().getContactList();
        var rnd  = new Random();
        var index = rnd.nextInt(oldContact.size());
        var testData = new ContactData().withFistName("Modify firstName").withMiddleName("Modify middleName").withPhoto("src/test/resources/images/avatar.jpg");
        app.contact().modifyContact(oldContact.get(index), testData);
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContact);
        expectedList.set(index, testData.withId(oldContact.get(index).id()).withPhoto(oldContact.get(index).photo()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

}
