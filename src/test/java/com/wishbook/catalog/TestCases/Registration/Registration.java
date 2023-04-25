package com.wishbook.catalog.TestCases.Registration;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.ExcelData;
import com.wishbook.catalog.PageObject.IntroSliderPage.IntroSliderPageFactory;
import com.wishbook.catalog.PageObject.IntroSliderPage.IntroSliderPageStrategy;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageFactory;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageFactory;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.PageObject.RegistrationPage.RegistrationPageFactory;
import com.wishbook.catalog.PageObject.RegistrationPage.RegistrationPageStrategy;
import com.wishbook.catalog.PageObject.RegistrationSelectCompanyTypePage.RegistrationSelectCompanyTypePageFactory;
import com.wishbook.catalog.PageObject.RegistrationSelectCompanyTypePage.RegistrationSelectCompanyTypePageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

/**
 * Created by wishbook on 13/3/18.
 */

public class Registration extends TestCase {

    public Registration(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.DontLogin));
    }

    protected void run() throws Exception  {

        String guestLogin=ExcelData.getData(AndroidLocator.excelPath, "AppiumLogin", 1, 2);
        String password=ExcelData.getData(AndroidLocator.excelPath, "AppiumLogin", 4, 1);


        LoginPageStrategy loginPageStrategy = LoginPageFactory.getStrategy(this);
        loginPageStrategy.login(guestLogin);
        PasswordPageStrategy passwordPageStrategy = PasswordPageFactory.getStrategy(this);
        passwordPageStrategy.loginWithPassword(password);

        RegistrationPageStrategy registrationPageStrategy = RegistrationPageFactory.getStrategy(this);
        registrationPageStrategy.selectEnglish();
        registrationPageStrategy.clickStartUsingWishbookButton();
        registrationPageStrategy.selectHomeBasedReseller();
        String actualHomeBasedSeller=registrationPageStrategy.getHomeBasedReseller();
        String expectedHomeBasedSeller="Home-based reseller";
        Assert.assertEquals(actualHomeBasedSeller,expectedHomeBasedSeller);
        registrationPageStrategy.clickStartUsingWishbookButton();
        IntroSliderPageStrategy introSliderPageStrategy = IntroSliderPageFactory.getStrategy(this);
        introSliderPageStrategy.clickGetStarted();
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        String companyNameActual=myBusinessPageStrategy.getCompanyType();
        String companyNameExpected="Online-Retailer Reseller";
        Assert.assertEquals(companyNameActual,companyNameExpected);
        LoginHelper loginHelper = new LoginHelper(this);
        loginHelper.logout();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        loginPageStrategy = LoginPageFactory.getStrategy(this);
        loginPageStrategy.login(guestLogin);
        passwordPageStrategy = PasswordPageFactory.getStrategy(this);
        passwordPageStrategy.loginWithPassword(password);

        registrationPageStrategy = RegistrationPageFactory.getStrategy(this);
        registrationPageStrategy.selectEnglish();
        registrationPageStrategy.clickStartUsingWishbookButton();
        registrationPageStrategy.selectRetailer();
        String actualRetailer=registrationPageStrategy.getRetailer();
        String expectedRetailer="Retailer";
        Assert.assertEquals(actualRetailer,expectedRetailer);
        registrationPageStrategy.clickStartUsingWishbookButton();
        introSliderPageStrategy = IntroSliderPageFactory.getStrategy(this);
        introSliderPageStrategy.clickGetStarted();
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        String companyNameActualRetailer=myBusinessPageStrategy.getCompanyType();
        String companyNameExpectedRetailer="Retailer";
        Assert.assertEquals(companyNameActualRetailer,companyNameExpectedRetailer);
        loginHelper = new LoginHelper(this);
        loginHelper.logout();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        loginPageStrategy = LoginPageFactory.getStrategy(this);
        loginPageStrategy.login(guestLogin);
        passwordPageStrategy = PasswordPageFactory.getStrategy(this);
        passwordPageStrategy.loginWithPassword(password);
        registrationPageStrategy = RegistrationPageFactory.getStrategy(this);
        registrationPageStrategy.selectEnglish();
        registrationPageStrategy.clickStartUsingWishbookButton();
        registrationPageStrategy.selectWholesaler();
        String actualManufacturer=registrationPageStrategy.getManufacturerWholeSalerBroker();
        String expectedManufacturer="Manufacturer/ Wholesaler/ Broker";
        Assert.assertEquals(actualManufacturer,expectedManufacturer);
        registrationPageStrategy.clickStartUsingWishbookButton();
        introSliderPageStrategy = IntroSliderPageFactory.getStrategy(this);
        introSliderPageStrategy.clickGetStarted();
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        String companyNameActualManufacturer=myBusinessPageStrategy.getCompanyType();
        String companyNameExpectedManufacturer="Wholesaler Distributor";
        Assert.assertEquals(companyNameActualManufacturer,companyNameExpectedManufacturer);
        loginHelper = new LoginHelper(this);
        loginHelper.logout();


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPageStrategy = LoginPageFactory.getStrategy(this);
        loginPageStrategy.login(guestLogin);
        passwordPageStrategy = PasswordPageFactory.getStrategy(this);
        passwordPageStrategy.loginWithPassword(password);
        registrationPageStrategy.clickCloseButton();
        PopUpPageStrategy popUpPageStrategy= PopUpPageFactory.getStrategy(this);
        popUpPageStrategy.clickYesRegister();
        loginPageStrategy = LoginPageFactory.getStrategy(this);
        loginPageStrategy.login(guestLogin);
        passwordPageStrategy = PasswordPageFactory.getStrategy(this);
        passwordPageStrategy.loginWithPassword(password);

        registrationPageStrategy.clickCloseButton();
        popUpPageStrategy= PopUpPageFactory.getStrategy(this);
        popUpPageStrategy.clickCancelRegister();
        registrationPageStrategy.clickCloseButton();






    }
}


