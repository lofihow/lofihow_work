package manager;
import Model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createcontact(ContactData contact) {
        openContactPage();
        manager.driver.findElement(By.linkText("add new")).click();
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstName());
        manager.driver.findElement(By.name("middlename")).click();
        manager.driver.findElement(By.name("middlename")).sendKeys(contact.middleName());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastName());
        manager.driver.findElement(By.name("nickname")).click();
        manager.driver.findElement(By.name("nickname")).sendKeys(contact.nickName());
        manager.driver.findElement(By.name("address")).click();
        manager.driver.findElement(By.name("address")).sendKeys(contact.address());
        manager.driver.findElement(By.name("mobile")).click();
        manager.driver.findElement(By.name("mobile")).sendKeys(contact.phonesHome());
        manager.driver.findElement(By.name("email")).click();
        manager.driver.findElement(By.name("email")).sendKeys(contact.email());
        manager.driver.findElement(By.name("bday")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("bday"));
            dropdown.findElement(By.xpath("//option[. = '8']")).click();
        }
        manager.driver.findElement(By.cssSelector("select:nth-child(61) > option:nth-child(10)")).click();
        manager.driver.findElement(By.name("bmonth")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("bmonth"));
            dropdown.findElement(By.xpath("//option[. = 'July']")).click();
        }
        manager.driver.findElement(By.cssSelector("select:nth-child(62) > option:nth-child(8)")).click();
        manager.driver.findElement(By.name("byear")).click();
        manager.driver.findElement(By.name("byear")).sendKeys("1941");
        manager.driver.findElement(By.name("aday")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("aday"));
            dropdown.findElement(By.xpath("//option[. = '12']")).click();
        }
        manager.driver.findElement(By.cssSelector("select:nth-child(66) > option:nth-child(14)")).click();
        {
            WebElement dropdown = manager.driver.findElement(By.name("amonth"));
            dropdown.findElement(By.xpath("//option[. = 'November']")).click();
        }
        manager.driver.findElement(By.cssSelector("select:nth-child(67) > option:nth-child(12)")).click();
        manager.driver.findElement(By.name("ayear")).click();
        manager.driver.findElement(By.name("ayear")).sendKeys("1955");
        manager.driver.findElement(By.cssSelector("input:nth-child(75)")).click();
    }

    public void deletecontact() {
        openContactPage();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.cssSelector(".left:nth-child(8) > input")).click();
    }

    public int getCount() {
        openContactPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }
    public void deleteALLContact() {
        openContactPage();
        selectALLContact();
    }

    private void selectALLContact() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for(var checkbox : checkboxes){
            checkbox.click();
        }
        manager.driver.findElement(By.cssSelector(".left:nth-child(8) > input")).click();
    }

}