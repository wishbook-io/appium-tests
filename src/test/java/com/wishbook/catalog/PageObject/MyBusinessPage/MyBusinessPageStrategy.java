package com.wishbook.catalog.PageObject.MyBusinessPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

@SuppressWarnings("unused")

public interface MyBusinessPageStrategy extends BaseStrategy {

    void clickRegisterNowButton();
    void clickDiscountSettingsButton();
    int getWishListAsShownInMyBusiness();
    void clickProfileLogo();
    void clickWishListMyBusiness();
    void clickMyCatalogs();
    void clickApplyNowButton();
    void clickMyNetwork();
    void clickRejectedBuyersButton();
    String getCompanyName();
    boolean isElementPresent();
    void clickRejectedSuppliersButton();
    void clickMyOrdersMyBusiness();
    String getTextCompanyName();
    Boolean IsRegistrationButtonDisplay();
    void clickMyViewersButton();
    Boolean myViewerIsDisplayed();
    boolean isCartIconPresent();
    void clickAddCatalogButton();
    void clickKycBankDetails();
    void clickWBMoney();
    boolean resellerHubIsDisplayed();
    void clickRewardPointsIcon();
    String getUserNameOnBusinessTab();
    String getUserCompanyNameOnBusinessTab();
    String getCompanyType();



}
