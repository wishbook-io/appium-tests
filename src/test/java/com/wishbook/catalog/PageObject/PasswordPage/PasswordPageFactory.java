package com.wishbook.catalog.PageObject.PasswordPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.TestCases.TestCase;

public class PasswordPageFactory {
    public static PasswordPageStrategy getStrategy(TestCase testCase) {
        PasswordPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new PasswordPageReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new PasswordPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
