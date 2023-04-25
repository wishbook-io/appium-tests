package com.wishbook.catalog.PageObject.BrandISellPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */

@SuppressWarnings("unused")

public class BrandISellPageObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = AndroidLocator.BRAND_I_SELL_DONE)
    private WebElement done;

    @AndroidFindBy(id = AndroidLocator.BRAND_I_SELL_CANCEL)
    private WebElement cancel;

    @AndroidFindBy(id = AndroidLocator.BRAND_I_SELL_SEARCH)
    private WebElement searchTextBox;
    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public BrandISellPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    public void clickDoneButton() {
        done.click();
    }

    public void clickCancelButton() {
        cancel.click();
    }

    public void enterBrandName(String brandName) {
        searchTextBox.sendKeys(brandName);
    }
    //endregion

}
