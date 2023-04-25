package com.wishbook.catalog.PageObject.IntroSliderPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageAndroidObject;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class IntroSliderPageFactory {
    public static IntroSliderPageStrategy getStrategy(TestCase testCase) {
        IntroSliderPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new IntroSliderPageReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new IntroSliderPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
