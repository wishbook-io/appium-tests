package com.wishbook.catalog.PageObject.ProductUploadPage1;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ProductUploadPage1AndroidObject extends ProductUploadPage1Object implements ProductUploadPage1Strategy {
    public ProductUploadPage1AndroidObject(TestCase testCase) {
        super(testCase);
    }


    public void setCatalogEnableDurationField(String num) {
        WebElement element = AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.CATALOG_ENABLE_DURATION);
        element.click();
        element.clear();
        element.sendKeys(num);
    }

    public void clickAddWorkButton() {
       AndroidHelper.getScrollableItem(By.id(AndroidLocator.ADD_WORK),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver()).click();
    }


    public void clickAddFabricButton() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.ADD_FABERIC).click();
    }

    public void clickAddStyleButton() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/btn_add_style_first").click();
    }


    public void clickOnSelectCategory() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.CHOOSE_CATEGORY).click();
    }

    public String getCategory() {
        return AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_TEXT_VIEW, 3).getText();
    }

    public String getWork() {
        WebElement element=   AndroidHelper.getScrollableItem(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.view.View/android.widget.CheckedTextView"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver());
        return element.getText();
    }

    public String getFabric() {
     WebElement element=  getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.view.View/android.widget.CheckedTextView"));
      return String.valueOf(element);
    }

    public String getBrandName() {
        return AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_TEXT_VIEW, 5).getText();
    }

    public String enterCatalogName(String catalogName) {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.ENTER_CATALOGS_NAME).sendKeys(catalogName);
      return catalogName;
    }


    public void clickCalender() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.CALENDER).click();

    }

    public void enterNumberOfPiecesPerScreen(int pieces) {
      WebElement element=  AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.NUMBER_OF_PIECES_PER_SCREEN);
      element.clear();
      element.sendKeys(String.valueOf(pieces));
    }

    public void enterPricesForScreenPieces(int prices) {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.PRICES_PER_PIECES_SCREEN).clear();
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.PRICES_PER_PIECES_SCREEN).sendKeys(String.valueOf(prices));

    }


    public String getScreenCategory() {

        return AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_TEXT_VIEW, 2).getText();
    }

    public void clickOnChooseABrandSpinner() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.CHOOSE_BRAND).click();

    }




    public boolean featuresOfProductIsDisplayed(String text) {
        text = String.format("//android.widget.TextView[@text=\"%1$s\"]", text);
        return (AndroidHelper.getScrollableItem(By.xpath(text),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver())).isDisplayed();
    }

    public boolean fabricButtonIsDisplayed() {
        return AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.ADD_FABERIC).isDisplayed();

    }

    public boolean workButtonIsDisplayed() {
        return AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.ADD_WORK).isDisplayed();

    }

    public boolean styleButtonIsDisplayed() {
        return AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/btn_add_style_first").isDisplayed();

    }




    public void clickRadioButtonProductSleeveByText(String Sleeve){
        Sleeve = String.format("//android.widget.RadioButton[@text=\"%1$s\"]", Sleeve);
        AndroidHelper.getScrollableItem(By.xpath(Sleeve),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }

    public void clickRadioButtonProductNeckType(String NeckType){
        NeckType = String.format("//android.widget.RadioButton[@text=\"%1$s\"]", NeckType);
        AndroidHelper.getScrollableItem(By.xpath(NeckType),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }

    public void clickRadioButtonProductType(String Type){
        Type = String.format("//android.widget.RadioButton[@text=\"%1$s\"]", Type);
        AndroidHelper.getScrollableItem(By.xpath(Type),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }
    public void clickRadioButtonProductFit(String fit){
        fit = String.format("//android.widget.RadioButton[@text=\"%1$s\"]", fit);
        AndroidHelper.getScrollableItem(By.xpath(fit),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }
    public void clickRadioButtonProductRise(String rise){
        rise = String.format("//android.widget.RadioButton[@text=\"%1$s\"]", rise);
        AndroidHelper.getScrollableItem(By.xpath(rise),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();

    }
    public void clickRadioButtonProductStretch(String stretch){
        stretch = String.format("//android.widget.RadioButton[@text=\"%1$s\"]", stretch);
        AndroidHelper.getScrollableItem(By.xpath(stretch),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }

    public void clickRadioButtonProductStitching(String stitching){
        stitching = String.format("//android.widget.RadioButton[@text=\"%1$s\"]", stitching);
        AndroidHelper.getScrollableItem(By.xpath(stitching),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }

    public void clickOccassionDressCheckbox(String occassional) {
        occassional = String.format("//android.widget.CheckBox[@text=\"%1$s\"]", occassional);
        AndroidHelper.getScrollableItem(By.xpath(occassional),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver()).click();


    }

    public void enterTopMaterialLength(int top){
       AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/edit_top").sendKeys(String.valueOf(top));
    }


    public void enterBottomMaterialLength(int bottom){
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/edit_bottom").sendKeys(String.valueOf(bottom));

    }

    public void enterDupattaLength(int length){

    }

    public void enterDupattaWidth(int width){

    }

    public void enterPalazzoBottomLength(int palazzoBottomLength){
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/edit_eav_text_value").sendKeys(String.valueOf(palazzoBottomLength));

    }
    public void enterLegginsBottomLength(int legginsBottomLength){
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "com.wishbook.catalog:id/edit_eav_text_value").sendKeys(String.valueOf(legginsBottomLength));

    }


}



