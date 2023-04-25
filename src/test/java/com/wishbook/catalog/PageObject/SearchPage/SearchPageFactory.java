package com.wishbook.catalog.PageObject.SearchPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageAndroidObject;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class SearchPageFactory {
    public static SearchPageStrategy getStrategy(TestCase testCase) {
        SearchPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new SearchPageReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new SearchPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}

