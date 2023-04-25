package com.wishbook.catalog.PageObject.SupplierRejectedPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;
@SuppressWarnings("unused")
public class SupplierRejectedPageFactory {
    public static SupplierRejectedPageStrategy getStrategy(TestCase testCase) {
        SupplierRejectedPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new SupplierRejectedPageAndroidObject(testCase);
        }
        return strategy;
    }
}
