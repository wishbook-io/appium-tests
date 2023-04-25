package com.wishbook.catalog.PageObject.CatalogPublicPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageAndroidObject;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class CatalogPublicPageFactory {
    public static CatalogPublicPageStrategy getStrategy(TestCase testCase) {
        CatalogPublicPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new CatalogPublicReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new CatalogPublicPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
