package com.wishbook.catalog.PageObject.RegistrationPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface RegistrationPageStrategy extends BaseStrategy {

    void selectEnglish();
    void selectHomeBasedReseller();
    void selectRetailer();
    void selectWholesaler();
    void selectBroker();
    void clickStartUsingWishbookButton();
    String getHomeBasedReseller();
    String getRetailer();
    String getManufacturerWholeSalerBroker();
    void clickCloseButton();
}
