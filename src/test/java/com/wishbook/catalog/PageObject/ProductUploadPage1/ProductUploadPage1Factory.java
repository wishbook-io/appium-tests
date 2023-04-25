package com.wishbook.catalog.PageObject.ProductUploadPage1;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageAndroidObject;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class ProductUploadPage1Factory {
    public static ProductUploadPage1Strategy getStrategy(TestCase testCase) {
        ProductUploadPage1Strategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new ProductUploadPage1ReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new ProductUploadPage1AndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
