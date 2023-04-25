package com.wishbook.catalog.PageObject.OrderCancelNoteDialoge;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class OrderCancelNoteDialogeFactory {
    public static OrderCancelNoteDialogeStrategy getStrategy(TestCase testCase) {
        OrderCancelNoteDialogeStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new OrderCancelNoteDialogeAndroidObject(testCase);
        }
        return strategy;
    }
}
