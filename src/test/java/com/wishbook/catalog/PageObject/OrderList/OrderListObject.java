package com.wishbook.catalog.PageObject.OrderList;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")

public class OrderListObject extends BasePageObject {

    @AndroidFindBy(id = "com.wishbook.catalog:id/action_search")
    private WebElement searchButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/search_icon")
    private WebElement enquirySearchButton;

    @AndroidFindBy(id = AndroidLocator.ORDER_SEARCH_TEXTFIELD)
    protected WebElement searchTextField;

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.BUYER_NAME_OREDR_RECEIPT_TEXT)
    private WebElement buyerOrderGetText;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.ALL_PEN_DIS_CAN_SPINNER)
    private WebElement allSpinner;


    @AndroidFindBy(id = AndroidLocator.PENDING_SPINNER)
    private WebElement pendingSpinner;

    @AndroidFindBy(id="com.wishbook.catalog:id/txt_order_no")
    private WebElement getOrderNumber;

    @AndroidFindBy(id = "com.wishbook.catalog:id/list_empty1")
    private WebElement listEmpty;

    @AndroidFindBy(id=AndroidLocator.GETTEXT_STATUS_LEAD_ENQUIRY)
    private WebElement getTextStatusLeadEnquiry;

    @AndroidFindBy(id = AndroidLocator.GETTEXT_ENQUIRED_ABOUT)
    private WebElement getTextEnquiredAbout;


    @AndroidFindBy(id = "com.wishbook.catalog:id/recycler_view")
    protected WebElement recycleView;


    public OrderListObject(TestCase testCase) {
        super(testCase);
    }


    //region  common services
    public void clickSearchButton() {
        searchButton.click();
    }

    public void enterSellerNameSearchTextField(String sellerName)
    {
        searchTextField.sendKeys(sellerName);
        ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void OrderListBackButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }
    public String getBuyerNameOrderReceipt() {
        return buyerOrderGetText.getText();
    }

    public int getOrderNumber() {
        WebElement element=  getOrderNumber;
        String orderText = element.getText();
        String orderCount = orderText .replaceAll("[^0-9]", "");
        return Integer.valueOf(orderCount);
        }
        public String getEmptyList() {
               return listEmpty.getText();
        }


    public void enterCatalogNameSearchTextField(String catalogName) {
        searchTextField.sendKeys(catalogName);
        ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
    }


    public String getTextLeadEnquiryStatus() {
        return getTextStatusLeadEnquiry.getText();
    }
    public String getTextEnquiredAbout(){
        return getTextEnquiredAbout.getText();
    }

    public void clickSearchedOrder(int index) {
        WebDriverWait recylerViewWait=new WebDriverWait(getDriver(),50);
        recylerViewWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.wishbook.catalog:id/recycler_view")));

        WebDriverWait brandIconWait=new WebDriverWait(getDriver(),50);
        brandIconWait.until(ExpectedConditions.elementToBeClickable(By.id("com.wishbook.catalog:id/prod_img")));

        recycleView.findElements(By.className("android.widget.LinearLayout")).get(index).click();
    }


    public void clickOnSearchIconForEnquiryLead()
    {
        enquirySearchButton.click();
    }        //endregion

}

