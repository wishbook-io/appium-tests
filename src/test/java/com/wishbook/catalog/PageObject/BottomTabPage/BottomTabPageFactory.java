package com.wishbook.catalog.PageObject.BottomTabPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageAndroidObject;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class BottomTabPageFactory {
    public static BottomTabPageStrategy getStrategy(TestCase testCase) {
        BottomTabPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new BottomTabReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new BottomTabPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
