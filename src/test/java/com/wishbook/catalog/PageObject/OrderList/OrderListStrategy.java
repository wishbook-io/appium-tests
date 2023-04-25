package com.wishbook.catalog.PageObject.OrderList;

public interface OrderListStrategy {
    void enterSellerNameSearchTextField(String sellerName);
    void clickSearchButton();
    int getOrderNumber();
   void OrderListBackButton();
    void clickSearchedOrder(int index);
    String getEmptyList();
    void enterCatalogNameSearchTextField(String catalogName);
    void clickSearchedLeadsEnquiry();
    String getTextLeadEnquiryStatus();
    void clickSearchedLead(int index);
    void enterOrderNumber( int orderNumber);
    void clickNewPurchaseOrder();
    void clickOnSearchIconForEnquiryLead();

}
