package com.wishbook.catalog.PageObject.CameraPicAction;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class CameraPicActionObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.CAMERA_CLICKED_IMAGE_SAVE)
    private WebElement save;

    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public CameraPicActionObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services

    @SuppressWarnings("unused")

    public void saveClickedImage()
    {
        save.click();

    }


    //endregion

}
