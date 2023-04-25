package com.wishbook.catalog.TestCases.Search;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageFactory;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageStrategy;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageFactory;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseOptions;

/**
 * Created by wishbook on 22/3/18.
 */

public class SearchCatalog extends TestCase {
    @SuppressWarnings("unused")
    public SearchCatalog(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));

    }
    public void run() {
        BottomTabPageStrategy bottomTabPageStrategy= BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickProductsButton();
        CatalogPublicPageStrategy catalogsPublicPageStrategy = CatalogPublicPageFactory.getStrategy(this);
        catalogsPublicPageStrategy.clickSearchIcon();
        //case1:enter specific text into search box
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("Hand w");

        //case2:add space at the starting and ending place
        searchPageStrategy.clickSearchBackButton();
        catalogsPublicPageStrategy=CatalogPublicPageFactory.getStrategy(this);
        catalogsPublicPageStrategy.clickSearchIcon();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("Himanshi Arora");

        //case3:enter digits to the searchbox
        searchPageStrategy.clickSearchBackButton();
        catalogsPublicPageStrategy=CatalogPublicPageFactory.getStrategy(this);
        catalogsPublicPageStrategy.clickSearchIcon();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("12");

        //case4: search by typing strating letter of catalog
        searchPageStrategy.clickSearchBackButton();
        catalogsPublicPageStrategy=CatalogPublicPageFactory.getStrategy(this);
        catalogsPublicPageStrategy.clickSearchIcon();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("A");

        //case5:search by typing catalog name with uppercase
        searchPageStrategy.clickSearchBackButton();
        catalogsPublicPageStrategy=CatalogPublicPageFactory.getStrategy(this);
        catalogsPublicPageStrategy.clickSearchIcon();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("HIMANSHI ARORA");

        //case6:search by typing catalog name with lower case
        searchPageStrategy.clickSearchBackButton();
        catalogsPublicPageStrategy=CatalogPublicPageFactory.getStrategy(this);
        catalogsPublicPageStrategy.clickSearchIcon();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("himanshi arora");

        //case7:search by typing catalog name with symbols
        searchPageStrategy.clickSearchBackButton();
        catalogsPublicPageStrategy=CatalogPublicPageFactory.getStrategy(this);
        catalogsPublicPageStrategy.clickSearchIcon();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.noSuggestions("@#^%");

        //case8:search without typing nothing
        searchPageStrategy.clickSearchBackButton();
        catalogsPublicPageStrategy=CatalogPublicPageFactory.getStrategy(this);
        catalogsPublicPageStrategy.clickSearchIcon();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.noSuggestions("");

        //case9:search by brand name
        searchPageStrategy.clickSearchBackButton();
        catalogsPublicPageStrategy=CatalogPublicPageFactory.getStrategy(this);
        catalogsPublicPageStrategy.clickSearchIcon();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("mitto");
    }
}
