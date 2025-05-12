package tests;
import manager.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {


    @Test
    void TestInfoContact() {
        var contacts = app.hbm().getContactList();
        var expectedPhones = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.home(), contact.mobile(), contact.work(), contact.secondary())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var expectedMail = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.email(), contact.email2(), contact.email3())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var expectedAddress = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.address())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var phones = app.contact().getPhones();
        var mail = app.contact().getMail();
        var address = app.contact().getAddress();
        Assertions.assertEquals(expectedPhones, phones);
        Assertions.assertEquals(expectedMail, mail);
        Assertions.assertEquals(expectedAddress, address);
    }
}