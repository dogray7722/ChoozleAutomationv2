package com.choozle.data;

import org.testng.annotations.DataProvider;

public class DataPackage {

    //Args: URL, Title of Page
    @DataProvider(name = "pages")
    public static Object[][] pages() {
        return new Object[][] {
                {"http://choozle.vm/users/login", "Choozle: Digital Advertising Made Easy™"}
        };
    }

    @DataProvider(name = "login")
    public static Object[][] login() {
        return new Object[][]{
                {"devs@choozle.com", "choozle123"}
        };
    }

}



