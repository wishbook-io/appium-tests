package com.wishbook.catalog.TestCases.ExploringProducts;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageFactory;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageStrategy;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarFactory;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.PageObject.ProductUploadPage2.ProductUploadPage2Factory;
import com.wishbook.catalog.PageObject.ProductUploadPage2.ProductUploadPage2Strategy;
import com.wishbook.catalog.PageObject.ProductSpinner.ProductSpinnerFactory;
import com.wishbook.catalog.PageObject.ProductSpinner.ProductSpinnerStrategy;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageFactory;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageStrategy;
import com.wishbook.catalog.PageObject.SelectPhotoAlbumPage.SelectPhotoAlbumPageFactory;
import com.wishbook.catalog.PageObject.SelectPhotoAlbumPage.SelectPhotoAlbumPageStrategy;
import com.wishbook.catalog.PageObject.TabToSelectImage.TabToSelectImageFactory;
import com.wishbook.catalog.PageObject.TabToSelectImage.TabToSelectImageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductTestCaseHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductUploadHelper;

import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class ExploringScreen extends TestCase {
    public ExploringScreen(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));
    }

    protected void run() {

        ProductUploadHelper productUploadHelper = new ProductUploadHelper(this, ProductTestCaseHelper.SetType.MultiSet, ProductTestCaseHelper.PhotoshootType.WhiteBackgroundOrFaceCut);
        productUploadHelper.execute();
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickHomeButton();
        HomePageStrategy homePageStrategy = HomePageFactory.getStrategy(this);
        homePageStrategy.clickHomeSearchTextField();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName(productUploadHelper.getScreenName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CatalogPublicPageStrategy catalogPublicPageStrategy = CatalogPublicPageFactory.getStrategy(this);
        catalogPublicPageStrategy.selectCatalogImage(1);
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //region verify screen
        // Assert.assertEquals(productUploadHelper.getSelectedCategory() ,catalogDetailsPageStrategy.getProductCategory());
      //  Assert.assertEquals(productUploadHelper.getNumberOfPcs(), catalogDetailsPageStrategy.getNumberOfDesigns());
        Assert.assertTrue(catalogDetailsPageStrategy.setAddScreenButtonIsDisplayed());
        Assert.assertTrue(catalogDetailsPageStrategy.setEditScreenButtonIsDisplay());
        Assert.assertTrue(catalogDetailsPageStrategy.stopSellingButtonIsDisplayed());
//        Assert.assertEquals(productUploadHelper.getSelectedWork(), catalogDetailsPageStrategy.getWorkText());
 //       Assert.assertEquals(productUploadHelper.getSelectedFabric(), catalogDetailsPageStrategy.getFabricText());
//        Assert.assertEquals(productUploadHelper.getPricesPerPieces(), catalogDetailsPageStrategy.getTextPriceOfDesign());
        //endregion

        //region editSet
        catalogDetailsPageStrategy.clickEditSetButton();
        ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
        productUploadPage2Strategy.enterScreenNameOrNumber("Screen123");
        productUploadPage2Strategy.enterScreenSetColorName("yellow");

        productUploadPage2Strategy.clickDeleteButtonInScreen();
        PopUpPageStrategy popUpPageStrategy = PopUpPageFactory.getStrategy(this);
        popUpPageStrategy.clickOk();
        //endregion

        //region Add One More Set into same
        productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
        productUploadPage2Strategy.clickAddImagesSetButton();
        SelectPhotoAlbumPageStrategy selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(this);
        selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(1);
        TabToSelectImageStrategy tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
        tabToSelectImageStrategy.selectImagesForCatalogDesign(0);
        tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
        tabToSelectImageStrategy.clickAddButton();
        productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
        productUploadPage2Strategy.clickSubmitButton();
        //endregion

        //region add one new screen with same quality name
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddSetButton();
        productUploadPage2Strategy.enterScreenNameOrNumber("ScreenMultiSet");
        productUploadPage2Strategy.enterScreenSetColorName("Red");
        productUploadPage2Strategy.clickAddImagesSetButton();
        selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(this);
        selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(1);
        tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
        tabToSelectImageStrategy.selectImagesForCatalogDesign(0);
        tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
        tabToSelectImageStrategy.clickAddButton();
        productUploadPage2Strategy.clickSubmitButton();
        //endregion

        //region Searching screen on catalog section and nonCatalog Section ProductTab

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        catalogDetailsPageStrategy=CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.BackCatalogButton();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();

        bottomTabPageStrategy.clickProductsButton();
        CatalogToolBarStrategy catalogToolBarStrategy = CatalogToolBarFactory.getStrategy(this);
        catalogToolBarStrategy.clickProductTypeSpinner();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ProductSpinnerStrategy productSpinnerStrategy = ProductSpinnerFactory.getStrategy(this);
        productSpinnerStrategy.clickNonCatalogSpinner();
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickProductsButton();
        catalogPublicPageStrategy = CatalogPublicPageFactory.getStrategy(this);
        catalogPublicPageStrategy.clickSearchIcon();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName(productUploadHelper.getScreenName());
        searchPageStrategy.selectCatalogImage(1);
        CatalogSearchHelper catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.goBackToCatalogTabAfterSearchInPublic();
        catalogToolBarStrategy.clickProductTypeSpinner();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productSpinnerStrategy.clickCatalogTypeSpinner();
        catalogSearchHelper.searchCatalogInPublicNoCatalogIsDisplay(productUploadHelper.getScreenName());
        //endregion


    }


    }

