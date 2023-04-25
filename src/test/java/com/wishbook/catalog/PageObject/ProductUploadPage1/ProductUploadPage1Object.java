package com.wishbook.catalog.PageObject.ProductUploadPage1;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * @see BasePageObject
 */


@SuppressWarnings("unused")
public class ProductUploadPage1Object extends BasePageObject {

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.CHOOSE_CATEGORY)
    WebElement chooseACategory;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.CHOOSE_BRAND)
    WebElement chooseABrand;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.ENTER_CATALOGS_NAME)
    private WebElement catalogName;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.CHECKBOX_SELL_FULL_CATALOG)
    private WebElement sellFullCatalogOnlyCheckbox;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.SHOW_HINTS)
    private WebElement showHintsButton;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.UPLOAD_PHOTO_COVER)
    private WebElement uploadCoverPhoto;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.CONTINUE_BUTTUN)
    private WebElement continueButton;


    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.PIC_CLICK_DONE)
    private WebElement picClickDone;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.PIC_SELECT_SAVE)
    private WebElement picSelectSave;


    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.NO)
    private WebElement okButton;

    @AndroidFindBy(id= AndroidLocator.ADD_FABERIC)
    private WebElement addFabricButton;

    @AndroidFindBy(id= AndroidLocator.ADD_WORK)
    private WebElement addWorkButton;

    @AndroidFindBy(id= AndroidLocator.ENTER_OTHER_DETAILS)
    private WebElement enterOtherDetailsTextField;

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;


    @AndroidFindBy(id= AndroidLocator.CATALOG_ENABLE_DURATION)
    protected WebElement catalogEnableDurationTextField;

    @AndroidFindBy(id = AndroidLocator.CALENDER_OK)
    private WebElement calenderOkButton;

    @AndroidFindBy(id= AndroidLocator.CONTINUE_BUTTUN)
    private WebElement enterPriceDetailsButton;

    @AndroidFindBy(id = AndroidLocator.DONE_BUTTON)
    private WebElement doneButton;

    @AndroidFindBy(id = AndroidLocator.SELECT_SIZE_KURTI)
    private WebElement selectKurtiSize;

    @AndroidFindBy(id= "com.wishbook.catalog:id/radio_catalog")
    private WebElement catalogRadioButton;

    @AndroidFindBy(id= "com.wishbook.catalog:id/radio_noncatalog")
    private WebElement nonCatalogRadioButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/edit_screen_quality_name")
    private WebElement screenQualityName;

    @AndroidFindBy(id = AndroidLocator.NUMBER_OF_PIECES_PER_SCREEN)
    protected WebElement piecesPerScreen;

    @AndroidFindBy(id = AndroidLocator.PRICES_PER_PIECES_SCREEN)
    protected WebElement pricesPerPiecesScreen;

    @AndroidFindBy(id = "com.wishbook.catalog:id/spinner_top_category")
    protected   WebElement selectTopCategory;

    @AndroidFindBy(id = "com.wishbook.catalog:id/radio_setmatching")
    private WebElement setMatchingRadioButton;


    //endregion
    //region constructor
    public ProductUploadPage1Object(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region services
    public void enterOtherDetailsTextField(String details) {
        enterOtherDetailsTextField.sendKeys(details);
    }



    @SuppressWarnings("unused")
    public void clickContinueButton() {
        continueButton.click();
    }
    @SuppressWarnings("unused")
    public void clickOkButton() {
        okButton.click();
    }


    public void clickCatalogRadioButton() {
        catalogRadioButton.click();
    }
    public void clickNonCatalogRadioButton() {
        nonCatalogRadioButton.click();
    }
    public void clickSetMatchingRadioButton(){
      setMatchingRadioButton.click();
    }
    public void BackAddProductButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }

    public void clickOkCalenderButton() {
        calenderOkButton.click();
    }

    public String getAddProductTileFromToolBar() {
        return toolBar.findElement(By.className(AndroidLocator.WIDGET_TEXT_VIEW)).getText();
    }

    public void clickAddProductBackButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }
     public void enterScreenQualityName(String screenName) {
       screenQualityName.sendKeys(screenName);
     }
     public boolean catalogRadioButtonIsDisplyed(){
        return catalogRadioButton.isDisplayed();
     }
     public boolean nonCatalogRadioButtonIsDisplyed(){
        return nonCatalogRadioButton.isDisplayed();
     }

    public void clickOnSelectTopCategory() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,"com.wishbook.catalog:id/spinner_top_category").click();

        }



    //endregion

}
