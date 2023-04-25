package com.wishbook.catalog.PageObject.SelectBuyerGroupSpinner;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class SelectBuyerGroupSpinnerFactory {
    public static SelectBuyerGroupSpinnerStrategy getStrategy(TestCase testCase) {
        SelectBuyerGroupSpinnerStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new SelectBuyerGroupSpinnerAndroidObject(testCase);
        }
        return strategy;
    }
}
