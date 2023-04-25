package com.wishbook.catalog.PageObject.SupplierRejectedPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class SupplierRejectedPageAndroidObject extends SupplierRejectedPageObject implements SupplierRejectedPageStrategy {
    public SupplierRejectedPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public String getSupplierName(int index) {
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_TEXT_VIEW, index);
        return element.getText();
    }
    public void clickRejectedSupplier(int index) {
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_TEXT_VIEW, index);
         element.click();
    }



}
