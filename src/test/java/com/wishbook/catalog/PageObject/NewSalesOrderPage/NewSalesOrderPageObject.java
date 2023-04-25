package com.wishbook.catalog.PageObject.NewSalesOrderPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class NewSalesOrderPageObject extends BasePageObject {


    @AndroidFindBy(id = "com.wishbook.catalog:id/edit_buyername")
    private WebElement enterBuyerNameTextField;

    @AndroidFindBy(id = "com.wishbook.catalog:id/order")
    private WebElement orderButton;







    public NewSalesOrderPageObject(TestCase testCase) {
        super(testCase);
    }


    public void clickEnterBuyerNameTextField() {
        enterBuyerNameTextField.click();
    }
    public void clickOnOrderButton() {
      orderButton.click();
    }



}
