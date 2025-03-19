import org.junit.jupiter.api.Test;
import test.TestBase;

public class ContactCreationTest extends TestBase {

  @Test
  public void CanCreateContact() {

    app.contact().createcontact();
  }
}
