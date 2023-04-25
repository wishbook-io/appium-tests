package com.wishbook.catalog.PageObject.ChangePassword;


import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePasswordReactNativeObject extends BasePageObject implements ChangePasswordStrategy {

  @AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
  private WebElement newPasswordTextField;

  @AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
  private WebElement repeatPasswordTextField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CHANGE PASSWORD']")
    private WebElement changePasswordButton;


    public ChangePasswordReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void enterNewPassword(String newPsd) {
      WebElement element=  AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,"android.widget.EditText",0);
      element.clear();
      element.sendKeys(newPsd);



    }

    public void repeatPassword(String confirmPsd) {
        WebElement element=  AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0,"android.widget.EditText",1);
        element.clear();
        element.sendKeys(confirmPsd);


    }

    public void clickChangePasswordButton() {
        changePasswordButton.click();

    }
}
