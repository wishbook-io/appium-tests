package com.wishbook.catalog.PageObject.MyWishListPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class MyWishListPageAndroidObject extends MyWishListPageObject implements MyWishListPageStrategy {
    public MyWishListPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void selectCatalogImage(int index){
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGE_IMAGE_VIEW, index);
        element.click();
    }
}
