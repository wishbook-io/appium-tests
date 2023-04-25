package com.wishbook.catalog.PageObject.SortByPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")
public class SortByPageObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = AndroidLocator.SORT_RECENTLY_UPLOADED)
    private WebElement sortRecentlyUploaded;

    @AndroidFindBy(id = AndroidLocator.SORT_PRICE_LOWTOHIGH)
    private WebElement sortPriceLowToHigh;

    @AndroidFindBy(id = AndroidLocator.SORT_PRICE_HIGHTOLOW)
    private WebElement sortPriceHighToLow;

    @AndroidFindBy(id = AndroidLocator.SORT_NUMBEROFVIEWS)
    private WebElement sortNumberOfViews;

    @AndroidFindBy(id = AndroidLocator.SORT_CLOSE)
    private WebElement sortCloseButton;

    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public SortByPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services

    /**
     * close the sort button to which click close button
     */
    public void clickSortCloseButton() {

        sortCloseButton.click();
    }

    /**
     * click On Recently Uploaded RadioButton while selecting catalogs
     */
    public void clickOnRecentlyUploadedRadioButton() {
        sortRecentlyUploaded.click();
    }

    /**
     * to sort the catalog according to low price to high price
     */
    @SuppressWarnings("unused")
    public void clickOnPriceLowToHighRadioButton() {
        sortPriceLowToHigh.click();
    }

    /**
     * to sort the catalogs according to high price to low price
     */
    @SuppressWarnings("unused")
    public void clickOnPriceHighToLowRadioButton() {
        sortPriceHighToLow.click();
    }

    /**
     * to sort the catalogs according to number of views
     */
    @SuppressWarnings("unused")
    public void clickOnPriceNumberOfViewsRadioButton() {
        sortNumberOfViews.click();
    }

    //endregion

}
