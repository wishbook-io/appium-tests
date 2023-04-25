package com.wishbook.catalog.PageObject.WishbookRewardPoints;


import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class WishbookRewardPointsFactory {
    public static WishbookRewardPointsStrategy getStrategy(TestCase testCase) {
        WishbookRewardPointsStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new WishbookRewardPointsAndroidObject(testCase);
        }
        return strategy;
    }
}
