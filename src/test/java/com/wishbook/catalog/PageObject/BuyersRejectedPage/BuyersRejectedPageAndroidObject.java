package com.wishbook.catalog.PageObject.BuyersRejectedPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class BuyersRejectedPageAndroidObject extends BuyersRejectedPageObject implements BuyersRejectedPageStrategy {
    public BuyersRejectedPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public String getBuyerName(int index) {
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_TEXT_VIEW, index);
        return element.getText();
    }

    public void clickRejectedBuyer(int index) {
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGE_RELATIVE_LAY0UT, index);
        element.click();
    }
    @SuppressWarnings("unused")
    public String getSupplierName() {
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_TEXT_VIEW, 1);
        return element.getText();
    }
    @SuppressWarnings("unused")
    public void clickRejectedSupplier() {
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGE_RELATIVE_LAY0UT, 0);
        element.click();
    }
}