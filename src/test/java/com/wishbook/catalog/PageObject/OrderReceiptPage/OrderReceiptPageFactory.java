package com.wishbook.catalog.PageObject.OrderReceiptPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageAndroidObject;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class OrderReceiptPageFactory {
    public static OrderReceiptPageStrategy getStrategy(TestCase testCase) {
        OrderReceiptPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new OrderReceiptReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new OrderReceiptPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}