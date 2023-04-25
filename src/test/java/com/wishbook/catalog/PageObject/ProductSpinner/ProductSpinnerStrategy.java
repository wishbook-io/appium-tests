package com.wishbook.catalog.PageObject.ProductSpinner;

public interface ProductSpinnerStrategy  {

    void clickCatalogTypeSpinner();
    void clickNonCatalogSpinner();
    String getNonCatalogText();
    String getCatalogAndNonCatalogText();
    void selectProductTypeSpinner(int index);
    void selectProductTypeSpinnerAtProductTab(int index);
}
