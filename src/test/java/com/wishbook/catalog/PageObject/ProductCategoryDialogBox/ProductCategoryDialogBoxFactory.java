package com.wishbook.catalog.PageObject.ProductCategoryDialogBox;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class ProductCategoryDialogBoxFactory {


    public static ProductCategoryDialogBoxStrategy getStrategy(TestCase testCase) {
        ProductCategoryDialogBoxStrategy  strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new ProductCategoryDialogBoxAndroid(testCase);
        }
        return strategy;
    }

}
