package com.wishbook.catalog.PageObject.ShipmentAndPaymentPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

@SuppressWarnings("unused")
public interface ShipmentAndPaymentPageStrategy extends BaseStrategy {

    void selectShipmentAddress(int index);
    void selectPaymentModeAtIndex(int index);
    void clickDoneButton();

    int getOrderNumber();
    String getSupplierNameShipment();
    void clickProceedForPaymentButton();
    void clickEnterPaymentDetails();

    void clickCashFreePaymentMode();
    void clickChequePaymentMode();
    void clickNeftPaymentMode();
    void clickCODPaymentMode();
    void clickWishbookCreditPaymentMode();
    float getAirTransportCharge();
    void clickConfirmCODOrder();



    float getTransportWishbookShippingCharge();
    void BackShippmentPaymentButton();
    boolean isOtherTransportMediumDisplayed();
    float getTotalPayableAmount();
    float getDeliveryCharge();
    float getTotalGst();
    String getDateOnShipmentPage();
    String getPaymentDetails();
    String getShipingAddressInOrderReceipt();
    float getTotalDiscount();
    float getTotalOrderAmount();
    boolean isOtherTransportMediumSelected();
    boolean transportViaWishbookIsPresent();
    boolean otherTransportMediumIsPresent();
    boolean shippingChargeIsPresent();
    boolean transportViaWishbookIsEnabled();
    boolean isDeliveryChargeDispalyed();
    boolean dateOnShippmentIsDisplayed();
    String scrollToSeeDetails();
    float getRewardPointsAmount();
    void clickDeliveryAddress();


    float getNowPay();
    float getResellAmount();
    boolean payementModeIsDisplayed();
    float getTotalPayableAmountAfterApplyingRewardPoints();

    boolean resellerOrderToggleIsDisplayed();
    void clickResellerToggle();
    float getOrderAmountShipmentPage();
    float getResaleAmountShipmentPage();
    boolean orderAmountShipmentPageIsDisplayed();
    boolean resaleAmountShipmentPageIsDisplayed();
    boolean changeLinkIsDisplayed();
    void clickChangeResaleLink();

}
