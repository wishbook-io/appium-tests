package com.wishbook.catalog.PageObject.MyCartPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyCartReactNativeObject extends BasePageObject implements MyCartPageStrategy {

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
    private WebElement titleMyCart;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='MyCartItemPriceText']")
    private WebElement getDiscountedPriceAfterGst;

    public MyCartReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public float getIndividualItemsDiscountedPrice() {
        return BasePageObject.getFloatFromString(getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"MyCartDiscountedPriceText\"]")).getText());

    }

    public float getGrandTotalPrice() {
        return BasePageObject.getFloatFromString(getDriver().findElement(MobileBy.ByAccessibilityId.AccessibilityId("MyCartTotalValueText")).getText());
    }

    public void clickIncreaseCatalogQuantity() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.xpath("//android.view.View[@content-desc='MyCartQuantityPlusTouchable']")).click();

    }

    public int getCatalogQuantity() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(getDriver().findElement(MobileBy.ByAccessibilityId.AccessibilityId("MyCartQuantityText")).getText());

    }

    public float getDiscountOnMycart() {
        return BasePageObject.getFloatFromString(getDriver().findElement(MobileBy.ByAccessibilityId.AccessibilityId("MyCartDiscountPercentText")).getText());

    }


    public int getNumberOfItemsAtToolBar() {
        WebElement element= titleMyCart;
        return Integer.valueOf(element.getText().replaceAll("[^0-9]", ""));

    }

    public void clickDeleteButton() {
     getDriver().findElements(By.className("android.widget.TextView")).get(4).click();
    }

    public String getEmptyCart() {
       return getDriver().findElement(MobileBy.ByAccessibilityId.AccessibilityId("MyCartEmptyCartMessageText")).getText();
    }

    public void clickPlaceOrderButton() {
        getDriver().findElement(MobileBy.ByAccessibilityId.AccessibilityId("MyCartPlaceOrderButton")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void BackMyCartButton() {
        getDriver().findElements(By.className("android.widget.TextView")).get(4).click();

    }

    public void clickItemsDetails() {

    }



    public String getFullCatalogText() {
        return null;
    }

    public float getSingleItemPrice() {
//        return BasePageObject.getFloatFromString(.getText());
  return 0;
    }


    public String getCatalogName(int instance) {
        return null;
    }

    public float getIndividualItemsPriceInCart(int instance) {
        return 0;
    }

    public int getCatalogQuantity(int instance) {
        return 0;
    }

    public float getCatalogPriceOnMyCart() {
        return BasePageObject.getFloatFromString(getDriver().findElements(By.className("android.widget.TextView")).get(6).getText());

    }

    public float getIndividualItemsDiscountedAfterGstPrice() {
        return BasePageObject.getFloatFromString(getDiscountedPriceAfterGst.getText());

    }

    public boolean switchReselerButtonIsDisplayed() {
        return false;
    }

    public boolean deleteButtonAppearOnCart() {
        return false;
    }

    public int getNumberOfItemsAtToolBarAfterRemovingItems() {
        return 0;
    }


    public String getCatalogNameMyCart() {
        return null;
    }

    public String getSoldByMyCart() {
        return null;
    }

}
