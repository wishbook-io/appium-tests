package com.wishbook.catalog.PageObject.ShareCatalogEnterBuyerName;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class ShareCatalogEnterBuyerNameObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/edit_search")
   private WebElement search;
    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public ShareCatalogEnterBuyerNameObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    @SuppressWarnings("unused")
    public void enterBuyerToBeSearch(String searchBuyer) {
        search.sendKeys(searchBuyer);
    }

    //endregion

}
