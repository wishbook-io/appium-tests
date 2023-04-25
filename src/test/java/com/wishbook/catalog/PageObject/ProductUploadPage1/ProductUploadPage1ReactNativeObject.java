package com.wishbook.catalog.PageObject.ProductUploadPage1;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class ProductUploadPage1ReactNativeObject extends BasePageObject implements ProductUploadPage1Strategy {


    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Step1SetMatchingRadio']")
    private WebElement setMatchingRadioButton;

    @AndroidFindBy(xpath= "//android.view.View[@content-desc='Step1CatalogRadio']")
    private WebElement catalogRadioButton;

    @AndroidFindBy(xpath= "//android.view.View[@content-desc='Step1NonCatalogRadio']")
    private WebElement nonCatalogRadioButton;

    @AndroidFindBy(accessibility = "Step1TopCategorySpinner")
    private WebElement selectTopCategorySpinner;

    @AndroidFindBy(accessibility = "Step1CategorySpinner")
    private WebElement chooseACategorySpinner;

    @AndroidFindBy(accessibility = "Step1BrandSpinner")
    WebElement chooseABrandSpinner;

    @AndroidFindBy(accessibility = "Step1ProductNameInput")
    private WebElement enterProductName;

    @AndroidFindBy(xpath= "//android.view.View[@content-desc='Step1FabricButton']")
    private WebElement addFabricButton;

    @AndroidFindBy(xpath= "//android.view.View[@content-desc='Step1WorkButton']")
    private WebElement addWorkButton;

    @AndroidFindBy(accessibility= "Step1OtherInput")
    private WebElement enterOtherDetailsTextField;

    @AndroidFindBy(accessibility= "Step1LiveInput")
    protected WebElement catalogEnableDurationTextField;

    @AndroidFindBy(accessibility = "Step1DispatchDateButton")
    private WebElement calenderButton;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement calenderOkButton;

    @AndroidFindBy(accessibility = "Step1SaveAndContinueButton")
    private WebElement saveAndContinueButton;

    @AndroidFindBy(accessibility = "Step1ItemNameInput")
    private WebElement screenQualityName;

    @AndroidFindBy(accessibility = "Step1NoOfPcsPerSetInput")
    protected WebElement piecesPerScreen;

    @AndroidFindBy(accessibility = "Step1PricePerPcInput")
    protected WebElement pricesPerPiecesScreen;

    @AndroidFindBy(accessibility = "Step1BackButton")
    private WebElement backButton;

    @AndroidFindBy(xpath = "//android.widget.Spinner[@content-desc='Step1BrandSpinner']")
    private WebElement getBrandName;

    @AndroidFindBy(xpath = "//android.widget.Spinner[@content-desc='Step1CategorySpinner']")
    private WebElement getCategoryName;




    public ProductUploadPage1ReactNativeObject(TestCase testCase) {

        super(testCase);
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

    public boolean catalogRadioButtonIsDisplyed(){
        return catalogRadioButton.isDisplayed();
    }
    public boolean nonCatalogRadioButtonIsDisplyed(){
        return nonCatalogRadioButton.isDisplayed();
    }


    public void clickOnSelectTopCategory() {
        WebDriverWait wait= new WebDriverWait(getDriver(),40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Spinner[@content-desc=\"Step1TopCategorySpinner\"]")));
      selectTopCategorySpinner.click();
    }

    public void clickOnSelectCategory() {
        chooseACategorySpinner.click();
    }

    public void clickOnChooseABrandSpinner() {
       chooseABrandSpinner.click();
    }


    public String getBrandName() {
        WebElement brandName=AndroidHelper.getScrollableItem(By.xpath("//android.widget.Spinner[@content-desc='Step1BrandSpinner']"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver());
        return brandName.getText();
    }


    public String getCategory() {
        WebElement brandName=AndroidHelper.getScrollableItem(By.xpath("//android.widget.Spinner[@content-desc='Step1CategorySpinner']"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver());
        return brandName.getText();
    }


    public String getScreenCategory() {
        return AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_TEXT_VIEW, 2).getText();
    }

    public String  enterCatalogName(String catalogName) {
        AndroidHelper.getScrollableItem(By.xpath("//android.widget.EditText[@content-desc=\"Step1ProductNameInput\"]"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver()).sendKeys(catalogName);
        return catalogName;
    }

    public void enterScreenQualityName(String screenName) {
        screenQualityName.sendKeys(screenName);
    }

    public void clickAddFabricButton() {
        AndroidHelper.getScrollableItem(By.xpath("//android.view.View[@content-desc='Step1FabricButton']"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver()).click();
    }

    public void clickAddStyleButton() {
        AndroidHelper.getScrollableItem(By.xpath("//android.view.View[@content-desc='Step1StyleButton']"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver()).click();
    }

    public void clickAddWorkButton() {
        AndroidHelper.getScrollableItem(By.xpath("//android.view.View[@content-desc='Step1WorkButton']"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver()).click();
    }


    public String getWork(){
        WebElement element=   AndroidHelper.getScrollableItem(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View[1]/android.view.View/android.view.View/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.TextView"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver());
     return element.getText();
    }

    public String getFabric(){
        WebElement element=   AndroidHelper.getScrollableItem(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View[1]/android.view.View/android.view.View/android.support.v4.widget.DrawerLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View[2]/android.view.View[1]/android.widget.TextView"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver());
        return element.getText();
    }

    public void setCatalogEnableDurationField(String num) {
    AndroidHelper.getScrollableItem(By.xpath("//android.widget.EditText[@content-desc=\"Step1LiveInput\"]"),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver()).click();
        WebElement element=  getDriver().findElement(MobileBy.ByAccessibilityId.AccessibilityId("Step1LiveInput"));
        element.clear();
        element.sendKeys(num);
    }

    public void clickCalender() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, AndroidLocator.CALENDER).click();

    }

    public void enterNumberOfPiecesPerScreen(int pieces) {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "Step1NoOfPcsPerSetInput").clear();
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "Step1NoOfPcsPerSetInput").sendKeys(String.valueOf(pieces));
    }

    public void enterPricesForScreenPieces(int prices) {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "Step1PricePerPcInput").clear();
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "Step1PricePerPcInput").sendKeys(String.valueOf(prices));

    }

    public boolean featuresOfProductIsDisplayed(String text) {
        text = String.format("//android.widget.TextView[@text=\"%1$s\"]", text);
        return (AndroidHelper.getScrollableItem(By.xpath(text),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver())).isDisplayed();
    }

    public boolean fabricButtonIsDisplayed() {
        return AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "").isDisplayed();

    }

    public boolean workButtonIsDisplayed() {
        return AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "").isDisplayed();

    }

    public boolean styleButtonIsDisplayed() {
        return AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(), 0, "").isDisplayed();

    }


    public void clickCheckBoxProductSizeByText(String Size){
        Size = String.format("//android.widget.TextView[@text=\"%1$s\"]", Size);
        AndroidHelper.getScrollableItem(By.xpath(Size),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver()).click();

    }

    public void clickRadioButtonProductSleeveByText(String Sleeve){
        Sleeve = String.format("//android.widget.TextView[@text=\"%1$s\"]", Sleeve);
        AndroidHelper.getScrollableItem(By.xpath(Sleeve),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }

    public void clickRadioButtonProductNeckType(String NeckType){
        NeckType = String.format("//android.widget.TextView[@text=\"%1$s\"]", NeckType);
        AndroidHelper.getScrollableItem(By.xpath(NeckType),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }

    public void clickRadioButtonProductType(String Type){
        Type = String.format("//android.widget.TextView[@text=\"%1$s\"]", Type);
        AndroidHelper.getScrollableItem(By.xpath(Type),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }
    public void clickRadioButtonProductFit(String fit){
        fit = String.format("//android.widget.TextView[@text=\"%1$s\"]", fit);
        AndroidHelper.getScrollableItem(By.xpath(fit),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }
    public void clickRadioButtonProductRise(String rise){
        rise = String.format("//android.widget.TextView[@text=\"%1$s\"]", rise);
        AndroidHelper.getScrollableItem(By.xpath(rise),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();

    }
    public void clickRadioButtonProductStretch(String stretch){
        stretch = String.format("//android.widget.TextView[@text=\"%1$s\"]", stretch);
        AndroidHelper.getScrollableItem(By.xpath(stretch),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }

    public void clickRadioButtonProductStitching(String stitching){
        stitching = String.format("//android.widget.TextView[@text=\"%1$s\"]", stitching);
        AndroidHelper.getScrollableItem(By.xpath(stitching),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }

    public void clickOccassionDressCheckbox(String occassional){
        occassional = String.format("//android.widget.TextView[@text=\"%1$s\"]", occassional);
        AndroidHelper.getScrollableItem(By.xpath(occassional),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();
    }

    public void enterTopMaterialLength(int top) {

    }

    public void enterBottomMaterialLength(int bottom) {

    }

    @Override
    public void enterDupattaLength(int length) {

    }

    @Override
    public void enterDupattaWidth(int width) {

    }

    @Override
    public void enterPalazzoBottomLength(int palazzoBottomLength) {

    }

    @Override
    public void enterLegginsBottomLength(int legginsBottomLength) {

    }


    public void enterOtherDetailsTextField(String details) {
        enterOtherDetailsTextField.sendKeys(details);
    }




    public void clickContinueButton() {
        saveAndContinueButton.click();
    }
    public void clickOkButton() {

    }



    public void BackAddProductButton() {
        backButton.click();
    }

    public void clickOkCalenderButton() {
        calenderOkButton.click();
    }

    public String getAddProductTileFromToolBar() {
        return null;
    }






}
