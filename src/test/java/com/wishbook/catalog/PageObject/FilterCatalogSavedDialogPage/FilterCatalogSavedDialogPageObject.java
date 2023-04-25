package com.wishbook.catalog.PageObject.FilterCatalogSavedDialogPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;



public class FilterCatalogSavedDialogPageObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.SAVE_FILTER_SAVE)
    private WebElement saveFilterSave;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.YES)
    private WebElement saveFilterCancel;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.SAVE_CATALOG_INPUTTEXT)
    private WebElement saveFilterEnterFilterName;

    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public FilterCatalogSavedDialogPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    @SuppressWarnings("unused")
    public void selectSaveFilterSave() {
        saveFilterSave.click();
    }

    @SuppressWarnings("unused")
    public void clickSaveFilterCancelButton() {
        saveFilterCancel.click();
    }

    @SuppressWarnings("unused")

    public void enterFilterName(String filterName) {
        saveFilterEnterFilterName.sendKeys(filterName);
    }

    //endregion

}
