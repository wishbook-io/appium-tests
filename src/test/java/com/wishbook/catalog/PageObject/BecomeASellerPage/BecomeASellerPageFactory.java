package com.wishbook.catalog.PageObject.BecomeASellerPage;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class BecomeASellerPageFactory {
    public static BecomeASellerPageStrategy getStrategy(TestCase testCase) {
        BecomeASellerPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new BecomeASellerPageAndroidObject(testCase);
        }
        return strategy;
    }
}
