package com.wishbook.catalog.PageObject.FilterCatalogDeleteDialogPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class FilterCatalogDeleteDialogPageFactory {
    public static FilterCatalogDeleteDialogPageStrategy getStrategy(TestCase testCase) {
        FilterCatalogDeleteDialogPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new FilterCatalogDeleteDeleteDialogPageAndroidObject(testCase);
        }
        return strategy;
    }
}
