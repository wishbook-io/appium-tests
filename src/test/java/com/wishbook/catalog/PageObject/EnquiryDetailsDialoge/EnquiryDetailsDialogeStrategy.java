package com.wishbook.catalog.PageObject.EnquiryDetailsDialoge;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface EnquiryDetailsDialogeStrategy extends BaseStrategy
{
    void enterNumberOfSet(int set);
    void clickSendButton();
    void clickPriceDiscountEnquiry();
    void clickFabricAndMaterialCheckBox();
    void clickDispatchAndDeliveryChecbox();
}
