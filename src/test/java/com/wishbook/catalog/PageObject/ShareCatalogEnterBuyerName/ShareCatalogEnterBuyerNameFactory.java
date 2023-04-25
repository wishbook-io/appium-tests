package com.wishbook.catalog.PageObject.ShareCatalogEnterBuyerName;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class ShareCatalogEnterBuyerNameFactory {
    public static ShareCatalogEnterBuyerNameStrategy getStrategy(TestCase testCase) {
        ShareCatalogEnterBuyerNameStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new ShareCatalogEnterBuyerNameAndroidObject(testCase);
        }
        return strategy;
    }
}
