package com.wishbook.catalog.TestCases.ShippingCharge;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageFactory;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageFactory;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class ShipmentCharges extends TestCase {
    public ShipmentCharges(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestWholeSaler));
    }

    protected void run() {

        //region searching common catalog ;
        System.out.println("searching common uploaded catalog");
        CatalogSearchHelper searchHelper = new CatalogSearchHelper(this);
        searchHelper.catalogSearchInHomePageSearchButton(getTest().getCommonCatalogName());
        //endregion

        //region Catalog is in Cart ;
        System.out.println("Catalog is in Cart");
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartButton();
        catalogDetailsPageStrategy.clickAddToCartIcon();
        MyCartPageStrategy myCartPageStrategy = MyCartPageFactory.getStrategy(this);
        myCartPageStrategy.clickPlaceOrderButton();
        //endregion

        //region Case 1: when address is non serviceable and design is single
        ShipmentAndPaymentPageStrategy shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
        shipmentAndPaymentPageStrategy.selectShipmentAddress(0);// non service area
        float shippmentCharge = shipmentAndPaymentPageStrategy.getAirTransportCharge();
        float expectedShipmentCharge = (float) 75.0;
        Assert.assertEquals(shippmentCharge, expectedShipmentCharge);

        shipmentAndPaymentPageStrategy.scrollToSeeDetails();
        float deliveryCharge = shipmentAndPaymentPageStrategy.getDeliveryCharge();
        Assert.assertEquals(shippmentCharge, deliveryCharge);
        //endregion

        //region case2: when address is serviceable and design is single
        shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
        shipmentAndPaymentPageStrategy.selectShipmentAddress(1);// service area
        shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
        float shippmentChargeServiceable = shipmentAndPaymentPageStrategy.getAirTransportCharge();
        float expectedShipmentChargeServiceable = 0;
        Assert.assertEquals(shippmentChargeServiceable, expectedShipmentChargeServiceable);
        shipmentAndPaymentPageStrategy.scrollToSeeDetails();
        Assert.assertTrue(shipmentAndPaymentPageStrategy.isDeliveryChargeDispalyed());
        Assert.assertEquals(shipmentAndPaymentPageStrategy.getDeliveryCharge(),shippmentChargeServiceable);
        //endregion

        //region Deleting added catalog into cart
        shipmentAndPaymentPageStrategy=ShipmentAndPaymentPageFactory.getStrategy(this);
        shipmentAndPaymentPageStrategy.BackShippmentPaymentButton();
        myCartPageStrategy=MyCartPageFactory.getStrategy(this);
        myCartPageStrategy.clickDeleteButton();
        PopUpPageStrategy popUpPageStrategy=PopUpPageFactory.getStrategy(this);
        popUpPageStrategy.clickOnYesRemoveItemFromCart();
        //endregion

    }
}

