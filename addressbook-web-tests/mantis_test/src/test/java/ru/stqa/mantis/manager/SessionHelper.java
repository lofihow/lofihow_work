package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

import java.time.Duration;
import java.util.regex.Pattern;

public class SessionHelper extends HelperBase{
    public SessionHelper(ApplicationManager manager){
        super(manager);
    }

    public void login(String user, String password) {
         type(By.name("username"),user);
         click(By.cssSelector("input[type='submit']"));
         type(By.name("password"),password);
         click(By.cssSelector("input[type='submit']"));
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.cssSelector("span.user-info"));
    }

    public void registerUser(String user, String email) {
        click(By.xpath("//a[@href=\"signup_page.php\"]"));
        fillUserForm(user,email);
        click(By.cssSelector("input[type='submit']"));
    }

    private void fillUserForm(String user, String email) {
        type(By.name("username"),user);
        type(By.name("email"),email);
    }

    public void completingRegistrationUser(String email, String username) {
        var messages = manager.mail().receive(email,"password", Duration.ofSeconds(60));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher =  pattern.matcher(text);
        if (matcher.find()){
            var url = text.substring(matcher.start(), matcher.end());
            manager.driver().navigate().to(url);
        }
        type(By.name("realname"),username);
        type(By.name("password"),"password");
        type(By.name("password_confirm"),"password");
        click(By.cssSelector("button[type='submit']"));
    }
}
