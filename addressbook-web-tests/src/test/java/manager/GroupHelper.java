package manager;

import org.openqa.selenium.By;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager){
        super(manager);
    }

    public void CreateGroup() {
        openGroupsPage();
        manager.driver.findElement(By.linkText("groups")).click();
        manager.driver.findElement(By.name("new")).click();
        manager.driver.findElement(By.name("group_name")).click();
        manager.driver.findElement(By.name("group_name")).sendKeys("group_name");
        manager.driver.findElement(By.name("group_header")).click();
        manager.driver.findElement(By.name("group_header")).sendKeys("group_header");
        manager.driver.findElement(By.name("group_footer")).click();
        manager.driver.findElement(By.name("group_footer")).sendKeys("group_footer");
        manager.driver.findElement(By.name("submit")).click();
        manager.driver.findElement(By.linkText("groups")).click();
    }

    public void RemoveGroup() {
        openGroupsPage();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.name("delete")).click();
    }
}
