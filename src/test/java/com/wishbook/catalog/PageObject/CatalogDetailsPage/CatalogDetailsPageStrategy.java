package com.wishbook.catalog.PageObject.CatalogDetailsPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface CatalogDetailsPageStrategy extends BaseStrategy{

    void clickStopSelling();
    void clickFollowButton();
    String getProductNameInMyProduct();
    void clickAddToCartButton();
    void clickWishListButton();
    String getFabricText();
    String getWorkText();
    String getCatalogName();
    String getTextReadyToShipOnProductDetailsPage();
    String getTextPreOrderOnProductDetailsPage();
    String getCatalogTitle();
    String getProductCategory();
    boolean setEditScreenButtonIsDisplay();
    boolean setAddScreenButtonIsDisplayed();
    void clickEditSetButton();
    void clickAddSetButton();
    int getFullCatalogPriceForProductsText();
    int getSinglePcsForProductText();
    String getCatalogNameOnMyProduct();

    void BackCatalogButton();
    void wishListSelected() ;
    void clickShareButtonCatalogsDetails();
    Boolean shareButtonIsDisplayed();
    void sendEnquiryButton();
    Boolean ChatWithSupplierButtonIsDisplayed();
    boolean stopSellingButtonIsDisplayed();
    String getBrandNameText();
    boolean isFollowButtonPresent();
    boolean isAddToCartButtonPresent();
    boolean isWishListButtonPresent();

    boolean isShareButtonPresent();
    boolean isBecomeASellerOfThisCatalogPresent();
    boolean isSendEnquiryPresent();
    boolean isAddToCartIconPresent();
    boolean isChatAndEnquiryButton();
    float getSinglePiecePrice();
    float FullCatalogPrice();
    String getSinglePieceString();




    String getSoldByName();
    boolean startSellingAgainButtonIsDisplayed();
    String getTextNoCatalogsToDisplay();
    void clickAddToCartIcon();
    int getNumberOfDesigns();
    void clickOnDesigns(int index);
    int getTextPriceOfDesign();
    String getProductSku();
    void clickBackButtonDesignPage();
    void clickBecomeSellerOfThisCatalogButton();
    float getFullCatalogPrice();
    float getSinglePrice();
    float getMarkedWholesalePrice();
    float getFullClearanceDiscountOff();
    float getSingleClearanceDiscountOff();

    void clickClearanceDiscountLink();


}
