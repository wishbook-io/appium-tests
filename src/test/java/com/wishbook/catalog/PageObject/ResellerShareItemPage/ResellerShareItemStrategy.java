package com.wishbook.catalog.PageObject.ResellerShareItemPage;

public interface ResellerShareItemStrategy {
    void enterResalePricePerPiece(int resalePrice);
    float getAveragePricePerPiece();
    void clickShareOnWhatsAppButton();
    void clickOthersButton();
    boolean isShareLinkDisplayed();
    boolean isShareFBDisplayed();
    boolean isShareSaveToGalleryDisplayed();
    boolean isShareOtherDisplayed();
    void clickOnOtherUnderOther();
    boolean isCompleteActionUsing();
}
