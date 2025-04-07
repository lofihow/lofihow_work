package manager;
import Model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        opensContactCreatePage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void removalContact(ContactData contact) {
        opensHomePage();
        selectContact(contact);
        removeSelectedContact();
        returnToHomePage();
    }

    public void removalAllContact() {
        opensHomePage();
        selectAllContact();
        removeSelectedContact();
        opensHomePage();
    }

    public void modifyContact (ContactData contact, ContactData modifyContact){
        opensHomePage();
        selectContact(contact);
        initContactModification(contact);
        fillContactForm(modifyContact);
        submitContactModification();
        returnToHomePage();
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void opensHomePage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("home"));
        }
    }

    private void returnToHomePage() {
        click(By.linkText("home"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstName());
        type(By.name("middlename"), contact.middleName());
        type(By.name("lastname"), contact.lastName());
        type(By.name("nickname"), contact.nickName());
        type(By.name("address"), contact.address());
        attach(By.name("photo"), contact.photo());
        type(By.name("home"), contact.phonesHome());
        type(By.name("email"), contact.email());
    }

    private void opensContactCreatePage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("add new"));
        }
    }

    private void initContactModification(ContactData contact) {
        click(By.xpath(String.format("//a[@href=\"edit.php?id=%s\"]",contact.id())));
    }

    public int getCountContact() {
        opensHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    private void selectAllContact() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }


    private void submitContactModification() {
        click(By.name("update"));
    }



    public List<ContactData> getList() {
        opensHomePage();
        var contacts = new ArrayList<ContactData>();
        var spans = manager.driver.findElements(By.xpath("//tr[@name=\"entry\"]"));
        var lastNameList = manager.driver.findElements(By.xpath("//tr[@name=\"entry\"]//td[2]"));
        var firstNameList = manager.driver.findElements(By.xpath("//tr[@name=\"entry\"]//td[3]"));
        var addressNameList = manager.driver.findElements(By.xpath("//tr[@name=\"entry\"]//td[4]"));
        for (int i = 0; i < spans.size(); i++) {
            var checkbox = spans.get(i).findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            var lastName = lastNameList.get(i).getText();
            var firstName = firstNameList.get(i).getText();
            var addressName = addressNameList.get(i).getText();
            contacts.add(new ContactData().withId(id).withLastName(lastName).withFistName(firstName).withAddress(addressName));
        }
        return contacts;
    }
}