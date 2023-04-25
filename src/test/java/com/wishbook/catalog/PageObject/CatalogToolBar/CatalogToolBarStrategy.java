package com.wishbook.catalog.PageObject.CatalogToolBar;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface CatalogToolBarStrategy  extends BaseStrategy {
    int getWishlistCountAsShownOnPageTitle();
    void clickReceivedCatalog();
    void clickWishListButton();
    void clickAddToCartButton();
    int getWishListCountOnMenuBadgeCatalogToolBar();
    void clickProductTypeSpinner();
    String getNonCatalogText();
    String getProductTypeSpinnerText();
    void clickActionToolBarIcon();
    void clickBackButton();
    boolean isActionToolIconDisplayed();
    boolean isMyFilterIconDisplayed();
    boolean isMyWishlistIconDisplayed();
    boolean isCartIconDisplayed();
    boolean isSearchIconDisplayed();
    void clickMyFilterIcon();
    int getMyFilterIconCount();

}
