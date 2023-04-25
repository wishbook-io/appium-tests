package com.wishbook.catalog.PageObject.SelectTopCategory;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SelectTopCategorySpinnerAndroid extends SelectTopCategorySpinnerObject implements SelectTopCategorySpinnerStrategy {
    public SelectTopCategorySpinnerAndroid(TestCase testCase) {
        super(testCase);
    }

    public void selectTopCategoryItems(int index){
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,AndroidLocator.WIDGET_TEXT_VIEW,1).click();

    }

    public void selectTopCategoryByName(String text){
        text=String.format("//android.widget.TextView[@text=\"%1$s\"]",text);
        AndroidHelper.getScrollableItem(By.xpath(text),
                AndroidHelper.ScrollDirection.Down,
                1,(AndroidDriver)getDriver()).click();


    }
}
