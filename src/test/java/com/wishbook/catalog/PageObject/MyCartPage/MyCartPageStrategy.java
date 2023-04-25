package com.wishbook.catalog.PageObject.MyCartPage;

public interface MyCartPageStrategy {
    float getIndividualItemsDiscountedPrice();
    float getGrandTotalPrice();
    String getCatalogNameMyCart();
    String getSoldByMyCart();
    void clickIncreaseCatalogQuantity();
    void clickDeleteButton();
    String getEmptyCart();
    void clickPlaceOrderButton();
    void BackMyCartButton();
    void clickItemsDetails();
    int getCatalogQuantity();
    int getNumberOfItemsAtToolBar();
    String getFullCatalogText();
    float getSingleItemPrice();
    float getDiscountOnMycart();
    String getCatalogName(int instance);
    float getIndividualItemsPriceInCart(int instance);
    int getCatalogQuantity(int instance);
    float getCatalogPriceOnMyCart();
    float getIndividualItemsDiscountedAfterGstPrice();
    boolean switchReselerButtonIsDisplayed();
    boolean deleteButtonAppearOnCart();
    int getNumberOfItemsAtToolBarAfterRemovingItems();


}
