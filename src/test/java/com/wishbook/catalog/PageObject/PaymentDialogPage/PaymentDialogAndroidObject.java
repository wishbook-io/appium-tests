package com.wishbook.catalog.PageObject.PaymentDialogPage;


import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaymentDialogAndroidObject extends PaymentDialogObject implements PaymentDialogStrategy {
    public PaymentDialogAndroidObject(TestCase testCase) {
        super(testCase);
    }

public void enterCheQueNumber(int number) {

    WebElement element=(AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/edit_cheque_number"),
            AndroidHelper.ScrollDirection.Down,
            4,(AndroidDriver)getDriver()));
    element.sendKeys(String.valueOf( number));



}
public void enterTransactionIDNEFT( String transactionID) {

    WebElement element=(AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/edit_neft"),
            AndroidHelper.ScrollDirection.Down,
            4,(AndroidDriver)getDriver()));
        element.sendKeys(String.valueOf(transactionID));



}

    public void enterBankNameInDetails(String bankName) {
        WebElement element=(AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/edit_bank_name"),
                AndroidHelper.ScrollDirection.Down,
                1,(AndroidDriver)getDriver()));
        element.sendKeys( bankName);
    }



}






