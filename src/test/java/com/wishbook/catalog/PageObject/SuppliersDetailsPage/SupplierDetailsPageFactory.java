package com.wishbook.catalog.PageObject.SuppliersDetailsPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class SupplierDetailsPageFactory {
    public static SupplierDetailsPageStrategy getStrategy(TestCase testCase) {
        SupplierDetailsPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new SupplierDetailsPageAndroidObject(testCase);
        }
        return strategy;
    }
}
