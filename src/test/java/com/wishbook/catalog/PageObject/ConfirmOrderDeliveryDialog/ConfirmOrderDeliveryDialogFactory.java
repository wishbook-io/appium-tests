package com.wishbook.catalog.PageObject.ConfirmOrderDeliveryDialog;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class ConfirmOrderDeliveryDialogFactory {
    public static ConfirmOrderDeliveryDialogStrategy getStrategy(TestCase testCase) {
        ConfirmOrderDeliveryDialogStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new ConfirmOrderDeliveryDialogAndroidObject(testCase);
        }
        return strategy;
    }
}
