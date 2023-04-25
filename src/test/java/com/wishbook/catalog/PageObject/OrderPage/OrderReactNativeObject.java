package com.wishbook.catalog.PageObject.OrderPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class OrderReactNativeObject extends BasePageObject implements OrderPageStrategy {

  @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='OrdersTabCartButton']")
  private WebElement cartIcon;

    public OrderReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void clickPendingSalesOrder() {

    }

    public int getTotalPurchaseOrder() {
        return 0;
    }

    public int getPendingPurchaseOrder() {
        return 0;
    }

    public int getDispatchedPurchaseOrder() {
        return 0;
    }

    public int getCancelledPurchaseOrder() {
        return 0;
    }

    public int getTotalSalesOrder() {
        return 0;
    }

    public int getPendingSalesOrder() {
        return 0;
    }

    public int getDispatchedSaleOrder() {
        return 0;
    }

    public int getCancelledSalesOrder() {
        return 0;
    }

    public int getTotalBrokerageOrder() {
        return 0;
    }

    public int getPendingBrokerageOrder() {
        return 0;
    }

    public int getDispatchedBrokerageOrder() {
        return 0;
    }

    public int getCancelledBrokerageOrder() {
        return 0;
    }

    public void clickBrokeragePendingOrder() {

    }

    public void clickDispatchedButton() {

    }

    public void clickPurchaseDispatchedButton() {

    }

    public void clickSalesCancelOrderButton() {

    }

    public void clickBackMyOrderButton() {

    }

    public void clickPendingPurchaseOrderButton() {

    }

    public void clickPurchaseCancelOrderButton() {

    }

    public int getTextOpenLead() {
        return 0;
    }

    public int getTextResolvedLead() {
        return 0;
    }

    public void openLeadButton() {

    }

    public void resolvedLeadButton() {

    }

    public int getTextTotalLead() {
        return 0;
    }

    public int getTextEnquiryOpen() {
        return 0;
    }

    public int getTextEnquiryResolved() {
        return 0;
    }

    public int getTextTotalEnquiry() {
        return 0;
    }

    public void openEnquiryButton() {

    }

    public void resolvedEnquiryButton() {

    }

    public boolean IsRegistrationButtonDisplay() {
        return false;
    }

    public boolean isCartIconPresent() {
        return cartIcon.isDisplayed();
    }

    public void clickAddToCartButton() {

    }
}
