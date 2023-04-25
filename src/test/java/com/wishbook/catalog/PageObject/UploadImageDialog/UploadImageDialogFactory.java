package com.wishbook.catalog.PageObject.UploadImageDialog;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.SelectCategorySpinner.SelectCategorySpinnerAndroid;
import com.wishbook.catalog.PageObject.SelectCategorySpinner.SelectCategorySpinnerReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class UploadImageDialogFactory {
    public static UploadImageDialogStrategy getStrategy(TestCase testCase) {
        UploadImageDialogStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new UploadImageDialogReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new UploadImageDialogAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}