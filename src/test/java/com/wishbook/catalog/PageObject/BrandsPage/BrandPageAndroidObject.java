package com.wishbook.catalog.PageObject.BrandsPage;


import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class BrandPageAndroidObject extends BrandPageObject implements BrandPageStrategy {
    public BrandPageAndroidObject(TestCase testCase) {
        super(testCase);
    }
    @SuppressWarnings("unused")

    public void clickFollowBrandButton(int index)
    {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGE_BUTTON, index).click();

    }
}