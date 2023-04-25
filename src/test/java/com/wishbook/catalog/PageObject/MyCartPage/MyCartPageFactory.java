package com.wishbook.catalog.PageObject.MyCartPage;


import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.HomePage.HomePageAndroidObject;
import com.wishbook.catalog.PageObject.HomePage.HomePageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class MyCartPageFactory {
    public static  MyCartPageStrategy getStrategy(TestCase testCase) {
         MyCartPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new MyCartReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new MyCartPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}

