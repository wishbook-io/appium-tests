package com.wishbook.catalog.PageObject.AddWorkPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AddWorkPageAndroidObject extends AddWorkPageObject implements AddWorkPageStrategy {
    public AddWorkPageAndroidObject(TestCase testCase) {
        super(testCase);
    }


    public void selectWorkItems(int instance) {
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_CHECK_BOX, instance);
        element.click();
    }
    public String getWorkItem(int index) {
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_CHECK_BOX, index);
        return element.getText();
    }


    public void clickWorkCheckBoxByText(String work){
        work = String.format("//android.widget.CheckBox[@text=\"%1$s\"]", work);
        AndroidHelper.getScrollableItem(By.xpath(work),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
       save.click();

    }


}