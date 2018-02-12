package com.choozle.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsPageFactory {

    WebDriver driver;

    public AccountsPageFactory(WebDriver driver) { this.driver=driver; }

    @FindBy(how = How.XPATH,using = "//tbody/tr/td[2]")
    WebElement targetAccount;

    public void clickElement(WebElement clickme){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickme));
        element.click();
    }

    public void clickTargetAccount()
    {
        clickElement(targetAccount);
    }
}
