package com.wishbook.catalog.PageObject.SelectBuyerGroupSpinner;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class SelectBuyerGroupSpinnerAndroidObject extends SelectBuyerGroupSpinnerObject implements SelectBuyerGroupSpinnerStrategy {
    public SelectBuyerGroupSpinnerAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void selectBuyerGroup(int index) {
       AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, AndroidLocator.WIDGET_TEXT_VIEW,index).click();

    }
}
