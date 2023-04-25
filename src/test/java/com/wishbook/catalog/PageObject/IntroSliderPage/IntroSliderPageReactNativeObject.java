package com.wishbook.catalog.PageObject.IntroSliderPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IntroSliderPageReactNativeObject extends BasePageObject implements IntroSliderPageStrategy {

   @AndroidFindBy(xpath = "//android.widget.TextView[@text='GET STARTED']")
   private WebElement getStartedButton;

    public IntroSliderPageReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void clickGetStarted() {
        getStartedButton.click();
    }
}
