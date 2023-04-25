package com.wishbook.catalog.PageObject.CatalogPublicPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;


/**
 * @see BasePageObject
 */

@SuppressWarnings("unused")

public class CatalogPublicPageObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = AndroidLocator.MYFILTERS_ICON)
    private WebElement myFilterIcon;

    @AndroidFindBy(id = AndroidLocator.UPLOAD_CATALOGS)
    private WebElement uploadCatalogIcon;

    @AndroidFindBy(id = AndroidLocator.SEARCH_BUTTON)
    private WebElement searchButtonIcon;

    @AndroidFindBy(id = AndroidLocator.FILTER_ICON)
    private WebElement filterButtonIcon;

    @AndroidFindBy(id = AndroidLocator.SORT_ICON)
    private WebElement sortIcon;

    @AndroidFindBy(id = AndroidLocator.SHARE_CATALOG_ICON)
    private WebElement catalogShare;

    @AndroidFindBy(id = AndroidLocator.RECYCLER_VIEW)
    private WebElement recyclerView;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_sold_by")
    private WebElement soldByCompanyName;

    @AndroidFindBy(id = AndroidLocator.TRUSTED_SELLER_ONLY)
    private WebElement trustedSellerButton;

    @AndroidFindBy(id = AndroidLocator.PRE_ORDER_BUTTON)
    private WebElement preOrderButton;

    @AndroidFindBy(id = AndroidLocator.READY_TO_DISPATCH)
    private WebElement readyToDispatchedButton;


    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_filter_availability")
    private WebElement availability;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_filter_catalog")
    private WebElement type;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_filter_category")
    private WebElement category;


    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_sort_trending")
    private WebElement trendingButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_sort_latest")
    private WebElement latestButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_sort_price")
    private WebElement priceButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_collection_type_value")
    private WebElement viewArrowDown;

    //endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public CatalogPublicPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region services

    public void clickUploadIcon() {
        uploadCatalogIcon.click();
    }

    public boolean trustedSellerIsDisplayed() {
        return getDriver().findElements(By.id(AndroidLocator.TRUSTED_SELLER_ONLY)).size() > 0;
    }

    public void clickSearchIcon() {
        searchButtonIcon.click();
    }

    public void clickFilterIcon() {
        filterButtonIcon.click();
    }

    public void clickSortIcon() {
        sortIcon.click();
    }

    public void clickMyFiltersIcon() {
        getDriver().findElement(By.id(AndroidLocator.MYFILTERS_ICON)).click();
    }

    public void clickCatalogShareIcon() {
        catalogShare.click();
    }

    public void clickSoldByCompany() {
        soldByCompanyName.click();
    }

    public void clickLaunchedButton() {
        readyToDispatchedButton.click();
    }

    public void clickPreLaunchedButton() {
        preOrderButton.click();
    }

    public boolean launchedButtonIsEnabled() {
        return readyToDispatchedButton.isEnabled();

    }

    public boolean preLaunchedIsEnabled() {
        return preOrderButton.isEnabled();

    }

    public boolean launchedButtonSelected() {
        return readyToDispatchedButton.isSelected();
    }

    public boolean preLaunchButtonIsSelected() {
        return preOrderButton.isSelected();
    }


    public void clickAvailabilityDownArrow() {
        availability.click();
    }

    public void clickTypeDownArrow() {
        type.click();
    }

    public void clickCategoryDownArrow() {
        category.click();
    }


    public boolean isAvailabilityDownArrowDisplayed() {
        return availability.isDisplayed();
    }

    public boolean isTypeDownArrowDisplayed() {
        return type.isDisplayed();
    }

    public boolean isCategoryDownArrowDisplayed(){
        return category.isDisplayed();
    }


    public String getCategory() {
        return category.getText();
    }

    public void clickTrendingButton() {
        trendingButton.click();
    }

    public void clickLatestButton() {
        latestButton.click();
    }

    public void clickPriceButton() {
        priceButton.click();
    }

    public void clickViewDownArrowButton(){
        viewArrowDown.click();
    }

    public boolean isViewDownArrowButton(){
        return viewArrowDown.isDisplayed();
    }


}//endregion services


