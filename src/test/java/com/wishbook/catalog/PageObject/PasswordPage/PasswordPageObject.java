package com.wishbook.catalog.PageObject.PasswordPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class PasswordPageObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")

    @AndroidFindBy(id = AndroidLocator.LOGIN_INPUT_PASSWORD)
    WebElement inputPassword;

    @SuppressWarnings("unused")

    @AndroidFindBy(id = AndroidLocator.PROCEED_BUTTON)
    WebElement passwordProceedButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/appbar")
    WebElement appbar;

    // endregion

    //region constructor
    /**
     * @see BasePageObject
     */
    public PasswordPageObject(TestCase testCase) {
        super(testCase);
    }


    public void BackLoginPageButton() {
        appbar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }

    //endregion

}
