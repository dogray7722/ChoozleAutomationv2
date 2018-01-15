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

    @FindBy(how = How.CSS,using = "regionLabel")
    WebElement accounts;

    public void login_base(String uid, String pass){
        username.sendKeys(uid);
        password.sendKeys(pass);
        submit.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Hi ")));
        element.click();
    }

    public void login_logout(String uid, String pass)
    {
        login_base(uid, pass);
        logout.click();
    }

    public void login_choozle(String uid, String pass)
    {
        login_base(uid, pass);
        WebDriverWait wait1 = new WebDriverWait(driver, 6);
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("User Info")));
        element1.click();
    }


}
