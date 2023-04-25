package com.wishbook.catalog.PageObject.MyCartPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyCartPageAndroidObject extends MyCartPageObject implements MyCartPageStrategy {
    public MyCartPageAndroidObject(TestCase testCase) {
        super(testCase);
    }
    public String getCatalogName(int instance) {
        return   AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, AndroidLocator.WIDGET_TEXT_VIEW,instance).getText();
        }

    public int getCatalogQuantity(int instance) {
        return Integer.parseInt(AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",instance).getText());
    }

    public float getIndividualItemsPriceInCart(int instance) {

            return BasePageObject.getFloatFromString( AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, AndroidLocator.WIDGET_TEXT_VIEW,instance).getText());
        }

        public float getCatalogPriceOnMyCart() {
            return BasePageObject.getFloatFromString( AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.GET_CATALOG_PRICE_ON_MY_CART).getText());

        }

    public boolean deleteButtonAppearOnCart() {
        AndroidHelper.scrolling(AndroidHelper.ScrollDirection.Down,4,(AndroidDriver)getDriver());
        return getDriver().findElements(By.id(AndroidLocator.DELETE_BUTTON_MY_CART)).size() > 0;

    }

}


