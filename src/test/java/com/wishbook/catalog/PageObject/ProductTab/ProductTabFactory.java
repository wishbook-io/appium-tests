package com.wishbook.catalog.PageObject.ProductTab;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.TestCases.TestCase;

public class ProductTabFactory {

    public static ProductTabStrategy getStrategy(TestCase testCase) {
       ProductTabStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework){
            case ReactNative:strategy= new ProductTabReactNative(testCase);
                break;
            case NativeAndroid:strategy=new ProductTabAndroidObject (testCase);
                break;
        }
        return strategy;
    }

}
