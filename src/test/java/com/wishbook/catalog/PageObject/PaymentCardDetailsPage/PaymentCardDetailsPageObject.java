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

public class PaymentCardDetailsPageObject extends BasePageObject {

    @AndroidFindBy(xpath="//android.widget.EditText[@index='0']")
    private WebElement enterCardNumberTextField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='uE013 Success']")
    private WebElement successButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='5']")
    private WebElement enterCvvTextField;

    @AndroidFindBy(xpath="//android.widget.Spinner[@index='0']")
    protected WebElement monthTextField;

    @AndroidFindBy(xpath = "//android.widget.Spinner[@index='1']")
    protected   WebElement yearTextField;

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement makePaymentButton;

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement payNowButton;

    @AndroidFindBy(xpath = "//android.view.View[@text='Enter Card']")
    private WebElement enterCard;





    public PaymentCardDetailsPageObject(TestCase testCase) {
        super(testCase);
    }

    public void enterCardNumber(String cardNum) {
        enterCardNumberTextField.sendKeys(cardNum);
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
        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, "android.widget.EditText", 2).sendKeys("02");
    }

    public void enterYear() {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, "android.widget.EditText", 3).sendKeys("2021");
    }


    public void clickPayButton() {
        payNowButton.click();
    }

    public void clickEnterCardLink(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        enterCard.click();
    }

}
