package com.wishbook.catalog.PageObject.SearchPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface SearchPageStrategy extends BaseStrategy {

    void searchCatalogName(String searchItem);
    void noSuggestions(String searchItem);
    void clickSearchBackButton();
    void selectCatalogImage(int index);
    String noDataFoundText();
    void BackHomeSearchButton();
    void closeSearchTextField();
    void clearSearchTextField();
    String noDataFoundTextLead();
    void clickSearchedProduct();
    void clickOnSuggestionBox();
    void clickWishlistIconOnSearchedProduct();


}
