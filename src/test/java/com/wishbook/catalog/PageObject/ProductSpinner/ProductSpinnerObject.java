package com.wishbook.catalog.PageObject.ProductSpinner;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSpinnerObject extends BasePageObject {



    @AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
    private WebElement catalogTypeSpinner;

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
    private WebElement nonCatalogTypeSpinner;

    @AndroidFindBy(id = "com.wishbook.catalog:id/spintext")
    private  WebElement getNonCatalogSpinnerText;

    @AndroidFindBy(id = "com.wishbook.catalog:id/spintext")
    private WebElement catalogAndNonCatalogSpinText;



    public ProductSpinnerObject(TestCase testCase) {
        super(testCase);
    }





    public void clickCatalogTypeSpinner() {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(),10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@index='0']")));
        catalogTypeSpinner.click();
    }
    public void clickNonCatalogSpinner() {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(),10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@index='1']")));
        nonCatalogTypeSpinner.click();
    }

    public String getNonCatalogText() {
        return getNonCatalogSpinnerText.getText();
    }

    public String getCatalogAndNonCatalogText() {
        return catalogAndNonCatalogSpinText.getText();
    }





}
