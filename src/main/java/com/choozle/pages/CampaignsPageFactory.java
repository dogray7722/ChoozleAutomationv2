package com.choozle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;
import java.util.Date;

public class CampaignsPageFactory {

    WebDriver driver;

    public CampaignsPageFactory(WebDriver driver) { this.driver=driver; }

    @FindBy(how = How.ID,using = "startDate")
    WebElement startDate;

    @FindBy(how = How.ID,using = "endDate")
    WebElement endDate;

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
        driver.get("http://app.choozle.vm/campaigns");
    }

    public void newCampaign()
    {
        driver.get("http://app.choozle.vm/campaign/add/choozle");
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
        Date dt = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d");
        String today = dateFormatter.format(dt);
        driver.findElement(By.xpath("//button[contains(@aria-label, '" + today + "')]")).click();

    }

    public void clickEndDate()
    {
        clickElement(endDate);
    }

    public void setCampaignEnd()
    {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE,1);
        dt = c.getTime();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d");
        String tomorrow = dateFormatter.format(dt);
        driver.findElement(By.xpath("//button[contains(@aria-label, '" + tomorrow + "')]")).click();
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
        WebDriverWait block = new WebDriverWait(driver,10);

        WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@style='box-sizing: border-box; padding: 1.875rem;']")));

        modal.findElement(By.xpath("//button")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Add Ad Group']")).isDisplayed());
    }

}
