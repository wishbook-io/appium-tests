package com.wishbook.catalog.PageObject.KycAndBankDeatilsPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class KycAndBankDetailsPageObject extends BasePageObject {


    @AndroidFindBy(id = AndroidLocator.ENTER_GST_NUMBER)
    private WebElement enterGstNumberTextField;

    @AndroidFindBy(id = AndroidLocator.ENTER_PAYTM_NUMBER)
    private WebElement enterPaytmNumber;


    @AndroidFindBy(id = AndroidLocator.BANK_NAME)
    private WebElement bankName;

    @AndroidFindBy(id = AndroidLocator.ACCOUNT_NUMBER)
    private WebElement accountNumber;

    @AndroidFindBy(id = AndroidLocator.IFSC_CODE)
    private WebElement ifscCode;

    @AndroidFindBy(id = AndroidLocator.ACCOUNT_TYPE)
    private WebElement accountType;

    @AndroidFindBy(xpath = AndroidLocator.SAVINGS_TYPE_XPATH)
    private WebElement savingsXpath;

    @AndroidFindBy(id = AndroidLocator.SAVE_BUTTON)
    private WebElement saveButton;

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;


    public KycAndBankDetailsPageObject(TestCase testCase) {
        super(testCase);
    }


    public void enterGstNumber(String gstNumber) {

        WebElement element=enterGstNumberTextField;
               element.clear();
               element.sendKeys(gstNumber);
    }

    public void enterPaytmNumberTextField(String number) {
        WebElement element=enterPaytmNumber;
        element.clear();
        element.sendKeys(number);
    }

    public void enterBankName(String bankNameText) {
       WebElement element= bankName;
       element.clear();
       element.sendKeys(bankNameText);
    }
    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void clickKycBackPage() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }
}
