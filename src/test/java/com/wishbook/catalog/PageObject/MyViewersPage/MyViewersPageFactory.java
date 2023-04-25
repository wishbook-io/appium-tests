package com.wishbook.catalog.PageObject.MyViewersPage;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class MyViewersPageFactory {
    public static MyViewerPageStrategy getStrategy(TestCase testCase) {
        MyViewerPageStrategy  strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new MyViewersPageAndroidObject(testCase);
        }
        return strategy;
    }
}
