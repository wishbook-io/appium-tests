package com.wishbook.catalog.PageObject.OrderPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface OrderPageStrategy extends BaseStrategy {
    void clickPendingSalesOrder();
    int getTotalPurchaseOrder();
    int getPendingPurchaseOrder();
    int getDispatchedPurchaseOrder();
    int getCancelledPurchaseOrder();
    int getTotalSalesOrder();
    int getPendingSalesOrder();
    int getDispatchedSaleOrder();
    int getCancelledSalesOrder();
    int getTotalBrokerageOrder();
    int getPendingBrokerageOrder();
    int getDispatchedBrokerageOrder();
    int getCancelledBrokerageOrder();
    void clickBrokeragePendingOrder();
    void clickDispatchedButton();
    void clickPurchaseDispatchedButton();
    void clickSalesCancelOrderButton();
    void clickBackMyOrderButton();
    void clickPendingPurchaseOrderButton();
    void clickPurchaseCancelOrderButton();
    int getTextOpenLead();
    int getTextResolvedLead();
    void openLeadButton();
    @SuppressWarnings("unused")
    void resolvedLeadButton();
    int getTextTotalLead();
    int getTextEnquiryOpen();
    int getTextEnquiryResolved();
    int getTextTotalEnquiry();
    void openEnquiryButton();
    void resolvedEnquiryButton();
    boolean IsRegistrationButtonDisplay();
    boolean isCartIconPresent();
    void clickAddToCartButton();

}
