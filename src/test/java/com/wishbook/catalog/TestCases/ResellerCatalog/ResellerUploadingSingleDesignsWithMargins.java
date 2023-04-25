package com.wishbook.catalog.TestCases.ResellerCatalog;

import com.wishbook.catalog.Execution.Core.BaseTest;

import com.wishbook.catalog.PageObject.BecomeASellerPage.BecomeASellerPageFactory;
import com.wishbook.catalog.PageObject.BecomeASellerPage.BecomeASellerPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductTestCaseHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.UploadUiHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class ResellerUploadingSingleDesignsWithMargins extends TestCase {
    public ResellerUploadingSingleDesignsWithMargins(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));
    }

    protected void run() {
        UploadUiHelper uploadUiHelper= new UploadUiHelper(this,ProductTestCaseHelper.SetType.SingleColorSet,ProductTestCaseHelper.PhotoshootType.Catalog);
        uploadUiHelper.execute();
        new LoginHelper(this).logout();
        new LoginHelper(this).loginAsTestWholesaler();

        System.out.println("catalogSearching....");
        CatalogSearchHelper catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(uploadUiHelper.getCatalogName());

        CatalogDetailsPageStrategy catalogDetailsPageStrategy= CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickBecomeSellerOfThisCatalogButton();
        BecomeASellerPageStrategy becomeASellerPageStrategy = BecomeASellerPageFactory.getStrategy(this);

        Assert.assertTrue(becomeASellerPageStrategy.fullCatalogOnlyIsDisplayed());
        Assert.assertTrue(becomeASellerPageStrategy.singlePiecesAndFullCatalogBothIsDisplayed());

        becomeASellerPageStrategy.ClickSinglePiecesAndFullCatalogBoth();

        becomeASellerPageStrategy.enterCatalogDuration(10);
        becomeASellerPageStrategy.clickDoneButton();
        becomeASellerPageStrategy.clickOk();
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

    }
}
