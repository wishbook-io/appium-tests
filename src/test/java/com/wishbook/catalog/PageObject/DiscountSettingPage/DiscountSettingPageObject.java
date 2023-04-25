package com.wishbook.catalog.PageObject.DiscountSettingPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DiscountSettingPageObject extends BasePageObject {



    //region element

    @AndroidFindBy(id = AndroidLocator.ADD_MORE_BUTTON)
    private WebElement addMoreBrandButton;

    @AndroidFindBy(id = AndroidLocator.ENTER_CASH_DISCOUNT_TEXTFIELD)
    private WebElement enterCashDiscountTextField;

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;

    @AndroidFindBy(id = AndroidLocator.ADD_DISCOUNT_ICON)
    private WebElement addDiscountIcon;

    @AndroidFindBy(id = AndroidLocator.SAVE_DISCOUNT)
    private WebElement saveButton;

    @AndroidFindBy(id = AndroidLocator.SAVE_SELECTED_SEARCHED_BRAND_NAME)
    private WebElement savedSelectedSearchedBrand;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@index='0']")
    private WebElement getTextOfSelectedBrandName;

    @AndroidFindBy(id = "com.wishbook.catalog:id/menu_delete")
    private WebElement deleteCreatedDiscount;

    @AndroidFindBy(id="com.wishbook.catalog:id/txt_cash_discount_value")
    private WebElement fullCatalogDiscount;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_single_pc_discount_value")
    private WebElement singlePieceDiscount;
    //endregion

    //region constructor
    public DiscountSettingPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region services

    public void BackBrandSearchButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }
    public void clickAddMoreButton() {
        addMoreBrandButton.click();
    }

    public void clickEnterCashDiscountText(float discount) {
       WebElement element= enterCashDiscountTextField;
       element.clear();
       element.sendKeys(Float.toString(discount));
    }
    public void addDiscountIcon() {
        addDiscountIcon.click();
    }

    public void saveButton() {
        saveButton.click();
    }
    public String getTextSelectedBrand() {
        return getTextOfSelectedBrandName.getText();
    }
    public float getEnteredDiscount() {
        return Float.parseFloat(enterCashDiscountTextField.getText());
    }
    public void clickSaveButtonAfterSelectBrand() {
        savedSelectedSearchedBrand.click();
    }

    public void deleteCratedDiscount() {
        deleteCreatedDiscount.click();
    }

    public float getFullCatalogDiscount(){
        return BasePageObject.getFloatFromString(fullCatalogDiscount.getText());
    }

    public float getSinglePieceDiscount(){
        return BasePageObject.getFloatFromString(singlePieceDiscount.getText());
    }
    //endregion



}
