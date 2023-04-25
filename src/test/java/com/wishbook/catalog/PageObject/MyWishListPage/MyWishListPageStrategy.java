package com.wishbook.catalog.PageObject.MyWishListPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface MyWishListPageStrategy extends BaseStrategy{
    @SuppressWarnings("unused")

    void selectCatalogImage(int index);
    void BackMyCatalogButton();
    String getMyWishListCatalogTitle();
    Boolean IsRegistrationButtonDisplay();
    String getMyWishListTileFromToolBar();

}
