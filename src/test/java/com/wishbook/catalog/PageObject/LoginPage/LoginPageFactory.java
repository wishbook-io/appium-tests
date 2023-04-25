package com.wishbook.catalog.PageObject.LoginPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.TestCases.TestCase;


/**
 * Created by wishbook on 7/4/18.
 */

public class LoginPageFactory  {
    public static LoginPageStrategy getStrategy(TestCase testCase){
        LoginPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new LoginPageReactNativeObject(testCase);
                             break;
            case NativeAndroid:strategy=new LoginPageAndroidObject(testCase);
                               break;
        }
        return strategy;
    }
}
