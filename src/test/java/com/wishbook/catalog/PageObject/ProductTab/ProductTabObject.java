package com.wishbook.catalog.PageObject.ProductTab;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductTabObject extends BasePageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sarees']")
    private WebElement sareesCategories;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Kurtis']")
    private WebElement kurtiesCategories;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dress Materials']")
    private WebElement dressMaterialsCategories;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Suits - Readymade']")
    private WebElement suitsReadymadeCategories;

    @AndroidFindBy(id = "com.wishbook.catalog:id/recycler_view_category")
    private WebElement recyclerView;

    public ProductTabObject(TestCase testCase) {
        super(testCase);
    }


  public void clickSareesCategory(){
    sareesCategories.click();
    }

  public void clickKurtisCategory(){kurtiesCategories.click();}

  public void clickDressMaterialCategory(){dressMaterialsCategories.click();}

  public void clickSuitsReadyMadeCategory(){suitsReadymadeCategories.click();}

}
