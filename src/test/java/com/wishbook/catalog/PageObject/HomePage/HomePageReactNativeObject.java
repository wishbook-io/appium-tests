package com.wishbook.catalog.PageObject.HomePage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePageReactNativeObject extends BasePageObject implements HomePageStrategy {


    //region elements
    @AndroidFindBy(accessibility = "HomeScreenWishlistButton")
    private WebElement wishListIcon;

    @AndroidFindBy(accessibility = "HomeScreenCartButton")
    private WebElement cartIcon;

    @AndroidFindBy(accessibility = "HomeScreenNotificationButton")
    private WebElement notificationIcon;

    @AndroidFindBy(accessibility = "HomeScreenMenuButton")
    private WebElement appbar;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"HomeScreenSearchInput\"]/android.widget.TextView")
    private WebElement homePageSearchTextField;

    public HomePageReactNativeObject(TestCase testCase) {
        super(testCase);
    }

  public  void clickAppBar(){
        appbar.click();
  }


    public void enterProductNameToBeSearch(String productName){
        homePageSearchTextField.sendKeys(productName);
        ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
    }


    public void clickHomeSearchTextField() {
        homePageSearchTextField.click();
    }


    public boolean isAppBarDisplayed() {
        return false;
    }

    public boolean isWishlistIconDisplayed() {
        return false;
    }

    public boolean isCartIconDisplayed() {
        return false;
    }

    public boolean isNotificationDisplayed() {
        return false;
    }

    public boolean isSearchBoxDisplayed() {
        return false;
    }

    public boolean isSliderDisplayed() {
        return false;
    }

    public boolean isStoriesDisplayed() {
        return false;
    }

    public boolean isCreditApplyDisplayed() {
        return false;
    }

    public boolean isLaunchedCatalogDisplayed() {
        return false;
    }

    public boolean isCategoriesDisplayed() {
        return false;
    }

    public void clickHomeWishListIcon() {

    }

    public void clickApplyNowButton() {

    }

    public void dismissCreditRatingDialog() {

    }

    public int getWishlistCountAsShownOnToolbar() {
        return 0;
    }

    public void clickAppBar(int index) {
        appbar.click();

    }

    public int getCartCountOnMenuBadge() {
        return 0;
    }

    public void clickOnSeeAllPublicBrand() {

    }

    public void clickSeeAllSinglePieces() {

    }

    public boolean nonCatalogBannerIsDisplayed() {
        return false;
    }

    public void clickSeeAllNonCatalog() {

    }

    public String seeAllNonCatalogIsDisplayed() {
        return null;
    }

    public void clickAddNewCatalogContainer() {

    }

    public void clickActiveCatalogs() {

    }


    public int getWishListCountOnMenuBadge() {
        return 0;
    }



    public boolean isCartIconPresent() {
        return cartIcon.isDisplayed();
    }

    public boolean requestFeedbackAndImproveCreditRatingIsDisplayed() {
        return false;
    }

    public boolean mostViewedCatalogs7DaysIsDisplayed() {
        return false;
    }

    public boolean mostSoldCatalogs30DaysIsDisplayed() {
        return false;
    }

    public boolean fromYourWishListIsDisplayed() {
        return false;
    }

    public boolean wishBookStoriesTextIsDisplyed() {
        return false;
    }

    public boolean storiesRecyclerViewIsDisplayed() {
        return false;
    }

    public boolean categoriesRecyclerViewIsDisplayed() {
        return false;
    }

    public boolean deeplinkIsDisplayed() {
        return false;
    }

    public boolean publicCatalogIsDisplayed() {
        return false;
    }

    public boolean bannerFirstIsDisplayed() {
        return false;
    }

    public boolean trustedSallerIsDisplayed() {
        return false;
    }

    public boolean bannerSecondIsDisplayed() {
        return false;
    }

    public boolean followedByMeIsDisplayed() {
        return false;
    }

    public boolean bannerThirdIsDisplayed() {
        return false;
    }

    public boolean wishListIconIsDisplayed() {
        return false;
    }

    public boolean searchButtonIsDisplayed() {
        return false;
    }

    public boolean chatIconIsDisplayed() {
        return false;
    }

    public boolean imageSliderIsDisplayed() {
        return false;
    }

    public boolean appBarIsDisplayed() {
        return false;
    }

    public boolean applyNowButtonIsDisplayed() {
        return false;
    }

    public boolean isWishListPresent() {
        return false;
    }

    public boolean isApplyNowElementPresent() {
        return false;
    }

    public boolean myCatalogIsDisplayed() {
        return false;
    }

    public boolean totalFollowersIsDisplayed() {
        return false;
    }

    public boolean catalogUnderTopMostViewedCatalogsInLast7Days() {
        return false;
    }

    public boolean viewsOnYourLatestCatalog() {
        return false;
    }

    public boolean bannerFifthIsDisplayed() {
        return false;
    }

    public boolean bannerFourthIsDisplayed() {
        return false;
    }

    public void enableCatalogContainer() {

    }

    public void recentlyViewedCatalogsIsDisplayed() {

    }

    public void clickSeeAllReceivedCatalog() {

    }

    public void clickAddToCartIcon() {

    }

    public void clickNotificationIcon() {

    }

    public String getNotificationEmptyMessage() {
        return null;
    }

    public void clickNotNowBackgroundPermissionCreditRating() {

    }

    public boolean notificationIconIsDisplay() {
        return false;
    }

    public boolean addToCartIsDisplayed() {
        return false;
    }

    public void clickWishlistSeeAll() {

    }

    public void clickEditCreditButton() {

    }

    public void clickSearch() {

    }
}



