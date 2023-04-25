package com.wishbook.catalog.PageObject.RegistrationSelectCompanyTypePage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class RegistrationSelectCompanyTypePageFactory {
    public static RegistrationSelectCompanyTypePageStrategy getStrategy(TestCase testCase) {
        RegistrationSelectCompanyTypePageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new RegistrationSelectCompanyTypePageAndroidObject(testCase);
        }
        return strategy;
    }
}
