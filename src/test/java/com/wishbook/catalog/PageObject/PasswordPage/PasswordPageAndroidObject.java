package com.wishbook.catalog.PageObject.PasswordPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.TestCases.TestCase;

public class PasswordPageAndroidObject extends PasswordPageObject implements PasswordPageStrategy {
    public PasswordPageAndroidObject(TestCase testCase) {
        super(testCase);
        AndroidHelper.allowPermission(testCase.getTest());
    }

    public void loginWithPassword(String password) {
        inputPassword.clear();
        inputPassword.sendKeys(password);
        passwordProceedButton.click();
    }
}
