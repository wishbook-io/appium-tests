package com.wishbook.catalog.PageObject.CatalogReceivedPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class CatalogReceivedPageFactory {
    public static CatalogReceivedPageStrategy getStrategy(TestCase testCase) {
        CatalogReceivedPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new CatalogReceivedPageAndroidObject(testCase);
        }
        return strategy;
    }
}
