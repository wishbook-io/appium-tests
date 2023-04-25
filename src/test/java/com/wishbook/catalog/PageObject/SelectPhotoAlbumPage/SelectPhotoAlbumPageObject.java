package com.wishbook.catalog.PageObject.SelectPhotoAlbumPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;

import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class SelectPhotoAlbumPageObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id= AndroidLocator.BACK_BUTTON)
    private WebElement backButton;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.IMAGE_GALLERY_FOLDER)
     private WebElement wishbookFolder;

     //com.wishbook.catalog:id/image_view_album_image
    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public SelectPhotoAlbumPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region services
    @SuppressWarnings("unused")
    public void clickWishbookPhotoAlbumButton(){

        wishbookFolder.click();
    }
    @SuppressWarnings("unused")
    public void clickBackButton() {
        backButton.click();
    }

    //endregion

}
