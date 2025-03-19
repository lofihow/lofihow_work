import org.junit.jupiter.api.Test;
import test.TestBase;


public class ContactDeleteTest extends TestBase {

    @Test
    public void deletecontact() {
        if (!app.contact().isContactPresent()) {
            app.contact().createcontact();
        }
        app.contact().deletecontact();
    }
}
