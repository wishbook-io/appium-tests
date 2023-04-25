package com.wishbook.catalog.PageObject.MyFilterPage;

import com.wishbook.catalog.PageObject.Core.BaseStrategy;

public interface MyFilterPageStrategy extends BaseStrategy {
    void clickCloseMyFilters();
    void chooseMyFilterAt(int index);
    void deleteFilterAt(int index);
    void clickClearAll();
    String getMyFiltersTitle();
    String getSavedFilterName();

}
