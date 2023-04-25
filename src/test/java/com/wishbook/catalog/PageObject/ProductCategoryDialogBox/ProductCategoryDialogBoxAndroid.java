package com.wishbook.catalog.PageObject.ProductCategoryDialogBox;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductCategoryDialogBoxAndroid extends ProductCategoryDialogBoxPageObject implements ProductCategoryDialogBoxStrategy {
    public ProductCategoryDialogBoxAndroid(TestCase testCase) {
        super(testCase);
    }

    public void selectProductCategoriesByName(String text){
        text=String.format("//android.widget.RadioButton[@text=\"%1$s\"]",text);
        AndroidHelper.getScrollableItem(By.xpath(text),
                AndroidHelper.ScrollDirection.Down,
                1,(AndroidDriver)getDriver()).click();


    }


}
