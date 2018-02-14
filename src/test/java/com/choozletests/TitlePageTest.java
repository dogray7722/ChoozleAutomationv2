package com.choozletests;

import com.choozle.data.DataPackage;
import com.choozle.data.DriverFactory;
import org.openqa.selenium.support.PageFactory;
import com.choozle.pages.TitlePageFactory;
import org.testng.annotations.*;
import org.testng.Assert;

public class TitlePageTest extends DriverFactory {

    public String url = "http://app.choozle.vm/users/login";

    TitlePageFactory czData;

    @BeforeClass
    public void setup() throws Exception
    {
        czData = PageFactory.initElements(driver, TitlePageFactory.class);
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

        Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/users/edit/1");
    }

    @Test
    public void MyAccounts(){
        czData.login_myaccounts();
        Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/accounts");

        czData.gotoadmin();
        Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/admins/master_account/index");
    }



}
