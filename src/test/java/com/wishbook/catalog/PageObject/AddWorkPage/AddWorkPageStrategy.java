package com.wishbook.catalog.PageObject.AddWorkPage;

public interface AddWorkPageStrategy {
    void selectWorkItems(int instance);
    String getWorkItem(int index);
    void clickSave();
    void clickWorkCheckBoxByText(String work);
}
