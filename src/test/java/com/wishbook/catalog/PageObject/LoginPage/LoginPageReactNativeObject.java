package com.wishbook.catalog.PageObject.LoginPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;

public class LoginPageReactNativeObject extends BasePageObject implements LoginPageStrategy{

    @AndroidFindBy(accessibility = "LoginScreenMobileInput")
    @iOSFindBy(id = "LoginScreenMobileInput")
    private WebElement enterMobileNumberTextField;

    @AndroidFindBy(accessibility = "LoginScreenProceedButton")
    @iOSFindBy(id = "LoginScreenProceedButton")
    private WebElement loginProceedButton;

    public LoginPageReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void enterMobileNumber(String mobileNumber) {
        enterMobileNumberTextField.clear();
        enterMobileNumberTextField.sendKeys(mobileNumber);
    }

    public String getMobileNumberInputText() {
        return enterMobileNumberTextField.getText();
    }

    public void login(String mobileNumber) {
        enterMobileNumber(mobileNumber);
        loginProceedButton.click();
    }

}
