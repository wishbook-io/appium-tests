package com.wishbook.catalog.PageObject.CategoriesPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class CategoriesPageFactory {
    public static CategoriesPageStrategy getStrategy(TestCase testCase) {
        CategoriesPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new CategoriesPageAndroidObject(testCase);
        }
        return strategy;
    }
}
