package com.wishbook.catalog.PageObject.CODConfirmationPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.ChooseABrandSpinner.ChooseABrandAndroidObject;
import com.wishbook.catalog.PageObject.ChooseABrandSpinner.ChooseABrandReactNativeSpinner;
import com.wishbook.catalog.TestCases.TestCase;

public class CODConfirmationPageFactory {
    public static CODConfirmationPageStrategy getStrategy(TestCase testCase) {
        CODConfirmationPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new CODConfirmationPageReactNative(testCase);
                break;
            case NativeAndroid:strategy=new CODConfirmationPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
