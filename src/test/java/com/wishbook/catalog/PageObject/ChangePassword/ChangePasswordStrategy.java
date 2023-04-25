package com.wishbook.catalog.PageObject.ChangePassword;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface ChangePasswordStrategy extends BaseStrategy{
    void enterNewPassword(String newPsd);
    void repeatPassword(String confirmPsd);
    void clickChangePasswordButton();


}
