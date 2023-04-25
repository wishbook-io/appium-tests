package com.wishbook.catalog.PageObject.TabToSelectImage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class TabToSelectImageAndroidObject extends TabToSelectImageObject implements TabToSelectImageStrategy {
    public TabToSelectImageAndroidObject(TestCase testCase) {
        super(testCase);
    }



public void selectImagesForCatalogDesign(int index) {
    AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, AndroidLocator.WIDGE_IMAGE_VIEW,index).click();

}

}

