package com.wishbook.catalog.PageObject.SelectCategorySpinner;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectCategorySpinnerAndroid extends SelectCategorySpinnerObject implements SelectCategorySpinnerStrategy {
    public SelectCategorySpinnerAndroid(TestCase testCase) {
        super(testCase);
    }
    public void selectCategoryItem(int index){
            AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,"android.widget.TextView",index).click();

    }
    public String getCategoryItem(int index){
      return   AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,"android.widget.TextView",index).getText();

    }

    public void selectCategoryByName(String text){

        text=String.format("//android.widget.TextView[@text=\"%1$s\"]",text);
        AndroidHelper.getScrollableItem(By.xpath(text),
                AndroidHelper.ScrollDirection.Down,
                1,(AndroidDriver)getDriver()).click();


    }





}
