package com.wishbook.catalog.PageObject.OrderPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

class OrderPageAndroidObject extends OrderPageObject implements OrderPageStrategy {
    public OrderPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void openLeadButton() {
        AndroidHelper.getScrollableItem(By.id(AndroidLocator.OPEN_LEADS_BUTTON),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver()).click();

    }

}
