package com.wishbook.catalog.PageObject.OrderReceiptPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


@SuppressWarnings("unused")
public class OrderReceiptPageObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = AndroidLocator.SUPPLIER_NAME_ON_ORDER_DETAILS)
    private WebElement supplierName;

    @AndroidFindBy (className ="android.widget.ImageButton")
    protected WebElement supportChatBackButton;

    @AndroidFindBy(id = AndroidLocator.SUPPLIER_NAME_ON_ORDER_DETAILS)//same Id in different pages
    private WebElement BuyerName;

    @AndroidFindBy(id = AndroidLocator.PAYMENT_STATUS)
    private WebElement paymentStatus;

    @AndroidFindBy(id = AndroidLocator.PAYMENT_DETAILS)
    private WebElement paymentDetails;

    @AndroidFindBy(id = AndroidLocator.AMOUNT_ON_ORDER_DEATILS)
    private WebElement orderDetails;

    @AndroidFindBy(id = AndroidLocator.ORDER_NUMBER_TEXT)
    private WebElement OrderNumber;

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;

    @AndroidFindBy(id = AndroidLocator.CHAT_WITH_BUYER_BUTTON)
    private WebElement chatWithBuyer;

    @AndroidFindBy(id = AndroidLocator.CHAT_WITH_SUPPLIER_BUTTON)
    private WebElement chatWithSupplier;

    @AndroidFindBy(id = AndroidLocator.BROKER_NAME_GET_TEXT)
    private WebElement brokerName;

    @AndroidFindBy(id = AndroidLocator.PAY_BUTTON_ORDER_RECEIPT)
    private WebElement payButton;

    @AndroidFindBy(id=AndroidLocator.ORDER_STATUS)
    private WebElement orderStatusGetText;

    @AndroidFindBy(id = "com.wishbook.catalog:id/invoice_prod_name")
    private WebElement orderReceiptCatalogName;

    @AndroidFindBy(id = AndroidLocator.DATE_ON_RECEIPT)
    private WebElement orderDateOnOrderReceipt;

    @AndroidFindBy(id = AndroidLocator.DATE_PAYMENT)
    private WebElement paymentDate;

     @AndroidFindBy(id = AndroidLocator.DISCOUNTING_INVOICE_PRICE)
     private WebElement dicountingPrice;

     @AndroidFindBy(id = AndroidLocator.DISCOUNT_INVOICE)
     private WebElement discountInvoice;

     @AndroidFindBy(id = "com.wishbook.catalog:id/btn_call_wb_support")
     private WebElement callWbSupportButton;

     @AndroidFindBy(id = "com.wishbook.catalog:id/btn_chat_wb_support")
     private WebElement chatWbSupportButton;

     @AndroidFindBy(id = "com.wishbook.catalog:id/shipment_date")
     private WebElement shipmentDate;

     @AndroidFindBy(id = "com.wishbook.catalog:id/invoice_prod_value")
     private WebElement getInvoiceDesignPrice;

     @AndroidFindBy(id = "com.wishbook.catalog:id/txt_seller_discount")
     private WebElement getDiscountInvoice;

     @AndroidFindBy(id = "com.wishbook.catalog:id/tax_class_1_value")
     private WebElement SGST;

     @AndroidFindBy(id="com.wishbook.catalog:id/tax_class_2_value")
     private  WebElement CGST;

     @AndroidFindBy(id = AndroidLocator.WISHBOOK_MONEY_TEXT_ON_ORDER_DEATILS)
     private WebElement getWishbookMoney;

     @AndroidFindBy(id = AndroidLocator.PAYABLE_AMOUNT)
     protected WebElement payableAmount;

     @AndroidFindBy(id = "com.wishbook.catalog:id/txt_reseller_note")
     private WebElement thisIsResellerOrderText;

     @AndroidFindBy(id = "com.wishbook.catalog:id/btn_reseller_hub")
     private WebElement gotoResellerHubButton;


    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public OrderReceiptPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  services
    public int getOrderNumber() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 160);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.wishbook.catalog:id/txt_order_no")));

        WebElement orderNumber = getDriver().findElement(By.id("com.wishbook.catalog:id/txt_order_no"));
        String element=orderNumber.getText();
        return Integer.valueOf(element.replaceAll("[^0-9]", ""));
    }
    public String getSupplierName() {
        return supplierName.getText();
    }
    public void orderReceiptBackButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }
    public boolean isChatWithBuyerPresent() {
        return getDriver().findElements(By.id(AndroidLocator.CHAT_WITH_BUYER_BUTTON)).size() > 0;
    }

    public boolean isChatWithSupplierPresent() {
        return getDriver().findElements(By.id(AndroidLocator.CHAT_WITH_SUPPLIER_BUTTON)).size() > 0;
    }
    public boolean isOrderDateIsDisplaye() {
        return getDriver().findElements(By.id(AndroidLocator.DATE_ON_RECEIPT)).size() > 0;

    }
    public boolean isRewardPointsDisplaying(){
        return getDriver().findElements(By.id(AndroidLocator.REWARD_POINTS)).size() > 0;

    }
    public String getOrderDate() {
        return getDriver().findElement(By.id(AndroidLocator.DATE_ON_RECEIPT)).getText();
    }
    public boolean paymentDateIsDisplaying() {
        return getDriver().findElements(By.id( AndroidLocator.DATE_PAYMENT)).size() > 0;

    }


    public String getBrokerName() {
        return brokerName.getText();
    }

    public String getBuyerName() {
        return BuyerName.getText();

    }
    public String getPaymentStatus() {
        return paymentStatus.getText();
    }
    public String getOrderStatus(){
        return orderStatusGetText.getText();
    }

    public String getOrderReceiptCatalogName() {
       return orderReceiptCatalogName.getText();
    }



    public String getShipmentDate() {
        return shipmentDate.getText();
    }


    public float getDiscountInInvoice() {
        return BasePageObject.getFloatFromString(getDiscountInvoice.getText());
    }


    public float getCgst() {
        return BasePageObject.getFloatFromString(CGST.getText());
    }

    public String getPaymentDetails() {
        return paymentDetails.getText();
    }



    public boolean transferButtonIsDisplayed() {
        return getDriver().findElements(By.id(AndroidLocator.TRANSFER_BUTTON)).size()>0;

    }
    public boolean dispatchedButtonIsDiplayed() {
        return getDriver().findElements(By.id(AndroidLocator.DISPATCH_ORDER_BUTTON)).size()>0;

    }
    public boolean supplierNameIsDisplyed() {
        return getDriver().findElements(By.id(AndroidLocator.SUPPLIER_NAME)).size()>0;

    }
    public boolean shippingChargeIsDisplayed() {
        return getDriver().findElements(By.id(AndroidLocator.WISHBOOK_SHIPPING_INVOICE)).size()>0;

    }

    public boolean isWBMoneyDisplayed() {
        return getDriver().findElements(By.id(AndroidLocator.WISHBOOK_MONEY_TEXT_ON_ORDER_DEATILS)).size()>0;
    }
    public boolean isDiscountDisplayed() {
        return getDriver().findElements(By.id("com.wishbook.catalog:id/relative_seller_discount")).size()>0;
    }

    public float getSgst() {
        AndroidHelper.scrolling(AndroidHelper.ScrollDirection.Down,
                4, (AndroidDriver) getDriver());
        return BasePageObject.getFloatFromString(SGST.getText());
    }
    public boolean payableAmountIsDisplayed(){
        return getDriver().findElements(By.id(AndroidLocator.PAYABLE_AMOUNT)).size()>0;

    }

    public boolean isPaidAmountDisplayed() {
        return getDriver().findElements(By.id(AndroidLocator.PAID_AMOUNT)).size()>0;

    }
    public boolean isResellerAmountDisplayed() {
        return getDriver().findElements(By.id("com.wishbook.catalog:id/txt_display_amount")).size()>0;

    }
    public boolean isShippingChargeDisplayed(){
        return getDriver().findElements(By.id(AndroidLocator.WISHBOOK_SHIPPING_INVOICE)).size()>0;
    }

    public String getWishbookProviderText(){
        return getDriver().findElement(By.id(AndroidLocator.SHIPPING_PROVIDER_WISHBOOK)).getText();

    }

    public boolean attachemntIconIsDisplayOnOrderReceipt() {
        return getDriver().findElements(By.id(AndroidLocator.ATTACHMENT_SELLER_ORDER_RECEIPT)).size()>0;

    }
    public boolean thisIsResellerOrderIsDisplayed(){
        return  getDriver().findElements(By.id("com.wishbook.catalog:id/txt_reseller_note")).size()>0;
    }
    public boolean gotoResellerHubButtonIsDisplayed(){
        return  getDriver().findElements(By.id("com.wishbook.catalog:id/btn_reseller_hub")).size()>0;

    }




    //endregion

}
