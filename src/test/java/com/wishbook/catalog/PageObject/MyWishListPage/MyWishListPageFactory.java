package com.wishbook.catalog.PageObject.MyWishListPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageAndroidObject;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class MyWishListPageFactory {
    public static MyWishListPageStrategy getStrategy(TestCase testCase) {
        MyWishListPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new MyWishListPageReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new MyWishListPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
