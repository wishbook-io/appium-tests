package com.wishbook.catalog.PageObject.OrderCancelNoteDialoge;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")
public class OrderCancelNoteDialogeObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = "com.wishbook.catalog:id/md_buttonDefaultPositive")
    private WebElement ok;

    @AndroidFindBy(id = "android:id/input")
    private WebElement cancelOrderNote;
    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public OrderCancelNoteDialogeObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    public void clickOnOk() {
        ok.click();
    }
    public void enterOrderCancelNote(String note) {
        cancelOrderNote.sendKeys(note);
    }

    //endregion

}
