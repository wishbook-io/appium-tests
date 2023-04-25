package com.wishbook.catalog.PageObject.UploadImageDialog;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class UploadImageDialogObject extends BasePageObject {

    //region elements


    @SuppressWarnings("unused")
    @AndroidFindBy(id=AndroidLocator.CAMERA_LIST_VIEW)
    private WebElement listView;

    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public UploadImageDialogObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    @SuppressWarnings("unused")
    public void selectCameraToUploadCatalog( int index) {
        List<WebElement> elements = listView.findElements(By.className(AndroidLocator.WIDGET_TEXT_VIEW));
        if (elements != null && index >= 0 && index < elements.size()) {
            elements.get(index).click();
        }

    }

    //endregion

}
