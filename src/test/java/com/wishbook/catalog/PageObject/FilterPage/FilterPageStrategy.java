package com.wishbook.catalog.PageObject.FilterPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface FilterPageStrategy extends BaseStrategy{

    void saveFilter();
    void clickClearAllButton();
    void clickApplyButton();
    void clickDeleteSavedFilterButton();
    void BackFilterButton();
    String getTitleNameFilter();



    int getStateCount();
    int getPriceCount();
    int getStyleCount();
    int getWorkCount();
    int getFabricCount();
    int getBrandCount();
    int getSizeCount();
    int getCategoryCount();
    void clickViewMore();





    boolean isCatalogRadioButtonDisplayed();
    boolean isNonCatalogRadioButtonDisplayed();
    boolean isFullSetRadioButtonDisplayed();
    boolean isSinglePieceAvailRadioButtonDisplayed();
    boolean isBothAvailableRadioButtonDisplayed();
    boolean isPreLaunchedChecBoxDisplayed();
    boolean isCategoryButtonDisplayed();
    boolean isBrandButtonDisplayed();
    boolean isPriceButtonDisplayed();
    boolean isFabricButtonDisplayed();
    boolean isWorkButtonDisplayed();
    boolean isViewMoreLinkDisplayed();
    boolean isStyleButtonDisplayed();
    boolean isStateButtonDisplayed();
    boolean isClearAllButtonDisplayed();
    boolean isApplyButtonDisplayed();
    boolean isSaveFilterDisplayed();
    boolean isSizeButtonDisplayed();
    boolean isStitchedDisplayed();
    boolean isSaveButtonDisplayed();
    boolean isDeleteButtonDisplayed();


    void selectCategoryByName(String name);
    void selectFabricByName(String name);
    void selectWorkByName(String name);
    void selectPriceAtIndex(int index);
    void selectSizeByName(String name);
    void selectStateByName(String name);
    void selectStyleByName(String name);
    void selectStitchByName(String name);
    void selectBrandByName(String name);


    boolean isCatalogRadioButtonSelected();
    boolean isNonCatalogRadioButtonSelected();
    boolean isFullSetRadioButtonSelected();
    boolean isSinglePiecesAvailableSelected();
    boolean isBothAvailableRadioButtonSelected();
    boolean isSareesRadioButtonSelected();
    boolean isKurtisRadioButtonSelected();
    boolean isCategoriesDressMateriaRadioButton();
    boolean isSuitReadymadeRadioButtonSelected();
    boolean isLehengasRadioButtonSelected();
    boolean isBlouseRadioButtonSelected();
    boolean isGownStitchedRadioButtonSelected();
    boolean isGownSemiStitchedRadioButtonSelected();
    boolean isTypeAndAvailabilityButtonDisplayed();

    void clickCategoryButton();
    void clickBrandButton();
    void clickPriceButton();
    void clickFabricButton();
    void clickWorkButton();
    void clickStyleButton();
    void clickStateButton();
    void clickSizeButton();
    void clickStitchedButton();


}
