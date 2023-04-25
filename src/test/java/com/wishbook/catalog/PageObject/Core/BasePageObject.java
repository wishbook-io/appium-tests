package com.wishbook.catalog.PageObject.Core;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


/**
 *  We follow Page Object Model design pattern.
 *  Each page object represents a page and offers services.
 *  Test cases can create page objects and use their services to
 *  perform actions on a page. All the page specific details like, ids
 *  of the elements etc are hidden away from the TestSharing cases. This
 *  class is the base class for all such page objects.
 *  The constructor calls init() function so that all the elements
 *  of the page objects are initialized by at the time of construction.
 */
@SuppressWarnings("unused")

public abstract class BasePageObject implements BaseStrategy {
    protected final TestCase testCase;

    /**
     * Test cases creating page objects must provide their references while
     * creating page objects. This will be used to access the driver and
     * also access the TestSharing if required.
     * @param testCase The TestSharing case which creates this page object.
     */
    public BasePageObject(TestCase testCase) {
        this.testCase = testCase;
        init();
    }

    /**
     * @return The driver
     */
    public WebDriver getDriver() {
        return testCase.getTest().getDriver();
    }

    /**
     * Finds and assigns the elements of the page objects.
     */
    public void init(){
        init(30);
    }

    /**
     * Waits for elements in the page to become available and then assigns the elements
     * of the page object.
     * @param secondsToWaitFor is a desired duration of the waiting for an element presence
     */
    public void init(int secondsToWaitFor){
        AppiumFieldDecorator fieldDecorator = new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(secondsToWaitFor));
        PageFactory.initElements(fieldDecorator,this);
        //PageFactory.initElements(new AppiumFieldDecorator(getDriver(),secondsToWaitFor, TimeUnit.SECONDS),this);
    }

    
    public void goBack() {
        boolean defaultGoBack = true;
        String automationName = testCase.getTest().getTestConfiguration().getAutomationName();
        if(TestConfiguration.APPIUM_VALUE_APPIUM.equals(automationName)){
            if(testCase.getTest().getTestConfiguration().isAndroid()){
                defaultGoBack=false;
                ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
            }
        }

        if(defaultGoBack){
            getDriver().navigate().back();
        }
    }

    public static float getFloatFromString(String text){
        String regEx = "[^0-9.]";
        return Float.valueOf(text.replaceAll(regEx,""));
    }

}
