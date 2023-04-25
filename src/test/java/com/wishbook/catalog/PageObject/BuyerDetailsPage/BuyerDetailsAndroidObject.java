package com.wishbook.catalog.PageObject.BuyerDetailsPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class BuyerDetailsAndroidObject extends BuyerDetailsObject implements BuyerDetailsStrategy {
    public BuyerDetailsAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void clickRejectBuyerButton() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0, AndroidLocator.REJECT_BUYER_BUTTON).click();
    }
    public void clickApproveButton() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0, AndroidLocator.APPROVE_BUTTON).click();
    }
    @SuppressWarnings("unused")
    public String rejectBuyerButtonIsDisplayed() {
        WebElement e= AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0, AndroidLocator.REJECT_BUYER_BUTTON);
      return e.getText();

    }




}
