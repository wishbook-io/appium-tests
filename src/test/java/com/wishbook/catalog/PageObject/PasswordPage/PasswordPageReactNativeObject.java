package com.wishbook.catalog.PageObject.PasswordPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PasswordPageReactNativeObject extends BasePageObject implements PasswordPageStrategy {


    @AndroidFindBy(accessibility = "VerifyOtpScreenProceedButton")
    WebElement passwordProceedButton;

    @AndroidFindBy(accessibility = "VerifyOtpScreenBackButton")
    private WebElement  backButton;


    public PasswordPageReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void loginWithPassword(String password) {
        WebDriverWait wait= new WebDriverWait(getDriver(),50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc='VerifyOtpScreenForgotButton']")));


       WebElement elementList= getDriver().findElements(By.className("android.widget.EditText")).get(7);
       elementList.clear();
       elementList.sendKeys(password);
       passwordProceedButton.click();
    }

    public void BackLoginPageButton() {
        backButton.click();
    }
}
