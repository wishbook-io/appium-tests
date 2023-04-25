package com.wishbook.catalog.PageObject.MyBusinessPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageAndroidObject;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class MyBusinessPageFactory {
    public static MyBusinessPageStrategy getStrategy(TestCase testCase) {
        MyBusinessPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new MyBusinessPageReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new MyBusinessPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}