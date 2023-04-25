package com.wishbook.catalog.TestCases.TestCaseHelper;

import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageFactory;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageStrategy;
import com.wishbook.catalog.PageObject.SortByPage.SortByPageFactory;
import com.wishbook.catalog.PageObject.SortByPage.SortByPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;

public class SortingHelper extends ProductTestCaseHelper {
    public SortingHelper(TestCase testCase, ProductTestCaseHelper.SetType setType, ProductTestCaseHelper.PhotoshootType photoshootType) {
        super(testCase,setType,photoshootType);
    }


    public void sortingSingleColorSet() {

        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickProductsButton();

        CatalogPublicPageStrategy catalogsPublicPageStrategy = CatalogPublicPageFactory.getStrategy(testCase);
        catalogsPublicPageStrategy.clickSortIcon();
        SortByPageStrategy sortByPageStrategy = SortByPageFactory.getStrategy(testCase);

        //case1:click close button of sorting sort
        sortByPageStrategy.clickSortCloseButton();

        //case2:click high to low price sort
        catalogsPublicPageStrategy = CatalogPublicPageFactory.getStrategy(testCase);
        catalogsPublicPageStrategy.clickSortIcon();
        sortByPageStrategy = SortByPageFactory.getStrategy(testCase);
        sortByPageStrategy.clickOnPriceHighToLowRadioButton();

        //case3:click low to high price sort
        catalogsPublicPageStrategy = CatalogPublicPageFactory.getStrategy(testCase);
        catalogsPublicPageStrategy.clickSortIcon();
        sortByPageStrategy = SortByPageFactory.getStrategy(testCase);
        sortByPageStrategy.clickOnPriceLowToHighRadioButton();

        //case4:click number of views sort
        catalogsPublicPageStrategy = CatalogPublicPageFactory.getStrategy(testCase);
        catalogsPublicPageStrategy.clickSortIcon();
        sortByPageStrategy = SortByPageFactory.getStrategy(testCase);
        sortByPageStrategy.clickOnPriceNumberOfViewsRadioButton();

        //case5:click recently uploaded sort
        catalogsPublicPageStrategy = CatalogPublicPageFactory.getStrategy(testCase);
        catalogsPublicPageStrategy.clickSortIcon();
        sortByPageStrategy = SortByPageFactory.getStrategy(testCase);
        sortByPageStrategy.clickOnRecentlyUploadedRadioButton();

    }

    protected void executeCatalogRelatedSteps() {
        sortingSingleColorSet();
    }

    protected void executeNonCatalogRelatedSteps() {
         sortingSingleColorSet();
    }

    protected void executeScreensRelatedSteps() { }


}
