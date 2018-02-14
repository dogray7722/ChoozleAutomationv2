package com.choozletests;

import com.choozle.data.DriverFactory;
import com.choozle.pages.PauseAccountFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PauseAccountTest extends DriverFactory {

    PauseAccountFactory czData;

    @BeforeClass
    public void setup() throws Exception
    {
        czData = PageFactory.initElements(driver, PauseAccountFactory.class);
    }

    @Test
    public void pauseAccount()
    {
       czData.accounts();
       czData.pauseAccount();
       Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/accounts_management");
    }

    @Test
    public void unpauseAccount()  {

        czData.accountStatusArrow();
        czData.paused();
        czData.unpause();
    }


}
