package com.wishbook.catalog.PageObject.OrderPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")

public class OrderPageObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = AndroidLocator.PENDING_SALES_ORDER)
    private WebElement pendingSalesOrder;


    @AndroidFindBy(id = "com.wishbook.catalog:id/cart")
    private WebElement addTocartButton;

    @AndroidFindBy(id = AndroidLocator.TOTAL_PURCHASE_ORDER_TEXT)
    private WebElement totalPurchaseOrderText;

    @AndroidFindBy(id = AndroidLocator.PURCHASE_PENDING_ORDER_TEXT)
    private WebElement pendingPurchaseOrderText;

    @AndroidFindBy(id = AndroidLocator.PURCHASE_DISPATCHED_ORDER_TEXT)
    private WebElement dispatchedPurchaseOrderText;

    @AndroidFindBy(id = AndroidLocator.PURCHASE_CANCELLED_OREDR_TEXT)
    private WebElement cancelledPurchaseOrderText;

    @AndroidFindBy(id = AndroidLocator.TOTAL_SALES_ORDER_TEXT)
    private WebElement totalSalesOrderText;

    @AndroidFindBy(id = AndroidLocator.SALES_PENDING_ORDER_TEXT)
    private WebElement pendingSalesOrderText;

    @AndroidFindBy(id = AndroidLocator.SALES_DISPATCHED_ORDER_TEXT)
    private WebElement dispatchedSalesOrderText;

    @AndroidFindBy(id = AndroidLocator.SALES_CANCELLED_ORDER_TEXT)
    private WebElement cancelledSalesOrderText;

    @AndroidFindBy(id = AndroidLocator.TOTAL_BROKERAGE_ORDER_TEXT)
    private WebElement totalBrokerageOrderText;

    @AndroidFindBy(id = AndroidLocator.BROKERAGE_PENDING_ORDER_TEXT)
    private WebElement pendingBrokerageOrderText;

    @AndroidFindBy(id = AndroidLocator.BROKERAGE_DISPATCHED_ORDER_TEXT)
    private WebElement dispatchedBrokerageOrderText;

    @AndroidFindBy(id = AndroidLocator.BROKERAGE_CANCELLED_ORDER_TEXT)
    private WebElement cancelledBrokerageOrderText;

    @AndroidFindBy(id = AndroidLocator.BROKERAGE_PENDING_ORDER_BUTTON)
    private WebElement brokeragerPandingButton;

    @AndroidFindBy(id = AndroidLocator.DISPATCH_BUTTON_SALES)
    private WebElement dispatchSalesButton;

    @AndroidFindBy(id = AndroidLocator.DISPATCH_BUTTON_PURCHASE)
    private WebElement dispatchPurchaseOrderButton;

    @AndroidFindBy(id = AndroidLocator.CANCEL_BUTTON_SALES_ORDER)
    private WebElement cancel;

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;

    @AndroidFindBy(id = "com.wishbook.catalog:id/linear_purchase_pending")
    private WebElement pendingPurchaseOrderButton;

    @AndroidFindBy(id = AndroidLocator.PURCHASE_CANCEL_BUTTON)
    private WebElement purchaseCancelOrderButton;

    @AndroidFindBy(id = AndroidLocator.OPEN_LEADS_TEXT)
    private WebElement openLeadsText;

    @AndroidFindBy(id = AndroidLocator.RESOLVED_LEADS_TEXT)
    private WebElement resolvedLeadsText;

    @AndroidFindBy(id = AndroidLocator.OPEN_LEADS_BUTTON)
    protected WebElement openLeadsButton;

    @AndroidFindBy(id = AndroidLocator.RESOLVED_LEADS_BUTTON)
    private WebElement resolvedLeadsButton;

    @AndroidFindBy(id = AndroidLocator.TOTAL_TEXT_LEAD)
    private WebElement totalLeadsText;

    @AndroidFindBy(id = AndroidLocator.OPEN_ENQUIRIES_TEXT)
    private WebElement openEnquiryText;

    @AndroidFindBy(id = AndroidLocator.RESOLVED_ENQUIRIES_TEXT)
    private WebElement resolvedEnquiryText;

    @AndroidFindBy(id = AndroidLocator.OPEN_ENQUIRIES_BUTTON)
    private WebElement openEnquiryButton;

    @AndroidFindBy(id = AndroidLocator.RESOLVED_ENQUIRIES_BUTTON)
    private WebElement resolvedEnquiryButton;

    @AndroidFindBy(id = AndroidLocator.TOTAL_TEXT_ENQUIRIES)
    private WebElement totalEnquiryText;

    @AndroidFindBy(id = AndroidLocator.REGISTER_BUTTON)
    private WebElement registerButton;
    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public OrderPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region services
    public void clickPendingSalesOrder() {
        pendingSalesOrder.click();
    }

    public int getTotalPurchaseOrder() {
        getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement element = totalPurchaseOrderText;
        String totalPurchaseOrderText = element.getText();
        String totalPurchaseOrderCount = totalPurchaseOrderText.replaceAll("[^0-9]", "");
        return Integer.valueOf(totalPurchaseOrderCount);
    }

    public int getPendingPurchaseOrder() {
        WebElement element = pendingPurchaseOrderText;
        String pendingPurchaseOrderText = element.getText();
        String pendingPurchaseOrderCount = pendingPurchaseOrderText.replaceAll("[^0-9]", "");
        return Integer.valueOf(pendingPurchaseOrderCount);
    }

    public int getDispatchedPurchaseOrder() {
        WebElement element = dispatchedPurchaseOrderText;
        String dispatchedPurchaseOrderText = element.getText();
        String dispatchedPurchaseOrderCount = dispatchedPurchaseOrderText.replaceAll("[^0-9]", "");
        return Integer.valueOf(dispatchedPurchaseOrderCount);

    }

    public int getCancelledPurchaseOrder() {
        WebElement element = cancelledPurchaseOrderText;
        String cancelledPurchaseOrderText = element.getText();
        String cancelledPurchaseOrderCount = cancelledPurchaseOrderText.replaceAll("[^0-9]", "");
        return Integer.valueOf(cancelledPurchaseOrderCount);

    }

    public int getTotalSalesOrder() {
        WebElement element = totalSalesOrderText;
        String totalSalesOrderText = element.getText();
        String totalSalesOrderTextCount = totalSalesOrderText.replaceAll("[^0-9]", "");
        return Integer.valueOf(totalSalesOrderTextCount);
    }

    public int getPendingSalesOrder() {
        WebElement element = pendingSalesOrderText;
        String pendingSalesOrderText = element.getText();
        String pendingSalesOrderCount = pendingSalesOrderText.replaceAll("[^0-9]", "");
        return Integer.valueOf(pendingSalesOrderCount);
    }

    public int getDispatchedSaleOrder() {
        WebElement element = dispatchedSalesOrderText;
        String dispatchedSalesOrderText = element.getText();
        String dispatchedSalesOrderCount = dispatchedSalesOrderText.replaceAll("[^0-9]", "");
        return Integer.valueOf(dispatchedSalesOrderCount);

    }

    public int getCancelledSalesOrder() {
        WebElement element = cancelledSalesOrderText;
        String cancelledSalesOrderText = element.getText();
        String cancelledSalesOrderCount = cancelledSalesOrderText.replaceAll("[^0-9]", "");
        return Integer.valueOf(cancelledSalesOrderCount);
    }

    public int getTotalBrokerageOrder() {
        WebElement element = totalBrokerageOrderText;
        String totalBrokerageOrderText = element.getText();
        String totalBrokerageOrderCount = totalBrokerageOrderText.replaceAll("[^0-9]", "");
        return Integer.valueOf(totalBrokerageOrderCount);
    }

    public int getPendingBrokerageOrder() {
        WebElement element = pendingBrokerageOrderText;
        String pendingBrokerageOrderText = element.getText();
        String pendingBrokerageOrderCount = pendingBrokerageOrderText.replaceAll("[^0-9]", "");
        return Integer.valueOf(pendingBrokerageOrderCount);

    }

    public int getDispatchedBrokerageOrder() {
        WebElement element = dispatchedBrokerageOrderText;
        String dispatchedBrokerageOrderText = element.getText();
        String dispatchedBrokerageOrderCount = dispatchedBrokerageOrderText.replaceAll("[^0-9]", "");
        return Integer.valueOf(dispatchedBrokerageOrderCount);

    }

    public int getCancelledBrokerageOrder() {
        WebElement element = cancelledBrokerageOrderText;
        String cancelledBrokerageOrderText = element.getText();
        String cancelledBrokerageOrderCount = cancelledBrokerageOrderText.replaceAll("[^0-9]", "");
        return Integer.valueOf(cancelledBrokerageOrderCount);
    }

    public void clickBrokeragePendingOrder() {
        brokeragerPandingButton.click();
    }

    public void clickDispatchedButton() {
        dispatchSalesButton.click();
    }

    public void clickPurchaseDispatchedButton() {
        dispatchPurchaseOrderButton.click();
    }

    public void clickSalesCancelOrderButton() {
        cancel.click();
    }

    public void clickBackMyOrderButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }

    public void clickPendingPurchaseOrderButton() {
        pendingPurchaseOrderButton.click();
    }

    public void clickPurchaseCancelOrderButton() {
        purchaseCancelOrderButton.click();
    }

    public int getTextOpenLead() {
        return Integer.valueOf(openLeadsText.getText());
    }

    public int getTextResolvedLead() {
        return Integer.valueOf(resolvedLeadsText.getText());
    }



    public void resolvedLeadButton() {
        resolvedLeadsButton.click();
    }

    public int getTextTotalLead() {
        return Integer.valueOf(totalLeadsText.getText());
    }

    public int getTextEnquiryOpen() {
        return Integer.valueOf(openEnquiryText.getText());
    }

    public int getTextEnquiryResolved() {
        return Integer.valueOf(resolvedEnquiryText.getText());
    }

    public int getTextTotalEnquiry() {
        return Integer.valueOf(totalEnquiryText.getText());
    }

    public void openEnquiryButton() {
        openEnquiryButton.click();
    }

    public void resolvedEnquiryButton() {
        resolvedEnquiryButton.click();
    }

    public boolean IsRegistrationButtonDisplay() {
        WebElement element = registerButton;
        Boolean v = element.isDisplayed();
        System.out.println("RegistrationButtonIsAvailable = " + v);
        return v;
        }

    public boolean isCartIconPresent() {
        return getDriver().findElements(By.id(AndroidLocator.CART_ICON)).size()>0;
    }

   public void clickAddToCartButton() {
        addTocartButton.click();
   }

    //endregion
}
