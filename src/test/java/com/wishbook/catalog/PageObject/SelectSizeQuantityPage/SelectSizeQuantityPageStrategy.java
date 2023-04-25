package com.wishbook.catalog.PageObject.SelectSizeQuantityPage;

public interface SelectSizeQuantityPageStrategy {

    String getKurtiSize(int index);
    void clickDoneButton();
    void increaseKurtiSizeQuantity(int index);
}
