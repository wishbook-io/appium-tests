package com.wishbook.catalog.PageObject.PaymentCardDetailsPage;

public interface PaymentCardDetailsPageStrategy {
    void selectCardExpiryMonth(int index);
    void selectCardExpiryYear(int index);
    void enterCvvNumber(String cvv);
    void clickPayButton();
    void enterCardNumber(String cardNum);
    void enterCardHolderName(String cardHolderName);
    void clickSuccessButton();
    float getPayAmount();
    void enterMonth();
    void enterYear();
    void clickEnterCardLink();
}
