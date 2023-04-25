package com.wishbook.catalog.PageObject.NavigationDrawerPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AppBarPageAndroidObject extends AppBarPageObject implements AppBarPageStrategy {
    public AppBarPageAndroidObject(TestCase testCase) {
        super(testCase);
    }



    public void clickLogout() {
        logOut.click();
        Yes.click();
    }
    public void clickProfile() {
        AndroidHelper.getScrollableItemByClassName((AndroidDriver)getDriver(),0, AndroidLocator.WIDGE_CHECKED_TEXT_VIEW,5).click();

    }

    public void clickCategories(){
        categoriesAppBar.click();

    }

    public void clickJoinOurWhatsAppGroup(){
        joinOurWhatsAppGroup.click();
    }

    public void clickReferAndEarn(){
        referAndEarn.click();
    }

    public void clickResellAndEarn(){
       resellAndEarn.click();
    }

    public void clickLanguage(){
     changeLanguage.click();
    }


   public void clickWishbookBankDetails(){
      wishbookBankDetails.click();
   }

   public void clickContactUs(){
      contactUs.click();
   }

   public void clickFaq(){
       WebElement element = AndroidHelper.getScrollableItem(By.xpath("//android.widget.CheckedTextView[@text='FAQ']"),
               AndroidHelper.ScrollDirection.Down,
               1,(AndroidDriver)getDriver());
       element.click();
   }
    public void clickAboutUs(){
        WebElement element = AndroidHelper.getScrollableItem(By.xpath("//android.widget.CheckedTextView[@text='About Us']"),
                AndroidHelper.ScrollDirection.Down,
                1,(AndroidDriver)getDriver());
        element.click();
    }

    public boolean earnResellDisplayed(){
        return  resellAndEarn.isDisplayed();
    }


}
