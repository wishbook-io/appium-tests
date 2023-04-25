package com.wishbook.catalog.PageObject.ManageDeliveryPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ManageDeliveryPageObject extends BasePageObject {

    @AndroidFindBy(id = "com.wishbook.catalog:id/img_close")
    private WebElement closeButton;



    public ManageDeliveryPageObject(TestCase testCase) {
        super(testCase);
    }

    public void clickCloseIcon(){
        closeButton.click();
    }
     public void selectAddressOutOfSurat(){

     }

}
