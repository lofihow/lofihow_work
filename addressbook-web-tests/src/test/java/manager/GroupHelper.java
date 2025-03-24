package manager;

import Model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager){
        super(manager);
    }

    public void creategroup(GroupData group) {
        openGroupsPage();
        manager.driver.findElement(By.linkText("groups")).click();
        manager.driver.findElement(By.name("new")).click();
        manager.driver.findElement(By.name("group_name")).click();
        manager.driver.findElement(By.name("group_name")).sendKeys(group.group_name());
        manager.driver.findElement(By.name("group_header")).click();
        manager.driver.findElement(By.name("group_header")).sendKeys(group.group_header());
        manager.driver.findElement(By.name("group_footer")).click();
        manager.driver.findElement(By.name("group_footer")).sendKeys(group.getGroup_footer());
        manager.driver.findElement(By.name("submit")).click();
        manager.driver.findElement(By.linkText("groups")).click();
    }

    public void RemoveGroups() {
        openGroupsPage();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.name("delete")).click();
    }

    public int getCount() {
        openGroupsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeALLGroup() {
        openGroupsPage();
        selectALLGroups();
    }

    private void selectALLGroups() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for(var checkbox : checkboxes){
            checkbox.click();
        }
        manager.driver.findElement(By.name("delete")).click();
    }
}
