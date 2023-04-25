package com.wishbook.catalog.PageObject.IntroSliderPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")

public class IntroSliderPageObject extends BasePageObject {


    //region elements
    @AndroidFindBy(id = AndroidLocator.GET_START_BUTTON)
    private WebElement getStartedButton;
    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public IntroSliderPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common service
    private boolean isPageDisplayed(){
        boolean displayed;
        try{
            getDriver().findElement(By.id(AndroidLocator.GET_START_BUTTON));
            displayed=true;
        }catch (NoSuchElementException e){
            displayed=false;
        }
        return displayed;
    }
    public void clickGetStarted() {
        getStartedButton.click();
    }
    //endregion

}
