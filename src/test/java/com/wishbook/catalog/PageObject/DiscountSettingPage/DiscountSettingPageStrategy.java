package com.wishbook.catalog.PageObject.DiscountSettingPage;

public interface DiscountSettingPageStrategy {
    void BackBrandSearchButton();
    void clickEnterCashDiscountText(float discount);
    void clickAddMoreButton();
    void addDiscountIcon();
    void  clickOnBrandNameCheckBox(int instance);
    void saveButton();
    String getTextSelectedBrand();
    float getEnteredDiscount();
    void clickOnCreatedDiscount(int index);
    void clickSaveButtonAfterSelectBrand();

    void deleteCratedDiscount();
    float getFullCatalogDiscount();
    float getSinglePieceDiscount();
}
