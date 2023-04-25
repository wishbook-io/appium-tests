package com.wishbook.catalog.PageObject.MyBusinessPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyBusinessPageAndroidObject extends MyBusinessPageObject implements MyBusinessPageStrategy {
    public MyBusinessPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public  void clickWishListMyBusiness() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,AndroidLocator.WISHLIST_MY_BUSINESS).click();
    }

    public int getWishListAsShownInMyBusiness() {
        WebElement element = AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(),0,AndroidLocator.WISHLIST_TEXT_VALUE);
        String wishListMyBusinessText = element.getText();
        String wishListCount = wishListMyBusinessText.replaceAll("[^0-9]", "");
        return Integer.valueOf(wishListCount);
    }
    public void clickBrandIFollow() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,AndroidLocator.BRAND_I_FOLLOW).click();

    }

    public void clickAddCatalogButton(){
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,AndroidLocator.ADD_CATALOG_IN_MY_BUSINESS).click();
    }

    @SuppressWarnings("unused")

    public int getBrandIFollowAsShownInMyBusiness() {
        WebElement e = AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(),0,AndroidLocator.BRAND_I_FOLLOW_TEXT_VALUE);
        String count = e.getText();
        String Count1 = count.replaceAll("[^0-9]", "");
        System.out.println(Count1);
        return Integer.valueOf(Count1);
    }

    public void clickRejectedBuyersButton() {
        WebElement e = AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(),0,AndroidLocator.REJECTED_BUYERS);
                   e.click();
    }
    public void clickMyNetwork(){
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,AndroidLocator.MY_NETWORK).click();

    }
    public void clickRejectedSuppliersButton() {
        WebElement e = AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(),0,AndroidLocator.REJECTED_SUPPLIER_BUTTON);
        e.click();
    }

    public void clickKycBankDetails() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,"com.wishbook.catalog:id/settings_gst").click();

    }
    public void clickWBMoney(){
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,AndroidLocator.WISHBOOK_MONEY).click();

    }
}
