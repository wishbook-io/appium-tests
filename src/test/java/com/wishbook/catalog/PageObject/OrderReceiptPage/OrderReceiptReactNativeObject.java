package com.wishbook.catalog.PageObject.OrderReceiptPage;

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

public class OrderReceiptReactNativeObject extends BasePageObject implements OrderReceiptPageStrategy {


    @AndroidFindBy(accessibility = "OrdersDetailScreenOrderNumberText")
    private WebElement orderDetailsOrderNumber;

    @AndroidFindBy(accessibility = "OrdersDetailScreenOrderDateText")
    private WebElement orderDetailsOrderDate;

    @AndroidFindBy(accessibility = "OrdersDetailScreenOrderStatusText")
    private WebElement orderDetailsOrderStatus;

    @AndroidFindBy(accessibility = "OrdersDetailScreenPaymentStatusText")
    private WebElement orderDetailsPaymentStatus;

    @AndroidFindBy(accessibility = "OrdersDetailScreenPaymentDateText")
    private WebElement orderDetailsPaymentDate;

    @AndroidFindBy(accessibility = "OrdersDetailScreenPaymentDetailsText")
    private WebElement orderDetailsPaymentDetails;

    @AndroidFindBy(accessibility = "OrdersDetailScreenAmountText")
    private WebElement orderValueSummaryProductAmount;

    @AndroidFindBy(accessibility = "OrdersDetailScreenOrderNumberText")
    private WebElement orderNumberInvoiceDetails;

    @AndroidFindBy(accessibility = "OrdersDetailScreenOrderDateText")
    private WebElement orderDateInvoiceDetails;

    @AndroidFindBy(accessibility = "OrdersDetailScreenOrderTrackingTex")
    private WebElement orderTracking;

    @AndroidFindBy(accessibility = "OrdersDetailScreenDiscountText")
    private WebElement discountTextInvoiceDetails;

    @AndroidFindBy(accessibility = "OrdersDetailScreenSGSTText")
    private WebElement sgstTextInvoiceDetails;

    @AndroidFindBy(accessibility = "OrdersDetailScreenCGSTText")
    private WebElement cgstTextInvoiceDetails;

    @AndroidFindBy(accessibility = "OrdersDetailScreenPaidAmountText")
    private WebElement paidAmountInvoiceDetails;

    @AndroidFindBy(accessibility = "OrdersDetailScreenPayableAmountText")
    private WebElement payableAmountInvoiceDetails;

    @AndroidFindBy(accessibility = "OrdersDetailScreenCallWbSupportButton")
    private WebElement callWbSupportButton;

    @AndroidFindBy(accessibility = "OrdersDetailScreenChatWbSupportButton")
    private WebElement chatWbSupportButton;



    public OrderReceiptReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public int getOrderNumber() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("OrdersDetailScreenAmountText")));
        String element=orderDetailsOrderNumber.getText();
        return Integer.valueOf(element.replaceAll("[^0-9]", ""));
    }

    public boolean isOrderDateIsDisplaye() {
        return getDriver().findElements(By.id("OrdersDetailScreenOrderDateText")).size() > 0;

    }
    public String getOrderDate() {
        return getDriver().findElement(By.id("OrdersDetailScreenOrderDateText")).getText();
    }
    public boolean paymentDateIsDisplaying() {
        return getDriver().findElements(By.id( "OrdersDetailScreenPaymentDateText")).size() > 0;

    }
    public String getPaymentStatus() {
        return orderDetailsPaymentStatus.getText();
    }
    public String getOrderStatus(){
        return orderDetailsOrderStatus.getText();
    }

    public float getRewardPoints() {
        return 0;
    }

    public boolean isRewardPointsDisplaying() {
        return false;
    }

    public String getPaymentDetails() {
        return orderDetailsPaymentDetails.getText();
    }



    public int getInvoiceOrderNumber(){
        return Integer.parseInt(AndroidHelper.getScrollableItem(By.id("OrdersDetailScreenOrderNumberText"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()).getText());
    }


    public String getOrderDateInvoice() {
        return (AndroidHelper.getScrollableItem(By.id("OrdersDetailScreenOrderDateText"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver())).getText();

    }

    public boolean trackYourOrderButtonIsDisplayed() {
        return getDriver().findElements(By.id("OrdersDetailScreenOrderTrackingText")).size()>0;

    }

    public float getDiscountInInvoice() {
        return BasePageObject.getFloatFromString(discountTextInvoiceDetails.getText());
    }


    public float getCgst() {
        return BasePageObject.getFloatFromString(cgstTextInvoiceDetails.getText());
    }

    public float getSgst() {
        AndroidHelper.scrolling(AndroidHelper.ScrollDirection.Down,
                4, (AndroidDriver) getDriver());
        return BasePageObject.getFloatFromString(sgstTextInvoiceDetails.getText());
    }

    public float getPayableAmount() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id("OrdersDetailScreenPayableAmountText"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());
    }

    public float getPaidAmount() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id("OrdersDetailScreenPaidAmountText"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());

    }

    public float getWBMoney() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id("OrdersDetailScreenWBMoneyText"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());

    }


    public float getInvoiceDiscount() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id("OrdersDetailScreenDiscountText"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());
    }

    public float getInvoiceShippingCharge() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id(""),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());

    }

    public boolean supplierNameIsDisplyed() {
        return getDriver().findElements(By.id("")).size()>0;

    }
    public boolean shippingChargeIsDisplayed() {
        return getDriver().findElements(By.id("")).size()>0;

    }

    public boolean isWBMoneyDisplayed() {
        return getDriver().findElements(By.id("OrdersDetailScreenWBMoneyText")).size()>0;
    }
    public boolean isDiscountDisplayed() {
        return getDriver().findElements(By.id("OrdersDetailScreenDiscountText")).size()>0;
    }


    public boolean payableAmountIsDisplayed(){
        return getDriver().findElements(By.id("OrdersDetailScreenPayableAmountText")).size()>0;

    }


    public boolean isPaidAmountDisplayed() {
        return getDriver().findElements(By.id("OrdersDetailScreenPaidAmountText")).size()>0;

    }
    public boolean isShippingChargeDisplayed(){
        return getDriver().findElements(By.id("")).size()>0;
    }


    public String getWishbookProviderText(){
        return getDriver().findElement(By.id("")).getText();

    }

    public boolean attachemntIconIsDisplayOnOrderReceipt() {
        return getDriver().findElements(By.id("")).size()>0;

    }

    public boolean payButtonIsDisplayed() {
        return AndroidHelper.getScrollableItem(By.id(""),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()).isDisplayed();

    }
    public boolean cancelButtonIsDisplayed() {
        return AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, "android.widget.Button", 1).isDisplayed();

    }
    public boolean chatWbSupportButtonIsDisplayed() {
        return AndroidHelper.getScrollableItem(By.id("OrdersDetailScreenChatWbSupportButton"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()).isDisplayed();

    }

    public boolean callWbSupportButtonIsDisplayed() {
        return AndroidHelper.getScrollableItem(By.id("OrdersDetailScreenCallWbSupportButton"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()).isDisplayed();
    }


    public String getSupplierName() {
        return null;
    }

    public void orderReceiptBackButton() {

    }



    public void clickPayButton() {

    }

    public int getOrderNumberScroll() {
        return 0;
    }

    public String getOrderStatusScroll() {
        return null;
    }

    public void clickOrderReceivedButton() {

    }

    public void clickCancelOrderButton() {

    }


    public String getOrderReceiptCatalogName() {
        return null;
    }

    public float getDiscountSettingInvoicePrice() {
        return 0;
    }

    public String getSupplierNameInvoice() {
        return null;
    }


    public boolean rateThisOrderIsDisplayed() {
        return false;
    }

    public String getShipmentDate() {
        return null;
    }

    public String getOrderReceivedText() {
        return null;
    }

    public float getDesignPriceAtInvoiceDetails() {
        return 0;
    }

    public float getNumberOfItemsAtBottom() {
        return 0;
    }

    public float getNumberOfItemsDispatchedAtShipping() {
        return 0;
    }

    public boolean gotoResellerHubButtonIsDisplayed() {
        return false;
    }

    public boolean thisIsResellerOrderIsDisplayed() {
        return false;
    }

    public float getResellerAmount() {
        return 0;
    }

    public boolean isResellerAmountDisplayed() {
        return false;
    }

    public String getDispatchPendingText() {
        return null;
    }

    public String getProductName() {
        return null;
    }

    @Override
    public float getCustomerPayableAmount() {
        return 0;
    }
}
