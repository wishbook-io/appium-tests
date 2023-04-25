package com.wishbook.catalog.PageObject.BottomTabPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;

import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @see BasePageObject
 */

@SuppressWarnings("unused")
public class BottomTabPageObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = AndroidLocator.CATALOG_TAB)
    private WebElement catalogButton;

    @AndroidFindBy(id = AndroidLocator.PROFILE_TAB)
    private WebElement myBusinessButton;

    @AndroidFindBy(id = AndroidLocator.HOME_TAB)
    private WebElement homeButton;

    @AndroidFindBy(id = AndroidLocator.ORDER_TAB)
    private WebElement ordersButton;

    @AndroidFindBy(id = AndroidLocator.MORE_TAB)
    private WebElement moreTabButton;
    // endregion

    //region constructor
    /**
     * @see BasePageObject
     */
    public BottomTabPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

     //region services
    public void clickProductsButton() {
        catalogButton.click();
    }
    public void clickMyBusiness() {
        myBusinessButton.click();
    }
    public void clickOrderButton() {
          ordersButton.click();
    }
    public void clickHomeButton() {
        homeButton.click();
    }
    public void clickMoreTab()
    {
        moreTabButton.click();
    }
//endregion
}
