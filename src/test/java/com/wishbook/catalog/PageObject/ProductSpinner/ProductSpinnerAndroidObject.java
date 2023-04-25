package com.wishbook.catalog.PageObject.ProductSpinner;


import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class ProductSpinnerAndroidObject extends ProductSpinnerObject implements ProductSpinnerStrategy {
    public ProductSpinnerAndroidObject(TestCase testCase) {
        super(testCase);
    }



    public void selectProductTypeSpinner(int index) {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,AndroidLocator.WIDGET_RADIO_BUTTON,index).click();

    }
    public void selectProductTypeSpinnerAtProductTab(int index){
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,AndroidLocator.WIDGET_TEXT_VIEW ,index).click();

    }
}
