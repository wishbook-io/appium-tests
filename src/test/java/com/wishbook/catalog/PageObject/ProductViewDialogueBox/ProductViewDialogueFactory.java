package com.wishbook.catalog.PageObject.ProductViewDialogueBox;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class ProductViewDialogueFactory {
      public static ProductViewDialogueStrategy getStrategy(TestCase testCase) {
          ProductViewDialogueStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new ProductViewDialogueAndroidObject(testCase);
        }
        return strategy;
    }

}
