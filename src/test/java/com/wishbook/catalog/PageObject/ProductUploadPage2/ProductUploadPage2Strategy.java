package com.wishbook.catalog.PageObject.ProductUploadPage2;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface ProductUploadPage2Strategy extends BaseStrategy {

    void clickFullCatalogOnly();
    void clickSinglePieceAndFullCatalogBoth();
    void uploadCoverPhoto();
    void clickSubmitButton();
    void enterPrice(int price);
    void clickAddProductPhotosButton();
    String getAddProductPhotosText();
    void enterScreenNameOrNumber(String screenName);
    void enterScreenSetColorName(String colorName);
    void clickAddImagesSetButton();
    void clickDeleteButtonInScreen();
    int getPriceForSinglePc( int index);
    int getEnteredPriceForProduct();
    void enterNumOfDesign(int num);

    void clickAddAnotherSetButton();
    String getSecondDesignPrice();
    String getFirstDesignPrice();
    void keepSetMatchingLiveTextbox(String num);
    void clickCheckBoxProductSizeByText(String Size);

    boolean isMarginPricesDisplayed();
    void enterMarginToTextField(int addMargin);
    void selectAddMarginInPercentRadioButton();
    void selectAddMarginInPriceRadioButton();
    int getTotalPriceAfterAddingMargingForSinglePiece();
    void clickAddMoreImagesOfSameDesign();


}
