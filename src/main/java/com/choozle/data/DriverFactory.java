package com.choozle.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class DriverFactory {

    public static WebDriver driver = null;

    @BeforeTest
    @Parameters ( { "browser" } )
        public static WebDriver startDriver(String browser)
    {
        if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/geckodriver");
        }
        else if (browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/chromedriver");
        }
        else if (browser.equalsIgnoreCase("safari"))
        {
            driver = new SafariDriver();
        }

        return driver;
    }

    @AfterTest
    public void shutDown()
    {
        driver.quit();
    }

}
