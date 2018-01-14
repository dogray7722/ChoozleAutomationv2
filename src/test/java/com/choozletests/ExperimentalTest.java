//package com.choozletests;
//
//import com.choozle.data.DataPackage;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class ExperimentalTest {
//
//    public WebDriver driver;
//
//
//    @Test(dataProvider = "pages", dataProviderClass = DataPackage.class)
//    public void loadPage(String url, String title){
//        driver.get(url);
//        Assert.assertEquals(driver.getTitle(), title);
//    }
//}
