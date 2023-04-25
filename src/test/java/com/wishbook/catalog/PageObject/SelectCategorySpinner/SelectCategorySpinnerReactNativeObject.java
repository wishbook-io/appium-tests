package com.wishbook.catalog.PageObject.SelectCategorySpinner;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SelectCategorySpinnerReactNativeObject extends BasePageObject implements SelectCategorySpinnerStrategy {
    public SelectCategorySpinnerReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void selectCategoryItem(int index) {

    }

    public String getCategoryItem(int index) {
        return null;
    }

    public void selectCategoryByName(String text) {
        text=String.format("//android.widget.CheckedTextView[@text=\"%1$s\"]",text);
        AndroidHelper.getScrollableItem(By.xpath(text),
                AndroidHelper.ScrollDirection.Down,
                1,(AndroidDriver)getDriver()).click();

    }
}
