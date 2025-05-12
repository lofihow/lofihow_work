package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunction;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTests extends TestBase{

    @Test
    void canRegisterUser(){
        var username = CommonFunction.randomString(8);
        var email = String.format("%s@localhost", username);
        app.jamesCli().addUser(email, "password");
        app.session().registerUser(username,email);
        app.mail().receive(email,"password", Duration.ofSeconds(60));
        app.session().completingRegistrationUser(email,username);
        app.http().login(username,"password");
        Assertions.assertTrue(app.http().isLoggedIn());
    }

    @Test
    void canRegisterApiUser(){
        var username = CommonFunction.randomString(8);
        var email = String.format("%s@localhost", username);
        app.jamesApi().addUser(email, "password");
        app.mantisApi().registerUser(username,email);
        app.mail().receive(email,"password", Duration.ofSeconds(60));
        app.session().completingRegistrationUser(email,username);
        app.http().login(username,"password");
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}
