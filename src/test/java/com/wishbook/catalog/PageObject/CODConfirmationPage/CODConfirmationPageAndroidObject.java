package com.wishbook.catalog.PageObject.CODConfirmationPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CODConfirmationPageAndroidObject extends CODConfirmationPageObject implements CODConfirmationPageStrategy {
    public CODConfirmationPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public float getAmountToBeCollected(){
        WebElement element = AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/txt_pending_amt"),
                AndroidHelper.ScrollDirection.Down,
                4, (AndroidDriver) getDriver());
        return BasePageObject.getFloatFromString(element.getText());
    }

}
