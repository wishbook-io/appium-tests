package com.wishbook.catalog.PageObject.PaymentOptionsPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PaymentOptionsPageObject extends BasePageObject {

@AndroidFindBy(id = "paymentMethodList")
private   WebElement paymentModeList;

@AndroidFindBy(xpath = "//android.view.View[@text='Debit Card']")
private WebElement debitCardButton;

    public PaymentOptionsPageObject(TestCase testCase) {
        super(testCase);
    }

    public void clickDebitCard() {
        debitCardButton.click();
    }

}
