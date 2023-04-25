package com.wishbook.catalog.PageObject.EnterDispatchDetailsPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class EnterDispatchedDetailsPageFactory {
    public static EnterDispatchedDetailsPageStrategy getStrategy(TestCase testCase) {
        EnterDispatchedDetailsPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new EnterDispatchedDetailsPageAndroidObject(testCase);
        }
        return strategy;
    }
}
