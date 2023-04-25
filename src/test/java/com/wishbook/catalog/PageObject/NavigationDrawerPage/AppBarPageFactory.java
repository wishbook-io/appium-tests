package com.wishbook.catalog.PageObject.NavigationDrawerPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class AppBarPageFactory {
    public static AppBarPageStrategy getStrategy(TestCase testCase) {
        AppBarPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new AppBarReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new AppBarPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
