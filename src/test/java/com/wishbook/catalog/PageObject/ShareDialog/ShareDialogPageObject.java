package com.wishbook.catalog.PageObject.ShareDialog;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ShareDialogPageObject extends BasePageObject {

    public ShareDialogPageObject(TestCase testCase) {
        super(testCase);
        // TODO Auto-generated constructor stub
    }
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.SHARE_ON_WISHBOOK)
    private WebElement shareOnWishbook;

    @SuppressWarnings("unused")
    public void clickShareOnWishbook() {
        shareOnWishbook.click();
    }


}