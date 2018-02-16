package com.choozle.pages;

import org.openqa.selenium.By;
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
        accountIdText = accountId.getText();
        System.out.println("The ID for the account is " + accountIdText);
        clickElement(account2Manage);
    }

    public void meth_accountSettings()
    {
        driver.get("http://app.choozle.vm/accounts_management/settings/" + accountIdText);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Total Margin ']")).isDisplayed());

    }

    public void meth_accountPayments()
    {
        driver.get("http://app.choozle.vm/accounts_management/payments/" + accountIdText);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Add a Custom Payment']")).isDisplayed());
    }

    public void meth_campaignFunds()
    {
        driver.get("http://app.choozle.vm/accounts_management/campaigns/" + accountIdText);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='s2id_autogen1']//span['Current Campaigns']")).isDisplayed());
    }

    public void meth_spendReport()
    {
        driver.get("http://app.choozle.vm/accounts_management/spend_report/" + accountIdText);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),\"Partner Spend Reports\")]")).isDisplayed());
    }

    public void meth_manageTags()
    {
        driver.get("http://app.choozle.vm/accounts_management/manage_tags/" + accountIdText);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"Ensighten Smart Tag\"]")).isDisplayed());
    }

    public void meth_changeLog()
    {
        driver.get("http://app.choozle.vm/accounts_management/changes/" + accountIdText);
        Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),\"Entity\")]")).isDisplayed());
    }

    public void meth_notes()
    {
        driver.get("http://app.choozle.vm/accounts_management/notes/" + accountIdText);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),\"New Note\")]")).isDisplayed());
    }

    public void meth_grapeshotLists()
    {
        driver.get("http://app.choozle.vm/accounts_management/grapeshot_lists/" + accountIdText);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"Grapeshot Form\"]")).isDisplayed());
    }

    public void backToApp()
    {
        System.out.println("Back to the App!");
        clickElement(backToApp);
        Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/accounts/index");
    }


}
