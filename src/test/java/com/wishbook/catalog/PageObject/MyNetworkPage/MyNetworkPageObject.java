package com.wishbook.catalog.PageObject.MyNetworkPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

@SuppressWarnings("unused")

public class MyNetworkPageObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.SEARCH_BUTTON)
    private WebElement  searchButtonIcon;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.SEARCH_BUYER)
    private WebElement searchBox;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.SELECT_BUYER_NAME)
    private WebElement selectBuyer;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/search_bar")
    private WebElement searchbar;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.GET_SUPPLIER_NAME)
    private WebElement getSupplierName ;
    // endregion

    //region constructor
    /**
     * @see BasePageObject
     */
    public MyNetworkPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    public void clickSearchButton(){
        searchButtonIcon.click();
    }
    public void enterBuyerName(String buyerName){
        searchBox.sendKeys(buyerName);
        ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));    }
    public void selectSearchedBuyerName() {
        selectBuyer.click();
    }

    @SuppressWarnings("unused")
    public void BackMyNetworkButton() {
       toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }
    public String getSelectedBuyerName(){
      return selectBuyer.getText();
    }
    public void clicksearchbar() {
        searchbar.click();
    }
    public String getSelectedSupplierName() {
        return getSupplierName.getText();
    }
    public void clickSelectedSupplier() {
        getSupplierName.click();
    }
    //endregion

}
