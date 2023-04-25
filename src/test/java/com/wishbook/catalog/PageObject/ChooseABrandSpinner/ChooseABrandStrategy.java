package com.wishbook.catalog.PageObject.ChooseABrandSpinner;

public interface ChooseABrandStrategy {
    String getBrandNameSpinner(int index);
    void clickONBrandNameFromSpinner(int index);
    void selectBrandByName(String text);
}
