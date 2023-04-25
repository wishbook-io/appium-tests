package com.wishbook.catalog.PageObject.ChangePassword;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageAndroidObject;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class ChangePasswordFactory {
    public static ChangePasswordStrategy getStrategy(TestCase testCase) {
        ChangePasswordStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new ChangePasswordReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new ChangePasswordAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
