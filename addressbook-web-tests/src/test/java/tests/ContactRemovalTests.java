package tests;

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