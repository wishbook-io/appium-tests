package com.wishbook.catalog.PageObject.SuppliersDetailsPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class SupplierDetailsPageObject extends BasePageObject {

    //region elements

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.ORDERS_SUPPLIER)
    private WebElement ordersSupplierDetail ;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;



    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public SupplierDetailsPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region services

    @SuppressWarnings("unused")
    public void clickOrdersSupplierDetails()
    {
        ordersSupplierDetail.click();
    }
    @SuppressWarnings("unused")
    public void BackSupplierDetailsButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }

    //endregion

}
