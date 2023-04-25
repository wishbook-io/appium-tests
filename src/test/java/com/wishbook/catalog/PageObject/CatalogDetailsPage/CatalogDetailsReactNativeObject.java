package com.wishbook.catalog.PageObject.CatalogDetailsPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CatalogDetailsReactNativeObject extends BasePageObject implements CatalogDetailsPageStrategy {





    @AndroidFindBy(accessibility = "ProductDetailScreenAddToWishlistButton")
    protected WebElement wishList;

    @AndroidFindBy(accessibility = AndroidLocator.CATALOG_TITLE)
    protected WebElement catalogTitle;

    @AndroidFindBy(accessibility = "ProductDetailScreenShareButton")
    private WebElement shareCatalogIcon;

    @AndroidFindBy(accessibility = "ProductDetailScreenFollowButton")
    private WebElement follow;
//
//    @AndroidFindBy(accessibility = "")
//    private WebElement becomeSellerOfThisCatalog;

    @AndroidFindBy(accessibility = "ProductDetailScreenAddOrGoToCartButton")
    private WebElement addToCartButton;

//    @AndroidFindBy(accessibility = "")
//    private WebElement stopSelling;

    @AndroidFindBy(accessibility = "ProductDetailScreenWorkText")
    private WebElement workText;

    @AndroidFindBy(accessibility = "ProductDetailScreenFabricText")
    private WebElement fabricText;

    @AndroidFindBy(className = AndroidLocator.BACK_PROFILE)
    private WebElement backToPublicCatalogPage;

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;



    @AndroidFindBy(id = AndroidLocator.PRICE_TEXT)
    private WebElement priceText;

    @AndroidFindBy(id = AndroidLocator.DISABLED_BY_SUPPLIER_TEXT)
    private WebElement disabledBySupplierText;

    @AndroidFindBy(id = "ProductDetailScreenShareButton")
    private WebElement shareButtonCatalogDetails;

    @AndroidFindBy(id = "ProductDetailScreenSendEnquiryButton")
    private WebElement sendEnquiryButton;



    @AndroidFindBy(id = AndroidLocator.BRAND_NAME_TEXT)
    private WebElement getBrandNameText;

    @AndroidFindBy(id = AndroidLocator.Number_Of_Design_Text)
    private WebElement getNumberOfDesign;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_sold_by")
    private WebElement soldByLinkText;

    @AndroidFindBy(id = "com.wishbook.catalog:id/btn_enable_disable")
    private WebElement startSellingAgain;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_empty_msg")
    private WebElement noCatalogToDisplay;

    @AndroidFindBy(accessibility = "ProductDetailScreenCartButton")
    private WebElement addToCartIcon;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_price")
    private WebElement getTextPrice;

    @AndroidFindBy(id = "com.wishbook.catalog:id/prod_sku")
    private WebElement productSku;

    @AndroidFindBy(id = "com.wishbook.catalog:id/back")
    private WebElement backToCatalogDetails;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_single_piece_price")
    private WebElement getSinglePiecePrice;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_price")
    private WebElement getFullCatalogPrice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='ProductDetailScreenProductNameText']")
    private WebElement catalogName;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_category")
    private WebElement categoryName;

    @AndroidFindBy(id = AndroidLocator.EDIT_SET_SCREEN)
    private WebElement editSetButton;

    @AndroidFindBy(id = AndroidLocator.ADD_SET_SCREEN)
    private WebElement addSetButton;


    public CatalogDetailsReactNativeObject(TestCase testCase) {
        super(testCase);
    }

    public void clickStopSelling() {

    }

    public void clickFollowButton() {

    }

    public String getProductNameInMyProduct() {
        return null;
    }

    public void clickAddToCartButton() {
       getDriver().findElement(MobileBy.ByAccessibilityId.AccessibilityId("ProductDetailScreenAddOrGoToCartButton")).click();
    }

    public void clickWishListButton() {

    }

    public String getFabricText() {
        return null;
    }

    public String getWorkText() {
        return null;
    }

    public String getCatalogName() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return catalogName.getText();
    }

    public String getTextReadyToShipOnProductDetailsPage() {
        return null;
    }

    public String getTextPreOrderOnProductDetailsPage() {
        return null;
    }

    public String getCatalogTitle() {
        return null;
    }

    public String getProductCategory() {
        return null;
    }

    public boolean setEditScreenButtonIsDisplay() {
        return false;
    }

    public boolean setAddScreenButtonIsDisplayed() {
        return false;
    }

    public void clickEditSetButton() {

    }

    public void clickAddSetButton() {

    }

    public int getFullCatalogPriceForProductsText() {
        return 0;
    }

    public int getSinglePcsForProductText() {
        return 0;
    }

    public String getCatalogNameOnMyProduct() {
        return null;
    }

    public void BackCatalogButton() {

    }

    public void wishListSelected() {

    }

    public void clickShareButtonCatalogsDetails() {

    }

    public Boolean shareButtonIsDisplayed() {
        return null;
    }

    public void sendEnquiryButton() {
        getDriver().findElement(MobileBy.ByAccessibilityId.AccessibilityId("ProductDetailScreenSendEnquiryButton")).click();

    }

    public Boolean ChatWithSupplierButtonIsDisplayed() {
        return null;
    }

    public boolean stopSellingButtonIsDisplayed() {
        return false;
    }

    public String getBrandNameText() {
        return null;
    }

    public boolean isFollowButtonPresent() {
        return false;
    }

    public boolean isAddToCartButtonPresent() {
        return false;
    }

    public boolean isWishListButtonPresent() {
        return false;
    }

    public boolean isShareButtonPresent() {
        return false;
    }

    public boolean isBecomeASellerOfThisCatalogPresent() {
        return false;
    }

    public boolean isSendEnquiryPresent() {
        return false;
    }

    public boolean isAddToCartIconPresent() {
        return false;
    }

    public boolean isChatAndEnquiryButton() {
        return false;
    }

    public float getSinglePiecePrice() {
        return 0;
    }

    public float FullCatalogPrice() {
        return 0;
    }

    public String getSinglePieceString() {
        return null;
    }

    public String getSoldByName() {
        return null;
    }

    public boolean startSellingAgainButtonIsDisplayed() {
        return false;
    }

    public String getTextNoCatalogsToDisplay() {
        return null;
    }

    public void clickAddToCartIcon() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(MobileBy.ByAccessibilityId.AccessibilityId("ProductDetailScreenCartButton")).click();

    }

    public int getNumberOfDesigns() {
        return 0;
    }

    public void clickOnDesigns(int index) {

    }

    public int getTextPriceOfDesign() {
        return 0;
    }

    public String getProductSku() {
        return null;
    }

    public void clickBackButtonDesignPage() {

    }

    public void clickBecomeSellerOfThisCatalogButton() {

    }

    @Override
    public float getFullCatalogPrice() {
        return 0;
    }

    @Override
    public float getSinglePrice() {
        return 0;
    }

    @Override
    public float getMarkedWholesalePrice() {
        return 0;
    }

    @Override
    public float getFullClearanceDiscountOff() {
        return 0;
    }

    @Override
    public float getSingleClearanceDiscountOff() {
        return 0;
    }

}
