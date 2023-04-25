package com.wishbook.catalog.PageObject.BottomTabPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.PageObject.LoginPage.LoginPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class BottomTabReactNativeObject extends BasePageObject implements BottomTabPageStrategy {


    @AndroidFindBy(accessibility = "BottomTabBarProductsButton")
    private WebElement productButton;

    @AndroidFindBy(accessibility = "BottomTabBarMyBusinessButton")
    private WebElement myBusinessButton;

    @AndroidFindBy(accessibility = "BottomTabBarHomeButton")
    private WebElement homeButton;

    @AndroidFindBy(accessibility = "BottomTabBarOrdersButton")
    private WebElement ordersButton;


    public BottomTabReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void clickProductsButton() {
        productButton.click();
    }

    public void clickMyBusiness() {
       myBusinessButton.click();
    }

    public void clickOrderButton() {
     ordersButton.click();
    }

    public void clickHomeButton() {
       homeButton.click();
    }

    public void clickMoreTab() {

    }
}
