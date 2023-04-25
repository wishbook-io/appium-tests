package com.wishbook.catalog.PageObject.OrderList;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OrderListReactNativeObject extends BasePageObject implements OrderListStrategy {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"OrdersListScreenOrderListButton\"]")
     private WebElement newCreatedPurchaseOrder;


    public OrderListReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void enterSellerNameSearchTextField(String sellerName) {

    }

    public void clickSearchButton() {

    }

    public void clickNewPurchaseOrder(){
        getDriver().findElements(By.className("//android.view.View[@content-desc=\"OrdersListScreenOrderListButton\"]")).get(0).click();
    }

    public void clickOnSearchIconForEnquiryLead() {

    }

    public int getOrderNumber() {
        return 0;
    }

    public void OrderListBackButton() {

    }

    public void clickSearchedOrder(int index) {

    }

    public String getEmptyList() {
        return null;
    }

    public void enterCatalogNameSearchTextField(String catalogName) {

    }

    public void clickSearchedLeadsEnquiry() {

    }

    public String getTextLeadEnquiryStatus() {
        return null;
    }

    public void clickSearchedLead(int index) {

    }

    public void enterOrderNumber(int orderNumber) {

    }
}
