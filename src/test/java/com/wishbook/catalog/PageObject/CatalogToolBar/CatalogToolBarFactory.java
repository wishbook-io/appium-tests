package com.wishbook.catalog.PageObject.CatalogToolBar;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.HomePage.HomePageAndroidObject;
import com.wishbook.catalog.PageObject.HomePage.HomePageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class CatalogToolBarFactory {
    public static CatalogToolBarStrategy getStrategy(TestCase testCase) {
        CatalogToolBarStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new CatalogToolBarReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new CatalogToolBarAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
