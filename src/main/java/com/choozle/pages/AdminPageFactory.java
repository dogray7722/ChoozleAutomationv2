package com.choozle.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPageFactory {

    WebDriver driver;

    public AdminPageFactory(WebDriver driver) { this.driver=driver; }

    @FindBy(how = How.LINK_TEXT,using = "Tag Queue")
            WebElement tagqueue;

    @FindBy(how = How.LINK_TEXT,using = "Users")
            WebElement users;

    @FindBy(how = How.LINK_TEXT,using = "Master Accounts")
            WebElement masteraccounts;

    @FindBy(how = How.LINK_TEXT,using = "Reports")
            WebElement reports;

    @FindBy(how = How.LINK_TEXT,using = "RAFT")
            WebElement raft;

    @FindBy(how = How.LINK_TEXT,using = "CRM")
            WebElement crm;

    @FindBy(how = How.LINK_TEXT,using = "Promo Codes")
            WebElement promocodes;

    @FindBy(how = How.LINK_TEXT,using = "IP Searches")
            WebElement ipsearches;

    @FindBy(how = How.LINK_TEXT,using = "Content")
            WebElement content;

    @FindBy(how = How.LINK_TEXT,using = "Subscriptions")
            WebElement subscriptions;


    public void clickElement(WebElement clickme){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickme));
        element.click();
    }

    public void tagqueue()
    {
        clickElement(tagqueue);
    }

    public void users()
    {
        clickElement(users);
    }

    public void masteraccounts()
    {
        clickElement(masteraccounts);
    }

    public void reports()
    {
        clickElement(reports);
    }

    public void raft()
    {
        clickElement(raft);
    }

    public void crm()
    {
        clickElement(crm);
    }

    public void promocodes()
    {
        clickElement(promocodes);
    }

    public void ipsearches()
    {
        clickElement(ipsearches);
    }

    public void subscriptions()
    {
        clickElement(subscriptions);
    }

    public void content()
    {
        clickElement(content);
    }

}
