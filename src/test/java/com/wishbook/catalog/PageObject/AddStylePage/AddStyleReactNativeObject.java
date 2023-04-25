package com.wishbook.catalog.PageObject.AddStylePage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddStyleReactNativeObject extends BasePageObject implements AddStylePageStrategy {

    @AndroidFindBy(accessibility = "EavSearchSaveButton")
    private WebElement save;

    public AddStyleReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void selectStyleItems(int instance) {

    }

    public void clickSave() {
        save.click();

    }

    public void clickRadioButtonProductStyle(String style) {
        style = String.format("//android.widget.TextView[@text=\"%1$s\"]", style);
        AndroidHelper.getScrollableItem(By.xpath(style),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();

    }
}
