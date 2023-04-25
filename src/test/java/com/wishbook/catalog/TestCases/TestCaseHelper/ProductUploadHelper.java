package com.wishbook.catalog.TestCases.TestCaseHelper;


import com.wishbook.catalog.Execution.Core.TestConfiguration;
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

/**
 * Created by wishbook on 21/5/18.
 */

public class ProductUploadHelper extends ProductTestCaseHelper {


    private String catalogName;
    private String screenName;
    private int categoryItemIndex = 1;//Sarees Category
    private int brandItemIndex = 1;
    private int fabricItemIndex = 0;//ArtSilk
    private int workItemIndex = 1;//Chinkankariexecute
    private String selectedWork = "";
    private String selectedFabric = "";
    private String selectedBrandName = "";
    private String selectedCategory = "";
    private int pricesPerPieces = 500;
    private int numberOfPcs = 1;
    private int price = 500;

    public ProductUploadHelper(TestCase testCase, SetType setType, PhotoshootType photoshootType) {
        super(testCase, setType, photoshootType);
    }

    public String getScreenName() {
        return screenName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfPcs() {
        return numberOfPcs;
    }

    public int getPricesPerPieces() {
        return pricesPerPieces;
    }

    public void setPricesPerPieces(int pricesPerPieces) {
        this.pricesPerPieces = pricesPerPieces;
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public void setCategoryItemIndex(int categoryItemIndex) {
        this.categoryItemIndex = categoryItemIndex;
    }

    public void setBrandItemIndex(int brandItemIndex) {
        this.brandItemIndex = brandItemIndex;
    }

    public void setFabricItemIndex(int fabricItemIndex) {
        this.fabricItemIndex = fabricItemIndex;
    }

    public void setWorkItemIndex(int workItemIndex) {
        this.workItemIndex = workItemIndex;
    }

    public String getCatalogName() {
        return this.catalogName;
    }

    public String getSelectedWork() {
        return selectedWork;
    }

    public String getSelectedFabric() {
        return selectedFabric;
    }

    public String getSelectedBrandName() {
        return selectedBrandName;
    }


    //region
    private void uploadSingleColorSet() {
        commonMethodForFullAndSingleUpload();
        ProductUploadPage2Strategy productUploadPage2Strategy= ProductUploadPage2Factory.getStrategy(testCase);
        productUploadPage2Strategy.enterPrice(price);
        productUploadPage2Strategy.clickSubmitButton();
    }



    public void  uploadSinglePieceFullCatalog(){
        commonMethodForFullAndSingleUpload();
        ProductUploadPage2Strategy productUploadPage2Strategy= ProductUploadPage2Factory.getStrategy(testCase);
        productUploadPage2Strategy.selectAddMarginInPriceRadioButton();
        productUploadPage2Strategy.enterMarginToTextField(100);
        productUploadPage2Strategy.enterPrice(1500);
        productUploadPage2Strategy.clickSubmitButton();
    }

    public void uploadNonCatalog() {

        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(testCase);
        myBusinessPageStrategy.clickAddCatalogButton();
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickNonCatalogRadioButton();

        commonMethodForFullAndSingleUpload();

        ProductUploadPage2Strategy productUploadPage2Strategy= ProductUploadPage2Factory.getStrategy(testCase);
        productUploadPage2Strategy.enterPrice(price);
        productUploadPage2Strategy.clickSubmitButton();

    }

    public void uploadMultiColorSet() {
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickProductsButton();
        CatalogPublicPageStrategy catalogPublicPageStrategy = CatalogPublicPageFactory.getStrategy(testCase);
        catalogPublicPageStrategy.clickUploadIcon();
        selectProductTypeInUploadPage();

        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        screenName = "test_" + RandomStringUtils.randomAlphabetic(8).toLowerCase();
        productUploadPage1Strategy.enterScreenQualityName(screenName);
        System.out.println("ScreenName :" + screenName);

        productUploadPage1Strategy.clickOnSelectCategory();
        SelectCategorySpinnerStrategy selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
        selectCategorySpinnerStrategy.selectCategoryByName("Sarees (color set)");
        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        selectedCategory = productUploadPage1Strategy.getScreenCategory();
        System.out.println("Category = " + selectedCategory);

        productUploadPage1Strategy.clickAddFabricButton();
        AddFabricPageStrategy addFabricPageStrategy = AddFabricPageFactory.getStrategy(testCase);
        addFabricPageStrategy.selectFabricItems(fabricItemIndex);
        selectedFabric = addFabricPageStrategy.getFabricItem(fabricItemIndex);
        System.out.println("Fabric = " + selectedFabric);
        addFabricPageStrategy.clickSave();

        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
        productUploadPage1Strategy.clickAddWorkButton();
        AddWorkPageStrategy addWorkPageStrategy = AddWorkPageFactory.getStrategy(testCase);
        addWorkPageStrategy.selectWorkItems(workItemIndex);
        selectedWork = addWorkPageStrategy.getWorkItem(workItemIndex);
        System.out.println("Work = " + selectedWork);
        addWorkPageStrategy.clickSave();

        productUploadPage1Strategy.clickOnChooseABrandSpinner();
        ChooseABrandStrategy chooseABrandStrategy = ChooseABrandFactory.getStrategy(testCase);
        chooseABrandStrategy.clickONBrandNameFromSpinner(1);
        selectedBrandName = chooseABrandStrategy.getBrandNameSpinner(6);
        System.out.println("BrandName = " + selectedBrandName);
        productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);


        productUploadPage1Strategy.enterNumberOfPiecesPerScreen(1);
        productUploadPage1Strategy.enterPricesForScreenPieces(pricesPerPieces);
        productUploadPage1Strategy.clickContinueButton();


        ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(testCase);
        productUploadPage2Strategy.enterScreenNameOrNumber("ScreenMultiSet");
        productUploadPage2Strategy.enterScreenSetColorName("Red");
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
        uploadSingleColorSet();
    }

    protected void executeNonCatalogRelatedSteps() {
        uploadNonCatalog();
    }

    protected void executeScreensRelatedSteps() {
        uploadMultiColorSet();

    }
    protected void excuteSinglePieceFullCatalogSteps(){
        uploadSinglePieceFullCatalog();
    }



















   public void commonMethodForFullAndSingleUpload() {
       BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
       bottomTabPageStrategy.clickMyBusiness();
       MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(testCase);
       myBusinessPageStrategy.clickAddCatalogButton();
       ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
       productUploadPage1Strategy.clickOnSelectCategory();
       SelectCategorySpinnerStrategy selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(testCase);
       selectCategorySpinnerStrategy.selectCategoryByName("Sarees");
       productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
       selectedCategory = productUploadPage1Strategy.getCategory();
       System.out.println("Category = " + selectedCategory);
       productUploadPage1Strategy.clickOnChooseABrandSpinner();
       ChooseABrandStrategy chooseABrandStrategy = ChooseABrandFactory.getStrategy(testCase);
       chooseABrandStrategy.selectBrandByName("Bhatolia");
       productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
       selectedBrandName = productUploadPage1Strategy.getBrandName();
       System.out.println("BrandName = " + selectedBrandName);
       catalogName = "test_" + RandomStringUtils.randomAlphabetic(8).toLowerCase();
       productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
       String productName = productUploadPage1Strategy.enterCatalogName(catalogName);
       System.out.println("Product Name " + productName);
       productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
       productUploadPage1Strategy.clickAddFabricButton();
       AddFabricPageStrategy addFabricPageStrategy = AddFabricPageFactory.getStrategy(testCase);
       addFabricPageStrategy.clickFabricCheckBoxByText("Art Silk");
       addFabricPageStrategy.clickSave();
       productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
       productUploadPage1Strategy.clickAddWorkButton();
       AddWorkPageStrategy addWorkPageStrategy = AddWorkPageFactory.getStrategy(testCase);
       addWorkPageStrategy.clickWorkCheckBoxByText("Crochet");
       addWorkPageStrategy.clickSave();
       productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(testCase);
       productUploadPage1Strategy.clickContinueButton();
       ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(testCase);
       productUploadPage2Strategy.uploadCoverPhoto();
       UploadImageDialogStrategy uploadImageDialogStrategy = UploadImageDialogFactory.getStrategy(testCase);
       if (testCase.getTest().getTestConfiguration().getDevelopmentFramework() == TestConfiguration.DevelopmentFramework.ReactNative) {
           uploadImageDialogStrategy.chooseCamera();
       } else {
           int uploadingImageByCamera = 0;
           uploadImageDialogStrategy.selectCameraToUploadCatalog(uploadingImageByCamera);
       }

       CameraPageStrategy cameraPageStrategy = CameraPageFactory.getStrategy(testCase);
       cameraPageStrategy.takePic();
       CameraPicActionStrategy cameraPicActionStrategy = CameraPicActionFactory.getStrategy(testCase);
       cameraPicActionStrategy.saveClickedImage();

       productUploadPage2Strategy.clickFullCatalogOnly();
       productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(testCase);
       productUploadPage2Strategy.enterNumOfDesign(3);

       for (int i = 0; i < 3; i++) {
           productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(testCase);
           productUploadPage2Strategy.clickAddProductPhotosButton();
           SelectPhotoAlbumPageStrategy selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(testCase);
           TabToSelectImageStrategy tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(testCase);
           selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(2);
           tabToSelectImageStrategy.selectImagesForCatalogDesign(0);
           tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(testCase);
           tabToSelectImageStrategy.clickAddButton();
       }

   }   }