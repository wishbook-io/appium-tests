package com.wishbook.catalog.PageObject.SelectCategorySpinner;

public interface SelectCategorySpinnerStrategy {
    void selectCategoryItem(int index);
    String getCategoryItem(int index);
    void selectCategoryByName(String text);

}
