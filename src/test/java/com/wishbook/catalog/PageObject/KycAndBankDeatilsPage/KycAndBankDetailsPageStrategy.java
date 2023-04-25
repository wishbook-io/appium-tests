package com.wishbook.catalog.PageObject.KycAndBankDeatilsPage;

public interface KycAndBankDetailsPageStrategy {
    void enterGstNumber(String gstNumber);
    void enterPaytmNumberTextField(String number);
    void enterBankName(String bankNameText);
    void enterAccountHolderName(String name);
    void enterIFSCcode(String ifsc);
    long enterAccountNumber(long accountNumber);
    void clickOnSaveButton();
    long getAccountNumber();
    void clickKycBackPage();

}
