package com.choozletests;

import com.choozle.data.DriverFactory;
import com.choozle.pages.ChoozlePageFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PauseAccountTest extends DriverFactory {

    ChoozlePageFactory czData;

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

//    public void selectDDValues()
//    {
//
//    }

    @BeforeClass
    public void setup() throws Exception
    {
        czData = PageFactory.initElements(driver, ChoozlePageFactory.class);
    }

    @Test
    public void AdminPage_pauseaccount()
    {
       czData.accounts();
       //Get the text of the account which we are pausing
       String accountToPause = driver.findElement(By.xpath("//*[@id=\"accounts-list\"]/tbody/tr[1]/td[1]")).getText();
       System.out.println("We are pausing this account: " + accountToPause);
       czData.pauseAccount();
       isAlertPresent();
       System.out.println(accountToPause + " has been paused successfully");
       Assert.assertEquals(driver.getCurrentUrl(), "http://choozle.vm/accounts_management");
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }



}
