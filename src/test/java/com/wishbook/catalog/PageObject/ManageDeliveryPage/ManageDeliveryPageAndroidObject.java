package com.wishbook.catalog.PageObject.ManageDeliveryPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class ManageDeliveryPageAndroidObject extends ManageDeliveryPageObject implements ManageDeliveryPageStrategy {
    public ManageDeliveryPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

public void selectAddressRadioButton(int index){
    AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_RADIO_BUTTON, index).click();

}

}
