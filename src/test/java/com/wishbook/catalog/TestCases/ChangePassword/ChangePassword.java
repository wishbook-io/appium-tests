package com.wishbook.catalog.TestCases.ChangePassword;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.ChangePassword.ChangePasswordFactory;
import com.wishbook.catalog.PageObject.ChangePassword.ChangePasswordStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.NavigationDrawerPage.AppBarPageStrategy;
import com.wishbook.catalog.PageObject.NavigationDrawerPage.AppBarPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;

/**
 * Created by wishbook on 16/4/18.
 */

public class ChangePassword extends TestCase {
    @SuppressWarnings("unused")
    public ChangePassword(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));

    }


    public void run() {
        HomePageStrategy homePageStrategy = HomePageFactory.getStrategy(this);

        if (getTest().getTestConfiguration().getDevelopmentFramework()==TestConfiguration.DevelopmentFramework.NativeAndroid) {
            homePageStrategy.clickAppBar(0);
        }
        else{
            homePageStrategy.clickAppBar();
        }
        AppBarPageStrategy navigationDrawerPageStrategy = AppBarPageFactory.getStrategy(this);
        navigationDrawerPageStrategy.clickChangePassword();

        ChangePasswordStrategy changePasswordStrategy= ChangePasswordFactory.getStrategy(this);

        //case1:just leave Blank and clickChange password
        changePasswordStrategy.enterNewPassword("");
        changePasswordStrategy.repeatPassword("");
        changePasswordStrategy.clickChangePasswordButton();

        //case2: wrong password to both the field
        changePasswordStrategy.enterNewPassword("1234567");
        changePasswordStrategy.repeatPassword("123");
        changePasswordStrategy.clickChangePasswordButton();

        //case3:
        changePasswordStrategy=ChangePasswordFactory.getStrategy(this);
        changePasswordStrategy.enterNewPassword("123456");
        changePasswordStrategy.repeatPassword("654321");
        changePasswordStrategy.clickChangePasswordButton();

        //case4:
        changePasswordStrategy=ChangePasswordFactory.getStrategy(this);
        changePasswordStrategy.enterNewPassword("654321");
        changePasswordStrategy.repeatPassword("123456");
        changePasswordStrategy.clickChangePasswordButton();

        //case5:
        changePasswordStrategy=ChangePasswordFactory.getStrategy(this);
        changePasswordStrategy.enterNewPassword("1234");
        changePasswordStrategy.repeatPassword("1234");
        changePasswordStrategy.clickChangePasswordButton();

         //case6: valid change password
        changePasswordStrategy=ChangePasswordFactory.getStrategy(this);
        changePasswordStrategy.enterNewPassword("123456");
        changePasswordStrategy.repeatPassword("123456");
        changePasswordStrategy.clickChangePasswordButton();
        if (getTest().getTestConfiguration().getDevelopmentFramework()==TestConfiguration.DevelopmentFramework.ReactNative){
            PopUpPageStrategy popUpPageStrategy=PopUpPageFactory.getStrategy(this);
            popUpPageStrategy.okChangePassword();
        }

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        navigationDrawerPageStrategy = AppBarPageFactory.getStrategy(this);
        navigationDrawerPageStrategy.clickLogout();
        new LoginHelper(this).loginAsTestManufacturer();

    }
}
