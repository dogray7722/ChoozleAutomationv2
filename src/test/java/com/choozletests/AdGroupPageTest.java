package com.choozletests;

import com.choozle.data.DriverFactory;
import com.choozle.pages.AdGroupPageFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdGroupPageTest extends DriverFactory{

    AdGroupPageFactory czData;

    @BeforeClass
    public void setup() throws Exception
    {
        czData = PageFactory.initElements(driver,AdGroupPageFactory.class);
    }

    @Test (priority = 1)
    public void nameAdGroup() {
        czData.newAdGroup();
    }

    @Test (priority = 2)
    public void totalBudget() {
        czData.setTotalAdGroupBudget();
    }

    @Test (priority = 3)
    public void dailyBudget() {
        czData.setDailyAdGroupBudget();
    }

    @Test (priority = 4)
    public void maxBid() {
        czData.setMaxCPMBid();
    }

    @Test (priority = 5)
    public void geoInclude() {
        czData.setGeoInclude();
    }

    @Test (priority = 6)
    public void selectGeoInclude() {
        czData.choozeFirstGeoInclude();
    }

    @Test (priority = 7)
    public void geoExclude() {
        czData.setGeoExclude();
    }

    @Test (priority = 8)
    public void selectGeoExclude() {
        czData.choozeFirstGeoExclude();
    }

//    @AfterClass
//    public void tearDown()
//    {
//        driver.quit();
//    }

}
