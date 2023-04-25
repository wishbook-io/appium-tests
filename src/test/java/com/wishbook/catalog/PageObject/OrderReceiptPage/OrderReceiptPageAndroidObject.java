package com.wishbook.catalog.PageObject.OrderReceiptPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderReceiptPageAndroidObject extends OrderReceiptPageObject implements OrderReceiptPageStrategy {
    public OrderReceiptPageAndroidObject(TestCase testCase) {
        super(testCase);
    }



    public boolean rateThisOrderIsDisplayed() {
       return AndroidHelper.getScrollableItem(By.id( AndroidLocator.STAR_RATINGS_ORDER_RECEIPT_PAGE),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()).isDisplayed();

    }


    public int getOrderNumberScroll(){
       return Integer.parseInt(AndroidHelper.getScrollableItem(By.id(AndroidLocator.ORDER_NUMBER_TEXT),
               AndroidHelper.ScrollDirection.Down,
               4,(AndroidDriver)getDriver()).getText());

    }
    public String getOrderStatusScroll() {
        return AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.ORDER_STATUS).getText();

    }
    public void clickOrderReceivedButton() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.ORDER_RECEIVED_BUTTON).click();
    }
    public void clickCancelOrderButton() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.CANCEL_ORDER_BUTTON).click();
        }

    public int getInvoiceOrderNumber(){
        return Integer.parseInt(AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/invoice_order_no"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()).getText());
    }
    public String getSupplierNameInvoice() {
        return (AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/invoice_seller_name"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver())).getText();

    }
    public String getOrderDateInvoice() {
        return (AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/invoice_order_date"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver())).getText();

    }
    public float getDiscountSettingInvoicePrice() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id(AndroidLocator.DISCOUNTING_INVOICE_PRICE),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));

          return  BasePageObject.getFloatFromString(element.getText());

    }
    public float getInvoiceDiscount() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id(AndroidLocator.DISCOUNT_INVOICE),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());
        }

    public float getInvoiceShippingCharge() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/txt_shipping_amount"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());

    }

    public float getPaidAmount() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id(AndroidLocator.PAID_AMOUNT),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());

    }

    public float getResellerAmount() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/txt_display_amount"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());

    }

    public float getRewardPoints(){
        WebElement element=(AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/txt_reward_point"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());
    }



    public float getPayableAmount() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id(AndroidLocator.PAYABLE_AMOUNT),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());
    }
    public boolean payButtonIsDisplayed() {
        return AndroidHelper.getScrollableItem(By.id(AndroidLocator.PAY_BUTTON_ORDER_RECEIPT),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()).isDisplayed();

    }
    public boolean cancelButtonIsDisplayed() {
      return   AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, "android.widget.Button", 1).isDisplayed();

    }

    public String getOrderReceivedText() {
        return AndroidHelper.getScrollableItem(By.id(AndroidLocator.ORDER_RECEIVED_BUTTON),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()).getText();

    }


    public float getNumberOfItemsDispatchedAtShipping(){
        WebElement element=(AndroidHelper.getScrollableItem(By.id(AndroidLocator.NUMBER_ITEMS_DISPATCHED),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());
    }

    public float getNumberOfItemsAtBottom(){
        WebElement element=(AndroidHelper.getScrollableItem(By.id(AndroidLocator.NUMBER_OF_ITEMS_AT_BOTTOM),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());
    }



    public float getWBMoney() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/txt_wishbook_amount"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());

    }

    public boolean chatWbSupportButtonIsDisplayed() {
        return AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/btn_chat_wb_support"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()).isDisplayed();

    }

    public boolean trackYourOrderButtonIsDisplayed() {
        return AndroidHelper.getScrollableItem(By.id(AndroidLocator.TRACK_YOUR_ORDER_BUTTON),
                AndroidHelper.ScrollDirection.Down,
                1,(AndroidDriver)getDriver()).isDisplayed();

    }

    public boolean callWbSupportButtonIsDisplayed() {
        return AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/btn_call_wb_support"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()).isDisplayed();
    }

    public float getDesignPriceAtInvoiceDetails() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/invoice_prod_value"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());

    }

    public String getDispatchPendingText(){
        return   AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, "android.widget.TextView", 15).getText();
    }

    public String getProductName(){
        return AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/invoice_prod_name"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()).getText();
    }

    public float getCustomerPayableAmount() {
        WebElement element=(AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/txt_display_amount"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()));
        return  BasePageObject.getFloatFromString(element.getText());

    }


}


