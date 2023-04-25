package com.wishbook.catalog.PageObject.CatalogToolBar;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * @see BasePageObject
 */
public class CatalogToolBarObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = "com.wishbook.catalog:id/action_wishlist")
    private WebElement wishListButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/action_cart")
    private WebElement addCartIcon;


    @AndroidFindBy(id = AndroidLocator.CATALOG_NON_CATALOG_SPINNER)
    private WebElement catalogNonCatalogSpinner;

    @AndroidFindBy(id = "com.wishbook.catalog:id/spintext")
    private  WebElement getNonCatalogSpinnerText;

    @AndroidFindBy(id = "com.wishbook.catalog:id/spintext")
    private WebElement catalogAndNonCatalogSpinText;

    @AndroidFindBy(id = "com.wishbook.catalog:id/action_view_type")
    private WebElement actionToolBarIcon;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='ऊपर जाएं']")
    private WebElement backButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/action_saved_filter")
    private WebElement myFilterIcon;

    @AndroidFindBy(id = "com.wishbook.catalog:id/action_search")
    private WebElement searchIcon;


    // endregion

    //region constructor
    /**
     * @see BasePageObject
     */
    public CatalogToolBarObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services

    public void clickWishListButton() {
      wishListButton.click();
    }

    public void clickAddToCartButton() {
        addCartIcon.click();

    }
    public int getWishListCountOnMenuBadgeCatalogToolBar() {
        return Integer.parseInt(wishListButton.findElement(By.className(AndroidLocator.WIDGET_TEXT_VIEW)).getText());
    }


    public void clickProductTypeSpinner() {
        catalogNonCatalogSpinner.click();
    }
    public String getNonCatalogText() {
        return getNonCatalogSpinnerText.getText();
    }

    public String getProductTypeSpinnerText() {
        return catalogAndNonCatalogSpinText.getText();
    }

    public void clickActionToolBarIcon() {
        actionToolBarIcon.click();
    }

    public void clickBackButton(){
        backButton.click();
    }


    public boolean isActionToolIconDisplayed(){
      return actionToolBarIcon.isDisplayed();
    }
    public boolean isMyFilterIconDisplayed(){
        return myFilterIcon.isDisplayed();
    }
    public boolean isMyWishlistIconDisplayed(){
        return wishListButton.isDisplayed();
    }

    public boolean isCartIconDisplayed(){
        return addCartIcon.isDisplayed();
    }

    public boolean isSearchIconDisplayed(){
       return searchIcon.isDisplayed();
    }

    public void clickMyFilterIcon(){
        myFilterIcon.click();
    }

    public int getMyFilterIconCount(){
      return Integer.parseInt(myFilterIcon.findElement(By.className("android.widget.TextView")).getText());
    }


    //endregion

}
