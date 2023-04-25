package com.wishbook.catalog.PageObject.CatalogReceivedPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;


import io.appium.java_client.android.AndroidDriver;

public class CatalogReceivedPageAndroidObject extends CatalogReceivedPageObject implements CatalogReceivedPageStrategy {
    public CatalogReceivedPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    @SuppressWarnings("unused")
    public void selectReceivedImage(int index) {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, AndroidLocator.WIDGE_IMAGE_VIEW,index).click();

   }

}
