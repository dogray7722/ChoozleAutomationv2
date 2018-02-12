package com.choozletests;

import com.choozle.data.DriverFactory;
import com.choozle.pages.AccountsPageFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountsPageTest extends DriverFactory {

    AccountsPageFactory czData;

    @BeforeClass
    public void setup() throws Exception
    {
        czData = PageFactory.initElements(driver, AccountsPageFactory.class);
    }

    @Test (priority = 1)
    public void targetAccount() {
        czData.clickTargetAccount();
    }

}
