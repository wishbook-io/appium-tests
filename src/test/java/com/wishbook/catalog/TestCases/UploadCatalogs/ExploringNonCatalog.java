package com.wishbook.catalog.TestCases.UploadCatalogs;

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
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageFactory;
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageStrategy;
import com.wishbook.catalog.PageObject.ProductSpinner.ProductSpinnerFactory;
import com.wishbook.catalog.PageObject.ProductSpinner.ProductSpinnerStrategy;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1Factory;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1Strategy;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageFactory;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductTestCaseHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductUploadHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class ExploringNonCatalog extends TestCase {
    public ExploringNonCatalog(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));
    }

    protected void run() {

        //region Check trusted seller option for noncatalog
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.dismissCreditRatingDialog();
        BottomTabPageStrategy bottomTabPageStrategy= BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickProductsButton();

        CatalogToolBarStrategy catalogToolBarStrategy= CatalogToolBarFactory.getStrategy(this);
        catalogToolBarStrategy.clickProductTypeSpinner();
        ProductSpinnerStrategy productSpinnerStrategy= ProductSpinnerFactory.getStrategy(this);
        productSpinnerStrategy.clickNonCatalogSpinner();
        //endregion

        //region Check if the user sees non-catalog option
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy= MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickAddCatalogButton();

        ProductUploadPage1Strategy productUploadPage1Strategy =ProductUploadPage1Factory.getStrategy(this);
        Assert.assertTrue(productUploadPage1Strategy.catalogRadioButtonIsDisplyed());
        Assert.assertTrue(productUploadPage1Strategy.nonCatalogRadioButtonIsDisplyed());
        productUploadPage1Strategy.BackAddProductButton();
        //endregion

        myBusinessPageStrategy=MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickMyCatalogs();

        MyCatalogPageStrategy myCatalogPageStrategy= MyCatalogPageFactory.getStrategy(this);
        myCatalogPageStrategy.clickAddCatalogIcon();

        productUploadPage1Strategy= ProductUploadPage1Factory.getStrategy(this);


        Assert.assertTrue(productUploadPage1Strategy.catalogRadioButtonIsDisplyed());
        Assert.assertTrue(productUploadPage1Strategy.nonCatalogRadioButtonIsDisplyed());
        productUploadPage1Strategy.clickNonCatalogRadioButton();
        productUploadPage1Strategy.BackAddProductButton();

        myCatalogPageStrategy= MyCatalogPageFactory.getStrategy(this);
        myCatalogPageStrategy.clickSearchIcon();
        myCatalogPageStrategy.BackCatalogButton();

        ProductUploadHelper productUploadHelper = new ProductUploadHelper(this,ProductTestCaseHelper.SetType.SingleColorSet,ProductTestCaseHelper.PhotoshootType.WhiteBackgroundOrFaceCut);
        productUploadHelper.execute();

        CatalogSearchHelper catalogSearchHelper= new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(productUploadHelper.getCatalogName());
        CatalogDetailsPageStrategy catalogDetailsPageStrategy= CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.BackCatalogButton();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();

        bottomTabPageStrategy.clickProductsButton();
        catalogToolBarStrategy.clickProductTypeSpinner();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productSpinnerStrategy.clickNonCatalogSpinner();

        catalogSearchHelper.searchCatalogInPublic(productUploadHelper.getCatalogName(),1);
        catalogSearchHelper.goBackToCatalogTabAfterSearchInPublic();

        catalogToolBarStrategy.clickProductTypeSpinner();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productSpinnerStrategy.clickCatalogTypeSpinner();
        catalogSearchHelper.searchCatalogInPublicNoCatalogIsDisplay(productUploadHelper.getCatalogName());

        }
}
