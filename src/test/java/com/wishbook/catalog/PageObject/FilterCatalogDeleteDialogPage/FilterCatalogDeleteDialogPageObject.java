package com.wishbook.catalog.PageObject.FilterCatalogDeleteDialogPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class FilterCatalogDeleteDialogPageObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.NO)
    private WebElement yesDeleteFilter;

    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public FilterCatalogDeleteDialogPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services


    @SuppressWarnings("unused")
    public void clickYes() {
        yesDeleteFilter.click();
    }


        //endregion

}
