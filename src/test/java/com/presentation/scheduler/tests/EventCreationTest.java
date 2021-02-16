package com.presentation.scheduler.tests;

import com.presentation.scheduler.model.Event;
import com.presentation.scheduler.model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EventCreationTest extends TestBase{

    @BeforeClass
    public void precondition(){
        if(!app.getUser().isLoggedIn()){
            app.getUser().logIn(new User().withEmail("yuli@telran.com").withPassword("123456yY"));
        }
    }

    @Test
    public void eventCreationTest(){
        app.event().initCreationNew();
        app.event().getSelectNextDay();
        app.event().fillCreationForm(new Event().withType("New Event").withTitle("meeting").withBreaks(2).withAmmout(50));
        app.event().confirmCreation();
      //  app.event().getCount();


    }
}
