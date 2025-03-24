import Model.ContactData;
import Model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.TestBase;


public class ContactDeleteTest extends TestBase {
    @Test
    public void CanDeleteContact() {
        if (app.contact().getCount() == 0) {
            app.contact().createcontact(new ContactData("firstName", "middleName", "lastName","nickName","address", "phonesHome","email"));
        }
        int contactCount = app.contact().getCount();
        app.contact().deletecontact();
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(contactCount - 1, newContactCount);
    }

    @Test
    void  canDeleteALLContactAtOnce(){
        if (app.contact().getCount() == 0) {
            app.contact().createcontact(new ContactData("firstName", "middleName", "lastName","nickName","address", "phonesHome","email"));
        }
        app.contact().deleteALLContact();
        Assertions.assertEquals(0, app.contact().getCount());
    }
}
