package com.wishbook.catalog.PageObject.MyWishListPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;

import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class MyWishListPageObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")

    @AndroidFindBy(id = AndroidLocator.WISHLIST_BUTTON)
    protected WebElement wishList;

    @SuppressWarnings("unused")

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;

    @SuppressWarnings("unused")

    @AndroidFindBy(id = AndroidLocator.CATALOG_TITLE)
    private WebElement myWishListCatalogTitle;

    @SuppressWarnings("unused")

    @AndroidFindBy(id = AndroidLocator.REGISTER_BUTTON)
    private WebElement registerButton;
    // endregion

    //region constructor
    /**
     * @see BasePageObject
     */
    public MyWishListPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    @SuppressWarnings("unused")
    public void BackMyCatalogButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }
    @SuppressWarnings("unused")
    public String getMyWishListCatalogTitle() {
        return myWishListCatalogTitle.getText();
    }

    @SuppressWarnings("unused")
    public Boolean IsRegistrationButtonDisplay() {
        WebElement element = registerButton;
        Boolean v = element.isDisplayed();
        System.out.println("RegistrationButtonIsAvailable = " + v);
        return v;
    }
    public String getMyWishListTileFromToolBar() {
        return toolBar.findElement(By.className(AndroidLocator.WIDGET_TEXT_VIEW)).getText();
    }


}


//endregion


