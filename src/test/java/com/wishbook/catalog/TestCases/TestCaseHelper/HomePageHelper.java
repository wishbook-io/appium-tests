package com.wishbook.catalog.TestCases.TestCaseHelper;

import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.BrandsPage.BrandPageFactory;
import com.wishbook.catalog.PageObject.BrandsPage.BrandPageStrategy;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageFactory;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageStrategy;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarFactory;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarStrategy;
import com.wishbook.catalog.PageObject.FilterPage.FilterPageFactory;
import com.wishbook.catalog.PageObject.FilterPage.FilterPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import org.testng.Assert;

public class HomePageHelper extends BaseTestCaseHelper {
    public HomePageHelper(TestCase testCase) {
        super(testCase);
        BottomTabPageStrategy bottomTabPageStrategy= BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickOrderButton();
        bottomTabPageStrategy.clickHomeButton();
        //region wait
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//endregion
    }
    public void checkTopAreaSlider(){
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(testCase);
//        Assert.assertTrue(homePageStrategy.imageSliderIsDisplayed());

    }
    public void checkBanner(){
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(testCase);

    }
    public void checkNonCatalogAndNonCatalogBanner() {
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(testCase);
        homePageStrategy.clickSeeAllNonCatalog();
        CatalogToolBarStrategy catalogToolBarStrategy= CatalogToolBarFactory.getStrategy(testCase);
        String nonCatalog=catalogToolBarStrategy.getNonCatalogText();
        String nonCatalogText="Non-Catalog";
        Assert.assertEquals(nonCatalog,nonCatalogText);
        BottomTabPageStrategy bottomTabPageStrategy= BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickHomeButton();
        homePageStrategy.seeAllNonCatalogIsDisplayed();

    }

    public void checkSinglePiecesAndItsBanner() {
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(testCase);
        homePageStrategy.clickSeeAllSinglePieces();
        BottomTabPageStrategy bottomTabPageStrategy= BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickProductsButton();
        CatalogPublicPageStrategy catalogPublicPageStrategy= CatalogPublicPageFactory.getStrategy(testCase);
        catalogPublicPageStrategy.clickFilterIcon();
        FilterPageStrategy filterPageStrategy= FilterPageFactory.getStrategy(testCase);
//        filterPageStrategy.clickCatalogFilter();
//        Assert.assertFalse(filterPageStrategy.singlePieceAvailableIsSelected());
        filterPageStrategy.BackFilterButton();
        bottomTabPageStrategy.clickHomeButton();

    }

    public void checkAllBrandPage() {
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(testCase);
        homePageStrategy.clickOnSeeAllPublicBrand();
        BrandPageStrategy brandPageStrategy= BrandPageFactory.getStrategy(testCase);
        String brandName= brandPageStrategy.getBrandsTileFromToolBar();
        String brand="Brands";
        Assert.assertEquals(brandName,brand);
        brandPageStrategy.clickBrandBackButton();

    }


}
