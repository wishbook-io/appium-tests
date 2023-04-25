package com.wishbook.catalog.PageObject.ProductAvailabilityDialogBox;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductAvailabilityDialogBoxPageObject extends BasePageObject {

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_title")
    private WebElement productAvailTitle;

    @AndroidFindBy(id = "com.wishbook.catalog:id/img_close")
    private WebElement closeProductAvail;



    public ProductAvailabilityDialogBoxPageObject(TestCase testCase) {
        super(testCase);
    }


    public void clickCloseButtonProductAvail(){
        closeProductAvail.click();
    }

    public String getProductAvailTitle(){
        return productAvailTitle.getText();
    }






}
