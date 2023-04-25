package com.wishbook.catalog.PageObject.ProfilePage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePageAndroidObject extends ProfilePageObject implements ProfilePageStrategy {
    public ProfilePageAndroidObject(TestCase testCase) {
        super(testCase);
    }


    public void enterName(String enterName) {
        WebElement e = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",6);
        e.clear();
        e.sendKeys(enterName);
    }

    public String getEnteredName(){
        WebElement e = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",6);
        return e.getText();

    }
    public void enterCompanyName(String companyname) {
        WebElement e = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",7);
        e.clear();
        e.sendKeys(companyname);
    }

    public String getCompananyName(){
        WebElement e = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",7);
        return e.getText();
    }

    public void enterPhoneNumber(String num) {
        WebElement e = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",8);
        e.clear();
        e.sendKeys(num);
    }

    public String getPhoneNumber() {
        WebElement e = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",8);
        return e.getText();
    }

    public void enterEmailId(String emailid) {
        WebElement e = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",9);
        e.clear();
        e.sendKeys(emailid);
    }

    public String getEmailId() {
        return AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",9).getText();
    }


    public void enterAddress(String address){
        WebElement e = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",10);
        e.clear();
        e.sendKeys(address);

    }

    public String getAddress(){
        return  AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",10).getText();

    }

    public void selectState(String state) {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.Spinner",2).click();

        state = String.format("//android.widget.TextView[@text=\"%1$s\"]", state);
        AndroidHelper.getScrollableItem(By.xpath(state),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver()).click();
    }

    public String getCity() {

        return AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.TextView",8).getText();


    }

    public void selectCity(String city) {
         AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.Spinner",3).click();

        city = String.format("//android.widget.TextView[@text=\"%1$s\"]", city);
        AndroidHelper.getScrollableItem(By.xpath(city),
                AndroidHelper.ScrollDirection.Down,
                1, (AndroidDriver) getDriver()).click();

    }



    public String getState() {
        return AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.TextView",6).getText();

    }



    public void enterPincode(int pincode){
       AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(),0,"com.wishbook.catalog:id/txt_manage_address");
        WebElement e = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",9);
        e.clear();
        e.sendKeys(String.valueOf(pincode));

    }
    public int getPincode(){
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(),0,"com.wishbook.catalog:id/txt_manage_address");
        WebElement e = AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, "android.widget.EditText",9);
        String element=e.getText();
        return Integer.valueOf(element.replaceAll("[^0-9]", ""));
    }

    public void enterGSTNumber(long GST){
        WebElement e = AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(),0,"com.wishbook.catalog:id/edit_gst");
        e.clear();
        e.sendKeys(String.valueOf(GST));
    }


    public String getGst() {
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(),0,"com.wishbook.catalog:id/txt_manage_address");
        WebElement e = AndroidHelper.getScrollableItemByResourceId((AndroidDriver) getDriver(),0,"com.wishbook.catalog:id/edit_gst");
        return  e.getText();
    }


    public void clickSaveChanges() {
        saveChangeButton.click();
    }

}
