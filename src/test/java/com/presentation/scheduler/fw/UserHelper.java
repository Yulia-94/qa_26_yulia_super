package com.presentation.scheduler.fw;

import com.presentation.scheduler.model.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class UserHelper extends HelperBase{


    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void logIn(String email, String password) throws InterruptedException {
        //clickOnLoginButton
        clickByCss("[href='/login']");
        fillLoginForm(new User().setEmail(email).setPassword(password));
        pause(2000);
        clickByCss("[type='submit']");
    }

    public boolean isRegistrationFormPresent() {
        return isElementPresent(By.xpath("//h2[contains(.,'Registration')]"));
    }

    public void selectCheckBox() {
        click(By.cssSelector("#check_policy"));
    }

    public void fillRegistrationForm(User user) {
        type(By.cssSelector("#first_name"), user.getfName());
        type(By.cssSelector("#second_name"), user.getlName());
        System.out.println("email is:" + user.getEmail());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void openRegForm() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void fillLoginForm(User user) {
        typeByCss("[name=email]", user.getEmail());
        typeByCss("[name=password]", user.getPassword());
    }

    public void clickLogoutButtonHeader() {
        click(By.xpath("//a[contains(., 'logOut')]"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(., 'logOut')]"));
    }

    public void clickOnLoginButton() {
        clickByCss("[href='/login']");
    }

}
