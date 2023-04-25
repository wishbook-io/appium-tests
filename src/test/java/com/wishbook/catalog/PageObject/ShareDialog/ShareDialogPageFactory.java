package com.wishbook.catalog.PageObject.ShareDialog;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class ShareDialogPageFactory {

    public static ShareDialogStrategy getStrategy(TestCase testCase) {
        ShareDialogStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new ShareDialogAndroidObject(testCase);
        }
        return strategy;
    }
}
