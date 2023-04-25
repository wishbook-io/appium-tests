package com.wishbook.catalog.PageObject.SuppliersDetailsPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class SupplierDetailsPageAndroidObject extends SupplierDetailsPageObject implements SupplierDetailsPageStrategy {

    public SupplierDetailsPageAndroidObject(TestCase testCase) {
        super(testCase);
    }
    @SuppressWarnings("unused")
    public void clickRemoveSupplier() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0, AndroidLocator.REJECT_BUYER_BUTTON).click();

    }
    @SuppressWarnings("unused")
    public void clickApproveButton() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0, AndroidLocator.APPROVE_BUTTON).click();
    }
}
