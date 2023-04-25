package com.wishbook.catalog.PageObject.HomePage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageAndroidObject;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class HomePageFactory {

    public static HomePageStrategy getStrategy(TestCase testCase) {
        HomePageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new HomePageReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new HomePageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
