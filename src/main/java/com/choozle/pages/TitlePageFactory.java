package com.choozle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TitlePageFactory {

    WebDriver driver;

    public TitlePageFactory(WebDriver driver) { this.driver=driver; }

    @FindBy(how = How.ID,using = "UserEmail")//titlepagetest
            WebElement username;

    @FindBy(how = How.ID,using = "UserPassword")//titlepagetest
            WebElement password;

    @FindBy(how = How.XPATH,using = "//input[@type=\"submit\"]")//titlepagetest
            WebElement submit;

    @FindBy(how = How.LINK_TEXT,using = "Logout")//titlepagetest
            WebElement logout;

    @FindBy(how = How.LINK_TEXT,using = "My User Info")//titlepagetest
            WebElement userinfo;

    @FindBy(how = How.LINK_TEXT,using = "My Accounts")//titlepagetest
            WebElement accounts;

    @FindBy(how = How.LINK_TEXT,using = "Go to Admin")//titlepagetest
            WebElement gotoadmin;

    public void login_base(String uid, String pass){//titlepagetest
        username.sendKeys(uid);
        password.sendKeys(pass);
        submit.click();
        click_hi_user();
    }

    public void click_hi_user()//titlepagetest
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Hi ")));
        element.click();
    }

    public void login_logout(String uid, String pass)//titlepagetest
    {
        login_base(uid, pass);
        logout.click();
    }

    public void login_myaccounts()//titlepage
    {
        click_hi_user();
        clickElement(accounts);
    }

    public void gotoadmin()//titlepage
    {
        click_hi_user();
        clickElement(gotoadmin);
    }

    public void clickElement(WebElement clickme){//titlepagetest + everything else
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickme));
        clickme.click();
    }

    public void login_userinfo(String uid, String pass)//titlepagetest
    {
        login_base(uid, pass);
        clickElement(userinfo);
    }
}
