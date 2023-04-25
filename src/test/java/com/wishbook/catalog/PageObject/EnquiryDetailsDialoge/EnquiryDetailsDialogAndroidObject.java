package com.wishbook.catalog.PageObject.EnquiryDetailsDialoge;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class EnquiryDetailsDialogAndroidObject extends EnquiryDetailsDialogeObject implements  EnquiryDetailsDialogeStrategy  {
    public EnquiryDetailsDialogAndroidObject(TestCase testCase) {
        super(testCase);
    }

    @SuppressWarnings("unused")

    public void clickEnquiryCheckbox(int index) {
    AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_CHECK_BOX, index).click();

}

}

