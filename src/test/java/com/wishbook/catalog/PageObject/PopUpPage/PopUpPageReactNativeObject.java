package com.wishbook.catalog.PageObject.PopUpPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PopUpPageReactNativeObject extends BasePageObject implements PopUpPageStrategy {


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
    private WebElement OkButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    private WebElement ok;

    @AndroidFindBy(accessibility = "android:id/button1")
    private WebElement yesLogoutButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
    private WebElement OKpasswordPopoUp;


    public PopUpPageReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void clickYesButton() {
      yesLogoutButton.click();
    }

    public void clickNoButton() {

    }

    public void clickOk() {
        OkButton.click();
    }

    public void clickOnYesRemoveItemFromCart() {

    }

    public void clickOnNoRemoveItemFromCart() {

    }

    public void clickDoneDiscount() {

    }

    public void enterNameForThisDiscountRuleTextField(String DiscountRule) {

    }

    public void enterResellAmountIntoTextField(float resellAmount) {

    }

    public float getResellAmountOnPopUp() {
        return 0;
    }

    public void clickYesIWantCod() {

    }

    public void okChangePassword(){
        ok.click();
    }

    public void clickOkPasswordPage(){
        OKpasswordPopoUp.click();
    }

    public void clickExitApp() {

    }

    public void clickCancelRegister() {

    }

    public void clickYesRegister() {

    }
}
