package com.wishbook.catalog.PageObject.SelectWareHouseDialog;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class SelectWareHouseDialogFactory {
    public static SelectWareHouseDialogStrategy getStrategy(TestCase testCase) {
        SelectWareHouseDialogStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new SelectWareHouseDialogAndroidObject(testCase);
        }
        return strategy;
    }
}
