package com.wishbook.catalog.PageObject.MyFilterPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class MyFilterPageAndroidObject extends MyFilterPageObject implements MyFilterPageStrategy {
    public MyFilterPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public String getSavedFilterName(){
       return   AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, "android.widget.RadioButton", 0).getText();

    }

}
