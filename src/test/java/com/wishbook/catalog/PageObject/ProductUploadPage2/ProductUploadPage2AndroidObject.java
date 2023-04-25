package com.wishbook.catalog.PageObject.ProductUploadPage2;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductUploadPage2AndroidObject extends ProductUploadPage2Object implements ProductUploadPage2Strategy {
    public ProductUploadPage2AndroidObject(TestCase testCase) {
        super(testCase);
    }


    public void clickSinglePieceAndFullCatalogBoth() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.SINGLE_PIECES_AND_FULL_CATALOG_BOTH_RADIOBUTTON).click();
    }

    public void selectAddMarginInPercentRadioButton() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.ADD_MARGIN_IN_PERCENTAGE_RADIOBUTTON).click();
    }

    public void selectAddMarginInPriceRadioButton(){
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.ADD_MARGING_IN_RS_RADIOBUTTON).click();

    }

    public void enterMarginToTextField(int addMargin){
        addMarginTextField.clear();
        addMarginTextField.sendKeys(String.valueOf(addMargin));
    }


    public void uploadCoverPhoto() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.UPLOAD_PHOTO_COVER).click();
        AndroidHelper.allowPermission(testCase.getTest());
        AndroidHelper.allowPermission(testCase.getTest());

    }

    public void enterPrice(int price) {
        WebElement element= AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/edit_price");
        element.sendKeys(String.valueOf(price));
        }

        public int getEnteredPriceForProduct() {
            WebElement element= AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/edit_price");
            return Integer.parseInt(element.getText().replaceAll("[^0-9]", ""));

        }


    public void clickAddProductPhotosButton() {
        AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/btn_add_product"),
                AndroidHelper.ScrollDirection.Down,
                2,(AndroidDriver)getDriver()).click();
    }


    public void clickFullCatalogOnly() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.FULL_CATALOG_ONLY_RADIOBUTTON).click();


    }

    public void clickCheckBoxProductSizeByText(String Size){
        Size = String.format("//android.widget.CheckBox[@text=\"%1$s\"]", Size);
        AndroidHelper.getScrollableItem(By.xpath(Size),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver()).click();

    }

    public void keepSetMatchingLiveTextbox(String num) {
        WebElement element = AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/edit_product_expire_days");
        element.click();
        element.clear();
        element.sendKeys(num);
    }

    public int getPriceForSinglePc( int index) {
        WebElement element= AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, "android.widget.TextView", index);
        return Integer.parseInt(element.getText().replaceAll("[^0-9]", ""));

    }
    public String getAddProductPhotosText() {
        return    AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.ADD_PRODUCT_PHOTOS_BUTTON).getText();

    }
    public void enterScreenSetColorName(String colorName) {
               AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/edit_colours").sendKeys(colorName);;

    }
    public void enterScreenNameOrNumber(String screenName) {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/edit_sku").sendKeys(screenName);
    }

    public void clickAddAnotherSetButton(){
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/btn_add_set").click();

    }

    public String getSecondDesignPrice() {
        return null;
    }

    public String getFirstDesignPrice() {
        return null;
    }

    public void clickAddImagesSetButton() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/attach_button").click();

    }

  public boolean isMarginPricesDisplayed(){
        return getDriver().findElement(By.id("com.wishbook.catalog:id/linear_common_margin")).isDisplayed();
  }

  public int getTotalPriceAfterAddingMargingForSinglePiece(){
     WebElement element= AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/txt_single_pc_product_price"),
              AndroidHelper.ScrollDirection.Down,
              2,(AndroidDriver)getDriver());
      String count=element.getText();
      String Count1 = count.replaceAll("[^0-9]", "");
      return Integer.valueOf(Count1);

  }
  public void clickAddMoreImagesOfSameDesign(){
      AndroidHelper.getScrollableItem(By.id("com.wishbook.catalog:id/btn_first_additional_image"),
              AndroidHelper.ScrollDirection.Down,
              2,(AndroidDriver)getDriver()).click();
  }

}