package com.wishbook.catalog.PageObject.EnquiryDetailsDialoge;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class EnquiryDetailsDialogeObject extends BasePageObject {

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_only_sets")
    private WebElement numberOfSets;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/check_price")
    private WebElement priceEnquiry;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/check_fabric")
    private WebElement fabricEnquiry;

    @AndroidFindBy(id = "com.wishbook.catalog:id/check_dispatch")
    private WebElement dispatchAndDelivery;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_send")
    private WebElement sendButton;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_cancel")
    private WebElement cancelButton;

    public EnquiryDetailsDialogeObject(TestCase testCase) {
        super(testCase);
    }

    @SuppressWarnings("unused")
    public void clickPriceDiscountEnquiry() {
        priceEnquiry.click();
    }
    @SuppressWarnings("unused")
    public void enterNumberOfSet(int set) {
        WebElement element=numberOfSets;
              element.clear();
              element.sendKeys(Integer.toString(set));
    }

    public void clickFabricAndMaterialCheckBox() {
        fabricEnquiry.click();
    }
    public void clickDispatchAndDeliveryChecbox() {
        dispatchAndDelivery.click();
    }
    @SuppressWarnings("unused")
    public void clickSendButton(){
        sendButton.click();
    }


}
