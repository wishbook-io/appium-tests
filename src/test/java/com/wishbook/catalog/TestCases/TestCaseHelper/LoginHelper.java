package com.wishbook.catalog.TestCases.TestCaseHelper;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.IntroSliderPage.IntroSliderPageFactory;
import com.wishbook.catalog.PageObject.IntroSliderPage.IntroSliderPageStrategy;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageFactory;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageStrategy;
import com.wishbook.catalog.PageObject.NavigationDrawerPage.AppBarPageStrategy;
import com.wishbook.catalog.PageObject.NavigationDrawerPage.AppBarPageFactory;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageFactory;
import com.wishbook.catalog.PageObject.PasswordPage.PasswordPageStrategy;
import com.wishbook.catalog.PageObject.SelectLanguage.LanguagePageFactory;
import com.wishbook.catalog.PageObject.SelectLanguage.LanguagePageStrategy;
import com.wishbook.catalog.TestCases.TestCase;

public class LoginHelper extends BaseTestCaseHelper {
    private static final String MOBILE_NUMBER_WHOLESALER_STAGING ="9925024856";
    private static final String MOBILE_NUMBER_RETAILER_STAGING ="7567760909";
    private static final String MOBILE_NUMBER_MANUFACTURER_STAGING ="8989898981";
    private static final String MOBILE_NUMBER_SALESPERSON_STAGING ="8888888888";
    private static final String MOBILE_NUMBER_GUEST_USER_STAGING ="6988888888";
    private static final String MOBILE_NUMBER_USER_STAGING ="6554444444";
    private static final String MOBILE_NUMBER_ONLINE_RETAILER_STAGING ="8686898989";
    private static final String MOBILE_NUMBER_BROKER_STAGING ="7676797979";
    private static final String MOBILE_NUMBER_TEST_RETAILER_STAGING ="6888877777";
    private static final String MOBILE_NUMBER_TEST_WHOLESALER_STAGING ="6554444444";
    private static final String MOBILE_NUMBER_TEST_MANUFACTURER_STAGING ="7575797979";
    private static final String MOBILE_NUMBER_TEST_WISHBOOK_INFO_STAGING="9978618989";
    private static final String MOBILE_NUMBER_TEST_RESELLER="6455555555";
    private static final String MOBILE_NUMBER_TEST_WHOLESALER_CATALOG_UPLOADER="7575787878";



    private static final String MOBILE_NUMBER_WHOLESALER_PRODUCTION="9304970848";
    private static final String MOBILE_NUMBER_RETAILER_PRODUCTION="9113779710";
    private static final String MOBILE_NUMBER_MANUFACTURER_PRODUCTION="9304970849";
    private static final String MOBILE_NUMBER_SALESPERSON_PRODUCTION="8888888888";
    private static final String MOBILE_NUMBER_GUEST_USER_PRODUCTION="6988888888";
    private static final String MOBILE_NUMBER_USER_PRODUCTION="9304970848";
    private static final String MOBILE_NUMBER_ONLINE_RETAILER_PRODUCTION="8686898989";
    private static final String MOBILE_NUMBER_BROKER_PRODUCTION="7676797979";
    private static final String MOBILE_NUMBER_TEST_RETAILER_PRODUCTION="9113779710";
    private static final String MOBILE_NUMBER_TEST_WHOLESALER_PRODUCTION="9304970848";
    private static final String MOBILE_NUMBER_TEST_MANUFACTURER_PRODUCTION="9304970849";

    public String getMobileNumberWholesaler(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_WHOLESALER_PRODUCTION;
                            break;
            case Staging:mobileNumber=MOBILE_NUMBER_WHOLESALER_STAGING;
                         break;
        }
        return mobileNumber;
    }

    public String getMobileNumberTestWholesalerCatalogUploader(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_TEST_WHOLESALER_CATALOG_UPLOADER;
                break;
            case Staging:mobileNumber=MOBILE_NUMBER_TEST_WHOLESALER_CATALOG_UPLOADER;
                break;
        }
        return mobileNumber;
    }

    public String getMobileNumberRetailer(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_RETAILER_PRODUCTION;
                break;
            case Staging:mobileNumber=MOBILE_NUMBER_RETAILER_STAGING;
                break;
        }
        return mobileNumber;
    }

    public String getMobileNumberManufacturer(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_MANUFACTURER_PRODUCTION;
                break;
            case Staging:mobileNumber=MOBILE_NUMBER_MANUFACTURER_STAGING;
                break;
        }
        return mobileNumber;
    }

    public String getMobileNumberSalesPerson(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_SALESPERSON_PRODUCTION;
                break;
            case Staging:mobileNumber=MOBILE_NUMBER_SALESPERSON_STAGING;
                break;
        }
        return mobileNumber;
    }

    public String getMobileNumberGuestUser(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_GUEST_USER_PRODUCTION;
                break;
            case Staging:mobileNumber=MOBILE_NUMBER_GUEST_USER_STAGING;
                break;
        }
        return mobileNumber;
    }

    public String getMobileNumberUser(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_USER_PRODUCTION;
                break;
            case Staging:mobileNumber=MOBILE_NUMBER_USER_STAGING;
                break;
        }
        return mobileNumber;
    }

    public String getMobileNumberOnlineRetailer(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_ONLINE_RETAILER_PRODUCTION;
                break;
            case Staging:mobileNumber=MOBILE_NUMBER_ONLINE_RETAILER_STAGING;
                break;
        }
        return mobileNumber;
    }

    public String getMobileNumberTestRetailer(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_TEST_RETAILER_PRODUCTION;
                break;
            case Staging:mobileNumber=MOBILE_NUMBER_TEST_RETAILER_STAGING;
                break;
        }
        return mobileNumber;
    }

    public String getMobileNumberBroker(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_BROKER_PRODUCTION;
                break;
            case Staging:mobileNumber=MOBILE_NUMBER_BROKER_STAGING;
                break;
        }
        return mobileNumber;
    }


    public String getMobileNumberTestWholesaler(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_TEST_WHOLESALER_PRODUCTION;
                break;
            case Staging:mobileNumber=MOBILE_NUMBER_TEST_WHOLESALER_STAGING;
                break;
        }
        return mobileNumber;
    }

    public String getMobileNumberTestReseller(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_TEST_RESELLER;
                break;
            case Staging:mobileNumber=MOBILE_NUMBER_TEST_RESELLER;
                break;
        }
        return mobileNumber;
    }

    public String getMobileNumberTestManufacturer(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_TEST_MANUFACTURER_PRODUCTION;
                break;
            case Staging:mobileNumber=MOBILE_NUMBER_TEST_MANUFACTURER_STAGING;
                break;
        }
        return mobileNumber;
    }

    public String getMobileNumberWishBookInfo(){
        String mobileNumber="";
        switch (testCase.getTest().getTestConfiguration().getServerType()){
            case Production:mobileNumber=MOBILE_NUMBER_TEST_WISHBOOK_INFO_STAGING;
                break;
            case Staging:mobileNumber=MOBILE_NUMBER_TEST_WISHBOOK_INFO_STAGING;
                break;
        }
        return mobileNumber;
    }

    public LoginHelper(TestCase testCase) {
        super(testCase);
    }

    public static void login(TestCase testCase) {
        LoginHelper helper = new LoginHelper(testCase);
        switch (testCase.getTestCaseOptions().getInitialLoginType()) {
            case LoginAsManufacturer:
                helper.loginAsManufacturer();
                break;
            case LoginAsWholeSaler:
                helper.defaultLogin();
                break;
            case LoginAsRetailer:
                helper.loginAsRetailer();
                break;
            case LoginAsTestManufacturer:
                helper.loginAsTestManufacturer();
                break;
            case LoginAsTestRetailer:
                helper.loginAsTestRetailer();
                break;
            case LoginAsTestWholeSaler:
                helper.loginAsTestWholesaler();
                break;
            case LoginAsBroker:
                helper.loginAsBroker();
                break;
            case LoginAsGuestUser:
                helper.loginAsGuestUser();
                break;
            case LoginAsUser:
                helper.loginAsUser();
                break;
            case LoginAsSalesPerson:
                helper.loginAsSalesPerson();
                break;
            case LoginAsWishbookInfoServices:
                helper.loginAsWishbookInfoServices();
                break;
            case  LoginAsTestReseller:
                helper.loginAsTestReseller();
            case LoginAsWholesalerCatalogUploader:
                helper.loginAsWholesalerCatalogUploader();

        }
    }

    public void loginToHome(String mobileNumber, String password) {
        LoginPageStrategy loginPageStrategy = LoginPageFactory.getStrategy(testCase);
        loginPageStrategy.login(mobileNumber);
        PasswordPageStrategy passwordPageStrategy = PasswordPageFactory.getStrategy(testCase);
        passwordPageStrategy.loginWithPassword(password);
        try{
            LanguagePageStrategy languagePageStrategy = LanguagePageFactory.getStrategy(testCase);
            languagePageStrategy.selectEnglishLanguage();
            IntroSliderPageStrategy introSliderPageStrategy = IntroSliderPageFactory.getStrategy(testCase);
            introSliderPageStrategy.clickGetStarted();
        }catch (Exception e){

        }
    }

    public void defaultLogin() {
        loginToHome(getMobileNumberWholesaler(), PasswordPageStrategy.DEFAULT_PASSWORD);
    }

    public void loginAsRetailer() {
        loginToHome(getMobileNumberRetailer(), PasswordPageStrategy.DEFAULT_PASSWORD);
    }

    public void loginAsManufacturer() {
        loginToHome(getMobileNumberManufacturer(), PasswordPageStrategy.DEFAULT_PASSWORD);
    }

    public void loginAsWholesaler() {
        loginToHome(getMobileNumberWholesaler(), PasswordPageStrategy.DEFAULT_PASSWORD);
    }
    public void loginAsSalesPerson() {
        loginToHome(getMobileNumberSalesPerson(),PasswordPageStrategy.DEFAULT_PASSWORD);
    }

    public void loginAsBroker() {
        loginToHome(getMobileNumberBroker(), PasswordPageStrategy.DEFAULT_PASSWORD);
    }

    public void loginAsTestRetailer() {
        loginToHome(getMobileNumberTestRetailer(), PasswordPageStrategy.DEFAULT_PASSWORD);
    }

    public void loginAsTestWholesaler() {
        loginToHome(getMobileNumberTestWholesaler(), PasswordPageStrategy.DEFAULT_PASSWORD);
    }
    @SuppressWarnings("unused")
    public void loginAsOnlineRetailer() {
        loginToHome(getMobileNumberOnlineRetailer(), PasswordPageStrategy.DEFAULT_PASSWORD);
    }

    public void loginAsUser() {
        loginToHome(getMobileNumberUser(), PasswordPageStrategy.DEFAULT_PASSWORD);
    }

    public void loginAsGuestUser() {
        loginToHome(getMobileNumberGuestUser(), PasswordPageStrategy.DEFAULT_PASSWORD);
    }

    public void loginAsTestManufacturer() {
        loginToHome(getMobileNumberTestManufacturer(), PasswordPageStrategy.DEFAULT_PASSWORD);
    }
    public void loginAsWishbookInfoServices() {
        loginToHome(getMobileNumberWishBookInfo(), PasswordPageStrategy.DEFAULT_PASSWORD);

    }
    public void loginAsTestReseller() {
        loginToHome(getMobileNumberTestReseller(),PasswordPageStrategy.DEFAULT_PASSWORD);
    }
    public void loginAsWholesalerCatalogUploader(){
        loginToHome(getMobileNumberTestWholesalerCatalogUploader(),PasswordPageStrategy.DEFAULT_PASSWORD);
    }

    public void logout() {
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickHomeButton();
        HomePageStrategy homePageStrategy = HomePageFactory.getStrategy(testCase);

        if(testCase.getTest().getTestConfiguration().getDevelopmentFramework()==TestConfiguration.DevelopmentFramework.NativeAndroid){
            homePageStrategy.clickAppBar(0);
        }
         else {
            homePageStrategy.clickAppBar();
        }

        AppBarPageStrategy navigationDrawerPageStrategy = AppBarPageFactory.getStrategy(testCase);
        navigationDrawerPageStrategy.clickLogout();
    }

}
