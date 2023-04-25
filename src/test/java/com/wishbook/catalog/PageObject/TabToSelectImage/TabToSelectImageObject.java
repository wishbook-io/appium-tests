package com.wishbook.catalog.PageObject.TabToSelectImage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class TabToSelectImageObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id= AndroidLocator.TAP_TO_SELECT_IMAGE)
    private WebElement tabToSelectImage;

    @AndroidFindBy(id= AndroidLocator.ADD_IMAGE_ICON)
    private WebElement addImageIcon;

    @AndroidFindBy(id = "com.wishbook.catalog:id/grid_view_image_select")
    private WebElement imageSelectView;

    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public TabToSelectImageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  services

    /**
     * select the image from the gallery
     */
    @SuppressWarnings("unused")
    public void selectImages() {
        tabToSelectImage.click();
    }

    public void selectImagesAtIndex(int index) {
        getDriver().findElements(By.className("android.widget.ImageView")).get(index);
    }

    /**
     * click on add button to add the image
     */
    @SuppressWarnings("unused")
    public void clickAddButton() {
        addImageIcon.click();
    }

    //endregion

}
