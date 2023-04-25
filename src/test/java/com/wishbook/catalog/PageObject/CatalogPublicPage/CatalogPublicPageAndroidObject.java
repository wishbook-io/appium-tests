package com.wishbook.catalog.PageObject.CatalogPublicPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPublicPageAndroidObject extends CatalogPublicPageObject implements CatalogPublicPageStrategy {



    public CatalogPublicPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void selectCatalogImage(int index) {
        WebDriverWait brandIconWait=new WebDriverWait(getDriver(),80);
        brandIconWait.until(ExpectedConditions.elementToBeClickable(By.id("com.wishbook.catalog:id/brand_img")));

        WebDriverWait imageWait = new WebDriverWait(getDriver(),120);
        WebElement element = imageWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.wishbook.catalog:id/cat_img")));
        element.click();


    }

}

