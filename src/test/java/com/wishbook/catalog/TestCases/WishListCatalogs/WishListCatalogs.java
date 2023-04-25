package com.wishbook.catalog.TestCases.WishListCatalogs;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarFactory;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.MyWishListPage.MyWishListPageFactory;
import com.wishbook.catalog.PageObject.MyWishListPage.MyWishListPageStrategy;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageFactory;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

/**
 * Created by wishbook on 14/5/18.
 */

public class WishListCatalogs extends TestCase {

    @SuppressWarnings("unused")
    public WishListCatalogs(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestRetailer));

    }
    @Override
    protected void run() {

        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(this);
//        homePageStrategy.dismissCreditRatingDialog();


        //region WishList Count in HomePage
        System.out.println("Count number Of Catalogs in WishList before Adding to WishList");
        homePageStrategy = HomePageFactory.getStrategy(this);
        int HomePageCount = homePageStrategy.getWishListCountOnMenuBadge();
        System.out.println("WishListcounts On HomePage =" + HomePageCount);
        //endregion

        //region WishList Count in CatalogToolBar
        BottomTabPageStrategy bottomTabPageStrategy=BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickProductsButton();
        CatalogToolBarStrategy catalogToolBarStrategy = CatalogToolBarFactory.getStrategy(this);
        int catalogToolBarWishlist = catalogToolBarStrategy.getWishListCountOnMenuBadgeCatalogToolBar();
        System.out.println("catalogToolBarWishlist =" + catalogToolBarWishlist);
        //endregion

        //region WishList Count in MyBusiness
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        int myBusinessWishListCount = myBusinessPageStrategy.getWishListAsShownInMyBusiness();
        System.out.println("myBusinessWishListCount= " + myBusinessWishListCount);
        //endregion

        //region Search For Uploaded Catalog and add to WishList
        System.out.println("Search uploaded Catalog and to wishlist");
        CatalogSearchHelper catalogSearchHelper =new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(getTest().getCommonCatalogName());

//        catalogSearchHelper.catalogSearchInHomePageSearchButton("test_rwbitfhl");


        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        String catalogName = catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        catalogDetailsPageStrategy.clickWishListButton();
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.wishListSelected();
        catalogDetailsPageStrategy.BackCatalogButton();
        SearchPageStrategy searchPageStrategy =SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName(getTest().getCommonCatalogName());
        SearchPageStrategy searchPageStrategy1 = SearchPageFactory.getStrategy(this);
        searchPageStrategy1.BackHomeSearchButton();

        //endregion

        //region Goto MyCatalog and check For Added catalog
        System.out.println("Checking catalog is in My wishList...");
        homePageStrategy = HomePageFactory.getStrategy(this);
        homePageStrategy.clickHomeWishListIcon();
        MyWishListPageStrategy myWishListPageStrategy = MyWishListPageFactory.getStrategy(this);
        String catalogTitle = myWishListPageStrategy.getMyWishListCatalogTitle().toLowerCase();
       Assert.assertEquals(catalogName, catalogTitle);
        myWishListPageStrategy.BackMyCatalogButton();
        System.out.println("Catalog is in My WishList");
        //endregion

        //region catalogToolBar WishList increased by 1
        System.out.println("\n Count Number Of Catalogs After Adding to wishList increases by 1");
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickProductsButton();
        catalogToolBarStrategy = CatalogToolBarFactory.getStrategy(this);
        int wishListCountAsShownOnCatalogsPageToolbar = catalogToolBarStrategy.getWishListCountOnMenuBadgeCatalogToolBar();
        System.out.println("catalogToolBarWishlist= " + wishListCountAsShownOnCatalogsPageToolbar);
        int t = catalogToolBarWishlist + 1;
        Assert.assertEquals(t, wishListCountAsShownOnCatalogsPageToolbar);
        //endregion

        //region MyBusiness WishList increased By 1
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        int WishListAsShownInMyBusiness = myBusinessPageStrategy.getWishListAsShownInMyBusiness();
        System.out.println("myBusinessWishListCount= " + WishListAsShownInMyBusiness);
        int u = myBusinessWishListCount + 1;
        Assert.assertEquals(u, WishListAsShownInMyBusiness);
        //endregion

        //region HomePage WishList increased by 1
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickHomeButton();
        homePageStrategy = HomePageFactory.getStrategy(this);
        int wishListCountAsShownOnHomePageToolbar = homePageStrategy.getWishlistCountAsShownOnToolbar();
        System.out.println("HomePageCount= " + wishListCountAsShownOnHomePageToolbar);
        int s = HomePageCount + 1;
        Assert.assertEquals(s, wishListCountAsShownOnHomePageToolbar);
        //endregion

        //region Assert
        Assert.assertEquals(wishListCountAsShownOnCatalogsPageToolbar, wishListCountAsShownOnHomePageToolbar);
        Assert.assertEquals(wishListCountAsShownOnCatalogsPageToolbar, WishListAsShownInMyBusiness);
        Assert.assertEquals(WishListAsShownInMyBusiness, wishListCountAsShownOnHomePageToolbar);
        //endregion

        //region Search uploaded Catalogs and remove from WishList
        System.out.println("search Uploaded Catalog... And Removing from Wishlist");
        CatalogSearchHelper catalogSearchHelper1 =new CatalogSearchHelper(this);
        catalogSearchHelper1.catalogSearchInHomePageSearchButton(getTest().getCommonCatalogName());

        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        String catalogName1 = catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        catalogDetailsPageStrategy.clickWishListButton();//to remove From WishList
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);


        catalogDetailsPageStrategy.BackCatalogButton();
        searchPageStrategy =SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName(getTest().getCommonCatalogName());
        searchPageStrategy1 = SearchPageFactory.getStrategy(this);
        searchPageStrategy1.BackHomeSearchButton();
        System.out.println("Catalog Removed from WishList");
        //endregion

        //region Goto MyWishList Uploaded Catalog Should Not be There
        System.out.println("Searching Catalog in My Catalog...");
        homePageStrategy = HomePageFactory.getStrategy(this);
        homePageStrategy.clickHomeWishListIcon();
        myWishListPageStrategy = MyWishListPageFactory.getStrategy(this);
        String catalogTitle1 = myWishListPageStrategy.getMyWishListCatalogTitle().toLowerCase();

        Assert.assertNotSame(catalogName1, catalogTitle1);
        myWishListPageStrategy.BackMyCatalogButton();
        System.out.println("Catalog is not in My WishList");
        //endregion

        //region catalogToolBar WishList Decrease By 1
        System.out.println("Count number of catalogs after removing Catalog From myWishList Decreases by 1");
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickProductsButton();
        catalogToolBarStrategy = CatalogToolBarFactory.getStrategy(this);
        int wishListCountAsShownOnCatalogsPageToolbar1 = catalogToolBarStrategy.getWishListCountOnMenuBadgeCatalogToolBar();
        System.out.println("catalogToolBarWishList= " + wishListCountAsShownOnCatalogsPageToolbar1);
        int a = wishListCountAsShownOnCatalogsPageToolbar - 1;
        Assert.assertEquals(catalogToolBarWishlist, a);
        //endregion

        //region MyBusiness WishList Decreased By 1
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        int WishListAsShownInMyBusiness1 = myBusinessPageStrategy.getWishListAsShownInMyBusiness();
        System.out.println("myBusinessWishList " + WishListAsShownInMyBusiness1);
        int b = WishListAsShownInMyBusiness - 1;
        Assert.assertEquals(b, myBusinessWishListCount);
        //endregion

        //region HomePage WishList Decreased By 1
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickHomeButton();
        homePageStrategy = HomePageFactory.getStrategy(this);
        int wishListCountAsShownOnHomePageToolbar1 = homePageStrategy.getWishlistCountAsShownOnToolbar();
        System.out.println("homePageWishList  " + wishListCountAsShownOnHomePageToolbar1);
        int c = wishListCountAsShownOnHomePageToolbar - 1;
        Assert.assertEquals(c, HomePageCount);
        //endregion

        //region Assert
        Assert.assertEquals(wishListCountAsShownOnCatalogsPageToolbar1, wishListCountAsShownOnHomePageToolbar1);
        Assert.assertEquals(wishListCountAsShownOnCatalogsPageToolbar1, WishListAsShownInMyBusiness1);
        Assert.assertEquals(WishListAsShownInMyBusiness1, wishListCountAsShownOnHomePageToolbar1);
        //endregion
        new LoginHelper(this).logout();
    }
}
