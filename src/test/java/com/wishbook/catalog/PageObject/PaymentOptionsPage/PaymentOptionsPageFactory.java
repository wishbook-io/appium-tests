package com.wishbook.catalog.PageObject.PaymentOptionsPage;


import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class PaymentOptionsPageFactory {
    public static PaymentOptionsPageStrategy getStrategy(TestCase testCase) {
        PaymentOptionsPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new PaymentOptionsPageAndroidObject(testCase);
        }
        return strategy;
    }
}


