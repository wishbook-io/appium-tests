package com.wishbook.catalog.PageObject.SortByPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface SortByPageStrategy extends BaseStrategy {
    void clickSortCloseButton();
    void clickOnRecentlyUploadedRadioButton();
    void clickOnPriceLowToHighRadioButton();
    void clickOnPriceHighToLowRadioButton();
    void clickOnPriceNumberOfViewsRadioButton();

}
