package com.wishbook.catalog.TestCases.StopSellingCatalog;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageFactory;
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.*;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class StopSellingCatalog extends TestCase {
    @SuppressWarnings("unused")
    public StopSellingCatalog(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));

    }
    protected void run() {

        //region Login as Manufacturer and upload catalog
        System.out.println("Login As Manufacturer");
        ProductUploadHelper productUploadHelper = new ProductUploadHelper(this,ProductTestCaseHelper.SetType.SingleColorSet,ProductTestCaseHelper.PhotoshootType.Catalog);
        productUploadHelper.execute();
        //endregion

        //region Search the catalog in Public catalog it should be there
        System.out.println("Searching Catalog in public....");
        CatalogSearchHelper catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(productUploadHelper.getCatalogName());

        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        String catalogName = catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(productUploadHelper.getCatalogName(), catalogName);
        catalogSearchHelper.goBackToHomePageAfterCatalogSelection();
        System.out.println("it is there.!!!!");
        //endregion

        //region Catalog Search in my catalog
        System.out.println("Searching uploaded Catalog in my Catalog");
        catalogSearchHelper.catalogSearchInMyCatalog(productUploadHelper.getCatalogName());
        String catalogNameInMyCatalog = catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(productUploadHelper.getCatalogName(), catalogNameInMyCatalog);
        catalogSearchHelper.goBackToMyBusinessPage();
        System.out.println("it is there.!!!!");
        //endregion

        //region Logout
        System.out.println("Logout Manufacturer\n");
        new LoginHelper(this).logout();
        //endregion

        //region login As Wholesaler
        System.out.println("LoginAs WholeSaler");
        new LoginHelper(this).loginAsTestWholesaler();
        //endregion

        //region Search catalog and Become Seller of Catalog
        catalogSearchHelper.catalogSearchInHomePageSearchButton(productUploadHelper.getCatalogName());
        String catalog2=catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(productUploadHelper.getCatalogName(),catalog2);
//        catalogDetailsPageStrategy.clickBecomeASellerOfThisCatalog()
        //endregion

        //region Search Catalog in public should be there
        System.out.println("Searching Catalog in public....");
        catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(productUploadHelper.getCatalogName());

        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        String catalogName1 = catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(productUploadHelper.getCatalogName(), catalogName1);
        catalogSearchHelper.goBackToHomePageAfterCatalogSelection();
        System.out.println("it is there.!!!!");
        //endregion

        //region Catalog Search in my catalog
        System.out.println("Searching uploaded Catalog in my Catalog");
        catalogSearchHelper.catalogSearchInMyCatalog(productUploadHelper.getCatalogName());
        String catalogNameInMyCatalog1 = catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(productUploadHelper.getCatalogName(), catalogNameInMyCatalog1);
        catalogSearchHelper.goBackToMyBusinessPage();
        System.out.println("it is there.!!!!");
        //endregion

        //region Logout
        System.out.println("Logout Wholesaler");
        new LoginHelper(this).logout();
        //endregion

        //region Login as Manufacturer
        System.out.println("\nLogin As Manufacturer");
        new LoginHelper(this).loginAsTestManufacturer();
        //endregion

        //region verify the sellers of catalog
        catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(productUploadHelper.getCatalogName());

        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        String catalogName2 = catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(productUploadHelper.getCatalogName(), catalogName2);

        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickStopSelling();
        catalogSearchHelper.goBackToHomePageAfterCatalogSelection();
        //endregion

        //region search stopped selling catalog verify start selling button
        System.out.println("checking stop selling catalog in public and my catalog..");
        catalogSearchHelper.searchCatalogInPublicNoCatalogIsDisplay(productUploadHelper.getCatalogName());
        catalogSearchHelper.catalogSearchInMyCatalogNoCatalogsToDisplay(productUploadHelper.getCatalogName());
        MyBusinessPageStrategy myBusinessPageStrategy= MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickMyCatalogs();
        MyCatalogPageStrategy myCatalogPageStrategy= MyCatalogPageFactory.getStrategy(this);
        myCatalogPageStrategy.clickSpinner();
        myCatalogPageStrategy.clickDisabledByMe();
        myCatalogPageStrategy.selectMyCatalogImage(2);
        catalogDetailsPageStrategy.startSellingAgainButtonIsDisplayed();
        Assert.assertTrue(catalogDetailsPageStrategy.startSellingAgainButtonIsDisplayed());
        System.out.println("Start selling Button is there");
        catalogDetailsPageStrategy.BackCatalogButton();
        myCatalogPageStrategy.clickSearchIcon();
        myCatalogPageStrategy.BackCatalogButton();
        //endregion

        //region logout
        System.out.println("manufacturer logout\n");
        new  LoginHelper(this).logout();
        //endregion

        //region login As Wholesaler
        new LoginHelper(this).loginAsWholesaler();
        //endregion

        //region check catalog in public and my catalog

        catalogSearchHelper.catalogSearchInMyCatalog(productUploadHelper.getCatalogName());
        String catalog=catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(productUploadHelper.getCatalogName(),catalog);
        catalogSearchHelper.goBackToMyBusinessPage();

        catalogSearchHelper.catalogSearchInHomePageSearchButton(productUploadHelper.getCatalogName());
        String catalog3=catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(productUploadHelper.getCatalogName(),catalog3);

        CatalogSharingHelper catalogSharingHelper= new CatalogSharingHelper(this);
        catalogSharingHelper.shareCommonIndividualCatalogs("6888877777");
        catalogSearchHelper.goBackToHomePageAfterCatalogSelection();
        //endregion

        catalogSearchHelper.catalogSearchInHomePageSearchButton(productUploadHelper.getCatalogName());
        String catalog4=catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertTrue(catalogDetailsPageStrategy.stopSellingButtonIsDisplayed());
        Assert.assertEquals(productUploadHelper.getCatalogName(),catalog4);
        catalogDetailsPageStrategy.clickStopSelling();

/*        //region login as manufacture  disable catalog and verify
        System.out.println("\n login as manufacturer");
        new LoginHelper(this).loginAsTestManufacturer();
        catalogSearchHelper.catalogSearchInHomePageSearchButton(getTest().getCommonCatalogName());
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        String catalogName = catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(getTest().getCommonCatalogName(), catalogName);
        System.out.println("stop selling catalog!!!");
        catalogDetailsPageStrategy.stopSelling();

        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.BackCatalogButton();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();


        System.out.println("searching disabled catalog in Mycatalog using filer using disabled by me");
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy= MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickMyCatalogs();
        MyCatalogPageStrategy myCatalogPageStrategy = MyCatalogPageFactory.getStrategy(this);
        myCatalogPageStrategy.clickSpinner();
        myCatalogPageStrategy.clickDisabledByMe();
        myCatalogPageStrategy = MyCatalogPageFactory.getStrategy(this);
        myCatalogPageStrategy.selectMyCatalogImage(1);
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        String catalogTitle1 = catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(getTest().getCommonCatalogName(), catalogTitle1);
        boolean b = catalogDetailsPageStrategy.startSellingAgainButtonIsDisplayed();
        Assert.assertTrue(b);
        catalogDetailsPageStrategy.BackCatalogButton();
        myCatalogPageStrategy.clickSearchIcon();
        myCatalogPageStrategy.BackCatalogButton();
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickOrderButton();
        System.out.println("Searching in public catalog");
        bottomTabPageStrategy.clickHomeButton();
        homePageStrategy = HomePageFactory.getStrategy(this);
        homePageStrategy.clickSearch();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName(getTest().getCommonCatalogName());
        String message= "No Data Found";
        String errorMesaage=catalogDetailsPageStrategy.getTextNoCatalogsToDisplay();
        Assert.assertEquals(message,errorMesaage);*/


    }

}
