package com.wishbook.catalog.TestCases.HomePageUI;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.MyWishListPage.MyWishListPageFactory;
import com.wishbook.catalog.PageObject.MyWishListPage.MyWishListPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.HomePageHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class HomePageUiRetailer extends TestCase {
    @SuppressWarnings("unused")
    public HomePageUiRetailer(BaseTest test) {

        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestRetailer));

    }
    protected void run() {
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.dismissCreditRatingDialog();
        BottomTabPageStrategy bottomTabPageStrategy= BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickOrderButton();
        bottomTabPageStrategy.clickHomeButton();
        //region wait
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//endregion

         homePageStrategy= HomePageFactory.getStrategy(this);

//        Assert.assertTrue(homePageStrategy.searchButtonIsDisplayed());
//        Assert.assertTrue(homePageStrategy.wishListIconIsDisplayed());
//        Assert.assertTrue(homePageStrategy.addToCartIsDisplayed());
//        Assert.assertTrue(homePageStrategy.appBarIsDisplayed());
//        Assert.assertTrue(homePageStrategy.applyNowButtonIsDisplayed());
//        Assert.assertTrue(homePageStrategy.notificationIconIsDisplay());
//        Assert.assertTrue(homePageStrategy.wishBookStoriesTextIsDisplyed());
//        Assert.assertTrue(homePageStrategy.storiesRecyclerViewIsDisplayed());
//        Assert.assertTrue(homePageStrategy.addToCartIsDisplayed());


        HomePageHelper homePageHelper= new HomePageHelper(this);
        homePageHelper.checkTopAreaSlider();
        homePageHelper.checkAllBrandPage();
        homePageHelper.checkNonCatalogAndNonCatalogBanner();
        homePageHelper.checkSinglePiecesAndItsBanner();
        homePageHelper.checkBanner();


        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickWishlistSeeAll();
        MyWishListPageStrategy myWishListPageStrategy=MyWishListPageFactory.getStrategy(this);
        String wishListText=myWishListPageStrategy.getMyWishListTileFromToolBar();
        String wishlist="My Wishlist";
        Assert.assertEquals(wishlist,wishListText);
        myWishListPageStrategy.BackMyCatalogButton();





    }
}
