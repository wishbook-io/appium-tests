package com.wishbook.catalog.PageObject.PaymentDialogPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.PageObject.PaymentCardDetailsPage.PaymentCardDetailsPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.WeakHashMap;

public class PaymentDialogReactNativeObject extends BasePageObject implements PaymentDialogStrategy {

    @AndroidFindBy(accessibility = "ShipayAmountInput")
    private WebElement amount;

    @AndroidFindBy(accessibility = "ShipayBankNameInput" )
    private WebElement enterBankName;

    @AndroidFindBy(accessibility = "ShipayChequeNumberInput")
    private WebElement chequeNumber;

    @AndroidFindBy(accessibility = "ShipaySaveButton")
    private WebElement saveButton;

    @AndroidFindBy(accessibility = "ShipayTransactionIdInput")
    private WebElement enterTransactionID;


    public PaymentDialogReactNativeObject(TestCase testCase) {
        super(testCase);
    }


    public void clickSavePaymentButton() {
        saveButton.click();
    }

    public float getAmount(){
        AndroidHelper.getScrollableItem(By.id("ShipayAmountInput"),
                AndroidHelper.ScrollDirection.Down,
                1,(AndroidDriver)getDriver());
        return BasePageObject.getFloatFromString(amount.getText());

    }
    public void enterBankNameInDetails(String bankName) {
        enterBankName.sendKeys(bankName);
    }

    public void enterCheQueNumber(int number) {
        chequeNumber.sendKeys(String.valueOf( number));
        }

    public void enterTransactionIDNEFT( String transactionID) {
        enterTransactionID.sendKeys(String.valueOf(transactionID));



    }


}
