package com.wishbook.catalog.PageObject.PopUpPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")

public class PopUpPageObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = AndroidLocator.YES)
    private WebElement yes;

    @AndroidFindBy(id = AndroidLocator. NO)
    private WebElement Ok;

    @AndroidFindBy(id = AndroidLocator.NO)
    private WebElement no;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement yesDialogCart;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement noDialogCart;

    @AndroidFindBy(id = "android:id/input")
    private WebElement enterNameForThisDiscountRule;

    @AndroidFindBy(id = "com.wishbook.catalog:id/md_buttonDefaultPositive")
    private WebElement DoneDiscount;

    @AndroidFindBy(id = "com.wishbook.catalog:id/edit_resell_amount")
    private WebElement enterResellAmountTextField;


    @AndroidFindBy(id = "com.wishbook.catalog:id/md_buttonDefaultNeutral")
    private WebElement exitApp;

    @AndroidFindBy(id = "com.wishbook.catalog:id/md_buttonDefaultNegative")
    private WebElement cancelButtonForRegist;

    @AndroidFindBy(id = "com.wishbook.catalog:id/md_buttonDefaultPositive")
    private WebElement yesButtonForRegist;
    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public PopUpPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region services
    /**
     * click yes if you are confirm for particular action
     */
    public void clickYesButton() {
        yes.click();
    }

    /**
     * click no if you are confirm for particular action
     */
    public void clickNoButton() {
        no.click();
    }


    public void clickOk()
    {
        Ok.click();
    }


    public void clickOnYesRemoveItemFromCart() {
        yesDialogCart.click();
    }
    public void clickOnNoRemoveItemFromCart() {
        noDialogCart.click();
    }

    public void enterNameForThisDiscountRuleTextField(String DiscountRule) {
        enterNameForThisDiscountRule.sendKeys(DiscountRule);
    }

    public void clickYesIWantCod(){
        DoneDiscount.click();
    }
    public void clickDoneDiscount() {
     DoneDiscount.click();
    }

    public void enterResellAmountIntoTextField(float resellAmount){
        enterResellAmountTextField.clear();
        enterResellAmountTextField.sendKeys(String.valueOf(resellAmount));
    }
    public float getResellAmountOnPopUp(){
        return Float.parseFloat(enterResellAmountTextField.getText());
    }


    public void clickExitApp(){
        exitApp.click();
    }
    public void clickCancelRegister(){
        cancelButtonForRegist.click();
    }
    public void clickYesRegister(){
        yesButtonForRegist.click();
    }

    //endregion

}
