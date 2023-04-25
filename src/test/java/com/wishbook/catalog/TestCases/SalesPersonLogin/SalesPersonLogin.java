package com.wishbook.catalog.TestCases.SalesPersonLogin;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.NavigationDrawerPage.AppBarPageStrategy;
import com.wishbook.catalog.PageObject.NavigationDrawerPage.AppBarPageFactory;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseOptions;

/**
 * Created by wishbook on 14/4/18.
 */

public class SalesPersonLogin extends TestCase {
    @SuppressWarnings("unused")
    public SalesPersonLogin(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsSalesPerson));

    }


    protected void run() {
//        LoginPageStrategy loginPageStrategy= LoginPageFactory.getStrategy(this);
//        loginPageStrategy.loginAsSalesPerson();
//        PasswordPageStrategy passwordPageStrategy= PasswordPageFactory.getStrategy(this);
//        passwordPageStrategy.loginWithPassword("123456");
//        LanguagePageStrategy languagePageStrategy = LanguagePageFactory.getStrategy(this);
//        languagePageStrategy.selectEnglish();
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy .clickProductsButton();
        bottomTabPageStrategy=BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickOrderButton();
        bottomTabPageStrategy=BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMoreTab();
        AppBarPageStrategy navigationDrawerPageStrategy = AppBarPageFactory.getStrategy(this);
        navigationDrawerPageStrategy.clickMoreTabLogout();

    }
}
