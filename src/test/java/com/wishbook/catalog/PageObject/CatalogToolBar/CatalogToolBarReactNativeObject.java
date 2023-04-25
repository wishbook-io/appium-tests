package com.wishbook.catalog.PageObject.CatalogToolBar;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

public class CatalogToolBarReactNativeObject extends BasePageObject implements  CatalogToolBarStrategy {


    public CatalogToolBarReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public int getWishlistCountAsShownOnPageTitle() {
        return 0;
    }

    public void clickReceivedCatalog() {

    }

    public void clickWishListButton() {

    }

    public void clickAddToCartButton() {

    }

    public int getWishListCountOnMenuBadgeCatalogToolBar() {
        return 0;
    }

    public void clickProductTypeSpinner() {

    }

    public String getNonCatalogText() {
        return null;
    }

    public String getProductTypeSpinnerText() {
        return null;
    }

    public void clickActionToolBarIcon() {

    }

    public void clickBackButton() {

    }

    public boolean isActionToolIconDisplayed() {
        return false;
    }

    public boolean isMyFilterIconDisplayed() {
        return false;
    }

    public boolean isMyWishlistIconDisplayed() {
        return false;
    }

    public boolean isCartIconDisplayed() {
        return false;
    }

    public boolean isSearchIconDisplayed() {
        return false;
    }

    public void clickMyFilterIcon() {

    }

    public int getMyFilterIconCount() {
        return 0;
    }
}
