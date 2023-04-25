package com.wishbook.catalog.PageObject.BrandISellPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

@SuppressWarnings("unused")

public class BrandISellPageFactory {
    public static BrandISellPageStrategy getStrategy(TestCase testCase) {
        BrandISellPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new BrandISellAndroidObject(testCase);
        }
        return strategy;
    }
}
