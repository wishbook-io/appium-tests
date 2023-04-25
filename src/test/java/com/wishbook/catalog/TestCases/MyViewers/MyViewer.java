package com.wishbook.catalog.TestCases.MyViewers;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.MyViewersPage.MyViewerPageStrategy;
import com.wishbook.catalog.PageObject.MyViewersPage.MyViewersPageFactory;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductTestCaseHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductUploadHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

/**
 * Created by wishbook on 10/4/18.
 */

public class MyViewer extends TestCase {

    @SuppressWarnings("unused")
    public MyViewer(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestRetailer));
    }


    @Override
    protected void run() {

        System.out.println("Login as Retailer and check My Viewer Button is displayed or not!!!");
        BottomTabPageStrategy bottomTabPageStrategy=BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy= MyBusinessPageFactory.getStrategy(this);
        String BuyerCompanyName=myBusinessPageStrategy.getTextCompanyName();
        System.out.println("BuyerCompanyName = " +BuyerCompanyName);
//        boolean v = myBusinessPageStrategy.myViewerIsDisplayed();
//        Assert.assertTrue(v);
//        System.out.println("My Viewer Button is Displayed is " +v);

        new LoginHelper(this).logout();
        System.out.println("Logout\n");



        //region Login As Manufacture
        new LoginHelper(this).loginAsTestManufacturer();
        System.out.println("Login As Manufacturer and Upload Catalog");
        ProductUploadHelper productUploadHelper = new ProductUploadHelper(this,ProductTestCaseHelper.SetType.SingleColorSet,ProductTestCaseHelper.PhotoshootType.Catalog);
        productUploadHelper.execute();
        new LoginHelper(this).logout();
        System.out.println("Logout\n");


        System.out.println("Login as Retailer");
        new LoginHelper(this).loginAsTestRetailer();
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.dismissCreditRatingDialog();
        System.out.println("seeing uploaded catalog....");
        CatalogSearchHelper catalogSearchHelper= new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(productUploadHelper.getCatalogName());
        CatalogDetailsPageStrategy catalogDetailsPageStrategy= CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickWishListButton();
        catalogSearchHelper.goBackToHomePageAfterCatalogSelection();
        new LoginHelper(this).logout();
        System.out.println("Logout\n");


        //region goto My viewers and check who is recently
        new LoginHelper(this).loginAsTestManufacturer();
        System.out.println("Login As Manufacturer and Upload Catalog");
        bottomTabPageStrategy= BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        myBusinessPageStrategy= MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickMyViewersButton();
        MyViewerPageStrategy myViewerPageStrategy= MyViewersPageFactory.getStrategy(this);
        myViewerPageStrategy.clickRecentViewer();

        String catalogNameInMyViewers=myViewerPageStrategy.getCatatlogNameMyViewer().toLowerCase();
        Assert.assertEquals(productUploadHelper.getCatalogName(),catalogNameInMyViewers);
        System.out.println("CatalogNameInMyViewer = " +catalogNameInMyViewers);


        String brandNameInMyViewer =myViewerPageStrategy.getBrandNameMyViewer();
        Assert.assertEquals(productUploadHelper.getSelectedBrandName(),brandNameInMyViewer);
        System.out.println("BrandNameInMyViewer = " +brandNameInMyViewer);

        String companyNameInMyViewer=myViewerPageStrategy.getCompanyNameRecentlyViewed();
        Assert.assertEquals(BuyerCompanyName,companyNameInMyViewer);
        System.out.println("companyNameInMyViewer = " +companyNameInMyViewer);
        //endregion
    }
}
