package com.wishbook.catalog.PageObject.DiscountSettingPage;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class  DiscountSettingPageFactory {
    public static DiscountSettingPageStrategy getStrategy(TestCase testCase) {
        DiscountSettingPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new DiscountSettingPageAndroid(testCase);
        }
        return strategy;
    }

}