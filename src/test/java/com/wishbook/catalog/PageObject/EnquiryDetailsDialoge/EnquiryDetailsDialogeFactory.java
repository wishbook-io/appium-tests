package com.wishbook.catalog.PageObject.EnquiryDetailsDialoge;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class EnquiryDetailsDialogeFactory {
    public static EnquiryDetailsDialogeStrategy getStrategy(TestCase testCase) {
        EnquiryDetailsDialogeStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new EnquiryDetailsDialogAndroidObject(testCase);
        }
        return strategy;
    }

}
