package com.wishbook.catalog.PageObject.AddStylePage;
import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddStylePageAndroidObject extends AddStylePageObject implements AddStylePageStrategy {
    public AddStylePageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void selectStyleItems(int instance) {
        WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,AndroidLocator.WIDGET_RADIO_BUTTON,instance);
        element.click();
    }

    public void clickRadioButtonProductStyle(String style){
        style = String.format("//android.widget.RadioButton[@text=\"%1$s\"]", style);
        AndroidHelper.getScrollableItem(By.xpath(style),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }

}
