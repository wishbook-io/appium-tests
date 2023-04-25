package com.wishbook.catalog.PageObject.NewSalesOrderPage;


import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class NewSalesOrderPageFactory {
    public static NewSalesOrderPageStrategy getStrategy(TestCase testCase) {
        NewSalesOrderPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new NewSalesOrderPageAndroidObject(testCase);
        }
        return strategy;
    }
}