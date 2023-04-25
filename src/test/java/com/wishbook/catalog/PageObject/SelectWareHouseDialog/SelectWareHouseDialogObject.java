package com.wishbook.catalog.PageObject.SelectWareHouseDialog;

import com.wishbook.catalog.PageObject.Core.BasePageObject;

import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class SelectWareHouseDialogObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/md_buttonDefaultPositive")
    private WebElement done;

    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public SelectWareHouseDialogObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    @SuppressWarnings("unused")
    public void clickOnDone() {
        done.click();
    }

    //endregion

}
