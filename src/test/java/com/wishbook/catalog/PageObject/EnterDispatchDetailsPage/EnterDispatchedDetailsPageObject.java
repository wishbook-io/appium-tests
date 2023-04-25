package com.wishbook.catalog.PageObject.EnterDispatchDetailsPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class EnterDispatchedDetailsPageObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.ENTER_MODE_OF_DISPATCH)
    private WebElement enterModeOfDispatch;


   @SuppressWarnings("unused")
   @AndroidFindBy(id = AndroidLocator.SAVE_DISPATCH_DETAILS)
    private WebElement saveButton;
    // endregion

    //region constructor
    /**
     * @see BasePageObject
     */
    public EnterDispatchedDetailsPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    @SuppressWarnings("unused")
    public void enterModeOfDispatch(String mode) {
        enterModeOfDispatch.sendKeys(mode);
    }
    @SuppressWarnings("unused")
    public void clickSaveDetails() {
        saveButton.click();
    }
    //endregion

}
