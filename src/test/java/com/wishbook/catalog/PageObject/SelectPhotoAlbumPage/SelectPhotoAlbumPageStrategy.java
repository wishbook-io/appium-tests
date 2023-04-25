package com.wishbook.catalog.PageObject.SelectPhotoAlbumPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface SelectPhotoAlbumPageStrategy extends BaseStrategy {
    void clickWishbookPhotoAlbumButton();
    @SuppressWarnings("unused")
    void clickBackButton();
    void selectImagesPhotoAlbum(int index);
    void clickOnGallery();

}
