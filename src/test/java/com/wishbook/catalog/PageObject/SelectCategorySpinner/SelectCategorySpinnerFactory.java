package com.wishbook.catalog.PageObject.SelectCategorySpinner;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.ProductUploadPage2.ProductUploadPage2AndroidObject;
import com.wishbook.catalog.PageObject.ProductUploadPage2.ProductUploadPage2ReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class SelectCategorySpinnerFactory {
    public static SelectCategorySpinnerStrategy getStrategy(TestCase testCase) {
        SelectCategorySpinnerStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new SelectCategorySpinnerReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new SelectCategorySpinnerAndroid(testCase);
                break;
        }
        return strategy;
    }
}

