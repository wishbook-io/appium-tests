package com.wishbook.catalog.PageObject.NavigationDrawerPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * @see BasePageObject
 */
@SuppressWarnings("unused")

public class AppBarPageObject extends BasePageObject {

    //region elements

    @SuppressWarnings("unused")
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Logout']")
    protected WebElement logOut;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Categories']")
    protected WebElement categoriesAppBar;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Join our Whatsapp Groups']")
    protected WebElement joinOurWhatsAppGroup;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Refer & Earn']")
    protected WebElement referAndEarn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Resell & Earn']")
    protected WebElement resellAndEarn;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Change Language']")
    protected WebElement changeLanguage;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Profile']")
    protected WebElement profile;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Wishbook Bank Details']")
    protected WebElement wishbookBankDetails;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Contact Us']")
    protected WebElement contactUs;










    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.NO)
    protected WebElement Yes;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.NAVIGATION_VIEW)
    private WebElement navigationView;


    @SuppressWarnings("unused")
   @AndroidFindBy(xpath = AndroidLocator.MORE_TAB_LOG_OUT)
   private WebElement moreTablogOut;


    @SuppressWarnings("unused")
   @AndroidFindBy(xpath = AndroidLocator.CHANGE_PASSWORD)
   private WebElement changePassword;

    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public AppBarPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region  services

    public void clickChangePassword() {
        changePassword.click();
    }



    public void clickMoreTabLogout() {
        moreTablogOut.click();
        Yes.click();
    }

    public void clickCategories() {
        categoriesAppBar.click();
    }

    //endregion

}
