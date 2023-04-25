package com.wishbook.catalog.PageObject.ShareCatalogPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;
@SuppressWarnings("unused")
public interface ShareCatalogPageStrategy  extends BaseStrategy {
    void clickSellFullCatalogCheckbox();
    void shareAtDifferentPriceRadioButton();
    void enterNewPriceTextBox(String price);
    void shareAfterAddingMargin();
    void addPercentTexBox(String percent);
    void addFixedAmountTextBox(String fixedAmount);
    void individualShareButton();
    void clickBuyerNameTextBox();
    void clickDoneButton();
    void clickbuyerGroupTextField();
    void BackShareCatalogButton();
    void groupSharingButton();
    void selectIndividualTab();
    void selectGroupTab();


}
