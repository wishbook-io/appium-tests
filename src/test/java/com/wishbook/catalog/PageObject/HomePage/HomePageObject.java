package com.wishbook.catalog.PageObject.HomePage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;



public class HomePageObject extends BasePageObject {


    //region elements

    @AndroidFindBy(id = "com.wishbook.catalog:id/appbar")
    private WebElement appBar;

    @AndroidFindBy(id = "com.wishbook.catalog:id/action_wishlist")
    private WebElement wishlistIcon;

    @AndroidFindBy(id = "com.wishbook.catalog:id/cart")
    private WebElement cartIcon;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_home_search")
    private WebElement searchTextBox;

    @AndroidFindBy(id = "com.wishbook.catalog:id/action_notification")
    private WebElement notificationIcon;

    @AndroidFindBy(id = "com.wishbook.catalog:id/imageView")
    private WebElement sliderBanner;

    @AndroidFindBy(id = "com.wishbook.catalog:id/recycler_view_stories")
    private WebElement wishbookStories;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_apply_credit")
    private WebElement applyCreditButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/recycler_view_category")
    protected  WebElement categoriesImages;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_apply_credit")
    protected WebElement creditApplyButton;






    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public HomePageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion




    //region is elements displaying

    public boolean isAppBarDisplayed(){
        return appBar.findElement(By.className("android.widget.ImageButton")).isDisplayed();
    }

    public boolean isWishlistIconDisplayed(){ return wishlistIcon.isDisplayed(); }

    public boolean isCartIconDisplayed(){return  cartIcon.isDisplayed();}

    public boolean isNotificationDisplayed(){ return notificationIcon.isDisplayed();}

    public boolean isSearchBoxDisplayed(){return searchTextBox.isDisplayed();}

    public boolean isSliderDisplayed(){ return sliderBanner.isDisplayed();}

    public boolean isStoriesDisplayed() { return wishbookStories.isDisplayed(); }





    //endregion

























    public int getWishlistCountAsShownOnToolbar() {
        WebElement element= wishlistIcon.findElement(By.className("android.widget.TextView"));
        String e=element.getText();
        return Integer.valueOf(e); }

    public int getWishListCountOnMenuBadge() {
        return Integer.parseInt(wishlistIcon.findElement(By.className(AndroidLocator.WIDGET_TEXT_VIEW)).getText());
    }

    public int getCartCountOnMenuBadge() {
        return Integer.parseInt(cartIcon.findElement(By.className(AndroidLocator.WIDGET_TEXT_VIEW)).getText());
    }

    public void clickAppBar(int index) {
        List<WebElement> elements = appBar.findElements(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON));
        if (elements != null && index >= 0 && index < elements.size()) {
            elements.get(index).click();
        }
    }
    public void clickAppBar(){
        appBar.click();}

    public void clickHomeWishListIcon() { wishlistIcon.click();}


    public void recentlyViewedCatalogsIsDisplayed() {
        TouchAction action = new TouchAction((PerformsTouchActions) getDriver());
        PointOption topElement = getDriver().findElement(By.id(AndroidLocator.IMAGE_VIEW_SLIDER_ADD));
        PointOption element = getDriver().findElement(By.id(AndroidLocator.RECENTLY_VIEWED_CATALOGS));
        action.longPress(element).moveTo(topElement).release().perform();
    }

    @SuppressWarnings("unused")
    public boolean isCartIconPresent() {
        return getDriver().findElements(By.id(AndroidLocator.CART_ICON)).size() > 0;
    }


    public void clickAddToCartIcon() {
        cartIcon.click();
    }

    public void clickNotificationIcon() {
        notificationIcon.click();
    }

    public String getNotificationEmptyMessage() {
        return null;//getEmptyNotificationMessage.getText();
    }

    public void clickNotNowBackgroundPermissionCreditRating() {

       // notNowCreditRatingBackgroundPermission.click();
    }

   public boolean notificationIconIsDisplay() {
        return notificationIcon.isDisplayed();
   }

    public boolean addToCartIsDisplayed() {
        return getDriver().findElements(By.id(AndroidLocator.CART_ICON)).size() > 0;
    }
    public void dismissCreditRatingDialog(){
        //Handle Credit rating dialog that appears on specific devices like Xiaomi,Vivo etc.
        try {
            Thread.sleep(5000);
            clickNotNowBackgroundPermissionCreditRating();
        }catch (Exception e){

        }
    }

    public void clickHomeSearchTextField(){
        getDriver().findElement(By.id("com.wishbook.catalog:id/txt_home_search")).click();
    }

    public void clickSearch(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.id("com.wishbook.catalog:id/txt_home_search")).click();

    }


    //endregion

}
