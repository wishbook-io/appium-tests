package com.wishbook.catalog.PageObject.PaymentCardDetailsPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class PaymentCardDetailsPageAndroidObject extends PaymentCardDetailsPageObject implements PaymentCardDetailsPageStrategy {
    public PaymentCardDetailsPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void selectCardExpiryMonth(int index) {

        monthTextField.click();
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.CheckedTextView",index).click();

    }

    public void selectCardExpiryYear(int index) {
        yearTextField.click();
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.CheckedTextView",index).click();

    }
    public void enterCardHolderName(String cardHolderName) {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",1).sendKeys(cardHolderName);

    }
    public void enterCvvNumber(String cvv ){
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",2).sendKeys(cvv);
    }






}
