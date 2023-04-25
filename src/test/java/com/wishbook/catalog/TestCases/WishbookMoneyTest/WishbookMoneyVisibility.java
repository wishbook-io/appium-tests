package com.wishbook.catalog.TestCases.WishbookMoneyTest;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageFactory;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageFactory;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageStrategy;
import com.wishbook.catalog.PageObject.WishbookRewardPoints.WishbookRewardPointsFactory;
import com.wishbook.catalog.PageObject.WishbookRewardPoints.WishbookRewardPointsStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.WishbookMoneyHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;

public class WishbookMoneyVisibility extends TestCase {
    public WishbookMoneyVisibility(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestRetailer));
    }

    protected void run() {


        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();

        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickWBMoney();

        WishbookRewardPointsStrategy wishbookRewardPointsStrategy = WishbookRewardPointsFactory.getStrategy(this);
       // float wishBoookMoneyOnWBMoneyPage = wishbookRewardPointsStrategy.getTotalAvailableWBMoneyText();
        wishbookRewardPointsStrategy.clickBackButton();

        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickHomeButton();

        //region searching common catalog ;
        System.out.println("searching common uploaded catalog");
        CatalogSearchHelper searchHelper = new CatalogSearchHelper(this);
        searchHelper.catalogSearchInHomePageSearchButton(getTest().getCommonCatalogName());
        //endregion

        //region Catalog is in Cart ;
        System.out.println("Catalog is in Cart");
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartButton();
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartIcon();
        MyCartPageStrategy myCartPageStrategy = MyCartPageFactory.getStrategy(this);
        myCartPageStrategy.clickIncreaseCatalogQuantity();
        myCartPageStrategy = MyCartPageFactory.getStrategy(this);
        myCartPageStrategy.clickPlaceOrderButton();
        //endregion

        ShipmentAndPaymentPageStrategy shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
        WishbookMoneyHelper wishbookMoneyHelper= new WishbookMoneyHelper(this);
        wishbookMoneyHelper.wishbookMoneyCheckedBoxOnShipmentPage();
        shipmentAndPaymentPageStrategy=ShipmentAndPaymentPageFactory.getStrategy(this);
        shipmentAndPaymentPageStrategy.BackShippmentPaymentButton();
        myCartPageStrategy=MyCartPageFactory.getStrategy(this);
        myCartPageStrategy.clickDeleteButton();
        PopUpPageStrategy popUpPageStrategy=PopUpPageFactory.getStrategy(this);
        popUpPageStrategy.clickOnYesRemoveItemFromCart();

    }
}
