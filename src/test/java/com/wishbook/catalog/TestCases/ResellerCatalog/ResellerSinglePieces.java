package com.wishbook.catalog.TestCases.ResellerCatalog;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BecomeASellerPage.BecomeASellerPageFactory;
import com.wishbook.catalog.PageObject.BecomeASellerPage.BecomeASellerPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageFactory;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class ResellerSinglePieces extends TestCase {


    public ResellerSinglePieces(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestWholeSaler));
    }

    protected void run() {
        //region Login As Wholesaler1 and become the seller of the catalog
        System.out.println("catalogSearching....");
        CatalogSearchHelper catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton("test_ouufpkvw");

        System.out.println("displaying Add to wishList, add to cart icon, share Icon,BecomeSellerButton, send enquiry and add to cart button ");
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        Assert.assertTrue(catalogDetailsPageStrategy.isWishListButtonPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isSendEnquiryPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isAddToCartButtonPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isShareButtonPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isAddToCartIconPresent());

        catalogDetailsPageStrategy.clickBecomeSellerOfThisCatalogButton();
        BecomeASellerPageStrategy becomeASellerPageStrategy = BecomeASellerPageFactory.getStrategy(this);
        Assert.assertTrue(becomeASellerPageStrategy.fullCatalogOnlyIsDisplayed());
        Assert.assertTrue(becomeASellerPageStrategy.singlePiecesAndFullCatalogBothIsDisplayed());

        becomeASellerPageStrategy.ClickSinglePiecesAndFullCatalogBoth();
        becomeASellerPageStrategy.enterCatalogDuration(10);


        //region wait
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//endregion
        System.out.println("checking wishList,add to cart button and icon,become a seller of this catalog,share button");
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        Assert.assertFalse(catalogDetailsPageStrategy.isChatAndEnquiryButton());
        Assert.assertFalse(catalogDetailsPageStrategy.isAddToCartButtonPresent());
        Assert.assertFalse(catalogDetailsPageStrategy.isBecomeASellerOfThisCatalogPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isShareButtonPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isAddToCartIconPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.stopSellingButtonIsDisplayed());
        Assert.assertFalse(catalogDetailsPageStrategy.isWishListButtonPresent());


        catalogDetailsPageStrategy.BackCatalogButton();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();
        new LoginHelper(this).logout();

        System.out.println("Logout \n\n Login in as Wholesaler 2");
        new LoginHelper(this).loginAsWholesaler();
        catalogSearchHelper.catalogSearchInHomePageSearchButton(getTest().getCommonCatalogName());
        catalogDetailsPageStrategy.clickBecomeSellerOfThisCatalogButton();

        Assert.assertTrue(becomeASellerPageStrategy.fullCatalogOnlyIsDisplayed());
        Assert.assertTrue(becomeASellerPageStrategy.singlePiecesAndFullCatalogBothIsDisplayed());



        becomeASellerPageStrategy.clickFullCatalogRadioButton();
        becomeASellerPageStrategy.enterCatalogDuration(10);
        becomeASellerPageStrategy.clickDoneButton();
        becomeASellerPageStrategy.clickOk();

        Assert.assertFalse(catalogDetailsPageStrategy.isChatAndEnquiryButton());
        Assert.assertFalse(catalogDetailsPageStrategy.isAddToCartButtonPresent());
        Assert.assertFalse(catalogDetailsPageStrategy.isBecomeASellerOfThisCatalogPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isShareButtonPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isAddToCartIconPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.stopSellingButtonIsDisplayed());
        Assert.assertFalse(catalogDetailsPageStrategy.isWishListButtonPresent());
        //endregion

    }
}
