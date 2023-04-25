package com.wishbook.catalog.PageObject.CODConfirmationPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CODConfirmationPageObject extends BasePageObject {

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_order_no")
    private WebElement orderNumber;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_order_status")
    private WebElement orderStatus;

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_cancel_order")
    private WebElement cancelCODOrderButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_reconfirm_order")
    private WebElement reconfirmCODButton;

    @AndroidFindBy(id="com.wishbook.catalog:id/txt_margin_amt")
    private WebElement marginAmount;


    public CODConfirmationPageObject(TestCase testCase) {
        super(testCase);
    }

    public int getOrderNumber(){
        return Integer.parseInt(orderNumber.getText());
    }

    public String getOrderStatus(){
        return orderStatus.getText();
    }

    public void clickReConfirmCodButton(){
        reconfirmCODButton.click();
    }

    public void clickCancelCodButton(){
        cancelCODOrderButton.click();
    }

    public float getMarginAmount(){
        return BasePageObject.getFloatFromString(marginAmount.getText());
    }

}
