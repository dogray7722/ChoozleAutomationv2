package com.choozletests;

import com.choozle.data.DataPackage;
import com.choozle.data.DriverFactory;
import org.openqa.selenium.support.PageFactory;
import com.choozle.pages.ChoozlePageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TitlePageTest extends DriverFactory {

    public String url = "http://choozle.vm/users/login";

    ChoozlePageFactory czData;

    @BeforeClass
    public void setup() throws Exception
    {
        czData = PageFactory.initElements(driver, ChoozlePageFactory.class);
    }

    @BeforeTest
    public void launchBrowser()
    {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test(dataProvider = "pages", dataProviderClass = DataPackage.class)
    public void TitlePageTest(String url, String title)
    {
        Assert.assertEquals(driver.getTitle(), title);
    }

    @Test(dataProvider = "login", dataProviderClass = DataPackage.class)
    public void LogInLogOut(String email, String pass)
    {
        czData.login_logout(email, pass);

        czData.login_userinfo(email, pass);
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/users/edit/1");
    }

    @Test(dataProvider = "login", dataProviderClass = DataPackage.class)
    public void MyAccounts(String email, String pass){
        czData.login_myaccounts(email, pass);
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/accounts");
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

}
