package com.wishbook.catalog.PageObject.RegistrationPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import java.util.Random;

import io.appium.java_client.android.AndroidDriver;

public class RegistrationPageAndroidObject extends RegistrationPageObject implements RegistrationPageStrategy {
    public RegistrationPageAndroidObject(TestCase testCase) {
        super(testCase);
    }


}

