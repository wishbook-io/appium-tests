package com.wishbook.catalog.PageObject.MyNetworkPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class MyNetworkPageFactory {
    public static MyNetworkPageStrategy getStrategy(TestCase testCase) {
        MyNetworkPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new MyNetworkPageAndroidObject(testCase);
        }
        return strategy;
    }
}
