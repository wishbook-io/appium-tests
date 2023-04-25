package com.wishbook.catalog.PageObject.OrderPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageAndroidObject;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class OrderPageFactory {
    public static OrderPageStrategy getStrategy(TestCase testCase) {
        OrderPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new OrderReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new OrderPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
