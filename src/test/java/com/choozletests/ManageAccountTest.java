package com.choozletests;

import com.choozle.data.DriverFactory;
import com.choozle.pages.ManageAccountFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ManageAccountTest extends DriverFactory{

    ManageAccountFactory czData;

    @BeforeClass
    public void setup() throws Exception
    {
        czData = PageFactory.initElements(driver, ManageAccountFactory.class);
    }

    @Test (priority = 1)
    public void clickAccount(){
        czData.manageAccount();
    }

    @Test (priority = 2)
    public void accSettings()
    {
        czData.meth_accountSettings();
    }

    @Test (priority = 3)
    public void accPayments()
    {
        czData.meth_accountPayments();
    }

    @Test (priority = 4)
    public void campFunds()
    {
        czData.meth_campaignFunds();
    }

    @Test (priority = 5)
    public void spendRep()
    {
        czData.meth_spendReport();
    }

    @Test (priority = 6)
    public void manTags()
    {
        czData.meth_manageTags();
    }

    @Test (priority = 7)
    public void changLog()
    {
        czData.meth_changeLog();
    }

    @Test (priority = 8)
    public void notez()
    {
        czData.meth_notes();
    }

    @Test (priority = 9)
    public void grapeList()
    {
        czData.meth_grapeshotLists();
    }

    @Test (priority = 10)
    public void back2App()
    {
        czData.backToApp();
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
