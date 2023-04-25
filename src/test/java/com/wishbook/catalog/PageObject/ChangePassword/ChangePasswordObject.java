package com.wishbook.catalog.PageObject.ChangePassword;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")

public class ChangePasswordObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = AndroidLocator.NEW_PASSWORD)
    private WebElement newPassword;

    @AndroidFindBy(id = AndroidLocator.REPEAT_PASSWORD)
    private WebElement repeatPassword;

    @AndroidFindBy(id = AndroidLocator.CHANGE_PASSWORD_BUTTON)
    private WebElement changePasswordButton;
    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public ChangePasswordObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    public void enterNewPassword(String newPsd) {
        newPassword.clear();
        newPassword.sendKeys(newPsd);
    }

    public void repeatPassword(String confirmPsd) {
        repeatPassword.clear();
        repeatPassword.sendKeys(confirmPsd);
    }

    public void clickChangePasswordButton() {
        changePasswordButton.click();
    }

    public int getPasswordTextLength() {
        String text = newPassword.getText();
        return text.length();
    }
    //endregion

}
