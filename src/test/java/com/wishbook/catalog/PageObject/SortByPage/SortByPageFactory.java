package com.wishbook.catalog.PageObject.SortByPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class SortByPageFactory {
    public static SortByPageStrategy getStrategy(TestCase testCase) {
        SortByPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new SortByPageAndroidObject(testCase);
        }
        return strategy;
    }
}
