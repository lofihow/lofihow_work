package manager;

import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    void login(String user, String password) {
        manager.driver.findElement(By.name("user")).click();
        manager.driver.findElement(By.name("user")).sendKeys(user);
        manager.driver.findElement(By.id("LoginForm")).click();
        manager.driver.findElement(By.name("pass")).click();
        manager.driver.findElement(By.name("pass")).sendKeys(password);
        manager.driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }

    public void logout() {
        manager.driver.findElement(By.linkText("Logout")).click();
        manager.driver.quit();
    }
}
