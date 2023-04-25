package com.wishbook.catalog.PageObject.ChangeResaleAmountPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeResaleAmountPageObject extends BasePageObject {


    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_resale_order_amount")
    private WebElement orderAmountResalePopUp;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_total_resale_amount")
    private WebElement resaleAmountResalePopup;

    @AndroidFindBy(id = "com.wishbook.catalog:id/item_qty")
    private WebElement getItemQuantity;

    @AndroidFindBy(id = "com.wishbook.catalog:id/edit_add_margin")
    private WebElement enterResaleAmountTextField;

    @AndroidFindBy(id = "com.wishbook.catalog:id/catalog_total_amount")
    private WebElement totalProductAmountIncludingGST;

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_done")
    private WebElement doneButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/img_close")
    private WebElement closeResalePopup;

    @AndroidFindBy(id = "com.wishbook.catalog:id/edit_default_margin")
    private WebElement discountPercentTextfield;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_edit_resale_default_margin")
    private WebElement editDefaultMargin;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_save_default_margin")
    private WebElement saveDefaultMargin;


    public ChangeResaleAmountPageObject(TestCase testCase) {
        super(testCase);
    }


    public float getOrderAmountResaleAmountChangePopup(){
        return BasePageObject.getFloatFromString(orderAmountResalePopUp.getText());
    }
    public float getResaleAmountResaleAmountChangePopup(){
        return BasePageObject.getFloatFromString(resaleAmountResalePopup.getText());
    }

    public float getItemPriceInclGSTResaleAmountChangePopup(){
        return BasePageObject.getFloatFromString(totalProductAmountIncludingGST.getText());

    }

    public int getItemQuantityResaleAmountChangePopup(){
        String element = getItemQuantity.getText();
        String wishListCount = element.replaceAll("[^0-9]", "");
        return Integer.valueOf(wishListCount);


    }

    public void enterResaleAmountIntoTextBox(float resaleAmount){
        enterResaleAmountTextField.sendKeys(String.valueOf(resaleAmount));

    }


    public float getEnteredAmountIntoTextBox(){
        return BasePageObject.getFloatFromString(enterResaleAmountTextField.getText());

    }

    public float getResaleMarginPercent(){
        return BasePageObject.getFloatFromString(discountPercentTextfield.getText());

    }

    public void clickCloseButton(){
        closeResalePopup.click();
    }
    public void clickDoneButton(){
        doneButton.click();
    }

    public void clickEditDefaultMargin(){
        editDefaultMargin.click();
    }
    public void clickSaveDefaultMargin(){
        saveDefaultMargin.click();
    }

    public void enterResaleMarginPercent(int percent){
        discountPercentTextfield.clear();
        discountPercentTextfield.sendKeys(String.valueOf(percent));

    }



}
