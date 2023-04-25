package com.wishbook.catalog.PageObject.MyFilterPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class MyFilterPageFactory {
    public static MyFilterPageStrategy getStrategy(TestCase testCase) {
        MyFilterPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new MyFilterPageAndroidObject(testCase);
        }
        return strategy;
    }
}
