package com.wishbook.catalog.PageObject.ProductAvailabilityDialogBox;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductAvailabilityDialogBoxAndroid extends ProductAvailabilityDialogBoxPageObject implements ProductAvailabilityDialogBoxStrategy {
    public ProductAvailabilityDialogBoxAndroid(TestCase testCase) {
        super(testCase);
    }

    public void selectProductAvailabiltyByName(String text){
        text=String.format("//tandroid.widget.RadioButton[@text=\"%1$s\"]",text);
        AndroidHelper.getScrollableItem(By.xpath(text),
                AndroidHelper.ScrollDirection.Down,
                1,(AndroidDriver)getDriver()).click();


    }

}
