package com.wishbook.catalog.PageObject.BuyersRejectedPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class BuyersRejectedPageFactory {
    public static BuyersRejectedPageStrategy getStrategy(TestCase testCase) {
        BuyersRejectedPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new BuyersRejectedPageAndroidObject(testCase);
        }
        return strategy;
    }
}
