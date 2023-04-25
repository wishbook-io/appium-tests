package com.wishbook.catalog.PageObject.ChooseABrandSpinner;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.SelectTopCategory.SelectTopCategorySpinnerAndroid;
import com.wishbook.catalog.PageObject.SelectTopCategory.SelectTopCategorySpinnerReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class ChooseABrandFactory {
    public static ChooseABrandStrategy getStrategy(TestCase testCase) {
        ChooseABrandStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new ChooseABrandReactNativeSpinner(testCase);
                break;
            case NativeAndroid:strategy=new ChooseABrandAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}