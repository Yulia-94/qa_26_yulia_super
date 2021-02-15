package com.presentation.scheduler.tests;

import com.presentation.scheduler.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginTest(){
        app.getUser().logIn(new User().withEmail("yuli@telran.com").withPassword("123456yY"));
       app.getUser().skipSettings();
       Assert.assertTrue(app.getUser().isLoggedIn());

    }


}
