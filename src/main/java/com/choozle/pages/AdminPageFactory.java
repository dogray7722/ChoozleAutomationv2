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

    @FindBy(how = How.LINK_TEXT,using = "Tag Queue")//adminpagetest
            WebElement tagqueue;

    @FindBy(how = How.LINK_TEXT,using = "Users")//adminpagetest
            WebElement users;

    @FindBy(how = How.LINK_TEXT,using = "Master Accounts")//adminpagetest
            WebElement masteraccounts;

    @FindBy(how = How.LINK_TEXT,using = "Reports")//adminpagetest
            WebElement reports;

    @FindBy(how = How.LINK_TEXT,using = "RAFT")//adminpagetest
            WebElement raft;

    @FindBy(how = How.LINK_TEXT,using = "CRM")//adminpagetest
            WebElement crm;

    @FindBy(how = How.LINK_TEXT,using = "Promo Codes")//adminpagetest
            WebElement promocodes;

    @FindBy(how = How.LINK_TEXT,using = "IP Searches")//adminpagetest
            WebElement ipsearches;

    @FindBy(how = How.LINK_TEXT,using = "Content")//adminpagetest
            WebElement content;

    @FindBy(how = How.LINK_TEXT,using = "Subscriptions")//adminpagetest
            WebElement subscriptions;


    public void clickElement(WebElement clickme){//titlepagetest + everything else
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickme));
        clickme.click();
    }

    public void tagqueue()
    {
        clickElement(tagqueue);
    }//adminpagetest

    public void users()
    {
        clickElement(users);
    }//adminpagetest

    public void masteraccounts()
    {
        clickElement(masteraccounts);
    }//adminpagetest

    public void reports()
    {
        clickElement(reports);
    }//adminpagetest

    public void raft()
    {
        clickElement(raft);
    }//adminpagetest

    public void crm()
    {
        clickElement(crm);
    }//adminpagetest

    public void promocodes()
    {
        clickElement(promocodes);
    }//adminpagetest

    public void ipsearches()
    {
        clickElement(ipsearches);
    }//adminpagetest

    public void subscriptions()
    {
        clickElement(subscriptions);
    }//adminpagetest

    public void content()
    {
        clickElement(content);
    }//adminpagetest

}
