package com.wishbook.catalog.PageObject.BrandsPage;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class BrandPageFactory {

        public static BrandPageStrategy getStrategy(TestCase testCase) {
        BrandPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new BrandPageAndroidObject(testCase);
        }
        return strategy;
    }
}

