package com.wishbook.catalog.PageObject.BecomeASellerPage;

public interface BecomeASellerPageStrategy {
    boolean fullCatalogOnlyIsDisplayed();

    boolean singlePiecesAndFullCatalogBothIsDisplayed();


    void clickDoneButton();

    void enterCatalogDuration(int days);

    void clickOk();

    void clickFullCatalogRadioButton();

    void ClickSinglePiecesAndFullCatalogBoth();

    boolean areAllSizesDisplayed();
    void clickCloseButton();
    void clickCheckBoxProductSizeByText(String Size);
    void clickSinglePiecesAndFullCatalogBoth();
    boolean isDesignNumberDisplayed();
    boolean isPricePerDesignDisplayed();
}
