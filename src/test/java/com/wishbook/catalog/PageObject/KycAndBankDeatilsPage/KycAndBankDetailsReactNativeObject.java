package com.wishbook.catalog.PageObject.KycAndBankDeatilsPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class KycAndBankDetailsReactNativeObject extends BasePageObject implements KycAndBankDetailsPageStrategy {

    @AndroidFindBy(accessibility = "")
    private WebElement gstTextField;

    @AndroidFindBy(accessibility = "")
    private WebElement paytmTextField;

    @AndroidFindBy(accessibility = "")
    private WebElement bankNameTextField;

    @AndroidFindBy(accessibility = "")
    private WebElement accountNumberTextField;

    @AndroidFindBy(accessibility = "")
    private WebElement ifscCodeTextField;

    @AndroidFindBy(accessibility = "")
    private WebElement accountTypeSpinner;

    @AndroidFindBy(accessibility = "")
    private WebElement savingAccount;

    @AndroidFindBy(accessibility = "")
    private WebElement saveButton;


    public KycAndBankDetailsReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void enterGstNumber(String gstNumber) {

    }

    public void enterPaytmNumberTextField(String number) {

    }

    public void enterBankName(String bankNameText) {

    }

    public void enterAccountHolderName(String name) {

    }

    public void enterIFSCcode(String ifsc) {

    }

    public long enterAccountNumber(long accountNumber) {
        return 0;
    }

    public void clickOnSaveButton() {

    }

    public long getAccountNumber() {
        return 0;
    }

    public void clickKycBackPage() {

    }
}
