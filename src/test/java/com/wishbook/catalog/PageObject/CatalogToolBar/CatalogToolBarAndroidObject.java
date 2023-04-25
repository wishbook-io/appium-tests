package com.wishbook.catalog.PageObject.CatalogToolBar;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class CatalogToolBarAndroidObject extends CatalogToolBarObject implements CatalogToolBarStrategy {
    public CatalogToolBarAndroidObject(TestCase testCase) {
        super(testCase);
    }


    public void clickReceivedCatalog() {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_TEXT_VIEW, 2).click();
    }


    public void clickBrandButton() {
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, AndroidLocator.WIDGET_TEXT_VIEW,1);
        element.click();
    }

    public int getWishlistCountAsShownOnPageTitle() {
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, AndroidLocator.WIDGET_TEXT_VIEW,3);
        String wishListTabText = element.getText();
        String wishListCount = wishListTabText.replaceAll("[^0-9]", "");
        return Integer.valueOf(wishListCount);
    }


}