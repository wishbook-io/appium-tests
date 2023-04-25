package com.wishbook.catalog.PageObject.SearchPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageReactNativeObject extends BasePageObject implements SearchPageStrategy {

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    private WebElement searchTextBox;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    private WebElement searchedImage;

    public SearchPageReactNativeObject(TestCase testCase) {
        super(testCase);
    }


    public void searchCatalogName(String searchItem) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 40);
        searchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='1']")));
        searchTextBox.click();
        searchTextBox.sendKeys(searchItem);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.view.View",25).click();
        }
    public void noSuggestions(String searchItem) {

    }

    public void clickSearchBackButton() {

    }

    public void selectCatalogImage(int index) {

    }

    public String noDataFoundText() {
        return null;
    }

    public void BackHomeSearchButton() {

    }

    public void closeSearchTextField() {

    }

    public void clearSearchTextField() {

    }

    public String noDataFoundTextLead() {
        return null;
    }

    public void clickSearchedProduct() {
       searchedImage.click();
    }

    public void clickOnSuggestionBox() {

    }

    public void clickWishlistIconOnSearchedProduct() {

    }
}
