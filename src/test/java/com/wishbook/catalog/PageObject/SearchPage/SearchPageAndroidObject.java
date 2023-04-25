package com.wishbook.catalog.PageObject.SearchPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SearchPageAndroidObject extends SearchPageObject implements SearchPageStrategy {
    public SearchPageAndroidObject(TestCase testCase) {
        super(testCase);
    }
    public void selectCatalogImage(int index) {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, AndroidLocator.WIDGE_IMAGE_VIEW,index).click();
    }

    public void clickOnSuggestionBox() {

    }


    public void searchCatalogName(String searchItem) {
        searchTextBox.clear();
        searchTextBox.sendKeys(searchItem);
        ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));    }
}
