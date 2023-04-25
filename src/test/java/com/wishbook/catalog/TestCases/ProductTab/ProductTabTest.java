package com.wishbook.catalog.TestCases.ProductTab;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageFactory;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageStrategy;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarFactory;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarStrategy;
import com.wishbook.catalog.PageObject.FilterPage.FilterPageFactory;
import com.wishbook.catalog.PageObject.FilterPage.FilterPageStrategy;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageFactory;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageStrategy;
import com.wishbook.catalog.PageObject.MyFilterPage.MyFilterPageFactory;
import com.wishbook.catalog.PageObject.MyFilterPage.MyFilterPageStrategy;
import com.wishbook.catalog.PageObject.MyWishListPage.MyWishListPageFactory;
import com.wishbook.catalog.PageObject.MyWishListPage.MyWishListPageStrategy;
import com.wishbook.catalog.PageObject.ProductAvailabilityDialogBox.ProductAvailabilityDialogBoxFactory;
import com.wishbook.catalog.PageObject.ProductAvailabilityDialogBox.ProductAvailabilityDialogBoxStrategy;
import com.wishbook.catalog.PageObject.ProductCategoryDialogBox.ProductCategoryDialogBoxFactory;
import com.wishbook.catalog.PageObject.ProductCategoryDialogBox.ProductCategoryDialogBoxStrategy;
import com.wishbook.catalog.PageObject.ProductTab.ProductTabFactory;
import com.wishbook.catalog.PageObject.ProductTab.ProductTabStrategy;
import com.wishbook.catalog.PageObject.ProductTypeDialogBox.ProductTypeDialogBoxFactory;
import com.wishbook.catalog.PageObject.ProductTypeDialogBox.ProductTypeDialogBoxStrategy;
import com.wishbook.catalog.PageObject.ProductViewDialogueBox.ProductViewDialogueFactory;
import com.wishbook.catalog.PageObject.ProductViewDialogueBox.ProductViewDialogueStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class ProductTabTest extends TestCase {
    public ProductTabTest(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestRetailer));
    }

    protected void run() {

        BottomTabPageStrategy bottomTabPageStrategy=BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickProductsButton();
        ProductTabStrategy productTabStrategy=ProductTabFactory.getStrategy(this);
        productTabStrategy.clickSareesCategory();
        CatalogToolBarStrategy catalogToolBarStrategy= CatalogToolBarFactory.getStrategy(this);
        CatalogPublicPageStrategy catalogPublicPageStrategy= CatalogPublicPageFactory.getStrategy(this);

        Assert.assertTrue(catalogToolBarStrategy.isActionToolIconDisplayed());
        Assert.assertTrue(catalogToolBarStrategy.isSearchIconDisplayed());
        Assert.assertTrue(catalogToolBarStrategy.isMyFilterIconDisplayed());
        Assert.assertTrue(catalogToolBarStrategy.isMyWishlistIconDisplayed());
        Assert.assertTrue(catalogToolBarStrategy.isCartIconDisplayed());
        Assert.assertTrue(catalogPublicPageStrategy.isAvailabilityDownArrowDisplayed());
        Assert.assertTrue(catalogPublicPageStrategy.isCategoryDownArrowDisplayed());
        Assert.assertTrue(catalogPublicPageStrategy.isTypeDownArrowDisplayed());

        catalogToolBarStrategy= CatalogToolBarFactory.getStrategy(this);
        catalogToolBarStrategy.clickMyFilterIcon();
        MyFilterPageStrategy myFilterPageStrategy= MyFilterPageFactory.getStrategy(this);
        String myFiltersTitleActual=myFilterPageStrategy.getMyFiltersTitle();
        String myFilterTitleExpected="My Filters";
        Assert.assertEquals(myFiltersTitleActual,myFilterTitleExpected);
        myFilterPageStrategy.clickCloseMyFilters();

        catalogToolBarStrategy.clickWishListButton();
        MyWishListPageStrategy myWishListPageStrategy= MyWishListPageFactory.getStrategy(this);
        String actualWishlistTitle=myWishListPageStrategy.getMyWishListTileFromToolBar();
        String expectedWishlistTitle="My Wishlist";
        Assert.assertEquals(actualWishlistTitle,expectedWishlistTitle);
        myWishListPageStrategy.BackMyCatalogButton();

        catalogToolBarStrategy.clickAddToCartButton();
        MyCartPageStrategy myCartPageStrategy= MyCartPageFactory.getStrategy(this);
        myCartPageStrategy.BackMyCartButton();


        catalogPublicPageStrategy.clickAvailabilityDownArrow();
        ProductAvailabilityDialogBoxStrategy productAvailabilityDialogBoxStrategy=ProductAvailabilityDialogBoxFactory.getStrategy(this);
        String actualProductAvailTitle=productAvailabilityDialogBoxStrategy.getProductAvailTitle();
        String expectedProductAvailTitle="Product Availability";
        Assert.assertEquals(actualProductAvailTitle,expectedProductAvailTitle);
        productAvailabilityDialogBoxStrategy.clickCloseButtonProductAvail();

        catalogPublicPageStrategy.clickTypeDownArrow();
        ProductTypeDialogBoxStrategy productTypeDialogBoxStrategy=ProductTypeDialogBoxFactory.getStrategy(this);
        String actualProductTypeTitle=productTypeDialogBoxStrategy.getProductTypeTitle();
        String expectedProductTypeTitle="Product Type";
        Assert.assertEquals(actualProductTypeTitle,expectedProductTypeTitle);
        productTypeDialogBoxStrategy.clickCloseButtonProductType();

        catalogPublicPageStrategy.clickCategoryDownArrow();
        ProductCategoryDialogBoxStrategy productCategoryDialogBoxStrategy=ProductCategoryDialogBoxFactory.getStrategy(this);
        String actualProductCategoryTitle=productCategoryDialogBoxStrategy.getProductCategoryTitle();
        String expectedProductCategoryTitle="Category";
        Assert.assertEquals(actualProductCategoryTitle,expectedProductCategoryTitle);
        productCategoryDialogBoxStrategy.clickCloseButtonProductCategory();

        catalogPublicPageStrategy.clickViewDownArrowButton();
        ProductViewDialogueStrategy productViewDialogueStrategy=ProductViewDialogueFactory.getStrategy(this);
        String actualProductViewTitle=productViewDialogueStrategy.getProductViewTitle();
        String expectedProductViewTitle="View Type";
        Assert.assertEquals(actualProductViewTitle,expectedProductViewTitle);
        productViewDialogueStrategy.clickCloseButtonProductView();


        catalogPublicPageStrategy.clickTrendingButton();
        catalogPublicPageStrategy.clickLatestButton();
        catalogPublicPageStrategy.clickPriceButton();


        String sareesActual=catalogPublicPageStrategy.getCategory();
        String expectedSarees="Sarees";
        Assert.assertEquals(sareesActual,expectedSarees);
        catalogPublicPageStrategy.clickFilterIcon();
        FilterPageStrategy filterPageStrategy=FilterPageFactory.getStrategy(this);
        filterPageStrategy.clickCategoryButton();
        Assert.assertTrue(filterPageStrategy.isSareesRadioButtonSelected());
        filterPageStrategy.BackFilterButton();
        catalogToolBarStrategy.clickActionToolBarIcon();
        catalogToolBarStrategy.clickBackButton();

        productTabStrategy=ProductTabFactory.getStrategy(this);
        productTabStrategy.clickKurtisCategory();
        catalogPublicPageStrategy= CatalogPublicPageFactory.getStrategy(this);
        String kutisActual=catalogPublicPageStrategy.getCategory();
        String expectedKurtis="Kurtis";
        Assert.assertEquals(kutisActual,expectedKurtis);
        catalogPublicPageStrategy.clickFilterIcon();
        filterPageStrategy=FilterPageFactory.getStrategy(this);
        filterPageStrategy.clickCategoryButton();
        Assert.assertTrue(filterPageStrategy.isKurtisRadioButtonSelected());
        filterPageStrategy.BackFilterButton();
        catalogToolBarStrategy= CatalogToolBarFactory.getStrategy(this);
        catalogToolBarStrategy.clickActionToolBarIcon();
        catalogToolBarStrategy.clickBackButton();


        productTabStrategy=ProductTabFactory.getStrategy(this);
        productTabStrategy.clickDressMaterialCategory();
        catalogPublicPageStrategy= CatalogPublicPageFactory.getStrategy(this);
        String dressMaterialActual=catalogPublicPageStrategy.getCategory();
        String expectedDressMaterial="Dress Materials";
        Assert.assertEquals(dressMaterialActual,expectedDressMaterial);
        catalogPublicPageStrategy.clickFilterIcon();
        filterPageStrategy=FilterPageFactory.getStrategy(this);
        filterPageStrategy.clickCategoryButton();
        Assert.assertTrue(filterPageStrategy.isCategoriesDressMateriaRadioButton());
        filterPageStrategy.BackFilterButton();
        catalogToolBarStrategy= CatalogToolBarFactory.getStrategy(this);
        catalogToolBarStrategy.clickActionToolBarIcon();
        catalogToolBarStrategy.clickBackButton();

        productTabStrategy=ProductTabFactory.getStrategy(this);
        productTabStrategy.clickSuitsReadyMadeCategory();
        catalogPublicPageStrategy= CatalogPublicPageFactory.getStrategy(this);
        String suitReadyMadeActual=catalogPublicPageStrategy.getCategory();
        String expectedSuitReadyMade="Suits - Readymade";
        Assert.assertEquals(suitReadyMadeActual,expectedSuitReadyMade);
        catalogPublicPageStrategy.clickFilterIcon();
        filterPageStrategy=FilterPageFactory.getStrategy(this);
        filterPageStrategy.clickCategoryButton();
        Assert.assertTrue(filterPageStrategy.isSuitReadymadeRadioButtonSelected());
        filterPageStrategy.BackFilterButton();
        catalogToolBarStrategy= CatalogToolBarFactory.getStrategy(this);
        catalogToolBarStrategy.clickActionToolBarIcon();
        catalogToolBarStrategy.clickBackButton();



    }
}
