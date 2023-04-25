package com.wishbook.catalog.TestCases.Filter;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageFactory;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageStrategy;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarFactory;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarStrategy;
import com.wishbook.catalog.PageObject.FilterCatalogDeleteDialogPage.FilterCatalogDeleteDialogPageFactory;
import com.wishbook.catalog.PageObject.FilterCatalogDeleteDialogPage.FilterCatalogDeleteDialogPageStrategy;
import com.wishbook.catalog.PageObject.FilterCatalogSavedDialogPage.FilterCatalogSavedDialogPageFactory;
import com.wishbook.catalog.PageObject.FilterCatalogSavedDialogPage.FilterCatalogSavedDialogPageStrategy;
import com.wishbook.catalog.PageObject.FilterPage.FilterPageFactory;
import com.wishbook.catalog.PageObject.FilterPage.FilterPageStrategy;
import com.wishbook.catalog.PageObject.MyFilterPage.MyFilterPageFactory;
import com.wishbook.catalog.PageObject.MyFilterPage.MyFilterPageStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.PageObject.ProductTab.ProductTabFactory;
import com.wishbook.catalog.PageObject.ProductTab.ProductTabStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductTestCaseHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

/**
 * Created by wishbook on 23/3/18.
 */

public class FilterProducts extends TestCase {
    @SuppressWarnings("unused")

    public FilterProducts(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestRetailer));

    }

    public void run() {

        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickProductsButton();
        ProductTabStrategy productTabStrategy = ProductTabFactory.getStrategy(this);
        productTabStrategy.clickSareesCategory();

        CatalogPublicPageStrategy catalogPublicPageStrategy = CatalogPublicPageFactory.getStrategy(this);
        catalogPublicPageStrategy.clickFilterIcon();

        FilterPageStrategy filterPageStrategy = FilterPageFactory.getStrategy(this);
        Assert.assertTrue(filterPageStrategy.isTypeAndAvailabilityButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isCategoryButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isBrandButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isPriceButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isFabricButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isWorkButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isViewMoreLinkDisplayed());
        Assert.assertTrue(filterPageStrategy.isSaveFilterDisplayed());
        Assert.assertTrue(filterPageStrategy.isApplyButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isClearAllButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isCatalogRadioButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isNonCatalogRadioButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isFullSetRadioButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isSinglePieceAvailRadioButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isBothAvailableRadioButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isPreLaunchedChecBoxDisplayed());
        String filterTitleActual=filterPageStrategy.getTitleNameFilter();
        String filterTitleExpected="Filter";
        Assert.assertEquals(filterTitleActual,filterTitleExpected);

        filterPageStrategy.clickCategoryButton();
        filterPageStrategy.selectCategoryByName("Kurtis");
        Assert.assertTrue(filterPageStrategy.isSizeButtonDisplayed());
        filterPageStrategy.selectCategoryByName("Suits - Readymade");
        Assert.assertTrue(filterPageStrategy.isSizeButtonDisplayed());
        filterPageStrategy.selectCategoryByName("Blouse");
        Assert.assertTrue(filterPageStrategy.isSizeButtonDisplayed());
        filterPageStrategy.selectCategoryByName("Gown - Stitched");
        Assert.assertTrue(filterPageStrategy.isSizeButtonDisplayed());
        filterPageStrategy.selectCategoryByName("Dress Materials - Unstitched");
        filterPageStrategy.selectCategoryByName("Sarees");
        filterPageStrategy.clickViewMore();
        Assert.assertTrue(filterPageStrategy.isStyleButtonDisplayed());
        Assert.assertTrue(filterPageStrategy.isStateButtonDisplayed());

        filterPageStrategy.clickCategoryButton();
        filterPageStrategy.selectCategoryByName("Lehengas");
        filterPageStrategy.clickBrandButton();
        filterPageStrategy.selectBrandByName("567");
        filterPageStrategy.clickPriceButton();
        filterPageStrategy.selectPriceAtIndex(0);
        filterPageStrategy.selectPriceAtIndex(1);
        filterPageStrategy.clickFabricButton();
        filterPageStrategy.selectFabricByName("Art Silk");
        filterPageStrategy.clickWorkButton();
        filterPageStrategy.selectWorkByName("Chicken");
        filterPageStrategy.clickStyleButton();
        filterPageStrategy.selectStyleByName("A-Cut");
        filterPageStrategy.clickStateButton();
        filterPageStrategy.selectStateByName("Gujarat");
        filterPageStrategy.selectStateByName("Jharkhand");

        Assert.assertEquals(filterPageStrategy.getCategoryCount(),1);
        Assert.assertEquals(filterPageStrategy.getBrandCount(),1);
        Assert.assertEquals(filterPageStrategy.getPriceCount(),2);
        Assert.assertEquals(filterPageStrategy.getFabricCount(),1);
        Assert.assertEquals(filterPageStrategy.getWorkCount(),1);
        Assert.assertEquals(filterPageStrategy.getStyleCount(),1);
        Assert.assertEquals(filterPageStrategy.getStateCount(),2);

        filterPageStrategy.saveFilter();

        FilterCatalogSavedDialogPageStrategy filterCatalogSavedDialogPageStrategy=FilterCatalogSavedDialogPageFactory.getStrategy(this);
        filterCatalogSavedDialogPageStrategy.enterFilterName("lehengasFilter");
        filterCatalogSavedDialogPageStrategy.selectSaveFilterSave();

        CatalogToolBarStrategy catalogToolBarStrategy=CatalogToolBarFactory.getStrategy(this);
        Assert.assertEquals(catalogToolBarStrategy.getMyFilterIconCount(),1);

        catalogPublicPageStrategy=CatalogPublicPageFactory.getStrategy(this);
        catalogPublicPageStrategy.clickFilterIcon();

        filterPageStrategy=FilterPageFactory.getStrategy(this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String savedFilterTitleActual1=filterPageStrategy.getTitleNameFilter();
        String savedFilterTitleExpected1="lehengasFilter";
        Assert.assertEquals(savedFilterTitleActual1,savedFilterTitleExpected1);

        Assert.assertTrue(filterPageStrategy.isDeleteButtonDisplayed());
        filterPageStrategy.clickDeleteSavedFilterButton();
        FilterCatalogDeleteDialogPageStrategy filterCatalogDeleteDialogPageStrategy= FilterCatalogDeleteDialogPageFactory.getStrategy(this);
        filterCatalogDeleteDialogPageStrategy.clickYes();
        Assert.assertTrue(filterPageStrategy.isSaveButtonDisplayed());

        filterPageStrategy=FilterPageFactory.getStrategy(this);
        String filterTitleActual1=filterPageStrategy.getTitleNameFilter();
        String filterTitleExpected1="Filter";
        Assert.assertEquals(filterTitleActual1,filterTitleExpected1);

        filterPageStrategy.clickCategoryButton();
        filterPageStrategy.selectCategoryByName("Lehengas");
        filterPageStrategy.clickBrandButton();
        filterPageStrategy.selectBrandByName("567");
        filterPageStrategy.clickPriceButton();
        filterPageStrategy.selectPriceAtIndex(0);
        filterPageStrategy.selectPriceAtIndex(1);
        filterPageStrategy.clickFabricButton();
        filterPageStrategy.selectFabricByName("Art Silk");
        filterPageStrategy.clickWorkButton();
        filterPageStrategy.selectWorkByName("Chicken");
        filterPageStrategy.clickViewMore();
        filterPageStrategy.clickStyleButton();
        filterPageStrategy.selectStyleByName("A-Cut");
        filterPageStrategy.clickStateButton();
        filterPageStrategy.selectStateByName("Gujarat");
        filterPageStrategy.selectStateByName("Jharkhand");
        filterPageStrategy.clickApplyButton();

    }


}
