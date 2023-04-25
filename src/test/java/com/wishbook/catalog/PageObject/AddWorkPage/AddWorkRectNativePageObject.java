package com.wishbook.catalog.PageObject.AddWorkPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddWorkRectNativePageObject extends BasePageObject implements AddWorkPageStrategy {

    @AndroidFindBy(accessibility = "EavSearchSaveButton")
    private WebElement saveButton;

    public AddWorkRectNativePageObject(TestCase testCase) {
        super(testCase);
    }

    public void selectWorkItems(int instance) {

    }

    public String getWorkItem(int index) {
        return null;
    }

    public void clickSave() {
        saveButton.click();

    }

    public void clickWorkCheckBoxByText(String work) {
            work=String.format("//android.widget.TextView[@text=\"%1$s\"]",work);
            AndroidHelper.getScrollableItem(By.xpath(work),
                    AndroidHelper.ScrollDirection.Down,
                    1,(AndroidDriver)getDriver()).click();

        }

    }

