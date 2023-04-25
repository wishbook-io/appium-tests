package com.wishbook.catalog.PageObject.FilterCatalogSavedDialogPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class FilterCatalogSavedDialogPageFactory {
    public static FilterCatalogSavedDialogPageStrategy getStrategy(TestCase testCase) {
        FilterCatalogSavedDialogPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new FilterCatalogSavedDialogPageAndroidObject(testCase);
        }
        return strategy;
    }
}
