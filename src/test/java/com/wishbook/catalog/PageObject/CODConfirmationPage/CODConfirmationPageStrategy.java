package com.wishbook.catalog.PageObject.CODConfirmationPage;

public interface CODConfirmationPageStrategy {
    float getAmountToBeCollected();
    int getOrderNumber();
    String getOrderStatus();
    void clickReConfirmCodButton();
    void clickCancelCodButton();
    float getMarginAmount();

}
