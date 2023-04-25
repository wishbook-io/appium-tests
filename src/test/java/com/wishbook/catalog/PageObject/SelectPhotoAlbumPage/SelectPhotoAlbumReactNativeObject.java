package com.wishbook.catalog.PageObject.SelectPhotoAlbumPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

public class SelectPhotoAlbumReactNativeObject extends BasePageObject implements SelectPhotoAlbumPageStrategy {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gallery']")
    private WebElement gallerySection;

    @AndroidFindBy(id = "com.android.documentsui:id/grid")
    private WebElement gridView;

    public SelectPhotoAlbumReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void clickWishbookPhotoAlbumButton() {

    }

    public void clickBackButton() {

    }

    public void selectImagesPhotoAlbum(int index) {
        gridView.findElements(By.className("android.widget.LinearLayout")).get(index).click();

    }
    public void clickOnGallery(){
        WebDriverWait wait= new WebDriverWait(getDriver(),50);
        wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//android.widget.TextView[@text='Gallery']")));
        gallerySection.click();
    }




}
