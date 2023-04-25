package com.wishbook.catalog.PageObject.SearchPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")
public class SearchPageObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = AndroidLocator.RECYCLER_SUGGESTION)
    private WebElement searchText;

    @AndroidFindBy(id = AndroidLocator.SEARCH_TEXTBOX)
    WebElement searchTextBox;

    @AndroidFindBy(id = AndroidLocator.BACK_SEARCH_BUTTON)
    private WebElement backSearchButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_empty_msg")
    private WebElement noCatalogToDisplay ;

    @AndroidFindBy(id = "com.wishbook.catalog:id/list_empty1")
    private WebElement noCatalogToDisplayLeadd;

    @AndroidFindBy(id = AndroidLocator.SEARCH_BUYER_NAME_BROKER_ORDER)
    private WebElement searchedBuyerNameBrokerOrder;

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;

    @AndroidFindBy(id =AndroidLocator.CLOSE_SEARCH_TEXT_FIELD)
    private WebElement closeSearchTexfield;

    @AndroidFindBy(id="com.wishbook.catalog:id/cat_img")
    private WebElement searchedProduct;

    @AndroidFindBy(id = "com.wishbook.catalog:id/img_wishlist")
    private WebElement wishlistOnSearchedProduct;


    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public SearchPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services

    public void noSuggestions(String searchItem) {
        searchTextBox.sendKeys(searchItem);
    }

    public void clickSearchBackButton() {
        backSearchButton.click();
    }
    public String noDataFoundText() {
       return noCatalogToDisplay.getText();
    }
    public void clickSearchedBuyerName() {
        searchedBuyerNameBrokerOrder.click();
    }
    public void BackHomeSearchButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }
    public void closeSearchTextField() {
        closeSearchTexfield.click();
    }

    public void clearSearchTextField() {
        searchTextBox.click();
    }

    public String noDataFoundTextLead() {
        return noCatalogToDisplayLeadd.getText();
    }


    public void clickSearchedProduct() {
        searchedProduct.click();

    }
    public void clickWishlistIconOnSearchedProduct(){
        wishlistOnSearchedProduct.click();
    }

    //endregion

}
