package com.wishbook.catalog.TestCases.OrderCatalogAndNonCatalog;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageFactory;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageStrategy;
import com.wishbook.catalog.PageObject.OrderList.OrderListFactory;
import com.wishbook.catalog.PageObject.OrderList.OrderListStrategy;
import com.wishbook.catalog.PageObject.OrderReceiptPage.OrderReceiptPageFactory;
import com.wishbook.catalog.PageObject.OrderReceiptPage.OrderReceiptPageStrategy;
import com.wishbook.catalog.PageObject.PaymentCardDetailsPage.PaymentCardDetailsPageFactory;
import com.wishbook.catalog.PageObject.PaymentCardDetailsPage.PaymentCardDetailsPageStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageFactory;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.*;
import com.wishbook.catalog.TestCases.TestCaseOptions;

public class OrderCatalogAndNonCatalog extends TestCase {
    public OrderCatalogAndNonCatalog(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestWholeSaler));
    }

    protected void run() {

        //region Login as Wholesaler Upload NonCatalog and logout ;
        ProductUploadHelper productUploadHelperNonCat = new ProductUploadHelper(this, ProductTestCaseHelper.SetType.SingleColorSet, ProductTestCaseHelper.PhotoshootType.WhiteBackgroundOrFaceCut);
        productUploadHelperNonCat.execute();
        new LoginHelper(this).logout();
        //endregion

        //region Login as Retailer And Add catalog
        new LoginHelper(this).loginAsTestRetailer();
        CatalogSearchHelper catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(getTest().getCommonCatalogName());
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartButton();
        catalogSearchHelper.goBackToHomePageAfterCatalogSelection();
        //endregion

        //region NonCatalog intoCart
        catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(productUploadHelperNonCat.getCatalogName());
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartButton();
        catalogDetailsPageStrategy.clickAddToCartIcon();
        //endregion

        //region MyCart calculation
        MyCartPageStrategy myCartPageStrategy= MyCartPageFactory.getStrategy(this);
        myCartPageStrategy.clickPlaceOrderButton();
        //endregion

        //region In shipment and payment page
        System.out.println("In shipment Page calculate invoice details and \n select payment mode ");
        ShipmentAndPaymentPageStrategy shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
        shipmentAndPaymentPageStrategy.selectShipmentAddress(0);
//        shipmentAndPaymentPageStrategy.UncheckedWishbookMoney();
//        shipmentAndPaymentPageStrategy.calculateInvoiceDetailsOnShipmentPage();
        shipmentAndPaymentPageStrategy.selectPaymentModeAtIndex(0);
        shipmentAndPaymentPageStrategy.clickProceedForPaymentButton();
        PaymentCardDetailsPageStrategy paymentCardDetailsPageStrategy= PaymentCardDetailsPageFactory.getStrategy(this);
        paymentCardDetailsPageStrategy.enterCardNumber("4012888888881881");
        paymentCardDetailsPageStrategy.enterCardHolderName("testing");
//        paymentCardDetailsPageStrategy.clickMonthTextFiled();
//        paymentCardDetailsPageStrategy.selectCardExpiryMonth(8);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        paymentCardDetailsPageStrategy.clickYearTextField();
//        paymentCardDetailsPageStrategy.selectCardExpiryYear(1);
//        paymentCardDetailsPageStrategy.clickMonthTextFiled();
//        paymentCardDetailsPageStrategy.selectCardExpiryMonth(8);
        paymentCardDetailsPageStrategy.enterCvvNumber("123");
        paymentCardDetailsPageStrategy.clickPayButton();
        paymentCardDetailsPageStrategy.clickSuccessButton();
        PopUpPageStrategy popUpPageStrategy= PopUpPageFactory.getStrategy(this);
        popUpPageStrategy.clickOk();
        //endregion

        //region check Manufacturer's order and verify name ;
        OrderListStrategy orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickSearchedOrder(6);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        OrderReceiptBuyerSideBeforePaymentHelper orderReceiptBuyerSideBeforePaymentHelper = new OrderReceiptBuyerSideBeforePaymentHelper(this);
 //       orderReceiptBuyerSideBeforePaymentHelper.orderReceiptBuyerDetails("Pending", "Paid");
        OrderReceiptPageStrategy orderReceiptPageStrategy = OrderReceiptPageFactory.getStrategy(this);
        orderReceiptPageStrategy.orderReceiptBackButton();
        //endregion

        //region check Wholesaler's order and verify name ;
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickSearchedOrder(4);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//         orderReceiptBuyerSideBeforePaymentHelper = new OrderReceiptBuyerSideBeforePaymentHelper(this);
//        orderReceiptBuyerSideBeforePaymentHelper.orderReceiptBuyerDetails("Pending", "Paid");
//         orderReceiptPageStrategy = OrderReceiptPageFactory.getStrategy(this);
//        orderReceiptPageStrategy.orderReceiptBackButton();
//        //endregion




    }
}
