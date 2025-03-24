import Model.ContactData;
import Model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import test.TestBase;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTest extends TestBase {

  public static List<ContactData> contactProvider() {
    var result = new ArrayList<ContactData>(List.of(
            new ContactData("First_name", "Middle_name", "Last_name", "Nickname", "address", "Telephone", "email")));
    for (int i = 0; i < 7; i++) {
      result.add(new ContactData(randomString(i * 2), randomString(i * 2), randomString(i * 2), randomString(i * 2), randomString(i * 2), randomString(i * 2), randomString(i * 2)));
    }
    return result;
  }


    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
      int contactCount = app.contact().getCount();
      app.contact().createcontact(contact);
      int newContactCount = app.contact().getCount();
      Assertions.assertEquals(contactCount + 1, newContactCount);
    }
  }