package com.wishbook.catalog.PageObject.SelectLanguage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")
public class LanguagePageObject extends BasePageObject {


    //region elements
    @AndroidFindBy(xpath =AndroidLocator.HINDI_LANGUAGE )
    private WebElement hindiRadioButton;

    @AndroidFindBy(xpath = AndroidLocator.ENGLISH_LANGUAGE)
    private WebElement englishRadioButton;

    @AndroidFindBy(id = AndroidLocator.DONE_BUTTON)
    private WebElement doneButton;
    // endregion

    //region constructor
    /**
     * @see BasePageObject
     */
    public LanguagePageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion



    //region services
    public void selectEnglishLanguage(){
        englishRadioButton.click();
        doneButton.click();
    }
    public void selectHindiLanguage(){
        hindiRadioButton.click();
        doneButton.click();
    }


    //endregion
}
