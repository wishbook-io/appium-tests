package com.wishbook.catalog.PageObject.ChangeResaleAmountPage;

public interface ChangeResaleAmountPageStrategy {
    float getOrderAmountResaleAmountChangePopup();
    float getResaleAmountResaleAmountChangePopup();
    float getItemPriceInclGSTResaleAmountChangePopup();
    int getItemQuantityResaleAmountChangePopup();
    void enterResaleAmountIntoTextBox(float resaleAmount);
    float getEnteredAmountIntoTextBox();
    void clickCloseButton();
    void clickDoneButton();
    float getResaleMarginPercent();
    void clickEditDefaultMargin();
    void clickSaveDefaultMargin();
    void enterResaleMarginPercent(int percent);

}
