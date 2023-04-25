package com.wishbook.catalog.TestCases.HomePageNavigation;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.CategoriesPage.CategoriesPageFactory;
import com.wishbook.catalog.PageObject.CategoriesPage.CategoriesPageStrategy;
import com.wishbook.catalog.PageObject.ChangePassword.ChangePasswordFactory;
import com.wishbook.catalog.PageObject.ChangePassword.ChangePasswordStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.NavigationDrawerPage.AppBarPageFactory;
import com.wishbook.catalog.PageObject.NavigationDrawerPage.AppBarPageStrategy;
import com.wishbook.catalog.PageObject.ProfilePage.ProfilePageFactory;
import com.wishbook.catalog.PageObject.ProfilePage.ProfilePageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class HomePageNavigation extends TestCase {
    public HomePageNavigation(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestRetailer));
    }

    protected void run() {
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(this);
   /*     homePageStrategy.clickAppBar(0);
        AppBarPageStrategy appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickCategories();
        CategoriesPageStrategy categoriesPageStrategy= CategoriesPageFactory.getStrategy(this);
        categoriesPageStrategy.getTitle();
        categoriesPageStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickJoinOurWhatsAppGroup();
        JoinOurWhatsAppGroupsStrategy joinOurWhatsAppGroupsStrategy=JoinOurWhatsAppGroupsFactory.getStrategy(this);
        joinOurWhatsAppGroupsStrategy.getTitle();
        joinOurWhatsAppGroupsStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickReferAndEarn();
        ReferAndEarnStrategy referAndEarnStrategy=ReferAndEarnFactory.getStrategy(this);
        referAndEarnStrategy.getTitle();
        referAndEarnStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickLanguage();
        ChangeLanguageStrategy changeLanguageStrategy=ChangeLanguageFactory.getStrategy(this);
        changeLanguageStrategy.getTitle();
        changeLanguageStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickChangePassword();
        ChangePasswordStrategy changePasswordStrategy=ChangePasswordFactory.getStrategy(this);
        changePasswordStrategy.getTitle();
        changePasswordStrategy.clickBackButton();


        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickProfile();
        ProfilePageStrategy profilePageStrategy=ProfilePageFactory.getStrategy(this);
        profilePageStrategy.getTitle();
        profilePageStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickWishbookBankDetails();
        WishbookBankDetailsStrategy wishbookBankDetailsStrategy=WishbookBankDetailsFactory.getStrategy(this);
        wishbookBankDetailsStrategy.getTitle();
        wishbookBankDetailsStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickContactUs();
        ContactUsStrategy contactUsStrategy=ContactUsFactory.getStrategy(this);
        contactUsStrategy.getTitle();
        contactUsStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickFaq();
        FaqStrategy faqStrategy=FaqFactory.getStrategy(this);
        faqStrategy.getTitle();
        faqStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickAboutUs();
        AboutUsStrategy aboutUsStrategy=AboutUsFactory.getStrategy(this);
        aboutUsStrategy.getTitle();
        aboutUsStrategy.clickBackButton();


        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        Assert.assertTrue(appBarPageStrategy.earnResellDisplayed());
        appBarPageStrategy.clickResellAndEarn();
        ResellAndEarnStrategy resellAndEarnStrategy=ResellAndEarnFactory.getStrategy(this);
        resellAndEarnStrategy.getTitle();
        resellAndEarnStrategy.clickBackButton();
        new LoginHelper(this).logout();




        new LoginHelper(this).loginAsTestManufacturer();
        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickCategories();
        categoriesPageStrategy= CategoriesPageFactory.getStrategy(this);
        categoriesPageStrategy.getTitle();
        categoriesPageStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickJoinOurWhatsAppGroup();
        joinOurWhatsAppGroupsStrategy=JoinOurWhatsAppGroupsFactory.getStrategy(this);
        joinOurWhatsAppGroupsStrategy.getTitle();
        joinOurWhatsAppGroupsStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickReferAndEarn();
        referAndEarnStrategy=ReferAndEarnFactory.getStrategy(this);
        referAndEarnStrategy.getTitle();
        referAndEarnStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickLanguage();
        changeLanguageStrategy=ChangeLanguageFactory.getStrategy(this);
        changeLanguageStrategy.getTitle();
        changeLanguageStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickChangePassword();
        changePasswordStrategy=ChangePasswordFactory.getStrategy(this);
        changePasswordStrategy.getTitle();
        changePasswordStrategy.clickBackButton();


        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickProfile();
        profilePageStrategy=ProfilePageFactory.getStrategy(this);
        profilePageStrategy.getTitle();
        profilePageStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickWishbookBankDetails();
        wishbookBankDetailsStrategy=WishbookBankDetailsFactory.getStrategy(this);
        wishbookBankDetailsStrategy.getTitle();
        wishbookBankDetailsStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickContactUs();
        contactUsStrategy=ContactUsFactory.getStrategy(this);
        contactUsStrategy.getTitle();
        contactUsStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickFaq();
        faqStrategy=FaqFactory.getStrategy(this);
        faqStrategy.getTitle();
        faqStrategy.clickBackButton();

        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        appBarPageStrategy.clickAboutUs();
        aboutUsStrategy=AboutUsFactory.getStrategy(this);
        aboutUsStrategy.getTitle();
        aboutUsStrategy.clickBackButton();


        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        appBarPageStrategy=AppBarPageFactory.getStrategy(this);
        Assert.assertTrue(appBarPageStrategy.earnResellDisplayed());
        appBarPageStrategy.clickResellAndEarn();
        resellAndEarnStrategy=ResellAndEarnFactory.getStrategy(this);
        resellAndEarnStrategy.getTitle();
        resellAndEarnStrategy.clickBackButton();
        new LoginHelper(this).logout();
*/

    }
}
