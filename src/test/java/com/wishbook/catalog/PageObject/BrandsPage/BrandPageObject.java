package com.wishbook.catalog.PageObject.BrandsPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


@SuppressWarnings("unused")

public class BrandPageObject extends BasePageObject {
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.REGISTER_BUTTON)
    private WebElement registerButton;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/search_src_text")
    private WebElement searchBox;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/brand_img")
    private WebElement selectBrand;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/search_close_btn")
    private WebElement searchBrandCloseButton;

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;

    public BrandPageObject(TestCase testCase) {
        super(testCase);
    }


    public Boolean IsRegistrationButtonDisplay() {
        WebElement element = registerButton;
        Boolean v = element.isDisplayed();
        System.out.println("RegistrationButtonIsAvailable = " + v);
        return v;
    }
    public void enterBrandName(String brandName) {
        searchBox.sendKeys(brandName);
    }
    public void selectBrandInSearch() {
        selectBrand.click();
    }
    public void clickCloseSearchButton() {
        searchBrandCloseButton.click();
    }

    public String getBrandsTileFromToolBar() {
       return toolBar.findElement(By.className(AndroidLocator.WIDGET_TEXT_VIEW)).getText();
    }

    public void clickBrandBackButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }

}
