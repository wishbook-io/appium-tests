package com.wishbook.catalog.PageObject.TabToSelectImage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class TabToSelectImageFactory {
    public static TabToSelectImageStrategy getStrategy(TestCase testCase) {
        TabToSelectImageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new TabToSelectImageAndroidObject(testCase);
        }
        return strategy;
    }
}
