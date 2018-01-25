package com.choozle.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
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

    @FindBy(how = How.XPATH,using = "//*[@id=\"accounts-list\"]/tbody/tr[1]/td[1]")
    WebElement account2pause;

    @FindBy(how = How.XPATH,using = ".//*[@id='accounts-list']/tbody/tr[1]/td[6]/a[2]")
    WebElement pauseAccount;

    @FindBy(how = How.CSS,using = "//*[@id=\"s2id_autogen1\"]/a/span[1]")
    WebElement accounttypedd;

    @FindBy(how = How.XPATH,using = "//*[@id=\"select2-drop\"]/ul/li[4]/div")
    WebElement paused;


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

    String useLater = "";

    public boolean isAlertPresent()
    {
        boolean presentFlag = false;

        try {
            Alert alert =driver.switchTo().alert();
            presentFlag = true;
            alert.accept();
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
        }

        return presentFlag;
    }

    public void pauseAccount() {
        useLater = account2pause.getText();
        System.out.println("We are pausing this account: " + useLater);
        clickElement(pauseAccount);
        isAlertPresent();
        System.out.println(useLater + " has been paused successfully");
    }

    public void unpause()
    {
        //Create an Array List of the table rows
        List<WebElement> table = driver.findElements(By.xpath(".//*[@id=\"accounts-list\"]//tr"));

        //Get the number of rows in the table - 1 to account for the table header
        int tableSize = table.size() - 1;
        System.out.println("The table has " + tableSize + " rows");

        //Create an Array List to hold our account names
        List<String> obj1 = new ArrayList();

        //Initialize a variable to hold the index for the table row with content that matches the string we defined above
        int match = 0;

        //Pump each account into our array
        for (int i = 0; i < tableSize; i++) {
            obj1.add(driver.findElement(By.xpath("//*[@id=\"accounts-list\"]/tbody/tr[" + (i + 1) + "]/td[1]")).getText());

            if (obj1.get(i).contains(useLater)) {
                match = i + 1;
                System.out.println("Click the Unpause account button on table row " + (match));
                driver.findElement(By.xpath("//*[@id=\"accounts-list\"]/tbody/tr[" + match + "]/td[6]/a")).click();
            }
        }
    }

    public void accountStatusArrow() { clickElement(accounttypedd); }

    public void paused() { clickElement(paused); }

}
