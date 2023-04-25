package com.wishbook.catalog.PageObject.CameraPicAction;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.TestCases.TestCase;


public class CameraPicActionFactory {
    public static CameraPicActionStrategy getStrategy(TestCase testCase) {
        CameraPicActionStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new CameraPicActionReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new CameraPicActionAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
