package com.wishbook.catalog.PageObject.ProductUploadPage2;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")
public class ProductUploadPage2Object extends BasePageObject {

    //region elements
    @AndroidFindBy(id= AndroidLocator.SAME_PRICE_DETAILS)
    private WebElement samePriceDetails;

    @AndroidFindBy(id= AndroidLocator.ENTER_PRICE_FOR_THIS_CATALOG)
    private WebElement priceForThisCatalogTextField;

    @AndroidFindBy(id= AndroidLocator.ENTER_INDIVIDUAL_PRICE_DETAILS)
    private WebElement individualPriceDetails;

    @AndroidFindBy(id= AndroidLocator.CONTINUE_BUTTUN)
    private WebElement addYourDesign;

    @AndroidFindBy(id = AndroidLocator.FULL_CATALOG_ONLY_RADIOBUTTON)
    private WebElement fullCatalogOnly;

    @AndroidFindBy(id = AndroidLocator.SINGLE_PIECES_AND_FULL_CATALOG_BOTH_RADIOBUTTON)
    private WebElement singlePieceAndFullCatalogBoth;

    @AndroidFindBy(id = AndroidLocator.ADD_MARGIN_IN_PERCENTAGE_RADIOBUTTON)
    private WebElement addMarginInPercentRadioButton;

    @AndroidFindBy(id = AndroidLocator.ADD_MARGIN_TEXTFIELD)
    protected WebElement addMarginTextField;

    @AndroidFindBy(id = AndroidLocator.ADD_MARGING_IN_RS_RADIOBUTTON)
    private WebElement addMarginWithPriceRadioButton;

    @AndroidFindBy(id = AndroidLocator.CONTINUE_BUTTUN)
    private WebElement submitButton;

    @AndroidFindBy(id = AndroidLocator.SELECT_CATALOG_DESIGN )
    private WebElement selectCatalogDesignButton;

    @AndroidFindBy(id = AndroidLocator.ENTER_MARGIN_TEXTFIELD_ADD_PRODUCT)
    private WebElement getMarginPrice;

    @AndroidFindBy(id = AndroidLocator.ENTER_PRICE)
    private WebElement getDesignPrice;

    @AndroidFindBy(id =AndroidLocator.ADD_PRODUCT_PHOTOS_BUTTON )
    private WebElement addProduct;

    @AndroidFindBy(id = "com.wishbook.catalog:id/edit_sku")
    private WebElement enterScreenNameOrNumber;

    @AndroidFindBy(id = "com.wishbook.catalog:id/edit_colours")
    private WebElement enterScreenColorName;

    @AndroidFindBy(id = "com.wishbook.catalog:id/attach_button")
    private WebElement addScreenPics;



    //endregion


    //region constructor

    /**
     * @see BasePageObject
     */
    public ProductUploadPage2Object(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  services


    /**
     * select and click radio button for providing same price for all catalogs
     */
    public void selectSamePriceCatalogRadioButton() {
        samePriceDetails.click();
    }



    public String getFullCatalogRadioButton() {
        return fullCatalogOnly.getText();
    }




    public void clickSubmitButton() {
        submitButton.click();
    }


    public void enterNumOfDesign(int num) {
        WebElement element=getDriver().findElement(By.id(AndroidLocator.ENTER_TOTAL_NUMBER_OF_DESIGN));
        element.click();
        element.sendKeys(String.valueOf(num));
    }



    public void enterScreenNameOrNumber(String screenName) {
        enterScreenNameOrNumber.sendKeys(screenName);
    }





    public void clickDeleteButtonInScreen() {
        getDriver().findElements(By.className("android.widget.ImageView")).get(1).click();
    }

    //endregion

}
