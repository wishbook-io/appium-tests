package com.wishbook.catalog.PageObject.MyCatalogPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class MyCatalogPageFactory {
    public static MyCatalogPageStrategy getStrategy(TestCase testCase) {
        MyCatalogPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new MyCatalogPageAndroidObject(testCase);
        }
        return strategy;
    }
}
