package com.wishbook.catalog.PageObject.MyBrandsPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;
@SuppressWarnings("unused")
public class MyBrandsPageFactory {
    public static MyBrandsPageStrategy getStrategy(TestCase testCase) {
        MyBrandsPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new MyBrandsPageAndroidObject(testCase);
        }
        return strategy;
    }
}
