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

public class ShipmentAndPaymentReactNativeObject extends BasePageObject implements ShipmentAndPaymentPageStrategy {


   @AndroidFindBy(accessibility = "ShipayOrderDateText")
   private WebElement orderDateText;

    @AndroidFindBy(xpath= "//android.widget.TextView[@content-desc=\"ShipayTotalOrderAmountText\"]")
    private WebElement totalOrderAmountText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"ShipayTotalDiscountText\"]\n")
    private WebElement totalDiscountText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"ShipayTotalGstText\"]")
    private WebElement totalGst;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"ShipayDeliveryChargesText\"]")
    private WebElement deliveryChargeText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"ShipayTotalAmountText\"]")
    private WebElement totalAmountBeforeApplyingWBMoney;



    @AndroidFindBy(accessibility = "ShipayWbMoneyAvailableText")
    private WebElement wbMoneyInCheckBox;


    @AndroidFindBy(accessibility = "ShipayFooterButton")
    private WebElement proceedForPaymentButton;

    @AndroidFindBy(accessibility = "ShipayFooterButton")
    private WebElement enterPaymentDetailsButton;

    @AndroidFindBy(accessibility ="ShipayBackButton" )
    private WebElement backButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Surface']")
    private WebElement surfaceRadioButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Air']")
    private WebElement AirRadioButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wallet/PayTM/UPI/Credit/Debit/Net Banking (Cashfree)']")
    private WebElement cashFree;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cash On Delivery']")
    private WebElement cashOnDelivery;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CHEQUE']")
    private WebElement cheque;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NEFT']")
    private WebElement neft;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wishbook Credit']")
    private WebElement wishbookCredit;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"ShipayWbMoneyUsedText\"]")
    private WebElement rewardsPoint;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"ShipayPayableAmountText\"]")
    private WebElement amountAfterApplyingWBRewards;


    public ShipmentAndPaymentReactNativeObject(TestCase testCase) {
        super(testCase);
    }


    public void selectShipmentAddress(int index) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, "android.widget.TextView", index).click();


    }

    public void selectPaymentModeAtIndex(int index) {

    }

    public void clickCashFreePaymentMode(){
        AndroidHelper.getScrollableItem(By.xpath("//android.widget.TextView[@text='Wallet/PayTM/UPI/Credit/Debit/Net Banking (Cashfree)']"),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver()).click();

    }
    public void clickChequePaymentMode(){
        AndroidHelper.getScrollableItem(By.xpath("//android.widget.TextView[@text='CHEQUE']"),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver()).click();

    }
    public void clickNeftPaymentMode(){
        AndroidHelper.getScrollableItem(By.xpath("//android.widget.TextView[@text='NEFT']"),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver()).click();

    }

    public void clickCODPaymentMode(){
        AndroidHelper.getScrollableItem(By.xpath("//android.widget.TextView[@text='Cash On Delivery']"),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver()).click();

    }

    public void clickWishbookCreditPaymentMode(){
        AndroidHelper.getScrollableItem(By.xpath("//android.widget.TextView[@text='Wishbook Credit']"),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver()).click();

    }

    public float getAirTransportCharge() {
        return 0;
    }

    public void clickConfirmCODOrder() {

    }


    public String getSupplierNameShipment() {
        return null;
    }


    public void clickProceedForPaymentButton() {
          proceedForPaymentButton.click();
    }

    public void clickEnterPaymentDetails() {
          enterPaymentDetailsButton.click();
    }

    public void BackShippmentPaymentButton() {
      backButton.click();

    }
    public String getDateOnShipmentPage() {
        return orderDateText.getText();
    }

    public float getTotalOrderAmount() {
        AndroidHelper.getScrollableItem(By.xpath("//android.widget.TextView[@content-desc=\"ShipayPayableAmountText\"]"),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver());

        return BasePageObject.getFloatFromString(totalOrderAmountText.getText());
    }

    public float getTotalDiscount() {
        return BasePageObject.getFloatFromString(totalDiscountText.getText());
    }
    public float getTotalGst() {
        return BasePageObject.getFloatFromString(totalGst.getText());
    }

    public float getDeliveryCharge() {
        return BasePageObject.getFloatFromString(deliveryChargeText.getText());
    }


    public float getTotalPayableAmount() {
        return BasePageObject.getFloatFromString(totalAmountBeforeApplyingWBMoney.getText());
    }

    public float getRewardPointsAmount() {
        return BasePageObject.getFloatFromString(rewardsPoint.getText());
    }

    public float getTotalPayableAmountAfterApplyingRewardPoints() {

        return BasePageObject.getFloatFromString(amountAfterApplyingWBRewards.getText());
    }


    public boolean isDeliveryChargeDispalyed() {
        return getDriver().findElements(By.xpath("//android.widget.TextView[@content-desc=\"ShipayDeliveryChargesText\"]")).size() > 0;

    }

    public boolean dateOnShippmentIsDisplayed() {
        return getDriver().findElements(By.xpath("//android.widget.TextView[@content-desc=\"ShipayOrderDateText\"]")).size() > 0;
    }

    public boolean shippingChargeIsPresent() {
        return getDriver().findElements(By.xpath("//android.widget.TextView[@content-desc=\"ShipayDeliveryChargesText\"]")).size() > 0;
    }



    public String scrollToSeeDetails() {
        return null;
    }


    public void clickDeliveryAddress() {

    }


    public float getNowPay() {
        return 0;
    }


    public float getResellAmount() {
        return 0;
    }

    public boolean payementModeIsDisplayed() {
        return getDriver().findElements(By.id("")).size() > 0;
    }


    public boolean resellerOrderToggleIsDisplayed() {
        return false;
    }

    public void clickResellerToggle() {

    }

    public float getOrderAmountShipmentPage() {
        return 0;
    }

    public float getResaleAmountShipmentPage() {
        return 0;
    }

    public boolean orderAmountShipmentPageIsDisplayed() {
        return false;
    }

    public boolean resaleAmountShipmentPageIsDisplayed() {
        return false;
    }

    public boolean changeLinkIsDisplayed() {
        return false;
    }

    public void clickChangeResaleLink() {

    }

    public void clickDoneButton() {

    }

    public int getOrderNumber() {
        return 0;
    }

    public float getTransportWishbookShippingCharge() {
        return 0;
    }

    public boolean isOtherTransportMediumDisplayed() {
        return false;
    }

    public String getPaymentDetails() {
        return null;
    }

    public String getShipingAddressInOrderReceipt() {
        return null;
    }

    public boolean isOtherTransportMediumSelected() {
        return false;
    }

    public boolean transportViaWishbookIsPresent() {
        return false;
    }

    public boolean otherTransportMediumIsPresent() {
        return false;
    }


    public boolean transportViaWishbookIsEnabled() {
        return false;
    }
}
