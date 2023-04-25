package com.wishbook.catalog.PageObject.SelectPhotoAlbumPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectPhotoAlbumPageAndroidObject extends SelectPhotoAlbumPageObject implements SelectPhotoAlbumPageStrategy {

    public void selectImagesPhotoAlbum(int index) {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(),0, "android.widget.ImageView",index).click();

    }

    public void clickOnGallery() {

    }

    public SelectPhotoAlbumPageAndroidObject(TestCase testCase) {
        super(testCase);
    }


}
