package com.choozle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class ChoozlePageFactory {

    WebDriver driver;

    public ChoozlePageFactory(WebDriver driver) { this.driver=driver; }

    @FindBy(how = How.ID,using = "UserEmail")
    WebElement username;

    @FindBy(how = How.ID,using = "UserPassword")
    WebElement password;

    @FindBy(how = How.XPATH,using = "//*[@id=\"UserLoginForm\"]/div[3]/div/div/input")
    WebElement submit;

    @FindBy(how = How.LINK_TEXT,using = "Logout")
    WebElement logout;

    @FindBy(how = How.LINK_TEXT,using = "My User Info")
    WebElement userinfo;

    @FindBy(how = How.LINK_TEXT,using = "My Accounts")
    WebElement accounts;

    @FindBy(how = How.LINK_TEXT,using = "Go to Admin")
    WebElement gotoadmin;

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

    @FindBy(how = How.LINK_TEXT,using = "Accounts")
    WebElement accountsmanagement;

    @FindBy(how = How.XPATH,using = "//*[@id=\"accounts-list\"]/tbody/tr[1]/td[6]/a[2]")
    WebElement account2pause;



    public void login_base(String uid, String pass){
        username.sendKeys(uid);
        password.sendKeys(pass);
        submit.click();
        click_hi_user();
    }

    public void click_hi_user()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Hi ")));
        element.click();
    }

    public void login_logout(String uid, String pass)
    {
        login_base(uid, pass);
        logout.click();
    }

    public void clickElement(WebElement clickme){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickme));
        clickme.click();
    }

    public void login_userinfo(String uid, String pass)
    {
        login_base(uid, pass);
        clickElement(userinfo);
    }

    public void login_myaccounts()
    {
        click_hi_user();
        clickElement(accounts);
    }

    public void gotoadmin()
    {
        click_hi_user();
        clickElement(gotoadmin);
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

    public void accounts()
    {
        clickElement(accountsmanagement);
    }

    public void pauseAccount() { clickElement(account2pause); }

}
