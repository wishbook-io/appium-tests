package com.wishbook.catalog.PageObject.MyBusinessPage;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.WeakHashMap;

public class MyBusinessPageReactNativeObject extends BasePageObject implements MyBusinessPageStrategy {

    @AndroidFindBy(accessibility = "an")
    private WebElement wishbookMoneyIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"MyBusinessAddProductButton\"]")
    private WebElement addProductButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='\uF110']")
    private WebElement cartIcon;

    public MyBusinessPageReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void clickRegisterNowButton() {

    }

    public void clickDiscountSettingsButton() {

    }

    public int getWishListAsShownInMyBusiness() {
        return 0;
    }

    public void clickProfileLogo() {

    }

    public void clickWishListMyBusiness() {

    }

    public void clickMyCatalogs() {

    }

    public void clickApplyNowButton() {

    }

    public void clickMyNetwork() {

    }

    public void clickRejectedBuyersButton() {

    }

    public String getCompanyName() {
        return null;
    }

    public boolean isElementPresent() {
    return true;
    }

    public void clickRejectedSuppliersButton() {

    }

    public void clickMyOrdersMyBusiness() {

    }

    public String getTextCompanyName() {
        return null;
    }

    public Boolean IsRegistrationButtonDisplay() {
        return null;
    }

    public void clickMyViewersButton() {

    }

    public Boolean myViewerIsDisplayed() {
        return null;
    }

    public boolean isCartIconPresent() {
        return cartIcon.isDisplayed();
    }

    public void clickAddCatalogButton() {
        addProductButton.click();

    }

    public void clickKycBankDetails() {

    }

    public void clickWBMoney() {

    }

    public boolean resellerHubIsDisplayed() {
        return false;
    }

    public void clickRewardPointsIcon() {

    }

    public String getUserNameOnBusinessTab() {
        return null;
    }

    public String getUserCompanyNameOnBusinessTab() {
        return null;
    }

    public String getCompanyType() {
        return null;
    }
}
