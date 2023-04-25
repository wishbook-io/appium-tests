package com.wishbook.catalog.PageObject.ProductTypeDialogBox;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class ProductTypeDialogBoxFactory {
    public static ProductTypeDialogBoxStrategy getStrategy(TestCase testCase) {
        ProductTypeDialogBoxStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new ProductTypeDialogBoxAndroid(testCase);
        }
        return strategy;
    }
}
