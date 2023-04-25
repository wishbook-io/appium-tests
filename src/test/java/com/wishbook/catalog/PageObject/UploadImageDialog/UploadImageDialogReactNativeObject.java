package com.wishbook.catalog.PageObject.UploadImageDialog;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UploadImageDialogReactNativeObject extends BasePageObject implements UploadImageDialogStrategy {

    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement textView;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
    private WebElement chooseCameraOption;

    public UploadImageDialogReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void selectCameraToUploadCatalog(int index) {
        chooseCameraOption.click();

    }

    public void  chooseCamera(){
        chooseCameraOption.click();
    }
}
