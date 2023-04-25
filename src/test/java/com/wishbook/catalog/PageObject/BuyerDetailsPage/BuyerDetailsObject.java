package com.wishbook.catalog.PageObject.BuyerDetailsPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;

import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class BuyerDetailsObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.REJECT_BUYER_BUTTON)
    protected WebElement rejectButton ;


    @SuppressWarnings("unused")

    @AndroidFindBy(id = AndroidLocator.APPROVE_BUTTON)
    protected WebElement approveButton;
    // endregion

    //region constructor
    /**
     * @see BasePageObject
     */
    public BuyerDetailsObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services

    //endregion

}
