package com.wishbook.catalog.PageObject.ProfilePage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageAndroidObject;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class ProfilePageFactory {
    public static ProfilePageStrategy getStrategy(TestCase testCase) {
        ProfilePageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new ProfilePageReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new ProfilePageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
