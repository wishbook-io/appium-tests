package com.wishbook.catalog.TestCases.HomePageUI;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageFactory;
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageStrategy;
import com.wishbook.catalog.PageObject.MyWishListPage.MyWishListPageFactory;
import com.wishbook.catalog.PageObject.MyWishListPage.MyWishListPageStrategy;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1Factory;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1Strategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.HomePageHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class HomePageUiWholesaler extends TestCase {
    @SuppressWarnings("unused")
    public HomePageUiWholesaler(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestWholeSaler));

    }

    protected void run() {

        BottomTabPageStrategy bottomTabPageStrategy= BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickOrderButton();
        bottomTabPageStrategy.clickHomeButton();
        //region wait
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//endregion

        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.dismissCreditRatingDialog();
//        Assert.assertTrue(homePageStrategy.searchButtonIsDisplayed());
//        Assert.assertTrue(homePageStrategy.wishListIconIsDisplayed());
//        Assert.assertTrue(homePageStrategy.addToCartIsDisplayed());
//        Assert.assertTrue(homePageStrategy.appBarIsDisplayed());
//        Assert.assertTrue(homePageStrategy.applyNowButtonIsDisplayed());
//        Assert.assertTrue(homePageStrategy.notificationIconIsDisplay());

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

        homePageStrategy.clickAddNewCatalogContainer();
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
        String addProduct= productUploadPage1Strategy.getAddProductTileFromToolBar();
        String productTitle="Add Products";
        Assert.assertEquals(addProduct,productTitle);
        productUploadPage1Strategy.BackAddProductButton();
        bottomTabPageStrategy.clickHomeButton();


        homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.clickActiveCatalogs();
        MyCatalogPageStrategy myCatalogPageStrategy= MyCatalogPageFactory.getStrategy(this);
        String MyCatalog=myCatalogPageStrategy.getMyCatalogTileFromToolBar();
        String myCatalog = "My Catalog";
        Assert.assertEquals(MyCatalog,myCatalog);
        myCatalogPageStrategy.BackCatalogButton();




    }
}
