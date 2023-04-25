package com.wishbook.catalog.PageObject.PaymentDialogPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

@SuppressWarnings("unused")

public class PaymentDialogObject extends BasePageObject {

    //region elements

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_add")
    private WebElement savePaymentButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/input_amount")
    private WebElement getAmountPayment;

    @AndroidFindBy(id = "com.wishbook.catalog:id/edit_bank_name")
    private WebElement enterBankName;



    //endregion

    public PaymentDialogObject(TestCase testCase) {
        super(testCase);
    }

    //region services

    public void clickSavePaymentButton() {
        savePaymentButton.click();
    }

    public float getAmount(){
        return BasePageObject.getFloatFromString(getAmountPayment.getText());

    }



    //endregion
}
