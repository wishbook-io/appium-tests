package com.wishbook.catalog.PageObject.ManageDeliveryPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.TestCases.TestCase;

public class ManageDeliveryPageFactory {

    public static ManageDeliveryPageStrategy getStrategy(TestCase testCase) {
        ManageDeliveryPageStrategy strategy = null;
        TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
        switch (framework) {
            case ReactNative:
                strategy = new ManageDeliveryPageReactNative(testCase);
                break;
            case NativeAndroid:
                strategy = new ManageDeliveryPageAndroidObject(testCase);
                break;
        }
        return strategy;
    }
}
