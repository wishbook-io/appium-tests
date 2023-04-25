package com.wishbook.catalog.PageObject.OrderReceiptPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface OrderReceiptPageStrategy extends BaseStrategy{
    int getOrderNumber();
    String getSupplierName();
    void orderReceiptBackButton();
    int getOrderNumberScroll();
    String getOrderStatusScroll();
    void clickOrderReceivedButton();
    void clickCancelOrderButton();
    String getOrderStatus();
    float getRewardPoints();
    boolean isRewardPointsDisplaying();

    boolean isShippingChargeDisplayed();
    String getPaymentStatus();
    String getOrderReceiptCatalogName();
    boolean isOrderDateIsDisplaye();
    boolean paymentDateIsDisplaying();
    boolean cancelButtonIsDisplayed();
    float getPaidAmount();
    float getInvoiceShippingCharge();
    float getInvoiceDiscount();
    float getDiscountSettingInvoicePrice();
    String getOrderDateInvoice();
    String getSupplierNameInvoice();
    int getInvoiceOrderNumber();
    String getOrderDate();

    boolean rateThisOrderIsDisplayed();
    boolean callWbSupportButtonIsDisplayed();
    boolean chatWbSupportButtonIsDisplayed();

    String getShipmentDate();
    String getOrderReceivedText();
    float getSgst();
    float getCgst();
    float getDiscountInInvoice();
    float getDesignPriceAtInvoiceDetails();
    String getPaymentDetails();
    float getWBMoney();
    float getPayableAmount();
    boolean supplierNameIsDisplyed();
    boolean shippingChargeIsDisplayed();
    String getWishbookProviderText();
    float getNumberOfItemsAtBottom();
    float getNumberOfItemsDispatchedAtShipping();
    boolean trackYourOrderButtonIsDisplayed();

    boolean isDiscountDisplayed();
    boolean isWBMoneyDisplayed();
    boolean payableAmountIsDisplayed();
    boolean isPaidAmountDisplayed();
    boolean attachemntIconIsDisplayOnOrderReceipt();
    boolean gotoResellerHubButtonIsDisplayed();
    boolean thisIsResellerOrderIsDisplayed();
    float getResellerAmount();
    boolean isResellerAmountDisplayed();

    String getDispatchPendingText();
    String getProductName();
    float getCustomerPayableAmount();

}
