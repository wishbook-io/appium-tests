package com.wishbook.catalog.PageObject.ProductUploadPage2;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductUploadPage2ReactNativeObject extends BasePageObject implements ProductUploadPage2Strategy{


    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Step2FullRadio']")
    private WebElement fullSetRadioButton;

    @AndroidFindBy(xpath= "//android.view.View[@content-desc='Step2SingleRadio']")
    private WebElement singlePiecesRadioButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Step2AddCoverPhotoButton\"]")
    private WebElement editCoverPhoto;

    @AndroidFindBy(accessibility = "Step2SubmitButton")
    private WebElement submitButton;

    @AndroidFindBy(accessibility = "Step2DesignPriceInput")
    private WebElement priceForDesigns;

    @AndroidFindBy(accessibility = "Step2TotalNoOfDesignsInput")
    private WebElement numberOfDesignsTextField;


    public ProductUploadPage2ReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void clickFullCatalogOnly() {
      fullSetRadioButton.click();
    }

    public void clickSinglePieceAndFullCatalogBoth() {
        singlePiecesRadioButton.click();

    }

    public void uploadCoverPhoto() {
        editCoverPhoto.click();

    }

    public void clickSubmitButton() {
        submitButton.click();

    }

    public void enterPrice(int price) {
        WebElement element=   AndroidHelper.getScrollableItem(By.xpath("//android.widget.EditText[@content-desc=\"Step2DesignPriceInput\"]"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver());
        element.sendKeys(String.valueOf(price));
    }

    public String getFirstDesignPrice(){
         AndroidHelper.getScrollableItem(By.xpath("//android.view.View[@content-desc=\"Step2AddProductPhotosButton\"]"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver());
       return   getDriver().findElements(By.className("android.widget.EditText")).get(0).getText();
    }

    public void keepSetMatchingLiveTextbox(String num) {

    }

    public void clickCheckBoxProductSizeByText(String Size) {

    }

    public boolean isMarginPricesDisplayed() {
        return false;
    }

    public void enterMarginToTextField(int addMargin) {

    }

    public void selectAddMarginInPercentRadioButton() {

    }

    public void selectAddMarginInPriceRadioButton() {

    }

    public int getTotalPriceAfterAddingMargingForSinglePiece() {
        return 0;
    }

    public void clickAddMoreImagesOfSameDesign() {

    }

    public String getSecondDesignPrice(){
        WebElement element= AndroidHelper.getScrollableItem(By.xpath("//android.view.View[@content-desc=\"Step2AddProductPhotosButton\"]"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver());
        return   getDriver().findElements(By.className("android.widget.EditText")).get(3).getText();

    }


    public void clickAddProductPhotosButton() {
        AndroidHelper.getScrollableItem(By.xpath("//android.view.View[@content-desc=\"Step2AddProductPhotosButton\"]"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver()).click();


    }



    public String getAddProductPhotosText() {
        return null;
    }

    public void enterScreenNameOrNumber(String screenName) {

    }

    public void enterScreenSetColorName(String colorName) {

    }

    public void clickAddImagesSetButton() {

    }

    public void clickDeleteButtonInScreen() {

    }

    public int getPriceForSinglePc(int index) {
        return 0;
    }

    public int getEnteredPriceForProduct() {
        WebElement element= AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "Step2TotalNoOfDesignsInput");
        return Integer.parseInt(element.getText().replaceAll("[^0-9]", ""));

    }



    public void enterNumOfDesign(int num) {
        WebElement element=numberOfDesignsTextField;
        element.click();
        element.sendKeys(String.valueOf(num));

    }


    public void clickAddAnotherSetButton() {

    }
}
