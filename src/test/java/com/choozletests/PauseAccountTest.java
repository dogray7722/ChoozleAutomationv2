package com.choozletests;

import com.choozle.data.DriverFactory;
import com.choozle.pages.ChoozlePageFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PauseAccountTest extends DriverFactory {

    ChoozlePageFactory czData;

    @BeforeClass
    public void setup() throws Exception
    {
        czData = PageFactory.initElements(driver, ChoozlePageFactory.class);
    }

    @Test
    public void pauseAccount()
    {
       czData.accounts();
       czData.pauseAccount();
       Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/accounts_management");
    }

    @Test
    public void unpauseAccount()  {

        czData.accountStatusArrow();
        czData.paused();
        czData.unpause();
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }



}
