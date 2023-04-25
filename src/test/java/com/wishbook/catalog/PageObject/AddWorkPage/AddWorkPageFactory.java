package com.wishbook.catalog.PageObject.AddWorkPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.SelectTopCategory.SelectTopCategorySpinnerAndroid;
import com.wishbook.catalog.PageObject.SelectTopCategory.SelectTopCategorySpinnerReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class AddWorkPageFactory {
    public static AddWorkPageStrategy getStrategy(TestCase testCase) {
        AddWorkPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new AddWorkRectNativePageObject(testCase);
                break;
            case NativeAndroid:strategy=new AddWorkPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
