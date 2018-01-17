package com.choozletests;

import com.choozle.data.DriverFactory;
import com.choozle.pages.ChoozlePageFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminPageTest extends DriverFactory{

    ChoozlePageFactory czData;

    @BeforeClass
    public void setup() throws Exception
    {
        czData = PageFactory.initElements(driver, ChoozlePageFactory.class);
    }

    @Test
    public void AdminPage_tagqueue()
    {
       czData.tagqueue();
       Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/admins/tag_queue/index");
    }

    @Test
    public void AdminPage_users()
    {
        czData.users();
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/admins/admins");
    }

    @Test
    public void AdminPage_masteraccounts()
    {
        czData.masteraccounts();
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/admins/master_account/index");
    }

    @Test
    public void AdminPage_reports()
    {
        czData.reports();
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/reports");
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }



}
