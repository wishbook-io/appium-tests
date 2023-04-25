package com.wishbook.catalog.PageObject.KycAndBankDeatilsPage;


import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class KycAndBankDetailsPageFactory {
    public static KycAndBankDetailsPageStrategy getStrategy(TestCase testCase) {
        KycAndBankDetailsPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new KycAndBankDetailsPageAndroidObject(testCase);
        }
        return strategy;
    }
}