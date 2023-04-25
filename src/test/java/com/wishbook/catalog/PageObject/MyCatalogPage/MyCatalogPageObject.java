package com.wishbook.catalog.PageObject.MyCatalogPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyCatalogPageObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.SEARCH_ICON_)
    private WebElement searchIcon;

    @SuppressWarnings("unused")
    @AndroidFindBy(id =AndroidLocator.SEARCH_TEXTFIELD)
    private WebElement searchText;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.SHARE_CATALOG_ICON)
    private WebElement shareButton;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/img_my_fragment_searchclose")
    private WebElement searchClose;

    @SuppressWarnings("unused")

    @AndroidFindBy(id = "com.wishbook.catalog:id/spinner")
    private WebElement enableSpinner;

    @AndroidFindBy(id = "com.wishbook.catalog:id/float_button_add_catalog")
    private WebElement addCatalogInMyCatalog;



    // endregion

    //region constructor
    /**
     * @see BasePageObject
     */
    public MyCatalogPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    @SuppressWarnings("unused")

    public void clickSearchIcon() {
        searchIcon.click();
    }
    @SuppressWarnings("unused")

    public void enterText(String text) {
        searchText.sendKeys(text);
        ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));

    }
    @SuppressWarnings("unused")

    public void clickShareButton() {
        shareButton.click();
    }


    @SuppressWarnings("unused")
    public void BackCatalogButton() {
         toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }
    @SuppressWarnings("unused")

    public void clickCloseSearchButton() {
        searchClose.click();
    }
    @SuppressWarnings("unused")

    public void clickSpinner() {
        enableSpinner.click();
    }

 public void clickAddCatalogIcon() {
        addCatalogInMyCatalog.click();
 }

    public String getMyCatalogTileFromToolBar() {
        return toolBar.findElement(By.className(AndroidLocator.WIDGET_TEXT_VIEW)).getText();
    }


    //endregion
}
