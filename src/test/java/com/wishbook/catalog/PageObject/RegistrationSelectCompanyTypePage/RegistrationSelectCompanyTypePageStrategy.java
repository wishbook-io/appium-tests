package com.wishbook.catalog.PageObject.RegistrationSelectCompanyTypePage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface RegistrationSelectCompanyTypePageStrategy extends BaseStrategy {
    void selectManufacturer();
    void selectWholesaler();
    void selectRetailer();
    void selectOnlineRetailer();
    void selectBroker();
    void  okButton();

}
