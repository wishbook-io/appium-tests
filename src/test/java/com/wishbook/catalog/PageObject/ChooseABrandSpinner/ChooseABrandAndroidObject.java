package com.wishbook.catalog.PageObject.ChooseABrandSpinner;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ChooseABrandAndroidObject extends ChooseABrandObject implements ChooseABrandStrategy {
    public ChooseABrandAndroidObject(TestCase testCase) { super(testCase);
    }


    public String getBrandNameSpinner(int index) {
        return AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,AndroidLocator.WIDGET_TEXT_VIEW,index).getText();
    }

    public void clickONBrandNameFromSpinner(int index){
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,"android.widget.TextView",index).click();

    }

    public void selectBrandByName(String text) {
        text=String.format("//android.widget.TextView[@text=\"%1$s\"]",text);
        AndroidHelper.getScrollableItem(By.xpath(text),
                AndroidHelper.ScrollDirection.Down,
                1,(AndroidDriver)getDriver()).click();

    }



}




