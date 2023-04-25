package com.wishbook.catalog.PageObject.AddFabricPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.SelectTopCategory.SelectTopCategorySpinnerAndroid;
import com.wishbook.catalog.PageObject.SelectTopCategory.SelectTopCategorySpinnerReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class AddFabricPageFactory {
    public static AddFabricPageStrategy getStrategy(TestCase testCase) {
        AddFabricPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new AddFabricPageReactNative(testCase);
                break;
            case NativeAndroid:strategy=new AddFabricPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}