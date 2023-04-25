package com.wishbook.catalog.PageObject.CatalogReceivedPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
public class CatalogReceivedPageObject extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.FILTER_ICON)
    private WebElement filterButtonIcon;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.REGISTER_BUTTON)
    private WebElement registerButton;


    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/disable_text1")
    private WebElement disabledMessage;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/cattitle")
    private WebElement catalogTitle;


    //endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public CatalogReceivedPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  common services
    @SuppressWarnings("unused")

    public void clickFilterIcon() {
        filterButtonIcon.click();
    }

    @SuppressWarnings("unused")
    public Boolean IsRegistrationButtonDisplay() {
        WebElement element = registerButton;
        Boolean v = element.isDisplayed();
        System.out.println("RegistrationButtonIsAvailable = " + v);
        return v;
    }

    @SuppressWarnings("unused")
    public String getDisableMessage()
    {
        return disabledMessage.getText();
    }


    @SuppressWarnings("unused")
    public String getCatalogTitle(){
        return catalogTitle.getText();
    }
    //endregion

}
