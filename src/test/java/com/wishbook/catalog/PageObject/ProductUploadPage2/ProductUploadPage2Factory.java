package com.wishbook.catalog.PageObject.ProductUploadPage2;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1AndroidObject;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1ReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class ProductUploadPage2Factory {
    public static ProductUploadPage2Strategy getStrategy(TestCase testCase) {
        ProductUploadPage2Strategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new ProductUploadPage2ReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new ProductUploadPage2AndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
