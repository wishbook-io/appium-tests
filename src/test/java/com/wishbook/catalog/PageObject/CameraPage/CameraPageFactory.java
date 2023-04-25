package com.wishbook.catalog.PageObject.CameraPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class CameraPageFactory {
    public static CameraPageStrategy getStrategy(TestCase testCase) {
        CameraPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new CameraPageAndroidObject(testCase);
        }
        return strategy;
    }
}
