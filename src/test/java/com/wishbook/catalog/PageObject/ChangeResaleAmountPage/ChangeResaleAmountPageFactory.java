package com.wishbook.catalog.PageObject.ChangeResaleAmountPage;


import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class ChangeResaleAmountPageFactory {
    public static ChangeResaleAmountPageStrategy getStrategy(TestCase testCase) {
        ChangeResaleAmountPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new ChangeResaleAmountPageAndroid(testCase);
        }
        return strategy;
    }
}
