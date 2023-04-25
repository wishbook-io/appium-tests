package com.wishbook.catalog.PageObject.ShareCatalogPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class ShareCatalogPageFactory {
    public static ShareCatalogPageStrategy getStrategy(TestCase testCase) {
        ShareCatalogPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new ShareCatalogPageAndroidObject(testCase);
        }
        return strategy;
    }
}
