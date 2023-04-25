package com.wishbook.catalog.PageObject.PaymentCardDetailsPage;

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

public class PaymentCardDetailsPageReactNative extends BasePageObject implements PaymentCardDetailsPageStrategy {

    @AndroidFindBy(xpath="//android.widget.EditText[@index='0']")
    private WebElement enterCardNumberTextField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='uE013 Success']")
    private WebElement successButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
    private WebElement enterCvvTextField;

    @AndroidFindBy(xpath="//android.widget.Spinner[@index='0']")
    private WebElement monthSpinner;

    @AndroidFindBy(xpath = "//android.widget.Spinner[@index='1']")
    private  WebElement yearSpinner;

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement makePaymentButton;




    public PaymentCardDetailsPageReactNative(TestCase testCase) {
        super(testCase);
    }


    public void enterCardNumber(String cardNum) {
        enterCardNumberTextField.sendKeys(cardNum);
    }
    public void clickMonthTextFiled() {
        monthSpinner.click();
    }
    public void clickYearTextField() {
        yearSpinner.click();
    }

    public void clickSuccessButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='\uE013 Success']")));
        getDriver().findElements(By.className("android.widget.Button")).get(0).click();

    }

    public float getPayAmount(){
        return BasePageObject.getFloatFromString(makePaymentButton.getText());
    }

    public void enterMonth() {

    }

    public void enterYear() {

    }

    public void clickEnterCardLink() {

    }


    public void selectCardExpiryMonth(int index) {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.CheckedTextView",index).click();

    }

    public void selectCardExpiryYear(int index) {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.CheckedTextView",index).click();

    }
    public void enterCardHolderName(String cardHolderName) {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",1).sendKeys(cardHolderName);

    }
    public void enterCvvNumber(String cvv ){
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",2).sendKeys(cvv);
    }

    public void clickPayButton() {

    }


}
