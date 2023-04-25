package com.wishbook.catalog.PageObject.MyFilterPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")

public class MyFilterPageObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.NO)
    private WebElement okDeleteSavedFilter;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.YES)
    private WebElement cancelDeleteSavedFilter;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.CLEAR_ALL_MYFILTER)
    private WebElement clearAll;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.CLOSE_MYFILTERS)
    private WebElement closeMyFilters;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.RECYCLER_VIEW)
    private WebElement myFiltersRecyclerViewElement;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_bottom_sheet_title")
    private WebElement myFilterText;

    public MyFilterPageObject(TestCase testCase) {
        super(testCase);
    }


    public void clickCloseMyFilters() {
        closeMyFilters.click();
    }

    public void clickOkButton() {
        okDeleteSavedFilter.click();
    }


    public void clickCancelButton() {
        cancelDeleteSavedFilter.click();
    }


    public void chooseMyFilterAt(int index){
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,AndroidLocator.WIDGET_RADIO_BUTTON,index).click();
    }

    public void deleteFilterAt(int index){
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,AndroidLocator.WIDGE_IMAGE_VIEW,index).click();
    }


    public void clickClearAll() {
        clearAll.click();
    }

    public String getMyFiltersTitle(){
        return myFilterText.getText();
    }
    //endregion
}
