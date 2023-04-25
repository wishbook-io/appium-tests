package com.wishbook.catalog.PageObject.RegistrationPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class RegistrationPageFactory {
    public static RegistrationPageStrategy getStrategy(TestCase testCase) {
        RegistrationPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new RegistrationPageAndroidObject(testCase);
        }
        return strategy;
    }
}
