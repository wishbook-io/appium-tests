package com.wishbook.catalog.PageObject.ProductCategoryDialogBox;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductCategoryDialogBoxPageObject extends BasePageObject {

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_title")
    private WebElement productCategoryTitle;

    @AndroidFindBy(id = "com.wishbook.catalog:id/img_close")
    private WebElement closeProductCategory;

    public ProductCategoryDialogBoxPageObject(TestCase testCase) {
        super(testCase);
    }

    public void clickCloseButtonProductCategory(){
        closeProductCategory.click();
    }

    public String getProductCategoryTitle(){
        return productCategoryTitle.getText();
    }

}
