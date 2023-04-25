package com.wishbook.catalog.PageObject.ChooseABrandSpinner;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ChooseABrandReactNativeSpinner extends BasePageObject implements ChooseABrandStrategy {

    public ChooseABrandReactNativeSpinner(TestCase testCase) {
        super(testCase);
    }

    public String getBrandNameSpinner(int index) {
        return null;
    }

    public void clickONBrandNameFromSpinner(int index) {

    }

    public void selectBrandByName(String text) {
        text=String.format("//android.widget.CheckedTextView[@text=\"%1$s\"]",text);
        AndroidHelper.getScrollableItem(By.xpath(text),
                AndroidHelper.ScrollDirection.Down,
                1,(AndroidDriver)getDriver()).click();

    }

}
