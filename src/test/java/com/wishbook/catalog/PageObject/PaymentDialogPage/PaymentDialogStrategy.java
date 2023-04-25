package com.wishbook.catalog.PageObject.PaymentDialogPage;

public interface PaymentDialogStrategy {
    void clickSavePaymentButton();
    float getAmount();
    void enterCheQueNumber(int number);
    void enterBankNameInDetails(String bankName);
    void enterTransactionIDNEFT( String transactionID);

}
