package com.wishbook.catalog.TestCases.Login;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.ExcelData;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageFactory;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageStrategy;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageFactory;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.PageObject.SelectLanguage.LanguagePageFactory;
import com.wishbook.catalog.PageObject.SelectLanguage.LanguagePageStrategy;
import com.wishbook.catalog.TestCases.TestCase;

import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

/**
 * Created by wishbook on 13/3/18.
 */

public class Login extends TestCase {


    @SuppressWarnings("unused")
    public Login(BaseTest test) {

        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.DontLogin));
    }


    public void run() throws Exception {
        LoginPageStrategy loginPageStrategy = LoginPageFactory.getStrategy(this);
        String alphaNumbericUserName = ExcelData.getData(AndroidLocator.excelPath, "AppiumLogin", 1, 0);
        String blankUserName = ExcelData.getData(AndroidLocator.excelPath, "AppiumLogin", 2, 0);
        String lessThanTenDigitUserName = ExcelData.getData(AndroidLocator.excelPath, "AppiumLogin", 3, 0);
        String moreThanTenDigitUserName = ExcelData.getData(AndroidLocator.excelPath, "AppiumLogin", 4, 0);
        String startWithTwoThreeNumUserName = ExcelData.getData(AndroidLocator.excelPath, "AppiumLogin", 5, 0);


        String blankPassword = ExcelData.getData(AndroidLocator.excelPath, "AppiumLogin", 1, 1);
        String wrongPassword = ExcelData.getData(AndroidLocator.excelPath, "AppiumLogin", 2, 1);
        String reversePassword = ExcelData.getData(AndroidLocator.excelPath, "AppiumLogin", 3, 1);



        //Case 1: Test for string containing characters other than numbers
        loginPageStrategy.login(alphaNumbericUserName);
        loginPageStrategy.login(blankUserName);
        loginPageStrategy.login(lessThanTenDigitUserName);
        loginPageStrategy.enterMobileNumber(moreThanTenDigitUserName);
        String enteredText = loginPageStrategy.getMobileNumberInputText();
        Assert.assertEquals(10, enteredText.length());
        loginPageStrategy.enterMobileNumber("");
        loginPageStrategy.login(startWithTwoThreeNumUserName);


        //case 6:valid login with n deny permission
        LoginHelper loginHelper = new LoginHelper(this);
        loginPageStrategy.login(loginHelper.getMobileNumberManufacturer());
        PasswordPageStrategy passwordPageStrategy = PasswordPageFactory.getStrategy(this);

        //case 7: submit empty password
        passwordPageStrategy.loginWithPassword(blankPassword);
        if (getTest().getTestConfiguration().getDevelopmentFramework() == TestConfiguration.DevelopmentFramework.ReactNative) {
            PopUpPageStrategy popUpPageStrategy = PopUpPageFactory.getStrategy(this);
            popUpPageStrategy.clickOk();
        }
        //case 8: submit a non-empty wrong password
        passwordPageStrategy.loginWithPassword(wrongPassword);
        PopUpPageStrategy popUpPageStrategy = PopUpPageFactory.getStrategy(this);
        popUpPageStrategy.clickOk();

        //case 9:submit wrong password
        passwordPageStrategy = PasswordPageFactory.getStrategy(this);
        passwordPageStrategy.loginWithPassword(reversePassword);
        popUpPageStrategy = PopUpPageFactory.getStrategy(this);
        popUpPageStrategy.clickOk();

        if (getTest().getTestConfiguration().getDevelopmentFramework() == TestConfiguration.DevelopmentFramework.ReactNative) {
            popUpPageStrategy = PopUpPageFactory.getStrategy(this);
            popUpPageStrategy.clickOkPasswordPage();
        }

        //case 10: submit the right password
        passwordPageStrategy = PasswordPageFactory.getStrategy(this);
        passwordPageStrategy.loginWithPassword(PasswordPageStrategy.DEFAULT_PASSWORD);

    }
}
