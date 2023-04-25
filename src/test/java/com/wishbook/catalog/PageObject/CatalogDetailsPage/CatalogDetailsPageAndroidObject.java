package com.wishbook.catalog.PageObject.CatalogDetailsPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class CatalogDetailsPageAndroidObject extends CatalogDetailsPageObject implements CatalogDetailsPageStrategy {
     CatalogDetailsPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void clickWishListButton() {
       WebElement wishlist=  AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(),0,AndroidLocator.WISHLIST_BUTTON);
        wishlist.click();
    }
    public String getCatalogTitle() {
        return catalogTitle.getText();

    }
     public void wishListSelected() {
         WebElement wishlist =  AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(),0,AndroidLocator.WISHLIST_BUTTON);
         Boolean wishlist1 =  wishlist.isEnabled();
        System.out.println(wishlist1);
     }

     public void clickOnDesigns(int index) {
         AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, AndroidLocator.WIDGE_IMAGE_VIEW,index).click();

     }
    public void clickStopSelling() {
        WebElement element=  AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(),0,AndroidLocator.STOP_SELLING);
        element.click();
    }


    public boolean stopSellingButtonIsDisplayed() {
        WebElement element=  AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(),0,AndroidLocator.STOP_SELLING);
        return element.isDisplayed();

    }
    public String getWorkText() {
        WebElement element = AndroidHelper.getScrollableItem(By.id(AndroidLocator.FABRIC_TEXT),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver());
        return element.getText();

    }
    public String getFabricText() {
         WebElement element = AndroidHelper.getScrollableItem(By.id(AndroidLocator.FABRIC_TEXT),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver());
       return element.getText();
    }
    public void clickBecomeSellerOfThisCatalogButton() {
        WebElement element = AndroidHelper.getScrollableItem(By.id(AndroidLocator.BECOME_SELLER_OF_THIS_CATALOG),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver());
        element.click();

    }

    public String getTextReadyToShipOnProductDetailsPage() {
         WebElement element = AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/txt_ready_to_dispatch"),
                AndroidHelper.ScrollDirection.Down,
                2,(AndroidDriver)getDriver());
       return element.getText();


    }

    public String getTextPreOrderOnProductDetailsPage() {
        WebElement element = AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/txt_pre_order"),
                AndroidHelper.ScrollDirection.Down,
                4,(AndroidDriver)getDriver());
        return element.getText();

    }
    public boolean isBecomeASellerOfThisCatalogPresent() {
        WebElement element = AndroidHelper.getScrollableItem(By.id(AndroidLocator.BECOME_SELLER_OF_THIS_CATALOG),
                AndroidHelper.ScrollDirection.Down,
                4, (AndroidDriver) getDriver());
        return element.isDisplayed();

    }
    public void clickClearanceDiscountLink(){
        AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/txt_clearance_discount_label"),
                AndroidHelper.ScrollDirection.Down,
                4, (AndroidDriver) getDriver()).click();
    }


}
