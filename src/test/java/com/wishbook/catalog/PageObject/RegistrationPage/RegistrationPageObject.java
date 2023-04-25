package com.wishbook.catalog.PageObject.RegistrationPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


/**
 * @see BasePageObject
 */
public class RegistrationPageObject extends BasePageObject {

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='English']")
    private WebElement englishRadioButton;

    @AndroidFindBy(xpath= "//android.widget.RadioButton[@text='Hindi']")
    private WebElement hindiRadioButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/onlineretailer_reseller")
    private WebElement homeBasedResellerCheckBox;

    @AndroidFindBy(id = "com.wishbook.catalog:id/retailer")
    private WebElement retailerCheckBox;

    @AndroidFindBy(id = "com.wishbook.catalog:id/wholesaler_distributor")
    private WebElement wholesalerCheckBox;

    @AndroidFindBy(id = "com.wishbook.catalog:id/wholesaler_distributor")
    private WebElement manufacturerCheckBox;

    @AndroidFindBy(id = "com.wishbook.catalog:id/broker")
    private WebElement brokerCheckBox;

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_save")
    private WebElement startUsingWishbook;

    @AndroidFindBy(id = "com.wishbook.catalog:id/img_close")
    private WebElement closeButton;




    public RegistrationPageObject(TestCase testCase) {
        super(testCase);
    }

    public void selectEnglish(){
        englishRadioButton.click();
    }

    public void selectHomeBasedReseller(){
        homeBasedResellerCheckBox.click();
    }

    public void selectRetailer(){
        retailerCheckBox.click();
    }

    public void selectWholesaler(){
        wholesalerCheckBox.click();
    }

    public void selectBroker(){
        brokerCheckBox.click();
    }

    public void clickStartUsingWishbookButton(){
        startUsingWishbook.click();
    }

    public String getHomeBasedReseller(){
        return  homeBasedResellerCheckBox.getText();
    }

    public String getRetailer(){
        return retailerCheckBox.getText();
    }

    public String getManufacturerWholeSalerBroker(){
        return manufacturerCheckBox.getText();
    }

    public void clickCloseButton(){
        closeButton.click();
    }


}
