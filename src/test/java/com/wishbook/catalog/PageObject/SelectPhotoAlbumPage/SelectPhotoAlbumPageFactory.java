package com.wishbook.catalog.PageObject.SelectPhotoAlbumPage;

import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class SelectPhotoAlbumPageFactory {
    public static SelectPhotoAlbumPageStrategy getStrategy(TestCase testCase) {
        SelectPhotoAlbumPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new SelectPhotoAlbumPageAndroidObject(testCase);
        }
        return strategy;
    }
}
