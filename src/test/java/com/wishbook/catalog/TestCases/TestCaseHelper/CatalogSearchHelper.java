package com.wishbook.catalog.TestCases.TestCaseHelper;

import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageFactory;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageStrategy;
import com.wishbook.catalog.PageObject.CatalogReceivedPage.CatalogReceivedPageFactory;
import com.wishbook.catalog.PageObject.CatalogReceivedPage.CatalogReceivedPageStrategy;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarFactory;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarStrategy;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageFactory;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageStrategy;
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageFactory;
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageStrategy;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageFactory;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CatalogSearchHelper extends BaseTestCaseHelper {
    public CatalogSearchHelper(TestCase testCase) {
        super(testCase);
    }

    public void catalogSearchInHomePageSearchButton(String catalogName) {
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickHomeButton();
        HomePageStrategy homePageStrategy = HomePageFactory.getStrategy(testCase);
        homePageStrategy.clickSearch();

        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(testCase);
        searchPageStrategy.searchCatalogName(catalogName);
        searchPageStrategy.clickSearchedProduct();

//       CatalogDetailsPageStrategy catalogDetailsPageStrategy= CatalogDetailsPageFactory.getStrategy(testCase);
//        String catalogNameInCatalogDetails=catalogDetailsPageStrategy.getCatalogName().toLowerCase();
//        Assert.assertEquals(catalogName.toLowerCase(),catalogNameInCatalogDetails.toLowerCase());
}

    public void goBackToHomePageAfterCatalogSelection() {
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(testCase);
        catalogDetailsPageStrategy.clickWishListButton();
        catalogDetailsPageStrategy.BackCatalogButton();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(testCase);
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();
    }

    public void catalogSearchInMyCatalog(String catalogName) {
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(testCase);
        myBusinessPageStrategy.clickMyCatalogs();
        MyCatalogPageStrategy myCatalogPageStrategy = MyCatalogPageFactory.getStrategy(testCase);
        myCatalogPageStrategy.clickSearchIcon();
        myCatalogPageStrategy.enterText(catalogName);
        myCatalogPageStrategy.selectMyCatalogImage(2);
    }

    public void goBackToMyBusinessPage() {
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(testCase);
        catalogDetailsPageStrategy.BackCatalogButton();
        MyCatalogPageStrategy myCatalogPageStrategy = MyCatalogPageFactory.getStrategy(testCase);
        myCatalogPageStrategy.clickCloseSearchButton();
        myCatalogPageStrategy.BackCatalogButton();
    }

    @SuppressWarnings("unused")
    public void searchCatalogInPublic(String catalogName, int indexImage) {
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickProductsButton();
        CatalogPublicPageStrategy catalogPublicPageStrategy = CatalogPublicPageFactory.getStrategy(testCase);
        catalogPublicPageStrategy.clickSearchIcon();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(testCase);
        searchPageStrategy.searchCatalogName(catalogName);
        searchPageStrategy.selectCatalogImage(indexImage);
        CatalogDetailsPageStrategy catalogDetailsPageStrategy= CatalogDetailsPageFactory.getStrategy(testCase);
        String catalogNameInCatalogDetails=catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(catalogName,catalogNameInCatalogDetails);
    }

    @SuppressWarnings("unused")

    public void goBackToCatalogTabAfterSearchInPublic() {
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(testCase);
        catalogDetailsPageStrategy.BackCatalogButton();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(testCase);
        searchPageStrategy.clearSearchTextField();
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();
    }

    public void searchCatalogInPublicNoCatalogIsDisplay(String catalogName) {
        BottomTabPageStrategy bottomTabPageObject = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageObject.clickProductsButton();
        CatalogPublicPageStrategy catalogPublicPageStrategy = CatalogPublicPageFactory.getStrategy(testCase);
        catalogPublicPageStrategy.clickSearchIcon();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(testCase);
        searchPageStrategy.searchCatalogName(catalogName);
        String noCatalogMessage = searchPageStrategy.noDataFoundText();
        System.out.println(noCatalogMessage);
        String catalogMessage = "No Data Found";
        Assert.assertEquals(catalogMessage, noCatalogMessage);

    }

    public void searchCatalogInReceived(String catalogName) {

        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickMyBusiness();
        bottomTabPageStrategy.clickHomeButton();



        CatalogToolBarStrategy catalogToolBarStrategy = CatalogToolBarFactory.getStrategy(testCase);
        catalogToolBarStrategy.clickReceivedCatalog();
        CatalogReceivedPageStrategy catalogReceivedPageStrategy = CatalogReceivedPageFactory.getStrategy(testCase);
        String catalogTitle = catalogReceivedPageStrategy.getCatalogTitle().toLowerCase();
        System.out.println("Received catalog = " + catalogTitle);
        Assert.assertEquals(catalogName, catalogTitle);
        System.out.println("ReceivedCatalog is same as uploadedCatalog");


    }

    public void catalogSearchInMyCatalogNoCatalogsToDisplay(String catalogName) {
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(testCase);
        myBusinessPageStrategy.clickMyCatalogs();
        MyCatalogPageStrategy myCatalogPageStrategy = MyCatalogPageFactory.getStrategy(testCase);
        myCatalogPageStrategy.clickSearchIcon();
        myCatalogPageStrategy.enterText(catalogName);
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(testCase);
        String noCatalogMessage = searchPageStrategy.noDataFoundText();
        System.out.println(noCatalogMessage);
        String catalogMessage = "No catalogs to display";
        Assert.assertEquals(catalogMessage, noCatalogMessage);
        searchPageStrategy.clickSearchBackButton();

    }



}