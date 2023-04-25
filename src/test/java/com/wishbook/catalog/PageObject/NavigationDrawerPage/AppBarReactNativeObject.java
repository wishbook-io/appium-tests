package com.wishbook.catalog.PageObject.NavigationDrawerPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class AppBarReactNativeObject extends BasePageObject implements AppBarPageStrategy {

    @AndroidFindBy(accessibility = "MenuSideBarLogoutButton")
    private WebElement logout;

    @AndroidFindBy(accessibility = "MenuSideBarChangePasswordButton")
    private WebElement changePassword;

    @AndroidFindBy(accessibility = "MenuSideBarProfileButton")
    private WebElement profile;

    @AndroidFindBy(accessibility = "MenuSideBarCategoriesButton")
    private WebElement category;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Yes']")
    protected WebElement Yes;

    public AppBarReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void clickLogout() {
        logout.click();
        Yes.click();
    }

    public void clickMoreTabLogout() {

    }

    public void clickChangePassword() {
        changePassword.click();

    }

    public void clickCategories() {
        category.click();

    }

    public void clickProfile() {
      profile.click();
    }

    public void clickJoinOurWhatsAppGroup() {

    }

    public void clickResellAndEarn() {

    }

    public boolean earnResellDisplayed() {
        return false;
    }

    public void clickReferAndEarn() {

    }

    public void clickLanguage() {

    }

    public void clickWishbookBankDetails() {

    }

    public void clickContactUs() {

    }

    public void clickFaq() {

    }

    public void clickAboutUs() {

    }
}
