package com.wishbook.catalog.PageObject.PasswordPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface PasswordPageStrategy extends BaseStrategy {
    String DEFAULT_PASSWORD = "123456";
    void loginWithPassword(String password);
    void BackLoginPageButton();
}
