package com.wishbook.catalog.PageObject.ConfirmOrderDeliveryDialog;

import com.wishbook.catalog.PageObject.Core.BasePageObject;

import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class ConfirmOrderDeliveryDialogObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/md_buttonDefaultPositive")
    private WebElement yes;
    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public ConfirmOrderDeliveryDialogObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    @SuppressWarnings("unused")
    public void clickOnYes() {
        yes.click();
    }
    //endregion

}
