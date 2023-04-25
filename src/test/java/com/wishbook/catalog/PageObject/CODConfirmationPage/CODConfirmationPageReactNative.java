package com.wishbook.catalog.PageObject.CODConfirmationPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

public class CODConfirmationPageReactNative extends BasePageObject implements CODConfirmationPageStrategy{

    public CODConfirmationPageReactNative(TestCase testCase) {
        super(testCase);
    }

    public float getAmountToBeCollected() {
        return 0;
    }

    public int getOrderNumber() {
        return 0;
    }

    public String getOrderStatus() {
        return null;
    }

    public void clickReConfirmCodButton() {

    }

    public void clickCancelCodButton() {

    }

    @Override
    public float getMarginAmount() {
        return 0;
    }
}
