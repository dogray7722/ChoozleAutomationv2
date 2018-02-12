package com.choozle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class CampaignsPageFactory {

    WebDriver driver;

    public CampaignsPageFactory(WebDriver driver) { this.driver=driver; }

    @FindBy(how = How.ID,using = "startDate")
    WebElement startDate;

    @FindBy(how = How.XPATH,using = "//button[contains(@aria-label,'February 12')]")
    WebElement campaignStart;

    @FindBy(how = How.ID,using = "endDate")
    WebElement endDate;

    @FindBy(how = How.XPATH,using = "//button[contains(@aria-label,'February 13')]")
    WebElement campaignEnd;

    @FindBy(how = How.XPATH,using = "//input[@value=\"Save and Continue\"]")
    WebElement saveIt;

    String uuid = UUID.randomUUID().toString();

    public void clickElement(WebElement clickme)
    {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickme));
        element.click();
    }

    public void campaignsIndex()
    {
        driver.get("http://choozle.vm/campaigns");
    }

    public void newCampaign()
    {
        driver.get("http://choozle.vm/campaign/add/choozle");
    }

    public void sendCampaignName()
    {
       driver.findElement(By.xpath("//input[@name=\"campaignName\"]")).sendKeys(uuid);
    }

    public void clickStartDate()
    {
        clickElement(startDate);
    }

    public void setCampaignStart()
    {
        clickElement(campaignStart);
    }

    public void clickEndDate()
    {
        clickElement(endDate);
    }

    public void setCampaignEnd()
    {
        clickElement(campaignEnd);
    }

    public void setCampaignBudget()
    {
        driver.findElement(By.name("campaignBudget")).sendKeys("10.00");
    }

    public void setDailyBudget()
    {
        driver.findElement(By.name("campaignDailyBudget")).sendKeys("1.00");
    }

    public void sendToBeeswax()
    {
        clickElement(saveIt);
    }

    public void clickBannerAd()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().activeElement();

        driver.findElement(By.xpath("//button")).click();
    }

}
