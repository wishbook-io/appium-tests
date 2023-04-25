package com.wishbook.catalog.PageObject.ProfilePage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface ProfilePageStrategy extends BaseStrategy {

    void enterName(String enterName);
    void enterCompanyName(String companyname);
    void enterEmailId(String emailid);
    void enterPhoneNumber(String num);
    void clickSaveChanges();
    void selectState(String state);
    void selectCity(String city);
    String getState();
    String getCity();
    String getPhoneNumber();
    void BackCatalogButton();
    String getEmailId();
    void enterAddress(String address);
    void enterPincode(int pincode);
    void enterGSTNumber(long GST);
    String getEnteredName();
    String getCompananyName();
    String getAddress();
    int getPincode();
    String getGst();

}
