package com.wishbook.catalog.TestCases.AddToCart;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.AddFabricPage.AddFabricPageFactory;
import com.wishbook.catalog.PageObject.AddFabricPage.AddFabricPageStrategy;
import com.wishbook.catalog.PageObject.AddWorkPage.AddWorkPageFactory;
import com.wishbook.catalog.PageObject.AddWorkPage.AddWorkPageStrategy;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CameraPage.CameraPageFactory;
import com.wishbook.catalog.PageObject.CameraPage.CameraPageStrategy;
import com.wishbook.catalog.PageObject.CameraPicAction.CameraPicActionFactory;
import com.wishbook.catalog.PageObject.CameraPicAction.CameraPicActionStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageFactory;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageFactory;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageStrategy;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1Factory;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1Strategy;
import com.wishbook.catalog.PageObject.ProductUploadPage2.ProductUploadPage2Factory;
import com.wishbook.catalog.PageObject.ProductUploadPage2.ProductUploadPage2Strategy;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageFactory;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageStrategy;
import com.wishbook.catalog.PageObject.SelectPhotoAlbumPage.SelectPhotoAlbumPageFactory;
import com.wishbook.catalog.PageObject.SelectPhotoAlbumPage.SelectPhotoAlbumPageStrategy;
import com.wishbook.catalog.PageObject.SelectSizeQuantityPage.SelectSizeQuantityPageFactory;
import com.wishbook.catalog.PageObject.SelectSizeQuantityPage.SelectSizeQuantityPageStrategy;
import com.wishbook.catalog.PageObject.TabToSelectImage.TabToSelectImageFactory;
import com.wishbook.catalog.PageObject.TabToSelectImage.TabToSelectImageStrategy;
import com.wishbook.catalog.PageObject.UploadImageDialog.UploadImageDialogFactory;
import com.wishbook.catalog.PageObject.UploadImageDialog.UploadImageDialogStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductTestCaseHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductUploadHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

import java.util.UUID;

public class DifferentProductDifferentSeller extends TestCase {
    private String catalogName;
    public DifferentProductDifferentSeller(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));
    }

    protected void run() {
        //region uploading kurti with sizes
        System.out.println("Login as Manufacturer and upload catalog 1");
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickProductsButton();
        CatalogPublicPageStrategy catalogPublicPageStrategy = CatalogPublicPageFactory.getStrategy(this);
        catalogPublicPageStrategy.clickUploadIcon();
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
//        productUploadPage1Strategy.selectCategoryItem(4);
//        productUploadPage1Strategy.selectBrandItem(1);
        catalogName = UUID.randomUUID().toString();
        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
        String catalog = productUploadPage1Strategy.enterCatalogName(catalogName).toLowerCase();
        System.out.println("CatalogName = " + catalog);
        productUploadPage1Strategy.clickAddFabricButton();
        AddFabricPageStrategy addFabricPageStrategy = AddFabricPageFactory.getStrategy(this);
        addFabricPageStrategy.selectFabricItems(2);
        addFabricPageStrategy.clickSave();
        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
        productUploadPage1Strategy.clickAddWorkButton();
        AddWorkPageStrategy addWorkPageStrategy = AddWorkPageFactory.getStrategy(this);
        addWorkPageStrategy.selectWorkItems(2);
        addWorkPageStrategy.clickSave();
        productUploadPage1Strategy.clickContinueButton();
        ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
        productUploadPage2Strategy.uploadCoverPhoto();
        UploadImageDialogStrategy uploadImageDialogStrategy = UploadImageDialogFactory.getStrategy(this);
        int uploadingImageByCamera = 0;
        uploadImageDialogStrategy.selectCameraToUploadCatalog(uploadingImageByCamera);
        CameraPageStrategy cameraPageStrategy = CameraPageFactory.getStrategy(this);
        cameraPageStrategy.takePic();
        CameraPicActionStrategy cameraPicActionStrategy = CameraPicActionFactory.getStrategy(this);
        cameraPicActionStrategy.saveClickedImage();
        productUploadPage2Strategy.enterNumOfDesign(1);
        productUploadPage2Strategy.goBack();
        productUploadPage2Strategy.clickAddProductPhotosButton();
        SelectPhotoAlbumPageStrategy selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(this);
        selectPhotoAlbumPageStrategy.clickWishbookPhotoAlbumButton();
        TabToSelectImageStrategy tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
        tabToSelectImageStrategy.selectImages();
        tabToSelectImageStrategy.clickAddButton();
        productUploadPage2Strategy.enterPrice(500);
        productUploadPage2Strategy.clickSubmitButton();
        new LoginHelper(this).logout();
        //endregion
        System.out.println("Logout \n\n Login as wholesaler and upload catalog 2");
        new LoginHelper(this).loginAsTestWholesaler();
        ProductUploadHelper productUploadHelper1 = new ProductUploadHelper(this,ProductTestCaseHelper.SetType.SingleColorSet,ProductTestCaseHelper.PhotoshootType.Catalog);
        productUploadHelper1.setCategoryItemIndex(7); //sarees
        productUploadHelper1.execute();
        new LoginHelper(this).logout();

        System.out.println("Login as retailer and search catalog1 and catalog 2 and add them to cart");
        new LoginHelper(this).loginAsTestRetailer();
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.dismissCreditRatingDialog();


        //region catalog 1 kurtie added to cart
        System.out.println("Kurti added to cart with sizes");
        CatalogSearchHelper catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(catalog);
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartButton();

        SelectSizeQuantityPageStrategy selectSizeQuantityPageStrategy = SelectSizeQuantityPageFactory.getStrategy(this);
        selectSizeQuantityPageStrategy.increaseKurtiSizeQuantity(5);
        selectSizeQuantityPageStrategy.increaseKurtiSizeQuantity(10);
        selectSizeQuantityPageStrategy.clickDoneButton();
        catalogDetailsPageStrategy.BackCatalogButton();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();

        //endregion

        //region 2 catalog 2 sarees added to cart
        catalogSearchHelper = new CatalogSearchHelper(this);
        bottomTabPageStrategy.clickProductsButton();
        catalogSearchHelper.catalogSearchInHomePageSearchButton(catalog);
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartButton();
        catalogDetailsPageStrategy.BackCatalogButton();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();


        //endregion

        //region goto cart and verify order
        System.out.println("verify catalog name and price in cart");
        homePageStrategy = HomePageFactory.getStrategy(this);
       // homePageStrategy.clickAddToCartIcon();
        MyCartPageStrategy myCartPageStrategy = MyCartPageFactory.getStrategy(this);
        String catalog1 = myCartPageStrategy.getCatalogName(6);
        //region wait
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//endregion
        String catalog2 = myCartPageStrategy.getCatalogName(18);
        Assert.assertEquals(catalog1, productUploadHelper1.getCatalogName());
        Assert.assertEquals(catalog2, productUploadHelper1.getCatalogName());

        myCartPageStrategy.getCatalogQuantity(1);
        float catalog1Price = myCartPageStrategy.getIndividualItemsPriceInCart(9);
        float catalog2Price = myCartPageStrategy.getIndividualItemsPriceInCart(25);
        float sumOfCatalogsPrice = catalog1Price + catalog2Price;
        float totalPrice = myCartPageStrategy.getGrandTotalPrice();
        Assert.assertEquals(totalPrice, sumOfCatalogsPrice);
        myCartPageStrategy.clickPlaceOrderButton();

        //endregion


    }
}
