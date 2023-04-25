package com.wishbook.catalog.PageObject.AddStylePage;


import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.SelectTopCategory.SelectTopCategorySpinnerAndroid;
import com.wishbook.catalog.PageObject.SelectTopCategory.SelectTopCategorySpinnerReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

@SuppressWarnings("unused")
public class AddStylePageFactory {
    public static AddStylePageStrategy getStrategy(TestCase testCase) {
        AddStylePageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new AddStyleReactNativeObject(testCase);
                break;
            case NativeAndroid:strategy=new AddStylePageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
