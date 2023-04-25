package com.wishbook.catalog.TestCases.DiscountSettings;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.DiscountSettingPage.DiscountSettingPageFactory;
import com.wishbook.catalog.PageObject.DiscountSettingPage.DiscountSettingPageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageFactory;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductTestCaseHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductUploadHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class DiscountSettings extends TestCase {
    public DiscountSettings(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));
    }

    protected void run() {

        //region setting discount on Brand
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickDiscountSettingsButton();

        DiscountSettingPageStrategy discountSettingPageStrategy = DiscountSettingPageFactory.getStrategy(this);
        discountSettingPageStrategy.addDiscountIcon();
        discountSettingPageStrategy.clickAddMoreButton();
        discountSettingPageStrategy.clickOnBrandNameCheckBox(3);
        discountSettingPageStrategy.clickSaveButtonAfterSelectBrand();


        discountSettingPageStrategy.clickEnterCashDiscountText(10);
        String selectedBrandName = discountSettingPageStrategy.getTextSelectedBrand().toLowerCase();
        System.out.println(selectedBrandName);
        float discountValue = discountSettingPageStrategy.getEnteredDiscount();
        System.out.println(discountValue);
        discountSettingPageStrategy.saveButton();

        PopUpPageStrategy popUpPageStrategy = PopUpPageFactory.getStrategy(this);
        popUpPageStrategy.enterNameForThisDiscountRuleTextField("Rules Applied");
        popUpPageStrategy.clickDoneDiscount();
        discountSettingPageStrategy.BackBrandSearchButton();
        //endregion

        //region upload catalog under brand and logout
        System.out.println("uploading.. catalog under discount is created brand ");
        ProductUploadHelper productUploadHelper = new ProductUploadHelper(this,ProductTestCaseHelper.SetType.SingleColorSet,ProductTestCaseHelper.PhotoshootType.Catalog);
        productUploadHelper.setBrandItemIndex(1);//Bhatolia
        String BrandName = productUploadHelper.getSelectedBrandName();
        System.out.println(BrandName);
        productUploadHelper.execute();
        new LoginHelper(this).logout();
        //endregion

        //region retailer Login
        System.out.println("retailer Login  and add to cart and verify discount");
        new LoginHelper(this).loginAsTestRetailer();
        CatalogSearchHelper catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(productUploadHelper.getCatalogName());
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartButton();
        //endregion

        //region verify brand discount in cart and logout
        String brandNameOnCatalogDetails = catalogDetailsPageStrategy.getBrandNameText().toLowerCase();
        Assert.assertEquals(selectedBrandName, brandNameOnCatalogDetails);
        catalogDetailsPageStrategy.clickAddToCartIcon();

        MyCartPageStrategy myCartPageStrategy = MyCartPageFactory.getStrategy(this);
        float discountOnCart = myCartPageStrategy.getDiscountOnMycart();
        Assert.assertEquals(discountOnCart, discountValue);
        float priceOfCatalog = myCartPageStrategy.getCatalogPriceOnMyCart();

        float calulationDiscount = discountOnCart * priceOfCatalog / 100;
        float discountedValue = priceOfCatalog - calulationDiscount;

        float singleItemPrice = myCartPageStrategy.getIndividualItemsDiscountedAfterGstPrice();
        Assert.assertEquals(discountedValue, singleItemPrice);

        float totalValue = myCartPageStrategy.getGrandTotalPrice();
        Assert.assertEquals(singleItemPrice, totalValue);

        myCartPageStrategy.clickDeleteButton();
        popUpPageStrategy.clickOnYesRemoveItemFromCart();

        myCartPageStrategy.BackMyCartButton();
        catalogSearchHelper.goBackToHomePageAfterCatalogSelection();
        new LoginHelper(this).logout();
        //endregion

        //region login As manufacture and edit discount
        new LoginHelper(this).loginAsTestManufacturer();
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickDiscountSettingsButton();

        discountSettingPageStrategy.clickOnCreatedDiscount(3);
        discountSettingPageStrategy.clickEnterCashDiscountText(20);
        float discountEditedValue = discountSettingPageStrategy.getEnteredDiscount();
        System.out.println(discountEditedValue);
        discountSettingPageStrategy.saveButton();
        discountSettingPageStrategy.BackBrandSearchButton();
        new LoginHelper(this).logout();
        //endregion

        //region login to retailer
        new LoginHelper(this).loginAsTestRetailer();
        catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(productUploadHelper.getCatalogName());
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartButton();
        //endregion

        //region verify edited brand discount in cart and logout
        String brandNameOnCatalogDetails1 = catalogDetailsPageStrategy.getBrandNameText().toLowerCase();
        Assert.assertEquals(selectedBrandName, brandNameOnCatalogDetails1);
        catalogDetailsPageStrategy.clickAddToCartIcon();

        myCartPageStrategy = MyCartPageFactory.getStrategy(this);
        float discountOnCart1 = myCartPageStrategy.getDiscountOnMycart();
        Assert.assertEquals(discountOnCart1, discountEditedValue);

        float priceOfCatalog1 = myCartPageStrategy.getCatalogPriceOnMyCart();

        float calulationDiscount1 = discountOnCart1 * priceOfCatalog1 / 100;
        float discountedValue1 = priceOfCatalog1 - calulationDiscount1;

        float singleItemPrice1 = myCartPageStrategy.getIndividualItemsDiscountedAfterGstPrice();
        Assert.assertEquals(discountedValue1, singleItemPrice1);

        float totalValue1 = myCartPageStrategy.getGrandTotalPrice();
        Assert.assertEquals(singleItemPrice1, totalValue1);

        myCartPageStrategy.clickDeleteButton();
        popUpPageStrategy.clickOnYesRemoveItemFromCart();
        new LoginHelper(this).logout();

        new LoginHelper(this).loginAsTestManufacturer();
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickDiscountSettingsButton();
        discountSettingPageStrategy.clickOnCreatedDiscount(3);
        discountSettingPageStrategy.deleteCratedDiscount();
        popUpPageStrategy.clickYesButton();
        //endregion


    }
}
