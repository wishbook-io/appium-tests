package com.wishbook.catalog.PageObject.MyCatalogPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;


import io.appium.java_client.android.AndroidDriver;

public class MyCatalogPageAndroidObject extends MyCatalogPageObject implements MyCatalogPageStrategy {
    public MyCatalogPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void selectMyCatalogImage(int index) {
       AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, AndroidLocator.WIDGE_IMAGE_VIEW,index).click();

    }
    public void clickDisabledByMe() {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, AndroidLocator.WIDGET_TEXT_VIEW,1).click();

    }

}
