package com.wishbook.catalog.PageObject.HomePage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;


public class HomePageAndroidObject extends HomePageObject implements HomePageStrategy {
    public HomePageAndroidObject(TestCase testCase) {
        super(testCase);
    }

 public boolean isCreditApplyDisplayed(){
     WebElement element = AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/txt_apply_credit"),
             AndroidHelper.ScrollDirection.Down,
             2, (AndroidDriver) getDriver());
     return element.isDisplayed();

 }

 public boolean isLaunchedCatalogDisplayed(){
     WebElement element = AndroidHelper.getScrollableItem(By.xpath("//android.widget.TextView[@text='Launched Catalogs']"),
             AndroidHelper.ScrollDirection.Down,
             4, (AndroidDriver) getDriver());
     return element.isDisplayed();
 }

 public boolean isCategoriesDisplayed(){
     WebElement element = AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/recycler_view_category"),
             AndroidHelper.ScrollDirection.Down,
             4, (AndroidDriver) getDriver());
     return element.isDisplayed();
 }

    public void clickApplyNowButton() {
        WebElement element = AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/txt_apply_credit"),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver());
        element.click();

    }

    public void clickOnSeeAllPublicBrand() {

    }

    public void clickSeeAllSinglePieces() {

    }

    public void clickSeeAllNonCatalog() {

    }

    public String seeAllNonCatalogIsDisplayed() {
        return null;
    }

    public void clickAddNewCatalogContainer() {

    }

    public void clickActiveCatalogs() {

    }

    public void clickHomeSearchTextField() {

    }

    public void clickWishlistSeeAll() {

    }

    public void clickEditCreditButton() {
        WebElement element = AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/txt_apply_credit"),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver());
        element.click();

    }


}

