package com.wishbook.catalog.TestCases.UploadedCatalogInSearch;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductTestCaseHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductUploadHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class UploadedCatalogInSearch extends TestCase {
    @SuppressWarnings("unused")
    public UploadedCatalogInSearch(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));

    }
    protected void run() {

        //region loginAsManufacturer

        //endregion

        //region upload catalog and note Brand Name,Category,CatalogName,Fabric,Work
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        String companyNameText=myBusinessPageStrategy.getTextCompanyName();

        ProductUploadHelper productUploadHelper2 = new ProductUploadHelper(this,ProductTestCaseHelper.SetType.SingleColorSet,ProductTestCaseHelper.PhotoshootType.Catalog);
        productUploadHelper2.setCategoryItemIndex(5);
        productUploadHelper2.setBrandItemIndex(2);
        productUploadHelper2.setFabricItemIndex(2);
        productUploadHelper2.setWorkItemIndex(2);
        productUploadHelper2.execute();
        //endregion

        //region Search in MyCatalog uploaded Catalog,search for wishList Follow Buy now,send enquiry, share
        CatalogSearchHelper catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInMyCatalog(productUploadHelper2.getCatalogName());
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);

        String getCatalogName = catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(productUploadHelper2.getCatalogName().toLowerCase(), getCatalogName);
        String getBrandName = catalogDetailsPageStrategy.getBrandNameText();
        Assert.assertEquals(productUploadHelper2.getSelectedBrandName(), getBrandName);
        System.out.println("checking for wishList Follow Buy now");
        boolean v2 = catalogDetailsPageStrategy.isAddToCartButtonPresent();
        Assert.assertFalse(v2);
        System.out.println("BuyNowButtonPresent no");

        boolean v3 = catalogDetailsPageStrategy.isFollowButtonPresent();
        Assert.assertFalse(v3);
        System.out.println("isFollowButtonPresent no");

        boolean v4 = catalogDetailsPageStrategy.isWishListButtonPresent();
        Assert.assertFalse(v4);
        System.out.println("isWishListButtonPresent no");

        String getWork = catalogDetailsPageStrategy.getWorkText();
        Assert.assertEquals(productUploadHelper2.getSelectedWork(), getWork);
        String getFabric = catalogDetailsPageStrategy.getFabricText();
        Assert.assertEquals(productUploadHelper2.getSelectedFabric(), getFabric);
        boolean v = catalogDetailsPageStrategy.stopSellingButtonIsDisplayed();
        Assert.assertTrue(v);



        catalogSearchHelper.goBackToMyBusinessPage();
        bottomTabPageStrategy.clickHomeButton();
        new LoginHelper(this).logout();
        //endregion

        //region loginAsWholesaler and search for uploaded catalog
        System.out.println("\n login as wholesaler");
        System.out.println("wait....");
        new LoginHelper(this).loginAsTestWholesaler();
        CatalogSearchHelper catalogSearchHelper1 = new CatalogSearchHelper(this);
        catalogSearchHelper1.catalogSearchInHomePageSearchButton(productUploadHelper2.getCatalogName());
        String getCatalogName1 = catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        Assert.assertEquals(productUploadHelper2.getCatalogName(), getCatalogName1);
        String getBrandName1 = catalogDetailsPageStrategy.getBrandNameText();
        Assert.assertEquals(productUploadHelper2.getSelectedBrandName(), getBrandName1);

        catalogDetailsPageStrategy.clickWishListButton();

        boolean v6=catalogDetailsPageStrategy.isWishListButtonPresent();
        Assert.assertTrue(v6);
        System.out.println("isWishListButtonPresent ");

        boolean v7=catalogDetailsPageStrategy.isFollowButtonPresent();
        Assert.assertTrue(v7);
        System.out.println("isFollowButtonPresent ");

        boolean v8=catalogDetailsPageStrategy.isAddToCartButtonPresent();
        Assert.assertTrue(v8);
        System.out.println("isBuyNowButtonPresent ");

        boolean v9=catalogDetailsPageStrategy.isShareButtonPresent();
        Assert.assertTrue(v9);
        System.out.println("isShareButtonPresent ");

        String getWork1 = catalogDetailsPageStrategy.getWorkText();
        Assert.assertEquals(productUploadHelper2.getSelectedWork(), getWork1);
        String getFabric1 = catalogDetailsPageStrategy.getFabricText();
        Assert.assertEquals(productUploadHelper2.getSelectedFabric(), getFabric1);


        boolean v10=catalogDetailsPageStrategy.isBecomeASellerOfThisCatalogPresent();
        Assert.assertTrue(v10);
        System.out.println("isBecomeASellerOfThisCatalogPresent ");

        boolean v11=catalogDetailsPageStrategy.isSendEnquiryPresent();
        Assert.assertTrue(v11);
        System.out.println("isSendEnquiryPresent ");

//        String soldByNameLink=catalogDetailsPageStrategy.getSoldByName();
//        Assert.assertEquals(companyNameText,soldByNameLink);

        System.out.println("-------uploaded catalog in search is passed-------");
        //endregion


    }
}
