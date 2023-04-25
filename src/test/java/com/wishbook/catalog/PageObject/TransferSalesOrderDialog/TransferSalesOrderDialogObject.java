package com.wishbook.catalog.PageObject.TransferSalesOrderDialog;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class TransferSalesOrderDialogObject extends BasePageObject {

    @SuppressWarnings("unused")
    @AndroidFindBy(id="com.wishbook.catalog:id/edit_buyername")
    private WebElement buyerNameTextField;

    @SuppressWarnings("unused")
    @AndroidFindBy(id="com.wishbook.catalog:id/md_buttonDefaultPositive")
    private WebElement saveButton;


    public TransferSalesOrderDialogObject(TestCase testCase) {
        super(testCase);
    }

    @SuppressWarnings("unused")
    public void clickBuyerNameTextField() {
        buyerNameTextField.click();
    }
    @SuppressWarnings("unused")
    public void clickSave()
    {
        saveButton.click();
    }
}
