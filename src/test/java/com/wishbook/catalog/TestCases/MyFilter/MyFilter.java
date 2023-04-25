package com.wishbook.catalog.TestCases.MyFilter;

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
import com.wishbook.catalog.PageObject.ProductTab.ProductTabFactory;
import com.wishbook.catalog.PageObject.ProductTab.ProductTabStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

/**
 * Created by wishbook on 26/3/18.
 */

public class MyFilter extends TestCase {

   private String filterName = "filter" + RandomStringUtils.randomAlphabetic(5).toLowerCase();

    @SuppressWarnings("unused")
    public MyFilter(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));

    }

    @Override
    public void run() {
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickProductsButton();
        ProductTabStrategy productTabStrategy = ProductTabFactory.getStrategy(this);
        productTabStrategy.clickSareesCategory();
        CatalogPublicPageStrategy catalogPublicPageStrategy = CatalogPublicPageFactory.getStrategy(this);
        catalogPublicPageStrategy.clickFilterIcon();
        FilterPageStrategy filterPageStrategy = FilterPageFactory.getStrategy(this);
        filterPageStrategy.clickCategoryButton();
        filterPageStrategy.selectCategoryByName("Kurtis");
        filterPageStrategy.clickSizeButton();
        filterPageStrategy.selectSizeByName("XS");
        filterPageStrategy.selectSizeByName("M");
        filterPageStrategy.clickBrandButton();
        filterPageStrategy.selectBrandByName("567");
        filterPageStrategy.clickPriceButton();
        filterPageStrategy.selectPriceAtIndex(3);
        filterPageStrategy.selectPriceAtIndex(1);
        filterPageStrategy.clickFabricButton();
        filterPageStrategy.selectFabricByName("Art Silk");
        filterPageStrategy.clickWorkButton();
        filterPageStrategy.selectWorkByName("Chicken");
        filterPageStrategy.saveFilter();
        FilterCatalogSavedDialogPageStrategy filterCatalogSavedDialogPageStrategy = FilterCatalogSavedDialogPageFactory.getStrategy(this);
        filterCatalogSavedDialogPageStrategy.enterFilterName(filterName);
        filterCatalogSavedDialogPageStrategy.selectSaveFilterSave();
        CatalogToolBarStrategy catalogToolBarStrategy = CatalogToolBarFactory.getStrategy(this);
        Assert.assertEquals(catalogToolBarStrategy.getMyFilterIconCount(), 1);
        catalogToolBarStrategy = CatalogToolBarFactory.getStrategy(this);
        catalogToolBarStrategy.clickMyFilterIcon();

        MyFilterPageStrategy myFilterPageStrategy = MyFilterPageFactory.getStrategy(this);
        String myFilterTitleActual = myFilterPageStrategy.getMyFiltersTitle();
        String myFilterTitleExpected = "My Filters";
        Assert.assertEquals(myFilterTitleActual,myFilterTitleExpected);
        String savedFilter=myFilterPageStrategy.getSavedFilterName();
        Assert.assertEquals(filterName,savedFilter);

        myFilterPageStrategy.deleteFilterAt(1);
        FilterCatalogDeleteDialogPageStrategy deleteDialogPageStrategy=FilterCatalogDeleteDialogPageFactory.getStrategy(this);
        deleteDialogPageStrategy.clickYes();





    }
}


