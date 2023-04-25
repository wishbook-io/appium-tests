package com.wishbook.catalog.PageObject.OrderList;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageAndroidObject;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class OrderListFactory {
    public static OrderListStrategy getStrategy(TestCase testCase) {
        OrderListStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new OrderListReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new orderListAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
