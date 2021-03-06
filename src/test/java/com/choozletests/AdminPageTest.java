package com.choozletests;

import com.choozle.data.DriverFactory;
import com.choozle.pages.AdminPageFactory;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminPageTest extends DriverFactory{

    AdminPageFactory czData;

    @BeforeClass
    public void setup() throws Exception
    {
        czData = PageFactory.initElements(driver, AdminPageFactory.class);
    }

    @Test (priority = 1)
    public void AdminPage_tagqueue()
    {
       czData.tagqueue();
       Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/admins/tag_queue/index");
    }

    @Test (priority = 2)
    public void AdminPage_users()
    {
        czData.users();
        Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/admins/admins");
    }

    @Test (priority = 3)
    public void AdminPage_masteraccounts()
    {
        czData.masteraccounts();
        Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/admins/master_account/index");
    }

    @Test (priority = 4)
    public void AdminPage_reports()
    {
        czData.reports();
        Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/reports");
    }

    @Test (priority = 5)
    public void AdminPage_raft()
    {
        czData.raft();
        Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/admins/raft/index");
    }

    @Test (priority = 6)
    public void AdminPage_crm()
    {
        czData.crm();
        Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/admins/crm/index");
    }

    @Test (priority = 7)
    public void AdminPage_promocodes()
    {
        czData.promocodes();
        Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/coupons");
    }

    @Test (priority = 8)
    public void AdminPage_ipsearches()
    {
        czData.ipsearches();
        Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/admin/ip_database/index");
    }

    @Test (priority = 9)
    public void AdminPage_subscriptions()
    {
        czData.subscriptions();
        Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/subscriptions");
    }

    @Test (priority = 10)
    public void AdminPage_content()
    {
        czData.content();
        Assert.assertEquals(driver.getCurrentUrl(), "http://app.choozle.vm/c_m_s_pages");
    }


}
