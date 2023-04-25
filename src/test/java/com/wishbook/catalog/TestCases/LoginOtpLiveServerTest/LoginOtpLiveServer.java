package com.wishbook.catalog.TestCases.LoginOtpLiveServerTest;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageFactory;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageStrategy;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageFactory;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageStrategy;
import com.wishbook.catalog.PageObject.SelectLanguage.LanguagePageFactory;
import com.wishbook.catalog.PageObject.SelectLanguage.LanguagePageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;

public class LoginOtpLiveServer extends TestCase {
    public LoginOtpLiveServer(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.DontLogin));
    }

    protected void run() {
        LoginHelper loginHelper = new LoginHelper(this);
        LoginPageStrategy loginPageStrategy = LoginPageFactory.getStrategy(this);
        loginPageStrategy.login("9704970848");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PasswordPageStrategy passwordPageStrategy = PasswordPageFactory.getStrategy(this);
        passwordPageStrategy.BackLoginPageButton();

        loginPageStrategy.login(loginHelper.getMobileNumberWholesaler());
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LanguagePageStrategy languagePageStrategy= LanguagePageFactory.getStrategy(this);
        languagePageStrategy.selectEnglishLanguage();

    }
}
