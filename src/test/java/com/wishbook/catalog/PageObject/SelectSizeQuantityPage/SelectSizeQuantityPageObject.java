package com.wishbook.catalog.PageObject.SelectSizeQuantityPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SelectSizeQuantityPageObject extends BasePageObject {


 @AndroidFindBy(id = "com.wishbook.catalog:id/btn_done")
 private WebElement doneButton;

    public SelectSizeQuantityPageObject(TestCase testCase) {
        super(testCase);
    }


    public void clickDoneButton(){
        doneButton.click();
    }
}
