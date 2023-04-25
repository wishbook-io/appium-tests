package com.wishbook.catalog.PageObject.MyBusinessPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

@SuppressWarnings("unused")

public class MyBusinessPageObject extends BasePageObject {

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.FOLLOW_TEXT)
    protected WebElement brandIFollowCount;
    //region elements
    @AndroidFindBy(id = AndroidLocator.GETTEXT_PROFILE_LOGO)
    private WebElement profileLogo;
    @SuppressWarnings("unused")
    @AndroidFindBy(xpath = AndroidLocator.MY_COMPANY_LOGO)
    private WebElement myCompanyLogo;
    @SuppressWarnings("unused")
    @AndroidFindBy(xpath = AndroidLocator.MY_BRANDS_LOGO)
    private WebElement myBrandLogo;
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.REGISTER_BUTTON)
    private WebElement registerButton;
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.DONE_BUTTON)
    private WebElement doneButton;
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.BRAND_I_FOLLOW)
    private WebElement brandIFollow;
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.MY_CATALOGS_MY_BUSINESS)
    private WebElement myCatalogs;
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.GETTEXT_USERNAME_FULLNAME)
    private WebElement userNameText;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.GETTEXT_COMPANY_NAME)
    private WebElement companyNameText;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.BRAND_I_SELL_MYBUSINESS)
    private WebElement brandIsell;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.WISHLIST_MY_BUSINESS)
    private WebElement wishlistMyBusiness;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.CREDIT_RATING_BUTTON)
    private WebElement creditRatingButton;

    @AndroidFindBy(id = AndroidLocator.MY_NETWORK)
    private WebElement myNetwork;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.MY_ORDERS_BUSINESS)
    private WebElement myOrdersMyBusiness;


    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_companyname")
    private WebElement companyNameGetText;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.MY_VIEWERS_BUTTON)
    private WebElement myViewersButton;

    @AndroidFindBy(id = AndroidLocator.DISCOUNT_SETTINGS_MY_BUSINESS)
    private WebElement discountSettingsButton;

    @AndroidFindBy(id = AndroidLocator.ADD_CATALOG_IN_MY_BUSINESS)
    private WebElement addCatalogInMyBusiness;

    @AndroidFindBy(id = "com.wishbook.catalog:id/linear_reseller")
    private WebElement resellerHub;

    @AndroidFindBy(id = "com.wishbook.catalog:id/settings_reward_points")
    private WebElement rewardPoints;

    @AndroidFindBy(xpath = "//android.widget.Switch[@text='ON']")
    private WebElement switchOn;

    @AndroidFindBy(xpath = "//android.widget.Switch[@text='OFF']")
    private WebElement switchOff;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_firstname")
    private WebElement userNameAppearingOnMyBusiness;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_companyname")
    private WebElement userCompanyNameOnMyBusiness;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_companytype")
    private WebElement companyType;



    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public MyBusinessPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  services
    public void clickMyCompanyIcon() {
        myCompanyLogo.click();
    }

    public void clickMyBrandsIcon() {
        brandIsell.click();
    }

    public void clickRegisterNowButton() {
        registerButton.click();
    }

    public void clickDone() {
        doneButton.click();
    }

    public void clickBrandIFollow() {
        brandIFollow.click();
    }

    public void clickProfileLogo() {
        profileLogo.click();
    }

    public void clickMyCatalogs() {
        myCatalogs.click();
    }

    public void clickApplyNowButton() {
        creditRatingButton.click();
    }

    public String getCompanyName() {
        return companyNameText.getText();
    }

    public boolean isElementPresent() {
       return getDriver().findElement(By.id(AndroidLocator.CREDIT_RATING_BUTTON)).isDisplayed();
    }

    public void clickMyOrdersMyBusiness() {
        myOrdersMyBusiness.click();
    }

    public String getTextCompanyName() {
        return companyNameGetText.getText();
    }

    public Boolean IsRegistrationButtonDisplay() {
        WebElement element = registerButton;
        Boolean v = element.isDisplayed();
        System.out.println("RegistrationButtonIsAvailable = " + v);
        return v;
    }

    public void clickMyViewersButton() {
        myViewersButton.click();
    }

    public Boolean myViewerIsDisplayed() {
        return myViewersButton.isDisplayed();
    }

    public boolean isCartIconPresent() {
        return getDriver().findElements(By.id(AndroidLocator.CART_ICON)).size() > 0;
    }

    public void clickDiscountSettingsButton() {
        discountSettingsButton.click();
    }

    public void clickAddCatalogButton(){
        AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,AndroidLocator.ADD_CATALOG_IN_MY_BUSINESS).click();
    }

    public boolean resellerHubIsDisplayed() {
        return resellerHub.isDisplayed();
    }


   public void clickRewardPointsIcon(){
        rewardPoints.click();
   }

   public void toggleOffForRetailerOrder(){
       boolean switchOffText=Boolean.parseBoolean(switchOff.getText());
       boolean switchOnText= Boolean.parseBoolean(switchOn.getText());

       if(switchOffText==true){
        boolean f= switchOn.isDisplayed();
       }
       else
        if(switchOnText==true){
            switchOn.click();
            PopUpPageStrategy popUpPageStrategy= PopUpPageFactory.getStrategy(testCase);
            popUpPageStrategy.clickOk();
        }

   }

   public String getUserNameOnBusinessTab(){
        return userNameAppearingOnMyBusiness.getText();
   }

   public String getUserCompanyNameOnBusinessTab(){
        return userCompanyNameOnMyBusiness.getText();
   }


   public String getCompanyType(){
      return   companyType.getText();
   }


}//endregion
