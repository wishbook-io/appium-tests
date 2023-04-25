package com.wishbook.catalog.PageObject.MyViewersPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class MyViewersPageAndroidObject  extends MyViewersPageObect implements MyViewerPageStrategy {
     public MyViewersPageAndroidObject(TestCase testCase) {
            super(testCase);
        }


     public void clickRecentViewer() {
         WebElement element = AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, "android.widget.LinearLayout", 2);
         element.click();
     }
}
