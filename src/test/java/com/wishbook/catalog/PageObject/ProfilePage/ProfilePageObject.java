package com.wishbook.catalog.PageObject.ProfilePage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @see BasePageObject
 */

@SuppressWarnings("unused")
public class ProfilePageObject extends BasePageObject {

    //region elements

    @AndroidFindBy(id="com.wishbook.catalog:id/edit_name")
    protected  WebElement enterName;

    @AndroidFindBy(id = "com.wishbook.catalog:id/edit_companyname")
    protected  WebElement companyName;

    @AndroidFindBy(id = "com.wishbook.catalog:id/spinner_city")
    protected WebElement cityName;

    @AndroidFindBy(id = "com.wishbook.catalog:id/spinner_state")
    protected  WebElement stateName;

    @AndroidFindBy(id = "com.wishbook.catalog:id/edit_phone")
    private WebElement phoneNumber;

    @AndroidFindBy(id = "com.wishbook.catalog:id/edit_email")
    private WebElement emailId;

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_save")
    protected WebElement saveChangeButton;

    @AndroidFindBy(id = "addressTODO")
    protected WebElement address;

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;







    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public ProfilePageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services


    public void BackCatalogButton() {
         toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();

    }



    //endregion

}
