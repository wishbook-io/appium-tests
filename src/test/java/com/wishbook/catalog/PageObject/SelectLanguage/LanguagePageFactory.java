package com.wishbook.catalog.PageObject.SelectLanguage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageAndroidObject;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;


public class LanguagePageFactory {
    public static LanguagePageStrategy getStrategy(TestCase testCase) {
        LanguagePageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new LanguagePageReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new LanguagePageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
