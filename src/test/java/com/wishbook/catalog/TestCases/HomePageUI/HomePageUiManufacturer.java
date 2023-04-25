package com.wishbook.catalog.TestCases.HomePageUI;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageFactory;
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageStrategy;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1Factory;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1Strategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.HomePageHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class HomePageUiManufacturer extends TestCase {
    @SuppressWarnings("unused")
    public HomePageUiManufacturer(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));

    }
    protected void run() {
        BottomTabPageStrategy bottomTabPageStrategy= BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickHomeButton();
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(this);

        Assert.assertTrue(homePageStrategy.isAppBarDisplayed());
        Assert.assertTrue(homePageStrategy.isWishlistIconDisplayed());
        Assert.assertTrue(homePageStrategy.isCartIconDisplayed());
        Assert.assertTrue(homePageStrategy.isNotificationDisplayed());
        Assert.assertTrue(homePageStrategy.isSearchBoxDisplayed());
        Assert.assertTrue(homePageStrategy.isSliderDisplayed());
     //   Assert.assertFalse(homePageStrategy.isEarnAndSellBannerDisplayed());
        Assert.assertTrue(homePageStrategy.isCreditApplyDisplayed());
        Assert.assertTrue(homePageStrategy.isStoriesDisplayed());
        Assert.assertTrue(homePageStrategy.isCategoriesDisplayed());

        Assert.assertTrue(homePageStrategy.isLaunchedCatalogDisplayed());
//        Assert.assertTrue(homePageStrategy.isPreLaunchedCatalogsDisplayed());
//        Assert.assertTrue(homePageStrategy.isNonCatalogDispalyed());
//        Assert.assertTrue(homePageStrategy.isBuySinglePiecesCatlogDisplayed());
//        Assert.assertTrue(homePageStrategy.isBuySinglePiecesNonCatalogDisplayed());
//        Assert.assertTrue(homePageStrategy.isFromYourWishlistDisplayed());
//        Assert.assertTrue(homePageStrategy.isFestivalLenhengasBannerDisplayed());
//        Assert.assertTrue(homePageStrategy.isExploreBrandsBannerDisplayed());
//
//        Assert.assertTrue(homePageStrategy.isSuitsForAllOccasionsBannerDisplayed());
//        Assert.assertTrue(homePageStrategy.isElegentPrintedCollectionBanner());
//        Assert.assertTrue(homePageStrategy.isProductsYouHaveEnabledDisplayed());
//        Assert.assertTrue(homePageStrategy.isAddNewProductsDisplayed());







    }
}
