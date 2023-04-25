package com.wishbook.catalog.TestCases.ReselleProductShare;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.ResellerShareItemPage.ResellerShareItemFactory;
import com.wishbook.catalog.PageObject.ResellerShareItemPage.ResellerShareItemStrategy;
import com.wishbook.catalog.TestCases.CatalogDetails.CatalogDetails;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class ResellerProductShare extends TestCase  {
    public ResellerProductShare(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestReseller));
    }

    protected void run() {
        CatalogSearchHelper catalogSearchHelper =new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(getTest().getCommonCatalogName());


        CatalogDetailsPageStrategy catalogDetailsPageStrategy= CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickShareButtonCatalogsDetails();

        ResellerShareItemStrategy resellerShareItemStrategy= ResellerShareItemFactory.getStrategy(this);
        resellerShareItemStrategy.clickOthersButton();

        resellerShareItemStrategy.clickShareOnWhatsAppButton();

        float avgPricePerPiece=resellerShareItemStrategy.getAveragePricePerPiece();


        resellerShareItemStrategy.enterResalePricePerPiece(0);
        resellerShareItemStrategy.clickShareOnWhatsAppButton();

        int rand = (int) (Math.random() * avgPricePerPiece + (0));

        resellerShareItemStrategy.enterResalePricePerPiece(rand);
        resellerShareItemStrategy.clickShareOnWhatsAppButton();

        resellerShareItemStrategy= ResellerShareItemFactory.getStrategy(this);
        Assert.assertTrue(resellerShareItemStrategy.isShareFBDisplayed());
        Assert.assertTrue(resellerShareItemStrategy.isShareLinkDisplayed());
        Assert.assertTrue(resellerShareItemStrategy.isShareSaveToGalleryDisplayed());
        Assert.assertTrue(resellerShareItemStrategy.isShareOtherDisplayed());
        resellerShareItemStrategy.clickOnOtherUnderOther();
        Assert.assertTrue(resellerShareItemStrategy.isCompleteActionUsing());


    }
}
