package com.choozle.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class PauseAccountFactory {

    WebDriver driver;

    public PauseAccountFactory(WebDriver driver) { this.driver=driver; }

    @FindBy(how = How.LINK_TEXT,using = "Accounts")
    WebElement accountsmanagement;

    @FindBy(how = How.XPATH,using = "//*[@id=\"accounts-list\"]/tbody/tr[1]/td[1]")
    WebElement account2pause;

    @FindBy(how = How.XPATH,using = ".//*[@id=\"accounts-list\"]/tbody/tr[1]/td[6]/a[2]")
    WebElement pauseAccount;

    @FindBy(how = How.XPATH,using = "//div[@class=\"large-2 columns\"]")
    WebElement accounttypedd;

    @FindBy(how = How.XPATH,using = "//select[@name='account_state']/option[text()='Paused']")
    WebElement paused;

    public void clickElement(WebElement clickme){//titlepagetest + everything else
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickme));
        element.click();
    }


    public void accounts()
    {
        clickElement(accountsmanagement);
    }

    String account2PauseText = "";

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
        account2PauseText = account2pause.getText();
        System.out.println("We are pausing this account: " + account2PauseText);
        clickElement(pauseAccount);
        isAlertPresent();
        System.out.println("\n" + account2PauseText + " has been paused successfully");
    }

    public void unpause()
    {
        //Create an Array List of the table rows
        List<WebElement> table = driver.findElements(By.xpath(".//*[@id=\"accounts-list\"]//tr"));

        //Get the number of rows in the table - 1 to account for the table header
        int tableSize = table.size() - 1;
        System.out.println("\n The table has " + tableSize + " rows");

        //Create an Array List to hold our account names
        List<String> obj1 = new ArrayList();

        //Initialize a variable to hold the index for the table row with content that matches the string we defined above
        int match = 0;

        //Pump each account into our array

        for (int i = 0; i < tableSize; i++) {
            obj1.add(driver.findElement(By.xpath("//*[@id=\"accounts-list\"]/tbody/tr[" + (i + 1) + "]/td[1]")).getText());

            if (obj1.get(i).contains(account2PauseText)) {
                match = i + 1;
                System.out.println("Click the Unpause account button on table row " + (match));
                WebDriverWait wait = new WebDriverWait(driver, 5);
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"accounts-list\"]/tbody/tr[" + match + "]/td[6]/a"))));
                element.click();
            }
        }
    }

    public void accountStatusArrow() { clickElement(accounttypedd);}

    public void paused() { clickElement(paused); }

}
