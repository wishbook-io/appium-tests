package com.wishbook.catalog.PageObject.CatalogPublicPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CatalogPublicReactNativeObject extends BasePageObject implements CatalogPublicPageStrategy {


    @AndroidFindBy(accessibility = "ProductsTabMyFilterButton")
    private WebElement myFilterIcon;

//    @AndroidFindBy(accessibility = "")
//    private WebElement uploadCatalogIcon;
//
    @AndroidFindBy(accessibility = "ProductsTabSearchButton")
    private WebElement  searchButtonIcon;

    @AndroidFindBy(accessibility = "ProductsTabFilter_AppliedButton")
    private WebElement filterButtonIcon;

    @AndroidFindBy(accessibility = "ProductsTabSort_AppliedButton")
    private WebElement sortIcon;

    @AndroidFindBy(id = AndroidLocator.SHARE_CATALOG_ICON)
    private WebElement catalogShare;

    @AndroidFindBy(id = AndroidLocator.RECYCLER_VIEW)
    private WebElement recyclerView;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_sold_by")
    private WebElement soldByCompanyName;


    @AndroidFindBy(id = "ProductsTabPreLaunchedButton")
    private WebElement preOrderButton;

    @AndroidFindBy(id = "ProductsTabLaunchedButton")
    private WebElement readyToDispatchedButton;


    public CatalogPublicReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void clickUploadIcon() {

    }

    public void clickSearchIcon() {
        searchButtonIcon.click();
    }

    public void clickFilterIcon() {

    }

    public void clickSortIcon() {

    }

    public void clickMyFiltersIcon() {

    }

    public void selectCatalogImage(int index) {

    }

    public boolean launchedButtonSelected() {
        return false;
    }

    public boolean preLaunchButtonIsSelected() {
        return false;
    }

    public void clickLaunchedButton() {

    }

    public void clickPreLaunchedButton() {

    }

    public boolean launchedButtonIsEnabled() {
        return false;
    }

    public boolean preLaunchedIsEnabled() {
        return false;
    }

    public void clickAvailabilityDownArrow() {

    }

    public void clickTypeDownArrow() {

    }

    public void clickCategoryDownArrow() {

    }

    public String getCategory() {
        return null;
    }

    public void clickTrendingButton() {

    }

    public void clickLatestButton() {

    }

    public void clickPriceButton() {

    }

    public boolean isAvailabilityDownArrowDisplayed() {
        return false;
    }

    public boolean isTypeDownArrowDisplayed() {
        return false;
    }

    public boolean isCategoryDownArrowDisplayed() {
        return false;
    }

    public boolean isViewDownArrowButton() {
        return false;
    }

    public void clickViewDownArrowButton() {

    }

}