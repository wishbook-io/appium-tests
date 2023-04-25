package com.wishbook.catalog.PageObject.AddFabricPage;

public interface AddFabricPageStrategy {
    void clickSave();
    void selectFabricItems(int instance);
    String getFabricItem(int index);
    void clickFabricCheckBoxByText(String fabric);
}
