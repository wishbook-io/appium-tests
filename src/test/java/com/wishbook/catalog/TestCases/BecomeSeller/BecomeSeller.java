package com.wishbook.catalog.TestCases.BecomeSeller;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.AddFabricPage.AddFabricPageFactory;
import com.wishbook.catalog.PageObject.AddFabricPage.AddFabricPageStrategy;
import com.wishbook.catalog.PageObject.AddWorkPage.AddWorkPageFactory;
import com.wishbook.catalog.PageObject.AddWorkPage.AddWorkPageStrategy;
import com.wishbook.catalog.PageObject.BecomeASellerPage.BecomeASellerPageFactory;
import com.wishbook.catalog.PageObject.BecomeASellerPage.BecomeASellerPageStrategy;
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
import com.wishbook.catalog.PageObject.ChooseABrandSpinner.ChooseABrandFactory;
import com.wishbook.catalog.PageObject.ChooseABrandSpinner.ChooseABrandStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1Factory;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1Strategy;
import com.wishbook.catalog.PageObject.ProductUploadPage2.ProductUploadPage2Factory;
import com.wishbook.catalog.PageObject.ProductUploadPage2.ProductUploadPage2Strategy;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageFactory;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageStrategy;
import com.wishbook.catalog.PageObject.SelectCategorySpinner.SelectCategorySpinnerFactory;
import com.wishbook.catalog.PageObject.SelectCategorySpinner.SelectCategorySpinnerStrategy;
import com.wishbook.catalog.PageObject.SelectPhotoAlbumPage.SelectPhotoAlbumPageFactory;
import com.wishbook.catalog.PageObject.SelectPhotoAlbumPage.SelectPhotoAlbumPageStrategy;
import com.wishbook.catalog.PageObject.TabToSelectImage.TabToSelectImageFactory;
import com.wishbook.catalog.PageObject.TabToSelectImage.TabToSelectImageStrategy;
import com.wishbook.catalog.PageObject.UploadImageDialog.UploadImageDialogFactory;
import com.wishbook.catalog.PageObject.UploadImageDialog.UploadImageDialogStrategy;
import com.wishbook.catalog.TestCases.Product;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import com.wishbook.catalog.TestCases.UploadProductTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

import java.util.ArrayList;

public class BecomeSeller extends TestCase {

    private String sarees;
    int randomPrice = (int)(Math.random() * 500);


    private  String kurtis;

    public BecomeSeller(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));
    }

    public  void run() {


        //region 1. upload single pieces catalog
        uploadProduct("Kurtis");


        ProductUploadPage2Strategy productUploadPage2Strategy=ProductUploadPage2Factory.getStrategy(this);
        productUploadPage2Strategy.clickFullCatalogOnly();
//        Assert.assertFalse(productUploadPage2Strategy.isMarginPricesDisplayed());
        productUploadPage2Strategy.clickSinglePieceAndFullCatalogBoth();
 //       Assert.assertTrue(productUploadPage2Strategy.isMarginPricesDisplayed());


        productUploadPage2Strategy.enterNumOfDesign(1);
        productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
        productUploadPage2Strategy.clickAddProductPhotosButton();
        SelectPhotoAlbumPageStrategy selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(this);


        if (getTest().getTestConfiguration().getDevelopmentFramework() == TestConfiguration.DevelopmentFramework.ReactNative) {
            selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(0);
        } else {
            TabToSelectImageStrategy tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
            selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(1);
            tabToSelectImageStrategy.selectImagesForCatalogDesign(0);
            tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
            tabToSelectImageStrategy.clickAddButton();
        }


        productUploadPage2Strategy.selectAddMarginInPercentRadioButton();
        productUploadPage2Strategy.enterMarginToTextField(10);

        productUploadPage2Strategy.enterPrice(randomPrice);
        System.out.println(randomPrice);
        int marginCalculation= randomPrice*10/100;
        int expectedSinglePrice=randomPrice+marginCalculation;
        int singlePiecePrice=productUploadPage2Strategy.getTotalPriceAfterAddingMargingForSinglePiece();
        Assert.assertEquals(expectedSinglePrice,singlePiecePrice);

        productUploadPage2Strategy.clickCheckBoxProductSizeByText("2XL");
        productUploadPage2Strategy.clickCheckBoxProductSizeByText("M");
        productUploadPage2Strategy.enterPrice(randomPrice);
        productUploadPage2Strategy.clickSubmitButton();

        //endregion

        //region 2. upload full catalog
        uploadProduct("Sarees");
        productUploadPage2Strategy.clickFullCatalogOnly();
        productUploadPage2Strategy.enterNumOfDesign(1);
        productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
        productUploadPage2Strategy.clickAddProductPhotosButton();
        selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(this);
        if (getTest().getTestConfiguration().getDevelopmentFramework() == TestConfiguration.DevelopmentFramework.ReactNative) {
            selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(0);
        } else {
            TabToSelectImageStrategy tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
            selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(1);
            tabToSelectImageStrategy.selectImagesForCatalogDesign(0);
            tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
            tabToSelectImageStrategy.clickAddButton();
        }
        productUploadPage2Strategy.enterPrice(1000);
        productUploadPage2Strategy.clickSubmitButton();

        new LoginHelper(this).logout();
        //endregion


        new LoginHelper(this).loginAsTestWholesaler();


        //region becoming seller for singlePieces and full set with Sizes
        CatalogSearchHelper catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(kurtis);
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        String catalogNameSinglePieces = catalogDetailsPageStrategy.getCatalogName();
        Assert.assertEquals(sarees.toLowerCase(), catalogNameSinglePieces.toLowerCase());
        Assert.assertTrue(catalogDetailsPageStrategy.isAddToCartButtonPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isSendEnquiryPresent());
        catalogDetailsPageStrategy.clickBecomeSellerOfThisCatalogButton();
        BecomeASellerPageStrategy becomeASellerPageStrategy = BecomeASellerPageFactory.getStrategy(this);
        becomeASellerPageStrategy.enterCatalogDuration(20);
        becomeASellerPageStrategy.clickFullCatalogRadioButton();
        Assert.assertTrue(becomeASellerPageStrategy.areAllSizesDisplayed());
        Assert.assertTrue(becomeASellerPageStrategy.fullCatalogOnlyIsDisplayed());
        Assert.assertTrue(becomeASellerPageStrategy.singlePiecesAndFullCatalogBothIsDisplayed());
        becomeASellerPageStrategy.clickCheckBoxProductSizeByText("3XL");
        becomeASellerPageStrategy.clickCheckBoxProductSizeByText("M");
        becomeASellerPageStrategy.clickSinglePiecesAndFullCatalogBoth();
        Assert.assertTrue(becomeASellerPageStrategy.isDesignNumberDisplayed());
        Assert.assertTrue(becomeASellerPageStrategy.isPricePerDesignDisplayed());
        Assert.assertTrue(becomeASellerPageStrategy.fullCatalogOnlyIsDisplayed());
        Assert.assertTrue(becomeASellerPageStrategy.singlePiecesAndFullCatalogBothIsDisplayed());
        becomeASellerPageStrategy.clickCheckBoxProductSizeByText("3XL");
        becomeASellerPageStrategy.clickCheckBoxProductSizeByText("M");
        becomeASellerPageStrategy.clickDoneButton();
        becomeASellerPageStrategy.clickOk();
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        Assert.assertTrue(catalogDetailsPageStrategy.stopSellingButtonIsDisplayed());
        Assert.assertFalse(catalogDetailsPageStrategy.isAddToCartButtonPresent());
        Assert.assertFalse(catalogDetailsPageStrategy.isSendEnquiryPresent());
        catalogDetailsPageStrategy.BackCatalogButton();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();
        //endregion

        //region becoming seller of full and single pieces without sizes
        catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(sarees);
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        String catalogNameSarees = catalogDetailsPageStrategy.getCatalogName();
        Assert.assertEquals(sarees.toLowerCase(), catalogNameSarees.toLowerCase());
        Assert.assertTrue(catalogDetailsPageStrategy.isAddToCartButtonPresent());
        Assert.assertTrue(catalogDetailsPageStrategy.isSendEnquiryPresent());
        catalogDetailsPageStrategy.clickBecomeSellerOfThisCatalogButton();
        becomeASellerPageStrategy = BecomeASellerPageFactory.getStrategy(this);
        becomeASellerPageStrategy.enterCatalogDuration(20);
        becomeASellerPageStrategy.clickFullCatalogRadioButton();
        Assert.assertFalse(becomeASellerPageStrategy.areAllSizesDisplayed());
        Assert.assertTrue(becomeASellerPageStrategy.fullCatalogOnlyIsDisplayed());
        Assert.assertTrue(becomeASellerPageStrategy.singlePiecesAndFullCatalogBothIsDisplayed());
        becomeASellerPageStrategy.clickSinglePiecesAndFullCatalogBoth();
        Assert.assertFalse(becomeASellerPageStrategy.isDesignNumberDisplayed());
        Assert.assertFalse(becomeASellerPageStrategy.isPricePerDesignDisplayed());
        Assert.assertFalse(becomeASellerPageStrategy.areAllSizesDisplayed());
        Assert.assertTrue(becomeASellerPageStrategy.fullCatalogOnlyIsDisplayed());
        Assert.assertTrue(becomeASellerPageStrategy.singlePiecesAndFullCatalogBothIsDisplayed());
        becomeASellerPageStrategy.clickDoneButton();
        becomeASellerPageStrategy.clickOk();
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        Assert.assertTrue(catalogDetailsPageStrategy.stopSellingButtonIsDisplayed());
        Assert.assertFalse(catalogDetailsPageStrategy.isAddToCartButtonPresent());
        Assert.assertFalse(catalogDetailsPageStrategy.isSendEnquiryPresent());
        catalogDetailsPageStrategy.BackCatalogButton();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();

        //endregion

    }










    private void uploadProduct(String category) {
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickAddCatalogButton();
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
        productUploadPage1Strategy.clickOnSelectCategory();
        SelectCategorySpinnerStrategy selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(this);
        selectCategorySpinnerStrategy.selectCategoryByName(category);
        productUploadPage1Strategy.clickOnChooseABrandSpinner();
        ChooseABrandStrategy chooseABrandStrategy = ChooseABrandFactory.getStrategy(this);
        chooseABrandStrategy.selectBrandByName("Bhatolia");
        if(category=="Sarees") {
            sarees = "test_" + RandomStringUtils.randomAlphabetic(8).toLowerCase() + "_sarees";
            productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
            productUploadPage1Strategy.enterCatalogName(sarees);

        }
        else {

            kurtis = "test_" + RandomStringUtils.randomAlphabetic(8).toLowerCase() + "_Kurtis";
            productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
            productUploadPage1Strategy.enterCatalogName(kurtis);
        }
        productUploadPage1Strategy.clickAddFabricButton();
        AddFabricPageStrategy addFabricPageStrategy = AddFabricPageFactory.getStrategy(this);
        addFabricPageStrategy.clickFabricCheckBoxByText("Art Silk");
        addFabricPageStrategy.clickSave();
        productUploadPage1Strategy.clickAddWorkButton();
        AddWorkPageStrategy addWorkPageStrategy = AddWorkPageFactory.getStrategy(this);
        addWorkPageStrategy.clickWorkCheckBoxByText("Crochet");
        addWorkPageStrategy.clickSave();
        productUploadPage1Strategy.clickContinueButton();
        ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);

        productUploadPage2Strategy.uploadCoverPhoto();
        UploadImageDialogStrategy uploadImageDialogStrategy = UploadImageDialogFactory.getStrategy(this);
        if (getTest().getTestConfiguration().getDevelopmentFramework() == TestConfiguration.DevelopmentFramework.ReactNative) {
            uploadImageDialogStrategy.chooseCamera();
        } else {
            int uploadingImageByCamera = 0;
            uploadImageDialogStrategy.selectCameraToUploadCatalog(uploadingImageByCamera);
        }

        CameraPageStrategy cameraPageStrategy = CameraPageFactory.getStrategy(this);
        cameraPageStrategy.takePic();
        CameraPicActionStrategy cameraPicActionStrategy = CameraPicActionFactory.getStrategy(this);
        cameraPicActionStrategy.saveClickedImage();

    }

    public void addMarginForSinglePieces(){
        ProductUploadPage2Strategy productUploadPage2Strategy=ProductUploadPage2Factory.getStrategy(this);
        productUploadPage2Strategy.clickFullCatalogOnly();
        Assert.assertFalse(productUploadPage2Strategy.isMarginPricesDisplayed());
        productUploadPage2Strategy.clickSinglePieceAndFullCatalogBoth();
        Assert.assertTrue(productUploadPage2Strategy.isMarginPricesDisplayed());
        productUploadPage2Strategy.selectAddMarginInPriceRadioButton();

        productUploadPage2Strategy.selectAddMarginInPercentRadioButton();
        productUploadPage2Strategy.enterMarginToTextField(10);
        productUploadPage2Strategy.enterPrice(randomPrice);

        int marginCalculation= randomPrice*10/100;
        int expectedSinglePrice=randomPrice+marginCalculation;
        int singlePiecePrice=productUploadPage2Strategy.getTotalPriceAfterAddingMargingForSinglePiece();
        Assert.assertEquals(expectedSinglePrice,singlePiecePrice);





    }

}