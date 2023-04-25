package com.wishbook.catalog.PageObject.PopUpPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageAndroidObject;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

public class PopUpPageFactory {
    public static PopUpPageStrategy getStrategy(TestCase testCase) {
        PopUpPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new PopUpPageReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new PopUpPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
