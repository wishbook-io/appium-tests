package com.wishbook.catalog.PageObject.TabToSelectImage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface TabToSelectImageStrategy extends BaseStrategy {
     void selectImages();
    void clickAddButton();
    void selectImagesForCatalogDesign(int index);
    void selectImagesAtIndex(int index);

}
