package com.choozle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class AdGroupPageFactory {

    WebDriver driver;

    public AdGroupPageFactory(WebDriver driver) { this.driver = driver; }

    @FindBy(how = How.XPATH,using = "//*[@id=\"react-select-3--value\"]/div[1]")
    WebElement geoInclude;

    @FindBy(how = How.XPATH,using = "//*[@id=\"react-select-3--value\"]/div[2]/input[@aria-activedescendant='react-select-3--option-0']")
    WebElement geoIncludeFirstChoice;

    @FindBy(how = How.XPATH,using = "//*[@id=\"react-select-4--value\"]/div[1]")
    WebElement geoExclude;

    @FindBy(how = How.XPATH,using = "//*[@id=\"react-select-4--value\"]/div[2]/input[@aria-activedescendant='react-select-3--option-0']")
    WebElement geoExcludeFirstChoice;

    @FindBy(how = How.XPATH,using = "//*[@id=\"react-select-5--value\"]/div[1]")
    WebElement siteListInclude;

    @FindBy(how = How.XPATH,using = "//*[@id=\"react-select-6--value\"]/div[1]")
    WebElement siteListExclude;

    @FindBy(how = How.XPATH,using = "//*[@id=\"react-select-7--value\"]/div[1]")
    WebElement catInclude;

    @FindBy(how = How.XPATH,using = "//*[@id=\"react-select-8--value\"]/div[1]")
    WebElement catExclude;

    @FindBy(how = How.XPATH,using = "//*[@id=\"react-select-9--value\"]/div[1]")
    WebElement retargInclude;

    @FindBy(how = How.XPATH,using = "//*[@id=\"react-select-10--value\"]/div[1]")
    WebElement retargExclude;

    @FindBy(how = How.XPATH,using = "//*[@id=\"react-select-11--value\"]/div[1]")
    WebElement InvSourceExclude;

    @FindBy(how = How.NAME,using = "frequencyCapImpressions")
    WebElement freqCapImpressions;

    @FindBy(how = How.NAME,using = "frequencyCapDuration")
    WebElement timeUnit;

    @FindBy(how = How.NAME,using = "includeMobile")
    WebElement devType;

    String uuid = UUID.randomUUID().toString();

    public void clickElement(WebElement clickme)
    {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickme));
        element.click();
    }

    public void newAdGroup() {

       driver.findElement(By.name("adGroupName")).sendKeys(uuid);

    }

    public void setTotalAdGroupBudget() {

        driver.findElement(By.name("totalBudget")).sendKeys("1.00");
    }

    public void setDailyAdGroupBudget() {

        driver.findElement(By.name("dailyBudget")).sendKeys("1.00");
    }

    public void setMaxCPMBid() {

        driver.findElement(By.name("maxCPM")).sendKeys("1.00");
    }

    public void setGeoInclude() {
        clickElement(geoInclude);
    }

    public void choozeFirstGeoInclude() {
        clickElement(geoIncludeFirstChoice);
    }

    public void setGeoExclude() {
        clickElement(geoExclude);
    }

    public void choozeFirstGeoExclude() {
        clickElement(geoExcludeFirstChoice);
    }

}
