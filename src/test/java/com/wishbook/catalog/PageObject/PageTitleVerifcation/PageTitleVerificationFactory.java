package com.wishbook.catalog.PageObject.PageTitleVerifcation;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.TestCases.TestCase;

public class PageTitleVerificationFactory {

       public static PageTitleVerificationStrategy getStrategy(TestCase testCase) {
        PageTitleVerificationStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new PageTitleVerificationReactNative(testCase);
                break;
            case NativeAndroid:strategy=new PageTitleVerificationAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}

