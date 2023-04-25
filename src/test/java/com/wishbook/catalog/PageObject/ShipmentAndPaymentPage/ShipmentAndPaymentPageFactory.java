package com.wishbook.catalog.PageObject.ShipmentAndPaymentPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageAndroidObject;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class ShipmentAndPaymentPageFactory {
    public static ShipmentAndPaymentPageStrategy getStrategy(TestCase testCase) {
        ShipmentAndPaymentPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new ShipmentAndPaymentReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new ShipmentAndPaymentPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
