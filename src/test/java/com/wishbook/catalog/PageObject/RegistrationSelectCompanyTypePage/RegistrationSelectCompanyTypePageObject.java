package com.wishbook.catalog.PageObject.RegistrationSelectCompanyTypePage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;

import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")
public class RegistrationSelectCompanyTypePageObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = AndroidLocator.MANUFACTURE)
    private WebElement manufacturer;

    @AndroidFindBy(id = AndroidLocator.WHOLESALER)
    private WebElement wholesaler;

    @AndroidFindBy(id = AndroidLocator.RETAILER)
    private WebElement retailer;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.ONLINE_RETAILER_RESELLER )
    private WebElement onlineRetailer;

    @AndroidFindBy(id = AndroidLocator.BROKER )
    private WebElement broker;

    @AndroidFindBy(id= AndroidLocator.OK_BUTTUN)
    private WebElement okButton;


    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public RegistrationSelectCompanyTypePageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region   services
    public void selectManufacturer() {
        manufacturer.click();

    }
    public void selectWholesaler() {
        wholesaler.click();

    }
    public void selectRetailer() {
        retailer.click();

    }
    public void selectOnlineRetailer() {
        onlineRetailer.click();

    }
    public void selectBroker() {
        broker.click();

    }

    public void  okButton() {
        okButton.click();
    }

    //endregion

}
