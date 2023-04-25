package com.wishbook.catalog.PageObject.DiscountSettingPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class DiscountSettingPageAndroid extends DiscountSettingPageObject implements DiscountSettingPageStrategy {
    public DiscountSettingPageAndroid(TestCase testCase) {
        super(testCase);
    }


    public void clickOnBrandNameCheckBox(int instance) {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_CHECK_BOX, instance).click();
        }

        public void clickOnCreatedDiscount(int index) {
            AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGE_LINEAR_LAYOUT, index).click();

        }


}


