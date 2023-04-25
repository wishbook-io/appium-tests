package com.wishbook.catalog.PageObject.BuyerDetailsPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class BuyerDetailsFactory {
    public static BuyerDetailsStrategy getStrategy(TestCase testCase) {
        BuyerDetailsStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new BuyerDetailsAndroidObject(testCase);
        }
        return strategy;
    }
}
