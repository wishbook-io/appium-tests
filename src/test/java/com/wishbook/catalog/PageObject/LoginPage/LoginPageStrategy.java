package com.wishbook.catalog.PageObject.LoginPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

/**
 * Created by wishbook on 7/4/18.
 */

public interface LoginPageStrategy extends BaseStrategy {



    void enterMobileNumber(String mobileNumber);

    String getMobileNumberInputText();

    void login(String mobileNumber);



}
