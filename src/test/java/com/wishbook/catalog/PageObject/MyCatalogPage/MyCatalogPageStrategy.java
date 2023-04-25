package com.wishbook.catalog.PageObject.MyCatalogPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface MyCatalogPageStrategy extends BaseStrategy {
    void clickSearchIcon();
    void enterText(String text);
    void clickShareButton();
    void selectMyCatalogImage(int index);
    void BackCatalogButton();
    void clickCloseSearchButton();
    void clickDisabledByMe();
    void clickSpinner();
    void clickAddCatalogIcon();
    String getMyCatalogTileFromToolBar();


}
