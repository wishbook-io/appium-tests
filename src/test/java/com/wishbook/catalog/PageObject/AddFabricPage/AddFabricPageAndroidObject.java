package com.wishbook.catalog.PageObject.AddFabricPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AddFabricPageAndroidObject extends AddFabricPageObject implements AddFabricPageStrategy {
    public AddFabricPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void selectFabricItems(int instance) {
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,AndroidLocator.WIDGET_CHECK_BOX,instance);
        element.click();
    }
    public String getFabricItem(int index) {
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,AndroidLocator.WIDGET_CHECK_BOX,index);
        return element.getText();
    }



    public void clickFabricCheckBoxByText(String fabric){
        fabric = String.format("//android.widget.CheckBox[@text=\"%1$s\"]", fabric);
        AndroidHelper.getScrollableItem(By.xpath(fabric),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
        save.click();
    }
}
