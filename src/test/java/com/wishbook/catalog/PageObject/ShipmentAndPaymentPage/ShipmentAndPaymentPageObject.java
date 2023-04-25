package com.wishbook.catalog.PageObject.ShipmentAndPaymentPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


/**
 * @see BasePageObject
 */
public class ShipmentAndPaymentPageObject extends BasePageObject {


    //region element


    @AndroidFindBy(xpath = "//android.widget.CheckBox[@index='0']")
    private float expectedTotalPaybleAmount;
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.WISHBOOK_SHIPPING_CHARGE)
    private WebElement shippingCharge;
    @SuppressWarnings("unused")
    @AndroidFindBy(uiAutomator = AndroidLocator.FIND_SCROLLVIEW_AT + "0" + AndroidLocator.AND_SCROLL_TO_VIEW + AndroidLocator.CANCEL_ORDER + AndroidLocator.AND_FINISH_SCROLL)
    private WebElement cancelOrder;
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.DONE_ORDER)
    private WebElement doneOrder;
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.ADD_NEW_ADDRESS_BROKER)
    private WebElement addNewAddressButton;
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.ENTER_ADDRESS_LINE1_broker)
    private WebElement enterAddressLine1Broker;
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.ENTER_DELIVERY_PINCODE)
    private WebElement enterDeliveryCodeBroker;
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.SAVE_BROKER_ADDRESS_BUTTON)
    private WebElement save;
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.PROCEED_FOR_PAYMENT_BUTTON)
    private WebElement proceedForPaymentButton;
    @SuppressWarnings("unused")

    @AndroidFindBy(id = AndroidLocator.ENTER_PAYMENT_DETAILS_BUTTON)
    private WebElement enterPaymentDetailsButton;
    @AndroidFindBy(id = AndroidLocator.OTHER_TRANSPOTATION_MEDIUM)
    private WebElement otherTransportationMedium;
    @AndroidFindBy(id = AndroidLocator.TRANSPORT_VIA_WISHBOOK)
    private WebElement transportViaWishBookShippingPartner;
    @AndroidFindBy(id = AndroidLocator.GET_WISHBOOK_SHIPPING_CHARGE)
    private WebElement getWishbookShippingPartnerPrice;

    @AndroidFindBy(id="com.wishbook.catalog:id/invoice_reward_point")
    private WebElement rewardPoints;

    @AndroidFindBy(id = AndroidLocator.GET_TOTAL_ORDER_AMOUNT_SHIPMENT_PAGE)
    private WebElement getTotalOrderAmount;
    @AndroidFindBy(id = AndroidLocator.GET_TOTAL_DISCOUNT_SHIPMENT_PAGE)
    private WebElement getTotalDiscount;
    @AndroidFindBy(id = AndroidLocator.GET_TOTAL_GST_SHIPMENT_PAGE)
    private WebElement getGstCharge;
    @AndroidFindBy(id = AndroidLocator.GET_DELIVERY_CHARGE_SHIPMENT_PAGE)
    private WebElement getDeliveryCharge;
    @AndroidFindBy(id = AndroidLocator.GET_TOTAL_PAYABLE_AMOUNT)
    private WebElement getTotalPayableAmount;
    @AndroidFindBy(id = AndroidLocator.GET_DATE_ON_CART)
    private WebElement dateOnCart;
    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_payment_detail")
    private WebElement paymentDetails;
    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_shipping_address")
    private WebElement shippingAddress;
    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_wishbook_amount")
    private WebElement getWishbookMoney;
    @AndroidFindBy(id = "com.wishbook.catalog:id/final_amount")
    private WebElement nowPay;


    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_display_amount")
    private WebElement getResellAmount;

    @AndroidFindBy(id = "com.wishbook.catalog:id/switch_resale_order")
    protected WebElement resellerToggle;

    @AndroidFindBy(id = "com.wishbook.catalog:id/total_order_amount")
    private WebElement totalOrderAmount;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_sub_charge")
    private WebElement airTransportCharge;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_select_delivery_address")
    private WebElement selectDeliveryAddress;

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_payment")
    private WebElement proceedToCODbutton;


    /**
     * @see BasePageObject
     */
    public ShipmentAndPaymentPageObject(TestCase testCase) {
        super(testCase);
    }
    // endregion


    //region  services
    @SuppressWarnings("unused")

    public void clickProceedForPaymentButton() {
        proceedForPaymentButton.click();
    }

    @SuppressWarnings("unused")
    public void clickCancelOrderButton() {
        cancelOrder.click();
    }

    @SuppressWarnings("unused")
    public void clickDoneButton() {
        doneOrder.click();
    }

    @SuppressWarnings("unused")
    public void BackShippmentPaymentButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }

    @SuppressWarnings("unused")
    public void clickAddNewAddressButton() {
        addNewAddressButton.click();
    }

    @SuppressWarnings("unused")
    public void enterAddresOfLine1Broker(String address) {
        enterAddressLine1Broker.sendKeys(address);
    }

    @SuppressWarnings("unused")
    public void enterPinCodeINBrokerAddress() {
        enterDeliveryCodeBroker.sendKeys("834001");
    }

    @SuppressWarnings("unused")
    public void clickSaveBrokerAddress() {
        save.click();
    }

    @SuppressWarnings("unused")

    public void clickEnterPaymentDetails() {
        enterPaymentDetailsButton.click();
    }



    public float getTransportWishbookShippingCharge() {
        return BasePageObject.getFloatFromString(getWishbookShippingPartnerPrice.getText());
        }

    public float getRewardPointsAmount(){
        return BasePageObject.getFloatFromString(rewardPoints.getText());
    }

    public float getTotalOrderAmount() {
        AndroidHelper.getScrollableItem(By.id(AndroidLocator.GET_TOTAL_ORDER_AMOUNT_SHIPMENT_PAGE),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver());
        return BasePageObject.getFloatFromString(totalOrderAmount.getText());

    }

    public float getTotalDiscount() {
        return BasePageObject.getFloatFromString(getTotalDiscount.getText());
    }

    public boolean isOtherTransportMediumDisplayed() {
        boolean v = otherTransportationMedium.isDisplayed();
        System.out.println("otherTransportationMedium is displying = " + v);
        return v;
    }

    public boolean isOtherTransportMediumSelected() {
        return otherTransportationMedium.isSelected();
    }

    public boolean otherTransportMediumIsPresent() {
        return getDriver().findElements(By.id(AndroidLocator.OTHER_TRANSPOTATION_MEDIUM)).size() > 0;
    }

    public boolean shippingChargeIsPresent() {
        return getDriver().findElements(By.id(AndroidLocator.GET_WISHBOOK_SHIPPING_CHARGE)).size() > 0;
    }

    public boolean dateOnShippmentIsDisplayed() {
        return getDriver().findElements(By.id(AndroidLocator.GET_DATE_ON_CART)).size() > 0;

    }

    public String getDateOnShipmentPage() {
        return getDriver().findElement(By.id(AndroidLocator.GET_DATE_ON_CART)).getText();

    }

    public String getPaymentDetails() {
        return paymentDetails.getText();
    }

    public String getShipingAddressInOrderReceipt() {
        return shippingAddress.getText();
    }



    public float getNowPay() {
        return BasePageObject.getFloatFromString(nowPay.getText());
    }

    public float getResellAmount() {
        return BasePageObject.getFloatFromString(getResellAmount.getText());
    }

    public float getAirTransportCharge(){
        return BasePageObject.getFloatFromString(airTransportCharge.getText());
    }

    public void clickDeliveryAddress(){
        selectDeliveryAddress.click();
    }

     public void clickConfirmCODOrder(){
        proceedToCODbutton.click();
     }


}




//endregion

