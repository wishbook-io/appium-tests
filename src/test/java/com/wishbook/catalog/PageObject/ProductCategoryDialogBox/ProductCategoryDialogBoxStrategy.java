package com.wishbook.catalog.PageObject.ProductCategoryDialogBox;

public interface ProductCategoryDialogBoxStrategy {
    void selectProductCategoriesByName(String text);
    void clickCloseButtonProductCategory();
    String getProductCategoryTitle();
}
