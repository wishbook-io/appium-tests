package com.wishbook.catalog.PageObject.ShareCatalogPage;

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
public class ShareCatalogPageObject extends BasePageObject {


    //region elements
    @AndroidFindBy(id = AndroidLocator.SHARE_SELL_FULL_CATALOG_CHECKBOX )
    private WebElement shareSellFullCatalogCheckBox;

    @AndroidFindBy(id = AndroidLocator.SHARE_AT_DIFFERENT_PRICE)
    private WebElement shareAtDifferentPrice;

    @AndroidFindBy(id = AndroidLocator.ENTER_NEW_PRICE)
    private WebElement enterNewPrice;

    @AndroidFindBy(id = AndroidLocator.SHARE_AFTER_ADDING_MARGIN)
    private WebElement shareAfterAddingMargin;

    @AndroidFindBy(id = AndroidLocator.SHARE_AFTER_MARGIN_ADD_PERCENTAGE )
    private WebElement shareAfterMarginAddPercent;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.ADD_FIXED_AMOUNT)
    private WebElement addFixedAmount;

    @AndroidFindBy(id = AndroidLocator.INDIVIDUAL_SHARE )
    private WebElement individualShare;

    @AndroidFindBy(id = AndroidLocator.ENTER_BUYER_NAME)
    private WebElement enterBuyerName;

    @AndroidFindBy(id = AndroidLocator.DONE_BUTTON_SHARE)
    private WebElement done;

    @AndroidFindBy(id = AndroidLocator.BUYER_GROUP_TEXTFIELD)
    private WebElement groupBuyerTextField;

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;


    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public ShareCatalogPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  services
    public void clickbuyerGroupTextField(){
        groupBuyerTextField.click();
    }

    public void clickSellFullCatalogCheckbox() {
        shareSellFullCatalogCheckBox.click();
    }
    public void shareAtDifferentPriceRadioButton() {
        shareAtDifferentPrice.click();
    }
    public void enterNewPriceTextBox(String price) {
        enterNewPrice.clear();
        enterNewPrice.sendKeys(price);

    }
    public void shareAfterAddingMargin() {
        shareAfterAddingMargin.click();
    }
    public void addPercentTexBox(String percent) {
        shareAfterMarginAddPercent.sendKeys(percent);
    }
    public void addFixedAmountTextBox(String fixedAmount) {
        addFixedAmount.sendKeys(fixedAmount);
    }
    public void clickBuyerNameTextBox() {
        enterBuyerName.click();
    }
    public void clickDoneButton() {
        done.click();
    }
    public void BackShareCatalogButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }

    //endregion

}
