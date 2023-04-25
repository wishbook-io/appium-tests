package com.wishbook.catalog.PageObject.SelectLanguage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LanguagePageReactNativeObject extends BasePageObject implements LanguagePageStrategy {

    @AndroidFindBy(xpath ="//android.view.View[@content-desc=\"LanguageScreenHindiRadio\"]" )
    private WebElement hindiRadioButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"LanguageScreenEnglishRadio\"]")
    private WebElement englishRadioButton;

    @AndroidFindBy(accessibility = "LanguageScreenDoneButton")
    private WebElement doneButton;





    public LanguagePageReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void selectEnglishLanguage() {
        englishRadioButton.click();
        doneButton.click();
    }

    public void selectHindiLanguage() {
        hindiRadioButton.click();
        doneButton.click();
    }
}
