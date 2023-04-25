package com.wishbook.catalog.PageObject.ProductAvailabilityDialogBox;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class ProductAvailabilityDialogBoxFactory {

    public static ProductAvailabilityDialogBoxStrategy getStrategy(TestCase testCase) {
        ProductAvailabilityDialogBoxStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new ProductAvailabilityDialogBoxAndroid(testCase);
        }
        return strategy;
    }

}
