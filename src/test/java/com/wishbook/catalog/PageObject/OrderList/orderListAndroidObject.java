package com.wishbook.catalog.PageObject.OrderList;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;


public class orderListAndroidObject extends OrderListObject implements OrderListStrategy {
    public orderListAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void clickSearchedLeadsEnquiry() {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGE_LINEAR_LAYOUT, 9).click();

    }
    public void clickSearchedLead(int index) {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGE_LINEAR_LAYOUT, index).click();

    }

    public void clickNewPurchaseOrder() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        recycleView.findElements(By.className("android.widget.RelativeLayout")).get(0).click();
    }
    public void enterOrderNumber( int orderNumber) {
        searchTextField.sendKeys(String.valueOf(orderNumber));
        ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, "android.widget.LinearLayout", 8).click();

    }
}