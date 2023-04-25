package com.wishbook.catalog.PageObject.SelectTopCategory;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.ProductUploadPage2.ProductUploadPage2AndroidObject;
import com.wishbook.catalog.PageObject.ProductUploadPage2.ProductUploadPage2ReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class SelectTopCategorySpinnerFactory {

    public static SelectTopCategorySpinnerStrategy getStrategy(TestCase testCase) {
        SelectTopCategorySpinnerStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new SelectTopCategorySpinnerReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new SelectTopCategorySpinnerAndroid(testCase);
                break;
        }
        return strategy;
    }
}
