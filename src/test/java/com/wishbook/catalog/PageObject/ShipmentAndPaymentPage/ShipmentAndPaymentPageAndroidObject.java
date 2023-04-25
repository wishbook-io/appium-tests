package com.wishbook.catalog.PageObject.ShipmentAndPaymentPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class ShipmentAndPaymentPageAndroidObject extends ShipmentAndPaymentPageObject implements ShipmentAndPaymentPageStrategy {
    public ShipmentAndPaymentPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void selectShipmentAddress(int index) {

        WebDriverWait wait= new WebDriverWait(testCase.getTest().getDriver(),50);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(AndroidLocator.ADD_NEW_ADDRESS_BROKER)));
        getDriver().findElements(By.className(AndroidLocator.WIDGET_RADIO_BUTTON)).get(index).click();
        }


    public void selectPaymentModeAtIndex(int index) {
        AndroidHelper.scrolling(AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver());
        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_RADIO_BUTTON, index).click();

    }


    public int getOrderNumber() {

        WebElement element = AndroidHelper.getScrollableItem(By.id(AndroidLocator.ORDER_NUMBER_TEXT_SHIPMENT),
                AndroidHelper.ScrollDirection.Down,
                4, (AndroidDriver) getDriver());
        return Integer.parseInt(element.getText());
    }

    public String getSupplierNameShipment() {
        WebElement element = AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.SUPPLIER_NAME_SHIPMENT);
        return element.getText();
    }



    public float getTotalGst() {
        WebElement element = AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.GET_TOTAL_GST_SHIPMENT_PAGE);
        return BasePageObject.getFloatFromString(element.getText());
    }

    public float getDeliveryCharge() {
        WebElement element = AndroidHelper.getScrollableItem(By.id(AndroidLocator.GET_DELIVERY_CHARGE_SHIPMENT_PAGE),
                AndroidHelper.ScrollDirection.Down,
                4, (AndroidDriver) getDriver());
        return BasePageObject.getFloatFromString(element.getText());

    }

    public float getTotalPayableAmount() {
        WebElement element = AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/total_amount"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver());
        return BasePageObject.getFloatFromString(element.getText());
    }


    public float getTotalPayableAmountAfterApplyingRewardPoints() {
        WebElement element = AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/payable_amount"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver());
        return BasePageObject.getFloatFromString(element.getText());
    }

    public boolean transportViaWishbookIsPresent() {
        WebElement element = AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.TRANSPORT_VIA_WISHBOOK);
        return element.isDisplayed();
    }

    public boolean transportViaWishbookIsEnabled() {
        WebElement element = AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.TRANSPORT_VIA_WISHBOOK);
        return element.isEnabled();
    }

    public boolean isDeliveryChargeDispalyed() {
        WebElement element = AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.GET_TOTAL_PAYABLE_AMOUNT);
        return element.isDisplayed();
    }


    public String scrollToSeeDetails() {
        WebElement element = AndroidHelper.getScrollableItem(By.id(AndroidLocator.SEE_DETAILS_INVOICE),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver());
        return element.getText();
    }

    public boolean payementModeIsDisplayed(){
        scrollToSeeDetails();
        return getDriver().findElements(By.xpath("//android.widget.TextView[@text='Online']")).size() > 0;

    }

    public boolean resellerOrderToggleIsDisplayed(){
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/switch_resale_order");
        return resellerToggle.isDisplayed();
    }

    public void clickResellerToggle(){
        resellerToggle.click();
    }

    public float getOrderAmountShipmentPage(){
        WebElement e=  AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/txt_resale_order_amount");
        return BasePageObject.getFloatFromString(e.getText());

    }

     public float getResaleAmountShipmentPage(){
       WebElement e=  AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/txt_total_resale_amount");
        return BasePageObject.getFloatFromString(e.getText());


    }

    public boolean orderAmountShipmentPageIsDisplayed(){
        return getDriver().findElements(By.id("com.wishbook.catalog:id/txt_resale_order_amount")).size() > 0;

    }
    public boolean resaleAmountShipmentPageIsDisplayed(){
        return getDriver().findElements(By.id("com.wishbook.catalog:id/txt_total_resale_amount")).size() > 0;

    }

    public boolean changeLinkIsDisplayed(){
        AndroidHelper.getScrollableItem(By.xpath("//android.widget.RadioButton[@index='1']"),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver());
        return getDriver().findElements(By.id("com.wishbook.catalog:id/txt_change_resale_amt")).size() > 0;

    }
    public void clickChangeResaleLink(){
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/txt_change_resale_amt").click();

    }

    public void clickCashFreePaymentMode(){
        WebElement element=AndroidHelper.getScrollableItem(By.xpath("//android.widget.RadioButton[@index='1']"),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver());
        element.click();

    }
    public void clickChequePaymentMode(){
       WebElement element= AndroidHelper.getScrollableItem(By.xpath("//android.widget.RadioButton[@index='5']"),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver());
       element.click();

    }
    public void clickNeftPaymentMode(){
       WebElement element= AndroidHelper.getScrollableItem(By.xpath("//android.widget.RadioButton[@index='6']"),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver());
        element.click();

    }

    public void clickCODPaymentMode(){
        WebElement element= AndroidHelper.getScrollableItem(By.xpath("//android.widget.RadioButton[@index='3']"),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver());
       element.click();

    }

    public void clickWishbookCreditPaymentMode(){
        WebElement element=  AndroidHelper.getScrollableItem(By.xpath("//android.widget.RadioButton[@index='8']"),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver());
        element.click();

    }
}


