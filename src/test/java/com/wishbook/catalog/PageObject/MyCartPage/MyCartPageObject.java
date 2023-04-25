package com.wishbook.catalog.PageObject.MyCartPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class MyCartPageObject extends BasePageObject {


    //region element
    @AndroidFindBy(id = AndroidLocator.GET_CATALOG_NAME_MY_CART)
    private WebElement getCatalogNameMyCart;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.GET_SOLDBY_MY_CART)
    private WebElement getSoldByMyCart;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.GET_DISCOUNT_PRICE_MY_CART)
    private WebElement getDiscountedPrice;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.GET_GRAND_TOTAL_PRICE_MY_CART)
    private WebElement getGrandTotalPrice;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.DELETE_BUTTON_MY_CART)
    private WebElement deleteButtonMyCart;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.INCREASE_QUATITY_MY_CART)
    private WebElement increaseCatalogQuantity;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/empty_cart")
    private WebElement emptyCartMessage;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/place_order")
    private WebElement placeOrderButton;

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;

    @AndroidFindBy(id = "com.wishbook.catalog:id/layout_catalog_details")
    private WebElement catalogDetails;

    @AndroidFindBy(id = "com.wishbook.catalog:id/edit_qty")
    private WebElement getCatalogQuantity;

    @AndroidFindBy(id = "com.wishbook.catalog:id/cart_catalog_amount")
    private WebElement getFullCatalog;

    @AndroidFindBy(id = "com.wishbook.catalog:id/cart_catalog_priceperpcs")
    private WebElement getCartPriceSingleItem;

    @AndroidFindBy(id = "com.wishbook.catalog:id/discount_percent")
    private WebElement discountOnMycart;

    @AndroidFindBy(id = "com.wishbook.catalog:id/cart_catalog_priceperpcs")
    private WebElement getCatalogPriceOnCart;

    @AndroidFindBy(id = "com.wishbook.catalog:id/cart_catalog_discountprice")
    private WebElement getDiscountedPriceAfterGst;

    @AndroidFindBy(id = "com.wishbook.catalog:id/switch_resale_order")
    private WebElement resalerSwitchButton;

    //endregion

    //region constructor
    public MyCartPageObject(TestCase testCase) {
        super(testCase);
    }//endregionre

    //region services
    public float getIndividualItemsDiscountedPrice() {
        WebDriverWait wait = new WebDriverWait(getDriver(),40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(AndroidLocator.GET_DISCOUNT_PRICE_MY_CART)));
        return BasePageObject.getFloatFromString(getDiscountedPrice.getText());
    }

    public float getIndividualItemsDiscountedAfterGstPrice() {
        return BasePageObject.getFloatFromString(getDiscountedPriceAfterGst.getText());
    }


    public float getGrandTotalPrice() {
        return BasePageObject.getFloatFromString(getGrandTotalPrice.getText());
    }

    public String getCatalogNameMyCart() {
        return getCatalogNameMyCart.getText();
    }

    public String getSoldByMyCart() {
        return getSoldByMyCart.getText();
    }

    public void clickIncreaseCatalogQuantity() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(AndroidLocator.INCREASE_QUATITY_MY_CART)));
        increaseCatalogQuantity.click();
    }

    public void clickDeleteButton() {
        deleteButtonMyCart.click();
    }

    public String getEmptyCart() {
        return emptyCartMessage.getText();
    }

    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

    public String getCatalogNameCart() {
        return getCatalogNameMyCart.getText();
    }

    public void clickItemsDetails() {
        catalogDetails.click();
    }

    public void BackMyCartButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }

   public int getCatalogQuantity() {
        WebDriverWait wait = new WebDriverWait(getDriver(),40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.wishbook.catalog:id/edit_qty")));
        return Integer.parseInt(getCatalogQuantity.getText());
   }

    public int getNumberOfItemsAtToolBar() {
        WebElement element= toolBar.findElement(By.className(AndroidLocator.WIDGET_TEXT_VIEW));
        return Integer.valueOf(element.getText().replaceAll("[^0-9]", ""));

        }

    public int getNumberOfItemsAtToolBarAfterRemovingItems() {
        WebDriverWait wait= new WebDriverWait(getDriver(),30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.wishbook.catalog:id/empty_cart")));
        WebElement element= toolBar.findElement(By.className(AndroidLocator.WIDGET_TEXT_VIEW));
        return Integer.valueOf(element.getText().replaceAll("[^0-9]", ""));

    }
    public String getFullCatalogText() {
        return getFullCatalog.getText();
    }

    public float getSingleItemPrice() {
         return BasePageObject.getFloatFromString(getCartPriceSingleItem.getText());
    }
    public float getDiscountOnMycart() {
        return BasePageObject.getFloatFromString(discountOnMycart.getText());

    }
    public boolean switchReselerButtonIsDisplayed() {
        WebDriverWait wait= new WebDriverWait(getDriver(),10);

       return resalerSwitchButton.isDisplayed();
    }

    //endregion

}
