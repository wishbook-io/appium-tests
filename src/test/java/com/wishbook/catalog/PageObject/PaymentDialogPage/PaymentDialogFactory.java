package com.wishbook.catalog.PageObject.PaymentDialogPage;


import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageAndroidObject;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

public class PaymentDialogFactory {
    public static PaymentDialogStrategy getStrategy(TestCase testCase) {
       PaymentDialogStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new PaymentDialogReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new PaymentDialogAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
