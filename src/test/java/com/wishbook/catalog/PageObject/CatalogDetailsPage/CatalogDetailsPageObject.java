package com.wishbook.catalog.PageObject.CatalogDetailsPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @see BasePageObject
 */

@SuppressWarnings("unused")
public class CatalogDetailsPageObject extends BasePageObject {

    //region elements
    @AndroidFindBy(id = AndroidLocator.WISHLIST_BUTTON)
    protected WebElement wishList;

    @AndroidFindBy(id = AndroidLocator.CATALOG_TITLE)
    protected WebElement catalogTitle;

    @AndroidFindBy(id = AndroidLocator.SOLD_BYLINK)
    private WebElement soldByLink;

    @AndroidFindBy(id = AndroidLocator.SOLD_BY_ALLLINK)
    private WebElement soldByAllLink;

    @AndroidFindBy(id = AndroidLocator.SHARE_CATALOG_ICON)
    private WebElement shareCatalogIcon;

    @AndroidFindBy(id = AndroidLocator.FOLLOW)
    private WebElement follow;

    @AndroidFindBy(id = AndroidLocator.SEE_MORE_LINK)
    private WebElement seeMoreLink;

    @AndroidFindBy(id = AndroidLocator.BECOME_SELLER_OF_THIS_CATALOG)
    private WebElement becomeSellerOfThisCatalog;

    @AndroidFindBy(id = AndroidLocator.CHAT_ENQUIRY_BUTTON)
    private WebElement chatEnquiryButton;

    @AndroidFindBy(id = AndroidLocator.ADD_TO_CART)
    private WebElement addToCartButton;

    @AndroidFindBy(id = AndroidLocator.STOP_SELLING)
    private WebElement stopSelling;

    @AndroidFindBy(className = AndroidLocator.BACK_PROFILE)
    private WebElement backToPublicCatalogPage;

    @AndroidFindBy(id = AndroidLocator.TOOLBAR)
    private WebElement toolBar;

    @AndroidFindBy(id = AndroidLocator.WORK_TEXT)
    private WebElement workText;

    @AndroidFindBy(id = AndroidLocator.FABRIC_TEXT)
    private WebElement fabricText;

    @AndroidFindBy(id = AndroidLocator.PRICE_TEXT)
    private WebElement priceText;

    @AndroidFindBy(id = AndroidLocator.DISABLED_BY_SUPPLIER_TEXT)
    private WebElement disabledBySupplierText;

    @AndroidFindBy(id = AndroidLocator.SHARE_BUTTON_CATALOG_DETAILS)
    private WebElement shareButtonCatalogDetails;

    @AndroidFindBy(id = AndroidLocator.BUY_AS_BROKER)
    private WebElement buyAsBrokerButton;

    @AndroidFindBy(id = AndroidLocator.SEND_ENQUIRY_BUTTON)
    private WebElement sendEnquiryButton;

    @AndroidFindBy(id = AndroidLocator.CREATE_SALES_ORDER_BUTTON)
    private WebElement createSalesOrder;

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

    @AndroidFindBy(id = AndroidLocator.CART_ICON)
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

    @AndroidFindBy(id = AndroidLocator.CATALOG_NAME_DETAILS)
    private WebElement catalogName;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_category")
    private WebElement categoryName;

    @AndroidFindBy(id = AndroidLocator.EDIT_SET_SCREEN)
    private WebElement editSetButton;

    @AndroidFindBy(id = AndroidLocator.ADD_SET_SCREEN)
    private WebElement addSetButton;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_price")
    private WebElement fullPrice;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_single_piece_price")
    private WebElement singlePrice;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_mwp_price")
    private WebElement markedWholesalePrice;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_full_clearance_discount")
    private WebElement fullDiscountOff;

    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_single_clearance_discount")
    private WebElement singleDiscountOff;





    // endregion

    //region constructor

    /**
     * @see BasePageObject
     */
    public CatalogDetailsPageObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region services
    public void clickBuyAsBrokerButton() {
        buyAsBrokerButton.click();
    }



    public float getSinglePiecePrice() {
        return BasePageObject.getFloatFromString(getSinglePiecePrice.getText());
        }
        public String getSinglePieceString() {
        return getSinglePiecePrice.getText();
        }

    public float FullCatalogPrice() {
        return BasePageObject.getFloatFromString(getFullCatalogPrice.getText());
    }

    public int getFullCatalogPriceForProductsText() {
        return Integer.parseInt(getFullCatalogPrice.getText().replaceAll("[^0-9]", ""));
    }
    public int getSinglePcsForProductText() {
        return Integer.parseInt(getSinglePiecePrice.getText().replaceAll("[^0-9]", ""));

    }




    public int getNumberOfCatalogItems() {
        return getDriver().findElements(By.id(AndroidLocator.ITEM_IMAGE_ID)).size();
    }


    public void clickSoldByLink() {
        soldByLink.click();
    }

    public void clickSellersLink() {
        soldByAllLink.click();
    }

    public void clickShareIcon() {
        shareCatalogIcon.click();
    }

    public void clickFollowButton() {
        follow.click();
    }

    public void clickSeeMoreSeeLessLink() {
        seeMoreLink.click();
    }


    public void clickChatEnquiryButton() {
        chatEnquiryButton.click();
    }

    public void clickAddToCartButton() {

        addToCartButton.click();
    }

    public String getCatalogName() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return catalogName.getText();
    }

    public String getProductNameInMyProduct(){
        return catalogName.getText();
    }

    public String getCatalogNameOnMyProduct(){
        WebDriverWait wait= new WebDriverWait(testCase.getTest().getDriver(),50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.wishbook.catalog:id/linear_add_product")));
        return catalogName.getText();
    }

    public void BackCatalogButton() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_BUTTON)).click();
    }

    public String getTextDisabledBySupplier() {
        return getDriver().findElement(By.id(AndroidLocator.DISABLED_BY_SUPPLIER_TEXT)).getText();

    }

    public void clickShareButtonCatalogsDetails() {
        shareButtonCatalogDetails.click();
    }

    public Boolean shareButtonIsDisplayed() {
        return getDriver().findElements(By.id(AndroidLocator.SHARE_BUTTON_CATALOG_DETAILS)).size() > 0;
    }

    public void sendEnquiryButton() {
        sendEnquiryButton.click();
    }

    public Boolean ChatWithSupplierButtonIsDisplayed() {
        return getDriver().findElements(By.id(AndroidLocator.CHAT_WITH_SUPPLIER_BUTTON)).size() > 0;

    }

    public String getBrandNameText() {
        return getBrandNameText.getText();
    }

    public boolean isWishListButtonPresent() {
        return getDriver().findElements(By.id(AndroidLocator.WISHLIST_BUTTON)).size() > 0;
    }

    public boolean isAddToCartButtonPresent() {
        return getDriver().findElements(By.id(AndroidLocator.ADD_TO_CART)).size() > 0;
    }

    public void clickAddToCartIcon() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addToCartIcon.click();
    }

    public boolean isFollowButtonPresent() {
        return getDriver().findElements(By.id(AndroidLocator.FOLLOW)).size() > 0;

    }

    public void clickAddProductDots() {
        toolBar.findElement(By.className(AndroidLocator.WIDGE_IMAGE_VIEW)).click();
    }

    public boolean isShareButtonPresent() {
        return getDriver().findElements(By.id(AndroidLocator.SHARE_BUTTON_CATALOG_DETAILS)).size() > 0;
    }
    public boolean isAddToCartIconPresent() {
        return getDriver().findElements(By.id(AndroidLocator.CART_ICON)).size() > 0;
    }
    public boolean isChatAndEnquiryButton() {
        return getDriver().findElements(By.id(AndroidLocator.CHAT_ENQUIRY_BUTTON)).size() > 0;
    }



    public boolean isSendEnquiryPresent() {
        return sendEnquiryButton.isDisplayed();
    }

    public int getNumberOfDesigns() {
        return Integer.parseInt(getNumberOfDesign.getText());
    }

    public String getSoldByName() {
        return soldByLinkText.getText();
    }

    public boolean startSellingAgainButtonIsDisplayed() {
        return startSellingAgain.isDisplayed();
    }

    public String getTextNoCatalogsToDisplay() {
        return noCatalogToDisplay.getText();
    }

    public void clickBecomeASellerOfThisCatalog() {
        becomeSellerOfThisCatalog.click();
    }

    public int getTextPriceOfDesign() {
        return Integer.parseInt(getTextPrice.getText().replaceAll("[^0-9]", ""));
    }
    public String getProductSku() {
        return productSku.getText();
    }
    public void clickBackButtonDesignPage() {
        backToCatalogDetails.click();
    }

    public String getProductCategory() {
        return categoryName.getText();
    }
    public boolean setEditScreenButtonIsDisplay() {
        return getDriver().findElements(By.id(AndroidLocator.EDIT_SET_SCREEN)).size() > 0;

    }
    public boolean setAddScreenButtonIsDisplayed() {
        return getDriver().findElements(By.id(AndroidLocator.ADD_SET_SCREEN)).size() > 0;

    }
    public void clickEditSetButton() {
        editSetButton.click();
    }
    public void clickAddSetButton() {
        addSetButton.click();
    }

    public float  getFullCatalogPrice(){
        WebDriverWait wait= new WebDriverWait(getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(fullPrice));
        WebElement text = fullPrice;
        String a=text.getText();
        String b= a.replaceAll("\\.(?!.*\\.)","");
        System.out.println(b);
        String regEx = "[^0-9.]";
        return Float.valueOf(b.replaceAll(regEx,""));


    }

    public float getSinglePrice(){
        WebElement text =singlePrice;
        String a=text.getText();
        String b= a.replaceAll("\\.(?!.*\\.)","");
        System.out.println(b);

        String regEx = "[^0-9.]";
        return Float.valueOf(b.replaceAll(regEx,""));


    }

    public float getMarkedWholesalePrice(){
        WebDriverWait wait= new WebDriverWait(getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(markedWholesalePrice));
        WebElement text = markedWholesalePrice;
        String a=text.getText();
        String b= a.replaceAll("\\.(?!.*\\.)","");
        System.out.println(b);
        String regEx = "[^0-9.]";
        return Float.valueOf(b.replaceAll(regEx,""));
    }

    public float getFullClearanceDiscountOff(){
        return BasePageObject.getFloatFromString(fullDiscountOff.getText());
    }

    public float getSingleClearanceDiscountOff(){
        return BasePageObject.getFloatFromString(singleDiscountOff.getText());
    }



}//endregion
