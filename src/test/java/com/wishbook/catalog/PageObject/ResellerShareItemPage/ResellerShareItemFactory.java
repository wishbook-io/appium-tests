package com.wishbook.catalog.PageObject.ResellerShareItemPage;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class ResellerShareItemFactory {

       public static ResellerShareItemStrategy getStrategy(TestCase testCase) {
        ResellerShareItemStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new ResellerShareItemAndroid(testCase);
        }
        return strategy;
    }

}
