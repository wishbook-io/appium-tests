package com.wishbook.catalog.PageObject.BecomeASellerPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@SuppressWarnings("ALL")
public class BecomeASellerPageObject extends BasePageObject {


    @AndroidFindBy(id = AndroidLocator.FULL_CATALOG_RADIOBUTTON)
    private WebElement fullCatalogOnlyRadioButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/radio_single_piece")
    private WebElement singlePiecesAndFullCatalogBoth;

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_done")
    private WebElement doneButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_dismiss")
    private WebElement okButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/flex_catalog_select_size")
    private WebElement allSizes;

    @AndroidFindBy(id = "com.wishbook.catalog:id/img_close")
    private WebElement closeButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_design_name")
    private WebElement designNumber;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_price_per_design")
    private WebElement pricesPerDesign;


    public BecomeASellerPageObject(TestCase testCase) {
        super(testCase);
    }

    public void clickFullCatalogRadioButton() {
        fullCatalogOnlyRadioButton.click();
    }

    public void ClickSinglePiecesAndFullCatalogBoth() {
        singlePiecesAndFullCatalogBoth.click();
    }

    public boolean fullCatalogOnlyIsDisplayed() {
        return getDriver().findElements(By.id(AndroidLocator.FULL_CATALOG_RADIOBUTTON)).size() > 0;
    }

    public boolean singlePiecesAndFullCatalogBothIsDisplayed() {
        return singlePiecesAndFullCatalogBoth.isDisplayed();
    }


    public void clickDoneButton() {
        doneButton.click();
    }

    public void enterCatalogDuration(int days) {
        WebElement element = getDriver().findElement(By.id(AndroidLocator.CATALOG_ENABLE_DURATION));
        element.clear();
        element.sendKeys(String.valueOf(days));
    }

    public void clickOk() {
        okButton.click();
    }


    public boolean areAllSizesDisplayed(){
       return allSizes.isDisplayed();
    }

    public void clickCloseButton(){
        closeButton.click();
    }

    public void clickSinglePiecesAndFullCatalogBoth(){
        singlePiecesAndFullCatalogBoth.click();
    }


    public boolean isDesignNumberDisplayed(){
        return designNumber.isDisplayed();
    }

    public boolean isPricePerDesignDisplayed(){
      return pricesPerDesign.isDisplayed();
    }
}