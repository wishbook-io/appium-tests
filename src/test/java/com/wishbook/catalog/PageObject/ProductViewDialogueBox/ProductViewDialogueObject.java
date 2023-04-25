package com.wishbook.catalog.PageObject.ProductViewDialogueBox;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductViewDialogueObject extends BasePageObject {


    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_title")
    private WebElement productViewTitle;

    @AndroidFindBy(id = "com.wishbook.catalog:id/img_close")
    private WebElement closeProductView;

    public ProductViewDialogueObject(TestCase testCase) {
        super(testCase);
    }

    public void clickCloseButtonProductView(){
        closeProductView.click();
    }

    public String getProductViewTitle(){
        return productViewTitle.getText();
    }








}
