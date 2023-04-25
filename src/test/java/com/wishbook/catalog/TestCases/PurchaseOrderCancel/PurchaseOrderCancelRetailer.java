package com.wishbook.catalog.TestCases.PurchaseOrderCancel;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageFactory;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageStrategy;
import com.wishbook.catalog.PageObject.OrderCancelNoteDialoge.OrderCancelNoteDialogeFactory;
import com.wishbook.catalog.PageObject.OrderCancelNoteDialoge.OrderCancelNoteDialogeStrategy;
import com.wishbook.catalog.PageObject.OrderList.OrderListFactory;
import com.wishbook.catalog.PageObject.OrderList.OrderListStrategy;
import com.wishbook.catalog.PageObject.OrderPage.OrderPageFactory;
import com.wishbook.catalog.PageObject.OrderPage.OrderPageStrategy;
import com.wishbook.catalog.PageObject.OrderReceiptPage.OrderReceiptPageFactory;
import com.wishbook.catalog.PageObject.OrderReceiptPage.OrderReceiptPageStrategy;
import com.wishbook.catalog.PageObject.PaymentDialogPage.PaymentDialogFactory;
import com.wishbook.catalog.PageObject.PaymentDialogPage.PaymentDialogStrategy;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageFactory;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageStrategy;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageFactory;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.*;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class PurchaseOrderCancelRetailer extends TestCase {
    @SuppressWarnings("unused")
    public PurchaseOrderCancelRetailer(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestRetailer));

    }


    protected void run() {

        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.dismissCreditRatingDialog();

        //region get initials purchase Order
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickOrderButton();
        //region wait
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//endregion
        OrderPageStrategy orderPageStrategy = OrderPageFactory.getStrategy(this);
        System.out.println("<------Purchase Order Details Before Order Creation------->");

        int purchaseTotalBeforeOrderCount = orderPageStrategy.getTotalPurchaseOrder();
        System.out.println("totalPurchaseOrderBeforeOrderCreation " + purchaseTotalBeforeOrderCount);

        int purchasePendingBeforeOrderCount = orderPageStrategy.getPendingPurchaseOrder();
        System.out.println("PendingPurchaseOrderBeforeOrderCreation " + purchasePendingBeforeOrderCount);

        int purchaseDispatchedBeforeOrderCount = orderPageStrategy.getDispatchedPurchaseOrder();
        System.out.println("DispatchedPurchaseOrderBeforeOrderCreation " + purchaseDispatchedBeforeOrderCount);

        int purchaseCancelledBeforeOrderCount = orderPageStrategy.getCancelledPurchaseOrder();
        System.out.println("CancelledPurchaseOrderBeforeOrderCreation" + purchaseCancelledBeforeOrderCount);


        int AddTotalPurchaseOrder = purchasePendingBeforeOrderCount + purchaseDispatchedBeforeOrderCount + purchaseCancelledBeforeOrderCount;
        Assert.assertEquals(purchaseTotalBeforeOrderCount, AddTotalPurchaseOrder);
        //endregion

        //region searching common catalog ;
        System.out.println("searching common uploaded catalog");
        CatalogSearchHelper searchHelper = new CatalogSearchHelper(this);
        searchHelper.catalogSearchInHomePageSearchButton(getTest().getCommonCatalogName());
        //endregion

        //region Catalog is in Cart ;
        System.out.println("Catalog is in Cart");
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartButton();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartIcon();
        MyCartPageStrategy myCartPageStrategy = MyCartPageFactory.getStrategy(this);
        myCartPageStrategy.clickIncreaseCatalogQuantity();
        myCartPageStrategy = MyCartPageFactory.getStrategy(this);
        myCartPageStrategy.clickPlaceOrderButton();
        //endregion

        //region payment using Other Method
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ShipmentAndPaymentPageStrategy shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
        shipmentAndPaymentPageStrategy.selectShipmentAddress(0);
        shipmentAndPaymentPageStrategy.scrollToSeeDetails();
        float totalPayble=shipmentAndPaymentPageStrategy.getTotalPayableAmount();
        //shipmentAndPaymentPageStrategy.clickOtherPaymentMode();
        shipmentAndPaymentPageStrategy.clickEnterPaymentDetails();
        PaymentDialogStrategy paymentDialogStrategy= PaymentDialogFactory.getStrategy(this);
        float amountOnPopup=paymentDialogStrategy.getAmount();
        Assert.assertEquals(totalPayble,amountOnPopup);
        paymentDialogStrategy.clickSavePaymentButton();
        //endregion

        //region In purchase order page after order ;
        OrderListStrategy orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickSearchedOrder(4);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        OrderReceiptBuyerSideAfterPaymentHelper orderReceiptBuyerSideAfterPaymentHelper = new OrderReceiptBuyerSideAfterPaymentHelper(this);
//        orderReceiptBuyerSideAfterPaymentHelper.orderReceiptBuyerDetails("Order Placed", "Pending");
        OrderReceiptPageStrategy orderReceiptPageStrategy = OrderReceiptPageFactory.getStrategy(this);
        orderReceiptPageStrategy.orderReceiptBackButton();
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickSearchButton();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.closeSearchTextField();
        orderListStrategy.OrderListBackButton();

         catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickWishListButton();
        catalogDetailsPageStrategy.BackCatalogButton();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();
        //endregion;

        //region after order creation pending purchase order is increased by 1
         bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickOrderButton();
        orderPageStrategy = OrderPageFactory.getStrategy(this);
        System.out.println("<--------Purchase Order Details After Order Creation-------->");
        int purchaseTotalAfterOrderCount = orderPageStrategy.getTotalPurchaseOrder();
        System.out.println("TotalPurchaseOrderAfterOrderCreation " + purchaseTotalAfterOrderCount);
        Assert.assertEquals(purchaseTotalBeforeOrderCount + 1, purchaseTotalAfterOrderCount);

        int purchasePendingAfterOrderCount= orderPageStrategy.getPendingPurchaseOrder();
        System.out.println("pendingPurchaseOrderAfterOrderCreation" + purchasePendingAfterOrderCount);
        Assert.assertEquals(purchasePendingBeforeOrderCount + 1, purchasePendingAfterOrderCount);

        int purchaseDispatchedAfterOrderCount = orderPageStrategy.getDispatchedPurchaseOrder();
        System.out.println("DispatchedPurchaseOrderAfterOrderCreation " + purchaseDispatchedAfterOrderCount);
        Assert.assertEquals(purchaseDispatchedBeforeOrderCount, purchaseDispatchedAfterOrderCount);

        int purchaseCancelledAfterOrderCount = orderPageStrategy.getCancelledPurchaseOrder();
        System.out.println("CancelledPurchaseOrderAfterOrderCreation" + purchaseCancelledAfterOrderCount);
        Assert.assertEquals(purchaseCancelledBeforeOrderCount, purchaseCancelledAfterOrderCount);

        int AddTotalOrders=purchaseCancelledAfterOrderCount+purchaseDispatchedAfterOrderCount+purchasePendingAfterOrderCount;
        Assert.assertEquals(AddTotalOrders,purchaseTotalAfterOrderCount);
        //endregion

        //region Search Order And Cancel Order
        orderPageStrategy.clickPendingPurchaseOrderButton();
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickSearchButton();
//        orderListStrategy.enterOrderNumber(orderReceiptBuyerSideAfterPaymentHelper.getOrderNumberOnReceipt());
        orderListStrategy.clickSearchedOrder(4);
        //region wait
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //endregion
        orderReceiptPageStrategy = OrderReceiptPageFactory.getStrategy(this);
        orderReceiptPageStrategy.clickCancelOrderButton();
        OrderCancelNoteDialogeStrategy cancelNoteDialogeStrategy = OrderCancelNoteDialogeFactory.getStrategy(this);
        cancelNoteDialogeStrategy.enterOrderCancelNote("Delay");
        cancelNoteDialogeStrategy.clickOnOk();

        orderReceiptPageStrategy = OrderReceiptPageFactory.getStrategy(this);
        String orderStatus3 = orderReceiptPageStrategy.getOrderStatusScroll();
        String Status3 = "Cancelled";
        Assert.assertEquals(Status3, orderStatus3);


        orderReceiptPageStrategy = OrderReceiptPageFactory.getStrategy(this);
        orderReceiptPageStrategy.orderReceiptBackButton();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.closeSearchTextField();
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickSearchButton();
        orderListStrategy.OrderListBackButton();
        //endregion

        //region verify that order is in cancel and cancel order is increased by 1 and pending order is decreased by1
        bottomTabPageStrategy.clickHomeButton();
        bottomTabPageStrategy.clickOrderButton();
        //region wait
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }// endregion
        orderPageStrategy = OrderPageFactory.getStrategy(this);
        System.out.println("<----------------Purchase Order Details After Order Cancel------------------------>");
        int totalPurchaseOrderAfterOrderCancelled = orderPageStrategy.getTotalPurchaseOrder();
        System.out.println("TotalPurchaseOrderAfterOrderCancel " + totalPurchaseOrderAfterOrderCancelled);
        Assert.assertEquals(totalPurchaseOrderAfterOrderCancelled, purchaseTotalAfterOrderCount);

        int pendingPurchaseOrderAfterOrderCancelled = orderPageStrategy.getPendingPurchaseOrder();
        System.out.println("pendingPurchaseOrderAfterOrderCancel" + pendingPurchaseOrderAfterOrderCancelled);
        Assert.assertEquals(purchasePendingAfterOrderCount-1, pendingPurchaseOrderAfterOrderCancelled);

        int dispatchedPurchaseOrderAfterOrderCancelled = orderPageStrategy.getDispatchedPurchaseOrder();
        System.out.println("DispatchedPurchaseOrderAfterOrderCancel " + dispatchedPurchaseOrderAfterOrderCancelled);
        Assert.assertEquals(dispatchedPurchaseOrderAfterOrderCancelled, purchaseDispatchedAfterOrderCount);

        int cancelPurchaseOrderAfterOrderCancel = orderPageStrategy.getCancelledPurchaseOrder();
        System.out.println("CancelledPurchaseOrderAfterOrderCancel" + cancelPurchaseOrderAfterOrderCancel);
        Assert.assertEquals(cancelPurchaseOrderAfterOrderCancel,purchaseCancelledAfterOrderCount+1);
        //endregion

        //region verify cancel order in cancel prchased order
        orderPageStrategy.clickPurchaseCancelOrderButton();
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickSearchButton();
//        orderListStrategy.enterOrderNumber(orderReceiptBuyerSideAfterPaymentHelper.getOrderNumberOnReceipt());
        orderListStrategy.clickSearchedOrder(4);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int orderNum5 = orderReceiptPageStrategy.getOrderNumber();
//        Assert.assertEquals(orderReceiptBuyerSideAfterPaymentHelper.getOrderNumberOnReceipt(), orderNum5);
        String OrderStatusCancelled = orderReceiptPageStrategy.getOrderStatus();
        String statusCancel="Cancelled";
        Assert.assertEquals(statusCancel,OrderStatusCancelled);
        orderReceiptPageStrategy.orderReceiptBackButton();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.closeSearchTextField();
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickSearchButton();
        orderListStrategy.OrderListBackButton();
        //endregion

    }
}
