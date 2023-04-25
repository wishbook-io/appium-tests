package com.wishbook.catalog.PageObject.FilterPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FilterPageAndroidObject extends FilterPageObject implements FilterPageStrategy {

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.PID + "recycler_view")
    private WebElement RecyclerViewElement;


    public FilterPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void selectCategoryByName(String name) {
        name = String.format("//android.widget.RadioButton[@text=\"%1$s\"]", name);
        AndroidHelper.getScrollableItem(By.xpath(name),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver()).click();
    }


    public void selectBrandByName(String name) {
        name = String.format("//android.widget.CheckBox[@text=\"%1$s\"]", name);
        AndroidHelper.getScrollableItem(By.xpath(name),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver()).click();    }


    public void selectFabricByName(String name) {
        name = String.format("//android.widget.CheckBox[@text=\"%1$s\"]", name);
        AndroidHelper.getScrollableItem(By.xpath(name),
                AndroidHelper.ScrollDirection.Down,
                2, (AndroidDriver) getDriver()).click();     }

    public void selectWorkByName(String name) {
        name = String.format("//android.widget.CheckBox[@text=\"%1$s\"]", name);
        AndroidHelper.getScrollableItem(By.xpath(name),
                AndroidHelper.ScrollDirection.Down,
                3, (AndroidDriver) getDriver()).click();
    }

    public void selectPriceAtIndex(int index) {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver) getDriver(), 0, AndroidLocator.WIDGET_CHECK_BOX, index).click();
    }

   public void selectSizeByName(String name){
        sizeButton.click();
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       name = String.format("//android.widget.CheckBox[@text=\"%1$s\"]", name);
       AndroidHelper.getScrollableItem(By.xpath(name),
               AndroidHelper.ScrollDirection.Down,
               1, (AndroidDriver) getDriver()).click();
   }
   public void selectStateByName(String name){
       name = String.format("//android.widget.CheckBox[@text=\"%1$s\"]", name);
       AndroidHelper.getScrollableItem(By.xpath(name),
               AndroidHelper.ScrollDirection.Down,
               1, (AndroidDriver) getDriver()).click();
   }

   public void selectStyleByName(String name){
       name = String.format("//android.widget.RadioButton[@text=\"%1$s\"]", name);
       AndroidHelper.getScrollableItem(By.xpath(name),
               AndroidHelper.ScrollDirection.Down,
               1, (AndroidDriver) getDriver()).click();
   }

   public void selectStitchByName(String name){
        stitchedButton.click();
       name = String.format("//android.widget.RadioButton[@text=\"%1$s\"]", name);
        AndroidHelper.getScrollableItem(By.xpath(name),
               AndroidHelper.ScrollDirection.Down,
               1, (AndroidDriver) getDriver()).click();
   }



}


