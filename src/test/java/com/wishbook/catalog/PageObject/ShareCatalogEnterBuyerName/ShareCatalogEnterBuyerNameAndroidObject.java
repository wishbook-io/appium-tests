package com.wishbook.catalog.PageObject.ShareCatalogEnterBuyerName;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class ShareCatalogEnterBuyerNameAndroidObject extends ShareCatalogEnterBuyerNameObject implements ShareCatalogEnterBuyerNameStrategy {
    public ShareCatalogEnterBuyerNameAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void clickSearchedBuyer(int index){
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, AndroidLocator.WIDGE_IMAGE_VIEW,index).click();

    }
}
