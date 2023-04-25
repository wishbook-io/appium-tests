package com.wishbook.catalog.PageObject.MyNetworkPage;

public interface MyNetworkPageStrategy {

    void clickSearchButton();
    void enterBuyerName(String buyerName);
    void selectSearchedBuyerName();
    void BackMyNetworkButton();
    String getSelectedBuyerName();
    void clicksearchbar();
    String getSelectedSupplierName();

    void clickSelectedSupplier();

}
