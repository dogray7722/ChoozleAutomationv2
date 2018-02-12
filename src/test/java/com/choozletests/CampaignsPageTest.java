package com.choozletests;

import com.choozle.data.DriverFactory;
import com.choozle.pages.CampaignsPageFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CampaignsPageTest extends DriverFactory{

    CampaignsPageFactory czData;

    @BeforeClass
    public void setup() throws Exception
    {
        czData = PageFactory.initElements(driver,CampaignsPageFactory.class);
    }

    @Test (priority = 1)
    public void goToCampaigns(){
        czData.campaignsIndex();
    }

    @Test (priority = 2)
    public void startNewCampaign(){
        czData.newCampaign();
    }

    @Test (priority = 3)
    public void writeCampaignName(){
        czData.sendCampaignName();

    }

    @Test (priority = 4)
    public void getStartDate(){
        czData.clickStartDate();
    }

    @Test (priority = 5)
    public void startCampaignOn(){
        czData.setCampaignStart();
    }

    @Test (priority = 6)
    public void getEndDate(){
        czData.clickEndDate();
    }

    @Test (priority = 7)
    public void stopCampaignOn(){
        czData.setCampaignEnd();
    }

    @Test (priority = 8)
    public void setBudget(){
        czData.setCampaignBudget();
    }

    @Test (priority = 9)
    public void setDaily(){
        czData.setDailyBudget();
    }

    @Test (priority = 10)
    public void clickSubmit() {
        czData.sendToBeeswax();
    }

    @Test (priority = 11)
    public void completeCampaign(){
        czData.clickBannerAd();
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }


}


