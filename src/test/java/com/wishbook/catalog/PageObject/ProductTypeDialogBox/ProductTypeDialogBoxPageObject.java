package com.wishbook.catalog.PageObject.ProductTypeDialogBox;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductTypeDialogBoxPageObject extends BasePageObject {

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_title")
    private WebElement productTypeTitle;

    @AndroidFindBy(id = "com.wishbook.catalog:id/img_close")
    private WebElement closeProductType;

    public ProductTypeDialogBoxPageObject(TestCase testCase) {
        super(testCase);
    }


    public void clickCloseButtonProductType(){
        closeProductType.click();
    }

    public String getProductTypeTitle(){
        return productTypeTitle.getText();
    }



}
