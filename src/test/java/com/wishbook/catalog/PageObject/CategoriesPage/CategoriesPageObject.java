package com.wishbook.catalog.PageObject.CategoriesPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class CategoriesPageObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;


    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.REGISTER_BUTTON)
    private WebElement registerButton;
    // endregion

    //region constructor
    /**
     * @see BasePageObject
     */
    public CategoriesPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    @SuppressWarnings("unused")
    public void BackCategoryButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }
    @SuppressWarnings("unused")
    public Boolean IsRegistrationButtonDisplay() {
        WebElement element = registerButton;
        Boolean v = element.isDisplayed();
        System.out.println("RegistrationButtonIsAvailable = " + v);
        return v;
    }

    //endregion

}
