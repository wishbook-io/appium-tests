package com.wishbook.catalog.PageObject.ProductUploadPage1;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface ProductUploadPage1Strategy extends BaseStrategy {
    void clickAddFabricButton();
    void clickAddWorkButton();
    void setCatalogEnableDurationField(String num);
    void enterOtherDetailsTextField(String details);
    String enterCatalogName(String catalogName);
    void clickContinueButton();
    String getCategory();
    String getWork();
    String getFabric();
    String getBrandName();
    void clickOnChooseABrandSpinner();
    String getScreenCategory();
    void  clickCatalogRadioButton();
    void clickNonCatalogRadioButton();
    void BackAddProductButton();
    void clickCalender();
    void clickOkCalenderButton();
    String getAddProductTileFromToolBar();
    void enterScreenQualityName(String screenName);
    void enterNumberOfPiecesPerScreen(int pieces);
    void enterPricesForScreenPieces(int prices);
    boolean catalogRadioButtonIsDisplyed();
    void clickOnSelectTopCategory();
    boolean nonCatalogRadioButtonIsDisplyed();
    void clickOnSelectCategory();
    boolean featuresOfProductIsDisplayed(String text);
    boolean fabricButtonIsDisplayed();
    boolean workButtonIsDisplayed();
    boolean styleButtonIsDisplayed();
    void clickSetMatchingRadioButton();
    void clickRadioButtonProductStretch(String stretch);
    void clickRadioButtonProductRise(String rise);
    void clickRadioButtonProductFit(String fit);
    void clickRadioButtonProductType(String Type);
    void clickRadioButtonProductNeckType(String NeckType);
    void clickRadioButtonProductSleeveByText(String Sleeve);
    void clickAddStyleButton();
    void clickRadioButtonProductStitching(String stitching);
    void clickOccassionDressCheckbox(String occassional);

    void enterTopMaterialLength(int top);
    void enterBottomMaterialLength(int bottom);
    void enterDupattaLength(int length);
    void enterDupattaWidth(int width);
    void enterPalazzoBottomLength(int palazzoBottomLength);
    void enterLegginsBottomLength(int legginsBottomLength);


}
