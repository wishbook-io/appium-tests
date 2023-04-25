package com.wishbook.catalog.PageObject.PaymentCardDetailsPage;


import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.OrderReceiptPage.OrderReceiptPageAndroidObject;
import com.wishbook.catalog.PageObject.OrderReceiptPage.OrderReceiptReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

 public class PaymentCardDetailsPageFactory {
    public static PaymentCardDetailsPageStrategy getStrategy(TestCase testCase) {
        PaymentCardDetailsPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new PaymentCardDetailsPageReactNative(testCase);
                break;
            case NativeAndroid:strategy=new PaymentCardDetailsPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
 }


