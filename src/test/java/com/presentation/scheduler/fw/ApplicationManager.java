package com.presentation.scheduler.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    //Properties properties;
    AppiumDriver driver;
    UserHelper user;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    DesiredCapabilities capabilities;
    EventHelper event;


    //public ApplicationManager(String browser) {
    //     this.browser = browser;
    //     properties = new Properties();
    // }


    public void start() throws IOException {
        // String target =System.getProperty("target", "local");
        // properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        // wd.navigate().to(properties.getProperty("web.baseURL")); //"https://ilcarro-dev-v1.firebaseapp.com/");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "qa26");
        capabilities.setCapability( "platformVersion", "8.0");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "C:/Testing/v.0.0.3.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);



        logger.info("App version: " + getAppVersion());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user = new UserHelper(driver);
        event = new EventHelper(driver);
    }

    public String getAppVersion(){
        return driver.findElement(By.xpath("//*[@resource-id='com.example.svetlana.scheduler:id/app_version_res']")).getText();
    }

    // public String setEmail(){
    //     return properties.getProperty("web.email");
    //  }

    // public String setPassword(){
    //  return properties.getProperty("web.password");
    // }

    public void stop() {

        driver.quit();
    }


    public UserHelper getUser() {
        return user;
    }

    public EventHelper event() {
        return event;
    }
}
