package com.wishbook.catalog.PageObject.AddStylePage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class AddStylePageObject extends BasePageObject {


    @AndroidFindBy(id = AndroidLocator.DONE_BUTTON)
    private WebElement save;

    public AddStylePageObject(TestCase testCase) {
        super(testCase);
    }

    public void clickSave() {
        save.click();
    }
}
