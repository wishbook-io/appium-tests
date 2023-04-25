package com.wishbook.catalog.PageObject.ProductSpinner;


import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class ProductSpinnerFactory {
    public static ProductSpinnerStrategy getStrategy(TestCase testCase) {
        ProductSpinnerStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new ProductSpinnerAndroidObject(testCase);
        }
        return strategy;
    }

}
