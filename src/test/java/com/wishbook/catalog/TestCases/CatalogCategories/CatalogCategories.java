package com.wishbook.catalog.TestCases.CatalogCategories;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageFactory;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageStrategy;
import com.wishbook.catalog.PageObject.CategoriesPage.CategoriesPageFactory;
import com.wishbook.catalog.PageObject.CategoriesPage.CategoriesPageStrategy;
import com.wishbook.catalog.PageObject.FilterPage.FilterPageFactory;
import com.wishbook.catalog.PageObject.FilterPage.FilterPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.NavigationDrawerPage.AppBarPageStrategy;
import com.wishbook.catalog.PageObject.NavigationDrawerPage.AppBarPageFactory;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

/**
 * Created by wishbook on 27/4/18.
 */

public class CatalogCategories extends TestCase {
    @SuppressWarnings("unused")
    public CatalogCategories(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsWholeSaler));

    }

    @Override
    protected void run() {
        HomePageStrategy homePageStrategy = HomePageFactory.getStrategy(this);
        homePageStrategy.clickAppBar(0);
        AppBarPageStrategy navigationDrawerPageStrategy = AppBarPageFactory.getStrategy(this);
        navigationDrawerPageStrategy.clickCategories();
        CategoriesPageStrategy categoriesPageStrategy= CategoriesPageFactory.getStrategy(this);
        categoriesPageStrategy.selectCategories(1);
        CatalogPublicPageStrategy catalogPublicPageStrategy=CatalogPublicPageFactory.getStrategy(this);
        catalogPublicPageStrategy.clickFilterIcon();
        FilterPageStrategy filterPageStrategy= FilterPageFactory.getStrategy(this);
        Assert.assertTrue(filterPageStrategy.isCategoriesDressMateriaRadioButton());
        Assert.assertTrue(filterPageStrategy.isStitchedDisplayed());
    }
}
