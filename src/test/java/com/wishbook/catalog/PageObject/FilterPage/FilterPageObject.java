package com.wishbook.catalog.PageObject.FilterPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")

public class FilterPageObject extends BasePageObject {


    //region count
    @AndroidFindBy(id = "com.wishbook.catalog:id/category_count")
    private WebElement categoryCount;
    @AndroidFindBy(id = "com.wishbook.catalog:id/strich_count")
    private WebElement kurtiSizeCount;
    @AndroidFindBy(id = "com.wishbook.catalog:id/brand_count")
    private WebElement brandCount;
    @AndroidFindBy(id = "com.wishbook.catalog:id/fabric_count")
    private WebElement fabricCount;
    @AndroidFindBy(id = "com.wishbook.catalog:id/work_count")
    private WebElement workCount;
    @AndroidFindBy(id = "com.wishbook.catalog:id/style_count")
    private WebElement styleCount;
    @AndroidFindBy(id = "com.wishbook.catalog:id/price_count")
    private WebElement priceCount;
    @AndroidFindBy(id = "com.wishbook.catalog:id/state_count")
    private WebElement stateCount;
    @AndroidFindBy(id = "com.wishbook.catalog:id/catalog_count")
    private WebElement typeAndAvailabilityCount;
    //endregion

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;

    @AndroidFindBy(id = AndroidLocator.CLEAR_ALL_FILTER)
    private WebElement clearAllButton;

    @AndroidFindBy(id = AndroidLocator.APPLY_BUTTON)
    private WebElement applyButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Save Filter']")
    private WebElement saveFilterButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Delete']")
    private WebElement deleteFilterButton;

    @AndroidFindBy(id ="com.wishbook.catalog:id/txt_view_more")
    private WebElement viewMoreLink;

    //region under Type and availability
    @AndroidFindBy(id = "com.wishbook.catalog:id/relative_ctype")
    protected WebElement typeAndAvailability;

    @AndroidFindBy(id = "com.wishbook.catalog:id/radio_catalog")
    private WebElement catalogRadioButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/radio_noncatalog")
    private WebElement nonCatalogRadioButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/check_full_catalog")
    private WebElement fullSetRadioButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/check_single_piece")
    private WebElement singlePiecesAvailableRadioButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/check_both")
    private WebElement bothAvailableRadioButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/chk_prelaunch")
    private WebElement inclucdePreLaunchedCheckBox;
    //endregion

    //region under category

    @AndroidFindBy(id = "com.wishbook.catalog:id/relative_category")
    protected WebElement categoryButton;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Sarees']")
    private WebElement sareesRadioButton;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Kurtis']")
    private WebElement kurtisRadioButton;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Dress Materials']")
    private WebElement dressMaterialRadioButton;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Suits - Readymade']")
    private WebElement suitReadymadeRadioButton;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Lehengas']")
    private WebElement lehengasRadioButton;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Blouse']")
    private WebElement blouseRadioButton;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Gown - Stitched']")
    private WebElement gownStitchedRadioButton;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Gown - Semi-Stitched']")
    private WebElement gownSemiStitchedRadioButton;

//endregion

    //region under Brand
    @AndroidFindBy(id = "com.wishbook.catalog:id/relative_brand")
    protected WebElement brandButton;
    //endregion

    //region underPrice
    @AndroidFindBy(id = "com.wishbook.catalog:id/relative_price")
    protected WebElement priceButton;
    //endregion

    //region fabric
    @AndroidFindBy(id ="com.wishbook.catalog:id/relative_fabric")
    protected WebElement fabricButton;
    //endregion

    //region work
    @AndroidFindBy(id ="com.wishbook.catalog:id/relative_work")
    protected WebElement workButton;
    //endregion

    //region style
    @AndroidFindBy(id ="com.wishbook.catalog:id/relative_style")
    protected WebElement styleButton;
    //endregion

    //region state
    @AndroidFindBy(id ="com.wishbook.catalog:id/relative_state")
    protected WebElement  stateButton;
    //endregion

    //region size
    @AndroidFindBy(xpath ="//android.widget.TextView[@text='Size']")
    protected WebElement  sizeButton;
    //endregion

    //region stitched
    @AndroidFindBy(xpath ="//android.widget.TextView[@text='Stitch']")
    protected WebElement  stitchedButton;
    //endregion


    //region Constructor
    public FilterPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region method for displaying elements

    public boolean isCatalogRadioButtonDisplayed() {
        return catalogRadioButton.isDisplayed(); }

    public boolean isNonCatalogRadioButtonDisplayed() {
        return nonCatalogRadioButton.isDisplayed(); }

    public boolean isFullSetRadioButtonDisplayed() {
        return fullSetRadioButton.isDisplayed();
    }

    public boolean isSinglePieceAvailRadioButtonDisplayed() {
       return singlePiecesAvailableRadioButton.isDisplayed();
    }

    public boolean isBothAvailableRadioButtonDisplayed() {
        return bothAvailableRadioButton.isDisplayed();
    }

    public boolean isPreLaunchedChecBoxDisplayed() {
        return inclucdePreLaunchedCheckBox.isDisplayed();
    }

    public boolean isCategoryButtonDisplayed() {
        return categoryButton.isDisplayed();
    }

    public boolean isBrandButtonDisplayed() {
        return brandButton.isDisplayed();
    }

    public boolean isPriceButtonDisplayed() {
        return priceButton.isDisplayed();
    }

    public boolean isFabricButtonDisplayed() {
        return fabricButton.isDisplayed();
    }

    public boolean isWorkButtonDisplayed() {
        return workButton.isDisplayed();
    }

    public boolean isViewMoreLinkDisplayed() {
        return viewMoreLink.isDisplayed();
    }

    public boolean isStyleButtonDisplayed() {
        return styleButton.isDisplayed();
    }

    public boolean isStateButtonDisplayed() {
        return stateButton.isDisplayed();
    }

    public boolean isClearAllButtonDisplayed() {
        return clearAllButton.isDisplayed();
    }

    public boolean isApplyButtonDisplayed() {
       return applyButton.isDisplayed();
    }

    public boolean isSaveFilterDisplayed() {
        return saveFilterButton.isDisplayed();
    }

    public boolean isSizeButtonDisplayed(){
        return sizeButton.isDisplayed();

    }

    public boolean isTypeAndAvailabilityButtonDisplayed(){return  typeAndAvailability.isDisplayed();}

    public boolean isStitchedDisplayed(){
        return stitchedButton.isDisplayed();

    }
    public boolean isSaveButtonDisplayed(){
        return saveFilterButton.isDisplayed();
    }

    public boolean isDeleteButtonDisplayed(){
        return deleteFilterButton.isDisplayed();
    }
    //endregion

    //region methods for counts

    public int getCategoryCount() {
        return Integer.parseInt(categoryCount.getText());
    }

    public int getSizeCount() {
        return Integer.parseInt(kurtiSizeCount.getText());
    }

    public int getBrandCount() {
        return Integer.parseInt(brandCount.getText());
    }

    public int getPriceCount() {
        return Integer.parseInt(priceCount.getText());
    }

    public int getFabricCount() {
        return Integer.parseInt(fabricCount.getText());
    }

    public int getWorkCount() {
        return Integer.parseInt(workCount.getText());
    }

    public int getStyleCount() {
        return Integer.parseInt(styleCount.getText());
    }

    public int getStateCount() { return Integer.parseInt(stateCount.getText());}

    public int getTypeAndAvailabilityCount(){ return Integer.parseInt(typeAndAvailabilityCount.getText()); }
    //endregion

    //region for clicking
    public void clickTypeAndAvailabilityButton(){
     typeAndAvailability.click();
    }

    public void clickCatalogRadioButton() {
        catalogRadioButton.click();
    }
    public void clickNonCatalogRadioButton(){
        nonCatalogRadioButton.click();
    }
    public void clickFullSetRadioButton(){
        fullSetRadioButton.click();
    }
    public void clickSinglePiecesAvailRadioButton(){
        singlePiecesAvailableRadioButton.click();
    }
    public void clickBothAvailableRadioButton(){
        bothAvailableRadioButton.click();
    }
    public void clickIncludePreLaunchedCheckBox(){
        inclucdePreLaunchedCheckBox.click();
    }
    public void clickViewMore(){
        viewMoreLink.click();
    }

    //endregion




    //region is elements selected
    public boolean isCatalogRadioButtonSelected() {
        return Boolean.valueOf(catalogRadioButton.getAttribute("checked"));
    }

    public boolean isNonCatalogRadioButtonSelected() {
        return Boolean.valueOf(nonCatalogRadioButton.getAttribute("checked"));

    }

    public boolean isFullSetRadioButtonSelected(){
        return Boolean.valueOf(fullSetRadioButton.getAttribute("checked"));

    }

    public boolean isSinglePiecesAvailableSelected(){
        return Boolean.valueOf(singlePiecesAvailableRadioButton.getAttribute("checked"));

    }

    public boolean isBothAvailableRadioButtonSelected(){
        return Boolean.valueOf(bothAvailableRadioButton.getAttribute("checked"));

    }

    public boolean isSareesRadioButtonSelected() {
        return Boolean.valueOf(sareesRadioButton.getAttribute("checked"));

    }

    public boolean isKurtisRadioButtonSelected() {
        return Boolean.valueOf(kurtisRadioButton.getAttribute("checked"));

    }

    public boolean isCategoriesDressMateriaRadioButton() {
        return Boolean.valueOf(dressMaterialRadioButton.getAttribute("checked"));

    }

    public boolean isSuitReadymadeRadioButtonSelected() {
        return Boolean.valueOf(suitReadymadeRadioButton.getAttribute("checked"));

    }

    public boolean isLehengasRadioButtonSelected(){
        return Boolean.valueOf(lehengasRadioButton.getAttribute("checked"));

    }

    public boolean isBlouseRadioButtonSelected(){
        return Boolean.valueOf(blouseRadioButton.getAttribute("checked"));

    }

    public boolean isGownStitchedRadioButtonSelected(){
        return Boolean.valueOf(gownStitchedRadioButton.getAttribute("checked"));

    }

    public boolean isGownSemiStitchedRadioButtonSelected(){
        return Boolean.valueOf(gownSemiStitchedRadioButton.getAttribute("checked"));

    }


    //endregion














    public void saveFilter() {
        saveFilterButton.click();
    }

    public void clickClearAllButton() {
        clearAllButton.click();
    }

    public void clickApplyButton() {
        applyButton.click();
    }

    public void clickDeleteSavedFilterButton() {
        deleteFilterButton.click();
    }

    public void BackFilterButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }

    public String getTitleNameFilter(){
        return toolBar.findElement(By.className("android.widget.TextView")).getText();
    }
    public void clickCategoryButton(){ categoryButton.click(); }

    public void clickBrandButton(){ brandButton.click(); }

    public void clickPriceButton(){ priceButton.click(); }

    public void clickFabricButton(){ fabricButton.click();}

    public void clickWorkButton(){ workButton.click();}

    public void clickStyleButton(){styleButton.click();}

    public void clickStateButton(){stateButton.click();}

    public void clickSizeButton(){sizeButton.click(); }

    public void clickStitchedButton(){stitchedButton.click();}




}


//endregion


