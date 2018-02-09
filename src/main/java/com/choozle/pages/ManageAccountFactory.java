package com.choozle.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ManageAccountFactory {

    WebDriver driver;

    public ManageAccountFactory(WebDriver driver) { this.driver=driver; }

    @FindBy(how = How.XPATH,using = "//tbody/tr/td[6]/a")
    WebElement account2Manage;

    @FindBy(how = How.XPATH,using = "//tbody/tr/td[3]")
    WebElement accountId;

    @FindBy(how = How.LINK_TEXT,using = "Account Settings")
    WebElement accountSettings;

    @FindBy(how = How.LINK_TEXT,using = "Account Payments")
    WebElement accountPayments;

    @FindBy(how = How.LINK_TEXT,using = "Campaign Funds")
    WebElement campaignFunds;

    @FindBy(how = How.LINK_TEXT,using = "Spend Report")
    WebElement spendReport;

    @FindBy(how = How.LINK_TEXT,using = "Manage Tags")
    WebElement manageTags;

    @FindBy(how = How.LINK_TEXT,using = "Change Log")
    WebElement changeLog;

    @FindBy(how = How.LINK_TEXT,using = "Notes")
    WebElement notes;

    @FindBy(how = How.LINK_TEXT,using = "Grapeshot List")
    WebElement grapeshotList;

    @FindBy(how = How.LINK_TEXT,using = "Back to the App")
    WebElement backToApp;

    String accountIdText = "";

    public void clickElement(WebElement clickme){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickme));
        element.click();
    }

    public void manageAccount()
    {
        System.out.println("The ID for the account is " + accountId.getText());
        clickElement(account2Manage);
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/accounts_management/sites/" + accountId.getText());
    }

    public void meth_accountSettings()
    {
        clickElement(accountSettings);
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/accounts_management/settings/" + accountId.getText());
    }

    public void meth_accountPayments()
    {
        clickElement(accountPayments);
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/accounts_management/payments/" + accountId.getText());
    }

    public void meth_campaignFunds()
    {
        clickElement(campaignFunds);
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/accounts_management/campaigns/" + accountId.getText());
    }

    public void meth_spendReport()
    {
        clickElement(spendReport);
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/accounts_management/spend_report/" + accountId.getText());
    }

    public void meth_manageTags()
    {
        clickElement(manageTags);
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/accounts_management/manage_tags/" + accountId.getText());
    }

    public void meth_changeLog()
    {
        clickElement(changeLog);
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/accounts_management/changes/" + accountId.getText());
    }

    public void meth_notes()
    {
        clickElement(notes);
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/accounts_management/notes/" + accountId.getText());
    }


    public void meth_grapeshotLists()
    {
        clickElement(grapeshotList);
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/accounts_management/grapeshot_lists/" + accountId.getText());
    }

    public void backToApp()
    {
        System.out.println("Back to the App!");
        clickElement(backToApp);
        Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/accounts/index");
    }


}