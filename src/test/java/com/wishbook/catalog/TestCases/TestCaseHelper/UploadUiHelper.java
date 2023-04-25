package com.wishbook.catalog.TestCases.TestCaseHelper;

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
import com.wishbook.catalog.PageObject.ChooseABrandSpinner.ChooseABrandFactory;
import com.wishbook.catalog.PageObject.ChooseABrandSpinner.ChooseABrandStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
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
import com.wishbook.catalog.PageObject.SelectTopCategory.SelectTopCategorySpinnerFactory;
import com.wishbook.catalog.PageObject.SelectTopCategory.SelectTopCategorySpinnerStrategy;
import com.wishbook.catalog.PageObject.TabToSelectImage.TabToSelectImageFactory;
import com.wishbook.catalog.PageObject.TabToSelectImage.TabToSelectImageStrategy;
import com.wishbook.catalog.PageObject.UploadImageDialog.UploadImageDialogFactory;
import com.wishbook.catalog.PageObject.UploadImageDialog.UploadImageDialogStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class UploadUiHelper extends ProductTestCaseHelper {

    protected String catalogName;

    public UploadUiHelper(TestCase testCase, SetType setType, PhotoshootType photoshootType) {
        super(testCase, setType, photoshootType);
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void uploadSingleColourProductUi() {
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickProductsButton();
        CatalogPublicPageStrategy catalogPublicPageStrategy = CatalogPublicPageFactory.getStrategy(testCase);
        catalogPublicPageStrategy.clickUploadIcon();
        selectProductTypeInUploadPage();

        verifyCategory();
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectTopCategory();
        SelectTopCategorySpinnerStrategy selectTopCategorySpinnerStrategy = SelectTopCategorySpinnerFactory.getStrategy(testCase);
        selectTopCategorySpinnerStrategy.selectTopCategoryItems(1);
        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectCategory();
        SelectCategorySpinnerStrategy selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Blouse");
        productUploadPage1Strategy.clickContinueButton();


        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnChooseABrandSpinner();
        ChooseABrandStrategy chooseABrandStrategy = ChooseABrandFactory.getStrategy(testCase);
        chooseABrandStrategy.clickONBrandNameFromSpinner(1);
        productUploadPage1Strategy.clickContinueButton();

        catalogName = "test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase();
        productUploadPage1Strategy.enterCatalogName(catalogName);
        productUploadPage1Strategy.clickContinueButton();


        productUploadPage1Strategy.clickAddFabricButton();
        AddFabricPageStrategy addFabricPageStrategy = AddFabricPageFactory.getStrategy(testCase);
        addFabricPageStrategy.selectFabricItems(0);
        addFabricPageStrategy.clickSave();
        productUploadPage1Strategy.clickContinueButton();


        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.setCatalogEnableDurationField("9");
        productUploadPage1Strategy.clickContinueButton();
        productUploadPage1Strategy.setCatalogEnableDurationField("20");
        productUploadPage1Strategy.clickContinueButton();


        productUploadPage1Strategy.clickAddWorkButton();
        AddWorkPageStrategy addWorkPageStrategy = AddWorkPageFactory.getStrategy(testCase);
        addWorkPageStrategy.selectWorkItems(1);
        addWorkPageStrategy.clickSave();
        productUploadPage1Strategy.clickContinueButton();


//---------------------------page upload catalog 2------------------------------
        ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(testCase);
        productUploadPage2Strategy.clickSinglePieceAndFullCatalogBoth();
        productUploadPage2Strategy.clickSubmitButton();
        PopUpPageStrategy popUpPageStrategy = PopUpPageFactory.getStrategy(testCase);
        popUpPageStrategy.clickOk();

        productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(testCase);
        productUploadPage2Strategy.uploadCoverPhoto();
        UploadImageDialogStrategy uploadImageDialogStrategy = UploadImageDialogFactory.getStrategy(testCase);
        uploadImageDialogStrategy.selectCameraToUploadCatalog(0);
        CameraPageStrategy cameraPageStrategy = CameraPageFactory.getStrategy(testCase);
        cameraPageStrategy.takePic();
        CameraPicActionStrategy cameraPicActionStrategy = CameraPicActionFactory.getStrategy(testCase);
        cameraPicActionStrategy.saveClickedImage();
        productUploadPage2Strategy.clickSubmitButton();

        testCase.getTest().getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        productUploadPage2Strategy.enterNumOfDesign(2);

        ProductUploadPage2Strategy productUploadPage2Strategy1 = ProductUploadPage2Factory.getStrategy(testCase);
        productUploadPage2Strategy1.clickAddProductPhotosButton();
        SelectPhotoAlbumPageStrategy selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(testCase);
        selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(1);
        TabToSelectImageStrategy tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(testCase);
        tabToSelectImageStrategy.selectImagesForCatalogDesign(0);
        tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(testCase);
        tabToSelectImageStrategy.clickAddButton();
        productUploadPage2Strategy.enterPrice(500);
        productUploadPage2Strategy.clickSubmitButton();


        int price2 = productUploadPage2Strategy.getEnteredPriceForProduct();
        int notMoreThan20Per = 20 * price2 / 100;
        int moreThan20Per = 30 * price2 / 100;

        ProductUploadPage2Strategy productUploadPage2Strategy2 = ProductUploadPage2Factory.getStrategy(testCase);
        productUploadPage2Strategy2.clickAddProductPhotosButton();
        selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(testCase);
        selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(1);
        tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(testCase);
        tabToSelectImageStrategy.selectImagesForCatalogDesign(1);
        tabToSelectImageStrategy.clickAddButton();

        productUploadPage2Strategy2 = ProductUploadPage2Factory.getStrategy(testCase);
        productUploadPage2Strategy2.getAddProductPhotosText();
//        productUploadPage2Strategy.selectMarginRupees();
//        productUploadPage2Strategy.enterMarginTextFiled(moreThan20Per);
        productUploadPage2Strategy.clickSubmitButton();

//        productUploadPage2Strategy.enterMarginTextFiled(notMoreThan20Per);
//        int marginPrice = productUploadPage2Strategy.getEnteredMarginPrice();
        int singlePc1 = productUploadPage2Strategy.getPriceForSinglePc(4);
        int singlePc2 = productUploadPage2Strategy.getPriceForSinglePc(6);
        System.out.println("first piece " + singlePc1 + "second piece " + singlePc2);
//        int totalPriceForSingle = marginPrice + price2;
//        Assert.assertEquals(totalPriceForSingle, productUploadPage2Strategy.getPriceForSinglePc(4));
//        Assert.assertEquals(totalPriceForSingle, productUploadPage2Strategy.getPriceForSinglePc(6));
//        Assert.assertEquals(productUploadPage2Strategy.getPriceForSinglePc(4), productUploadPage2Strategy.getPriceForSinglePc(6));
        productUploadPage2Strategy.clickSubmitButton();

        //region Searching Uploaded single piece Catalog
        System.out.println("catalogSearching....");
        CatalogSearchHelper catalogSearchHelper = new CatalogSearchHelper(testCase);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(catalogName);
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(testCase);
        catalogDetailsPageStrategy.BackCatalogButton();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(testCase);
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();
        // endregion


    }

    public void uploadMultiSetProductUi() {

        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickProductsButton();
        CatalogPublicPageStrategy catalogPublicPageStrategy = CatalogPublicPageFactory.getStrategy(testCase);
        catalogPublicPageStrategy.clickUploadIcon();
        selectProductTypeInUploadPage();

        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        String screenName = "test_" + RandomStringUtils.randomAlphabetic(8).toLowerCase();
        productUploadPage1Strategy.enterScreenQualityName(screenName);
        productUploadPage1Strategy.clickContinueButton();

        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectCategory();
        SelectCategorySpinnerStrategy selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryItem(1);

        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryItem(2);

        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryItem(3);

        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryItem(4);

        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryItem(5);

        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryItem(6);

        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryItem(7);


        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryItem(8);

        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryItem(0);
        productUploadPage1Strategy.clickContinueButton();

        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnChooseABrandSpinner();
        ChooseABrandStrategy chooseABrandStrategy = ChooseABrandFactory.getStrategy(testCase);
        chooseABrandStrategy.clickONBrandNameFromSpinner(1);
        productUploadPage1Strategy.clickContinueButton();

        productUploadPage1Strategy.clickAddFabricButton();
        AddFabricPageStrategy addFabricPageStrategy = AddFabricPageFactory.getStrategy(testCase);
        addFabricPageStrategy.selectFabricItems(0);
        addFabricPageStrategy.clickSave();
        productUploadPage1Strategy.clickContinueButton();

        productUploadPage1Strategy.clickAddWorkButton();
        AddWorkPageStrategy addWorkPageStrategy = AddWorkPageFactory.getStrategy(testCase);
        addWorkPageStrategy.selectWorkItems(1);
        addWorkPageStrategy.clickSave();
        productUploadPage1Strategy.clickContinueButton();

        productUploadPage1Strategy.enterNumberOfPiecesPerScreen(-2);
        productUploadPage1Strategy.clickContinueButton();

        productUploadPage1Strategy.enterNumberOfPiecesPerScreen(0);
        productUploadPage1Strategy.clickContinueButton();

        productUploadPage1Strategy.enterNumberOfPiecesPerScreen(101);
        productUploadPage1Strategy.clickContinueButton();

        productUploadPage1Strategy.enterNumberOfPiecesPerScreen(2);
        productUploadPage1Strategy.clickContinueButton();

        productUploadPage1Strategy.enterPricesForScreenPieces(70);
        productUploadPage1Strategy.clickContinueButton();

        productUploadPage1Strategy.enterPricesForScreenPieces(00);
        productUploadPage1Strategy.clickContinueButton();

        productUploadPage1Strategy.enterPricesForScreenPieces(50002);
        productUploadPage1Strategy.clickContinueButton();

        productUploadPage1Strategy.enterPricesForScreenPieces(100);
        productUploadPage1Strategy.clickContinueButton();

        ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(testCase);
        productUploadPage2Strategy.enterScreenNameOrNumber("ScreenMultiSet");
        productUploadPage2Strategy.clickSubmitButton();

        productUploadPage2Strategy.enterScreenSetColorName("Red");
        productUploadPage2Strategy.clickSubmitButton();

        productUploadPage2Strategy.clickAddImagesSetButton();
        SelectPhotoAlbumPageStrategy selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(testCase);
        selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(1);
        TabToSelectImageStrategy tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(testCase);
        tabToSelectImageStrategy.selectImagesForCatalogDesign(0);
        tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(testCase);
        tabToSelectImageStrategy.clickAddButton();

        productUploadPage2Strategy.clickAddImagesSetButton();
        selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(testCase);
        selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(1);
        tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(testCase);
        tabToSelectImageStrategy.selectImagesForCatalogDesign(1);
        tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(testCase);
        tabToSelectImageStrategy.clickAddButton();
        productUploadPage2Strategy.clickSubmitButton();

    }

    protected void executeCatalogRelatedSteps() {
        uploadSingleColourProductUi();
    }

    protected void executeNonCatalogRelatedSteps() {
        uploadSingleColourProductUi();
    }

    protected void executeScreensRelatedSteps() {
        // uploadMultiSetProductUi();

    }

    public void verifyCategory() {

        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectTopCategory();
        SelectTopCategorySpinnerStrategy selectTopCategorySpinnerStrategy = SelectTopCategorySpinnerFactory.getStrategy(testCase);
        selectTopCategorySpinnerStrategy.selectTopCategoryItems(1);

        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectCategory();
        SelectCategorySpinnerStrategy selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Blazers & Suites");
        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Fit"));
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());


        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Blouse");
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.workButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());


        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Dress Materials");
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.workButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Stitching Type"));


        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Ghagra");
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.workButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());


        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Gown - Semi-Stitched");
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.workButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());

        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Gown - Stitched");
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.workButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));


        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Jeans");
        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Fit"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Stretch"));
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());


        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Kurtis");
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.workButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));

        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Lehengas");
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.workButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());

        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Sarees");
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.workButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());


        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Shirts");
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Fit"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Sleeve"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Neck Type"));

        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Suits - Readymade");
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.workButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());


        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("T-Shirts");
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Sleeve"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Neck Type"));


        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Trousers & Chino");
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Fit"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Rise"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Stretch"));


        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Winter Wear");
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Sleeve"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Neck Type"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Type"));


        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickOnSelectTopCategory();
        selectTopCategorySpinnerStrategy = SelectTopCategorySpinnerFactory.getStrategy(testCase);
        selectTopCategorySpinnerStrategy.selectTopCategoryItems(0);
        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);

        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Blazers & Suites");
        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Fit"));
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());


        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Indo Western Sherwanis");
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        // Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());

        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Jackets");
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        // Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());

        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Jeans");
        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Fit"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Stretch"));
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());


        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Kurta");
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        // Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());

        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Kurta Pyjamas");
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.fabricButtonIsDisplayed());
        Assert.assertTrue(productUploadPage1Strategy.styleButtonIsDisplayed());

        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Shirts");
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Fit"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Sleeve"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Neck Type"));

        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("T-Shirts");
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Sleeve"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Neck Type"));


        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Trousers & Chino");
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Fit"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Rise"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Stretch"));


        productUploadPage1Strategy.clickOnSelectCategory();
        selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Winter Wear");
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Size"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Sleeve"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Neck Type"));
        Assert.assertTrue(productUploadPage1Strategy.featuresOfProductIsDisplayed("Type"));

    }
}
