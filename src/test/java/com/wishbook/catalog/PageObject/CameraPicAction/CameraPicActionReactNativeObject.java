package com.wishbook.catalog.PageObject.CameraPicAction;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CameraPicActionReactNativeObject extends BasePageObject implements CameraPicActionStrategy {

    @AndroidFindBy(id = "com.wishbook.catalogone.sales:id/menu_crop")
    private WebElement savePic;

    public CameraPicActionReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void saveClickedImage() {
        savePic.click();

    }

}
