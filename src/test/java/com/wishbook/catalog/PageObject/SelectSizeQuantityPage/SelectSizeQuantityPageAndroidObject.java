package com.wishbook.catalog.PageObject.SelectSizeQuantityPage;


import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class SelectSizeQuantityPageAndroidObject extends SelectSizeQuantityPageObject implements SelectSizeQuantityPageStrategy {
    public SelectSizeQuantityPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public String getKurtiSize(int index) {
     return   AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_TEXT_VIEW, index).getText();
    }

    public void increaseKurtiSizeQuantity(int index) {
         AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_TEXT_VIEW, index).click();

    }

}