package com.wishbook.catalog.PageObject.ShareCatalogPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShareCatalogPageAndroidObject extends ShareCatalogPageObject implements ShareCatalogPageStrategy {
    public ShareCatalogPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    @SuppressWarnings("unused")
    public void individualShareButton() {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_TEXT_VIEW, 2).click();
    }
    @SuppressWarnings("unused")
    public void groupSharingButton() {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_TEXT_VIEW, 1).click();

    }
    @SuppressWarnings("unused")
    public void selectGroupTab(){
        selectTab(0);
    }
    @SuppressWarnings("unused")
    public void selectIndividualTab(){
        selectTab(1);
    }
    private void selectTab(int position){
        List<WebElement> elements = getDriver().findElements(By.className("android.support.v7.app.ActionBar$Tab"));
        if(elements!=null){
            int size = elements.size();
            if(position>=0 && position<size){
                elements.get(position).click();
            }
        }
    }


}