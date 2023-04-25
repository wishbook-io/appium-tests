package com.wishbook.catalog.PageObject.CatalogPublicPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface CatalogPublicPageStrategy extends BaseStrategy{
    void clickUploadIcon();
    void clickSearchIcon();
    void clickFilterIcon();
    void clickSortIcon();
    void clickMyFiltersIcon();
    void selectCatalogImage(int index);

    boolean launchedButtonSelected();
    boolean preLaunchButtonIsSelected();

    void clickLaunchedButton();
    void clickPreLaunchedButton();

    boolean launchedButtonIsEnabled();
    boolean preLaunchedIsEnabled();

    void clickAvailabilityDownArrow();
    void clickTypeDownArrow();
    void clickCategoryDownArrow();
    String getCategory();
    void clickTrendingButton();
    void clickLatestButton();
    void clickPriceButton();
    boolean isAvailabilityDownArrowDisplayed();
    boolean isTypeDownArrowDisplayed();
    boolean isCategoryDownArrowDisplayed();

    boolean isViewDownArrowButton();
    void clickViewDownArrowButton();


}
