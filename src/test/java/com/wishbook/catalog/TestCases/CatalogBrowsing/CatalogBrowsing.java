package com.wishbook.catalog.TestCases.CatalogBrowsing;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageFactory;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageStrategy;
import com.wishbook.catalog.PageObject.FilterPage.FilterPageFactory;
import com.wishbook.catalog.PageObject.FilterPage.FilterPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.MyWishListPage.MyWishListPageFactory;
import com.wishbook.catalog.PageObject.MyWishListPage.MyWishListPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class CatalogBrowsing extends TestCase {

    @SuppressWarnings("unused")

    public CatalogBrowsing(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));

    }
    protected void run() {


        //region Search in MyCatalog uploaded Catalog,search for wishList Follow Buy now,send enquiry, share
        System.out.println(" Search in MyCatalog uploaded Catalog,search for wishList Follow Buy now,send enquiry, share");
        CatalogSearchHelper catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInMyCatalog(getTest().getCommonCatalogName());
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);


        String getCatalogName = catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(getTest().getCommonCatalogName().toLowerCase(), getCatalogName);
        String getBrandName = catalogDetailsPageStrategy.getBrandNameText();
        Assert.assertEquals(getTest().getCommonCatalogBrandName(), getBrandName);

        String getWork = catalogDetailsPageStrategy.getWorkText();
        Assert.assertEquals(getTest().getCommoncatalogWork(), getWork);
        String getFabric = catalogDetailsPageStrategy.getFabricText();
        Assert.assertEquals(getTest().getCommonCatalogFabric(), getFabric);


        catalogSearchHelper.goBackToMyBusinessPage();
        BottomTabPageStrategy bottomTabPageStrategy= BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickHomeButton();
        new LoginHelper(this).logout();
        System.out.println("logout.. \n\n Login as Retailer");
        //endregion

        //region loginAsRetailer verify uploaded catalog while searching
        new LoginHelper(this).loginAsTestRetailer();
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.dismissCreditRatingDialog();
        System.out.println("\n Retailer Login wait....");


        CatalogSearchHelper catalogSearchHelper1 = new CatalogSearchHelper(this);
        catalogSearchHelper1.catalogSearchInHomePageSearchButton(getTest().getCommonCatalogName());

        String brandName1 = catalogDetailsPageStrategy.getBrandNameText();
        Assert.assertEquals(getTest().getCommonCatalogBrandName(), brandName1);

        String work1 = catalogDetailsPageStrategy.getWorkText();
        Assert.assertEquals(getTest().getCommoncatalogWork(), work1);
        String Fabric1 = catalogDetailsPageStrategy.getFabricText();
        Assert.assertEquals(getTest().getCommonCatalogFabric(), Fabric1);

        catalogDetailsPageStrategy.clickWishListButton();
        Assert.assertTrue(catalogDetailsPageStrategy.isWishListButtonPresent());

        Assert.assertTrue(catalogDetailsPageStrategy.isFollowButtonPresent());

        Assert.assertTrue(catalogDetailsPageStrategy.isAddToCartButtonPresent());

        Assert.assertTrue(catalogDetailsPageStrategy.isShareButtonPresent());

//        Assert.assertTrue(catalogDetailsPageStrategy.isSendEnquiryPresent());


        catalogSearchHelper.goBackToHomePageAfterCatalogSelection();
        //endregion

        //region searching catalog through filter and verify
        System.out.println("filtering uploaded catalog...");
        bottomTabPageStrategy.clickProductsButton();

        CatalogPublicPageStrategy catalogPublicPageStrategy = CatalogPublicPageFactory.getStrategy(this);
        catalogPublicPageStrategy.clickFilterIcon();

        FilterPageStrategy filterPageStrategy = FilterPageFactory.getStrategy(this);
//        filterPageStrategy.selectCategoryAtIndex(5);//Blouse
//        filterPageStrategy.fillBrandNameInSearch("Bs");
//        filterPageStrategy.selectFabricAtIndex(0);//Brocade
//        filterPageStrategy.selectWorkAtIndex(1);//Crochet
//        filterPageStrategy.selectPriceAtIndex(1);
        filterPageStrategy.clickApplyButton();
        catalogPublicPageStrategy = CatalogPublicPageFactory.getStrategy(this);
        catalogPublicPageStrategy.selectCatalogImage(4);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String catalogName1 = catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(getTest().getCommonCatalogName(), catalogName1);
        String brandName2 = catalogDetailsPageStrategy.getBrandNameText();
        Assert.assertEquals(getTest().getCommonCatalogBrandName(), brandName2);
        String work2 = catalogDetailsPageStrategy.getWorkText();
        Assert.assertEquals(getTest().getCommoncatalogWork(), work2);
        String Fabric2 = catalogDetailsPageStrategy.getFabricText();
        Assert.assertEquals(getTest().getCommonCatalogFabric(), Fabric2);

        catalogDetailsPageStrategy.clickWishListButton();

        Assert.assertTrue(catalogDetailsPageStrategy.isWishListButtonPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isFollowButtonPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isAddToCartButtonPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isShareButtonPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isSendEnquiryPresent());
        catalogDetailsPageStrategy.BackCatalogButton();
        //endregion

        //region searching catalog in My wishlist and verify
        System.out.println("searching in my wishList..");
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickHomeButton();
        homePageStrategy = HomePageFactory.getStrategy(this);
        homePageStrategy.clickHomeWishListIcon();
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        String catalogTitle = catalogDetailsPageStrategy.getCatalogTitle().toLowerCase();
        Assert.assertEquals(getTest().getCommonCatalogName(), catalogTitle);
        MyWishListPageStrategy myWishListPageStrategy = MyWishListPageFactory.getStrategy(this);
        myWishListPageStrategy.BackMyCatalogButton();
        //endregion
        new LoginHelper(this).logout();
        System.out.println("logout");
        //endregion


        //endregion
    }
}

