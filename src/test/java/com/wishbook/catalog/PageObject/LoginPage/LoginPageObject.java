package com.wishbook.catalog.PageObject.LoginPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")
public class LoginPageObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = AndroidLocator.LOGIN_INPUT_MOBILE)
    private WebElement loginInputMobileNumber;

    @AndroidFindBy(id = AndroidLocator.PROCEED_BUTTON)
    private WebElement loginProceedButton;
    // endregion

    //region  constructor

    /**
     * @see BasePageObject
     */
    public LoginPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region common services

    /**
     * Clears the previously entered text and types the provided text.
     *
     * @param mobileNumber This will be entered in the mobile number field.
     */
    public void enterMobileNumber(String mobileNumber) {
        loginInputMobileNumber.clear();
        loginInputMobileNumber.sendKeys(mobileNumber);
    }

    /**
     * @return The mobile number in the mobile number input field.
     */
    public String getMobileNumberInputText() {
        return loginInputMobileNumber.getText();
    }

    /**
     * Clears the previously entered mobile number and types
     * the mobile number in the mobile number field and clicks proceed button.
     *
     * @param mobileNumber The mobile number which must be used to login
     */
    public void login(String mobileNumber) {
        enterMobileNumber(mobileNumber);
        loginProceedButton.click();
    }
    //endregion

}