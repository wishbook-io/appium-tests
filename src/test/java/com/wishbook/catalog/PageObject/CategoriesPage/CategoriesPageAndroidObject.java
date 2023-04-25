package com.wishbook.catalog.PageObject.CategoriesPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;


import io.appium.java_client.android.AndroidDriver;

public class CategoriesPageAndroidObject extends CategoriesPageObject implements CategoriesPageStrategy {
    public CategoriesPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void selectCategories(int index) {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,AndroidLocator.WIDGE_IMAGE_VIEW,index).click();
    }
}
