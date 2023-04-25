package com.wishbook.catalog.PageObject.AddFabricPage;

import com.wishbook.catalog.PageObject.AddStylePage.AddStylePageStrategy;
import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddFabricPageReactNative extends BasePageObject implements AddFabricPageStrategy {

    @AndroidFindBy(accessibility = "EavSearchSaveButton")
    private WebElement saveButton;

    public AddFabricPageReactNative(TestCase testCase) {
        super(testCase);
    }

    public void clickSave() {
        saveButton.click();

    }

    public void selectFabricItems(int instance) {

    }

    public String getFabricItem(int index) {
        return null;
    }

    public void clickFabricCheckBoxByText(String fabric) {
        fabric=String.format("//android.widget.TextView[@text=\"%1$s\"]",fabric);
            AndroidHelper.getScrollableItem(By.xpath(fabric),
                    AndroidHelper.ScrollDirection.Down,
                    1,(AndroidDriver)getDriver()).click();

        }

    }

