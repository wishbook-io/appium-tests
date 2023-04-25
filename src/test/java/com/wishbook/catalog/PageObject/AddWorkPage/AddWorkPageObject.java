package com.wishbook.catalog.PageObject.AddWorkPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddWorkPageObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.DONE_BUTTON)
    protected WebElement save;
    // endregion

    //region constructor
    /**
     * @see BasePageObject
     */
    public AddWorkPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    @SuppressWarnings("unused")
    public void clickSave() {
        save.click();
    }
    //endregion

}
