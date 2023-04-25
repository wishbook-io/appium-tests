package com.wishbook.catalog.PageObject.ResellerShareItemPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.glassfish.grizzly.compression.lzma.impl.Base;
import org.openqa.selenium.WebElement;


public class ResellerShareItemPageObject extends BasePageObject implements ResellerShareItemStrategy {

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_catalog_price")
    private WebElement avgPricePerPiece;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_total_resale_price")
    private WebElement resalePricePerPieceTextField;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_btn_whatsapp_share")
    private WebElement shareOnWhatsAppButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_title")
    private WebElement titleOfPage;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_btn_other_share")
    private WebElement otherButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/img_close")
    private WebElement closeButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_share_link")
    private WebElement shareLinkAndEarnreward;

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_share_facebook")
    private WebElement shareOnFb;

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_save_gallery")
    private WebElement saveToGallery;

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_share_other")
    private WebElement other;

    @AndroidFindBy(id = "android:id/tw_resolver_pagemode_page_list")
    private WebElement completeActionUsing;


    public ResellerShareItemPageObject(TestCase testCase) {
        super(testCase);
    }

    public float getAveragePricePerPiece() {
        return BasePageObject.getFloatFromString(avgPricePerPiece.getText());
    }

    public void enterResalePricePerPiece(int resalePrice) {
        resalePricePerPieceTextField.clear();
        resalePricePerPieceTextField.sendKeys(String.valueOf(resalePrice));
    }

    public void clickShareOnWhatsAppButton() {
        shareOnWhatsAppButton.click();
    }

    public void clickOthersButton() {
        otherButton.click();
    }

    public boolean isShareLinkDisplayed() {
    return shareLinkAndEarnreward.isDisplayed();
    }

    public boolean isShareFBDisplayed() {
        return shareOnFb.isDisplayed();
    }


    public boolean isShareSaveToGalleryDisplayed() {
       return saveToGallery.isDisplayed();
    }

    public boolean isShareOtherDisplayed() {
        return other.isDisplayed();
    }

    public void clickOnOtherUnderOther(){
        other.click();
    }

    public boolean isCompleteActionUsing(){
        return completeActionUsing.isDisplayed();
    }

}