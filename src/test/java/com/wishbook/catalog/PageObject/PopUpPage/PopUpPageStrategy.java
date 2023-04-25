package com.wishbook.catalog.PageObject.PopUpPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

@SuppressWarnings("unused")
public interface PopUpPageStrategy  extends BaseStrategy {
    void clickYesButton();
    void clickNoButton();
    void clickOk();
    void clickOnYesRemoveItemFromCart();
    void clickOnNoRemoveItemFromCart();
    void clickDoneDiscount();
    void enterNameForThisDiscountRuleTextField(String DiscountRule);
    void enterResellAmountIntoTextField(float resellAmount);
    float getResellAmountOnPopUp();
    void clickYesIWantCod();
    void okChangePassword();
    void clickOkPasswordPage();
    void clickExitApp();
    void clickCancelRegister();
    void clickYesRegister();


}
