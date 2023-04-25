package com.wishbook.catalog.PageObject.HomePage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface HomePageStrategy extends BaseStrategy {



    boolean isAppBarDisplayed();
    boolean isWishlistIconDisplayed();
    boolean isCartIconDisplayed();
    boolean isNotificationDisplayed();
    boolean isSearchBoxDisplayed();
    boolean isSliderDisplayed();
    boolean isStoriesDisplayed();
    boolean isCreditApplyDisplayed();
    boolean isLaunchedCatalogDisplayed();
    boolean isCategoriesDisplayed();












    void clickHomeWishListIcon();
    void clickApplyNowButton();
    void dismissCreditRatingDialog();
    int getWishlistCountAsShownOnToolbar();
    void clickAppBar(int index);
    int getCartCountOnMenuBadge();
    void clickAppBar();
    void clickOnSeeAllPublicBrand();
    void clickSeeAllSinglePieces();
    void  clickSeeAllNonCatalog();
    String  seeAllNonCatalogIsDisplayed();
    void clickAddNewCatalogContainer();
    void clickActiveCatalogs();
    int getWishListCountOnMenuBadge();
    void clickHomeSearchTextField();
    void clickWishlistSeeAll();
    void clickEditCreditButton();
    void clickSearch();


}
