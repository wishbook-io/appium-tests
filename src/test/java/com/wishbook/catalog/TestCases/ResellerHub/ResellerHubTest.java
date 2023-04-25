package com.wishbook.catalog.TestCases.ResellerHub;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageFactory;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageStrategy;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarFactory;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageFactory;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageFactory;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class ResellerHubTest extends TestCase {
    public ResellerHubTest(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestReseller));
    }

    protected void run() {
        BottomTabPageStrategy bottomTabPageStrategy= BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy= MyBusinessPageFactory.getStrategy(this);
        String actualCompanyName=myBusinessPageStrategy.getTextCompanyName();
        String expectedCompanyName="Online-Retailer Reseller";
//        Assert.assertEquals(actualCompanyName,expectedCompanyName);
        Assert.assertTrue(myBusinessPageStrategy.resellerHubIsDisplayed());



        bottomTabPageStrategy.clickProductsButton();
        CatalogToolBarStrategy catalogToolBarStrategy=CatalogToolBarFactory.getStrategy(this);
        catalogToolBarStrategy.clickActionToolBarIcon();
        CatalogPublicPageStrategy catalogPublicPageStrategy=CatalogPublicPageFactory.getStrategy(this);
        catalogPublicPageStrategy.selectCatalogImage(4);
        CatalogDetailsPageStrategy catalogDetailsPageStrategy= CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartButton();
        catalogDetailsPageStrategy= CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartIcon();
        MyCartPageStrategy myCartPageStrategy=MyCartPageFactory.getStrategy(this);
        Assert.assertTrue(myCartPageStrategy.switchReselerButtonIsDisplayed());
        myCartPageStrategy.clickPlaceOrderButton();

        PopUpPageStrategy popUpPageStrategy= PopUpPageFactory.getStrategy(this);
        popUpPageStrategy.enterResellAmountIntoTextField(2000);
        float resellAmtOnPopUp= popUpPageStrategy.getResellAmountOnPopUp();
        popUpPageStrategy.clickOk();

        ShipmentAndPaymentPageStrategy shipmentAndPaymentPageStrategy= ShipmentAndPaymentPageFactory.getStrategy(this);
        shipmentAndPaymentPageStrategy.scrollToSeeDetails();
        float resellAmountOnShipment=shipmentAndPaymentPageStrategy.getResellAmount();
        Assert.assertEquals(resellAmountOnShipment,resellAmtOnPopUp);












    }
}
