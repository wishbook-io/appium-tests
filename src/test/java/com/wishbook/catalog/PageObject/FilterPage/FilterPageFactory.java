package com.wishbook.catalog.PageObject.FilterPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class FilterPageFactory {
    public static FilterPageStrategy getStrategy(TestCase testCase) {
        FilterPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new FilterPageAndroidObject(testCase);
        }
        return strategy;
    }
}
