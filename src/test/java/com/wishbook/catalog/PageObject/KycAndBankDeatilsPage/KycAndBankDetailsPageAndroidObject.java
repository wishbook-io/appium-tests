package com.wishbook.catalog.PageObject.KycAndBankDeatilsPage;


import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class KycAndBankDetailsPageAndroidObject extends KycAndBankDetailsPageObject implements KycAndBankDetailsPageStrategy {
    public KycAndBankDetailsPageAndroidObject(TestCase testCase) {
        super(testCase);
    }
    public long enterAccountNumber(long accountNumber) {
     WebElement element= AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,AndroidLocator.ACCOUNT_NUMBER);
     element.clear();
     element.sendKeys(String.valueOf(accountNumber));
      return accountNumber;
    }
    public void enterIFSCcode(String ifsc) {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,AndroidLocator.IFSC_CODE).sendKeys(ifsc);

    }
    public void enterAccountHolderName(String name) {
      WebElement element=  AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,AndroidLocator.ACCOUNT_HOLDER_NAME);
      element.clear();
      element.sendKeys(name);

    }
    public long getAccountNumber() {
        return Long.valueOf( AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,AndroidLocator.ACCOUNT_NUMBER).getText());

    }

}