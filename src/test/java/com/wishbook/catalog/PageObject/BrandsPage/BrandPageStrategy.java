package com.wishbook.catalog.PageObject.BrandsPage;


@SuppressWarnings("unused")
public interface BrandPageStrategy {

    void clickFollowBrandButton(int index);
    Boolean IsRegistrationButtonDisplay();
    void selectBrandInSearch();
    void enterBrandName(String brandName);
    void clickCloseSearchButton();
    String getBrandsTileFromToolBar();
    void clickBrandBackButton();

}
