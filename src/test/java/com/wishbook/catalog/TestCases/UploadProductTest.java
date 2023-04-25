package com.wishbook.catalog.TestCases;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.AddFabricPage.AddFabricPageFactory;
import com.wishbook.catalog.PageObject.AddFabricPage.AddFabricPageStrategy;
import com.wishbook.catalog.PageObject.AddStylePage.AddStylePageFactory;
import com.wishbook.catalog.PageObject.AddStylePage.AddStylePageStrategy;
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
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1Factory;
import com.wishbook.catalog.PageObject.ProductUploadPage1.ProductUploadPage1Strategy;
import com.wishbook.catalog.PageObject.ProductUploadPage2.ProductUploadPage2Factory;
import com.wishbook.catalog.PageObject.ProductUploadPage2.ProductUploadPage2Strategy;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageStrategy;
import com.wishbook.catalog.PageObject.SelectCategorySpinner.SelectCategorySpinnerFactory;
import com.wishbook.catalog.PageObject.SelectCategorySpinner.SelectCategorySpinnerStrategy;
import com.wishbook.catalog.PageObject.SelectPhotoAlbumPage.SelectPhotoAlbumPageFactory;
import com.wishbook.catalog.PageObject.SelectPhotoAlbumPage.SelectPhotoAlbumPageStrategy;
import com.wishbook.catalog.PageObject.TabToSelectImage.TabToSelectImageFactory;
import com.wishbook.catalog.PageObject.TabToSelectImage.TabToSelectImageStrategy;
import com.wishbook.catalog.PageObject.UploadImageDialog.UploadImageDialogFactory;
import com.wishbook.catalog.PageObject.UploadImageDialog.UploadImageDialogStrategy;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import org.testng.Assert;

public class UploadProductTest extends TestCase {


    private Product product = new Product();

    public UploadProductTest(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));
    }


    public void setProduct(Product product) {
        this.product = product;
    }


    private void sellerLogin() {
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickAddCatalogButton();
    }

    private void uploadCoverPhoto() {
        if (product.getProductType() == Product.ProductType.SetMatch) {
            ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
            productUploadPage2Strategy.clickAddImagesSetButton();
            SelectPhotoAlbumPageStrategy selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(this);
            selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(1);
            TabToSelectImageStrategy tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
            tabToSelectImageStrategy.selectImagesForCatalogDesign(0);
            tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
            tabToSelectImageStrategy.clickAddButton();

            productUploadPage2Strategy.clickAddImagesSetButton();
            selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(this);
            selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(1);
            tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
            tabToSelectImageStrategy.selectImagesForCatalogDesign(0);
            tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
            tabToSelectImageStrategy.clickAddButton();
        } else {
            ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
            productUploadPage2Strategy.uploadCoverPhoto();
            UploadImageDialogStrategy uploadImageDialogStrategy = UploadImageDialogFactory.getStrategy(this);
            int uploadingImageByCamera = 0;
            uploadImageDialogStrategy.selectCameraToUploadCatalog(uploadingImageByCamera);
            CameraPageStrategy cameraPageStrategy = CameraPageFactory.getStrategy(this);
            cameraPageStrategy.takePic();
            CameraPicActionStrategy cameraPicActionStrategy = CameraPicActionFactory.getStrategy(this);
            cameraPicActionStrategy.saveClickedImage();
        }
    }

    private void addDesigns(int numberOfDesigns) {
        if (product.getProductType() == Product.ProductType.SetMatch) {
            ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
            productUploadPage1Strategy.enterNumberOfPiecesPerScreen(numberOfDesigns);
        } else {
            ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
            productUploadPage2Strategy.enterNumOfDesign(numberOfDesigns);

            for (int i = 0; i < numberOfDesigns; i++) {
                productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
                productUploadPage2Strategy.clickAddProductPhotosButton();
                SelectPhotoAlbumPageStrategy selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(this);
                TabToSelectImageStrategy tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);


                if (getTest().getTestConfiguration().getDevelopmentFramework() == TestConfiguration.DevelopmentFramework.ReactNative) {
                    selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(0);

                } else {
                    selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(2);
                    tabToSelectImageStrategy.selectImagesForCatalogDesign(0);
                    tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
                    tabToSelectImageStrategy.clickAddButton();
                    addMoreImagesOfSameDesign();
                }

            }
        }
    }

    private void enterPrice(int price) {
        if (product.getProductType() == Product.ProductType.SetMatch) {
            ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
            productUploadPage1Strategy.enterPricesForScreenPieces(price);
        } else {
            ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
            productUploadPage2Strategy.enterPrice(price);
        }
    }


    private void productAs() {

    }

    private void chooseProductType() {
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
        switch (product.getProductType()) {
            case Catalog:
                productUploadPage1Strategy.clickCatalogRadioButton();
                break;
            case NonCatalog:
                productUploadPage1Strategy.clickNonCatalogRadioButton();
                break;
            case SetMatch:
                productUploadPage1Strategy.clickSetMatchingRadioButton();
                break;
        }
    }

/*
    private void chooseTopCategory() {
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
        productUploadPage1Strategy.clickOnSelectTopCategory();
        SelectTopCategorySpinnerStrategy selectTopCategorySpinnerStrategy = SelectTopCategorySpinnerFactory.getStrategy(this);
        switch (product.getTopCategory()) {
            case Menswear:
                selectTopCategorySpinnerStrategy.selectTopCategoryItems(0);
                break;
            case Womenswear:
                selectTopCategorySpinnerStrategy.selectTopCategoryItems(1);
                break;
        }
    }

*/

    private void chooseCategory() {
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
        productUploadPage1Strategy.clickOnSelectCategory();
        SelectCategorySpinnerStrategy selectCategorySpinnerStrategy = SelectCategorySpinnerFactory.getStrategy(this);
        selectCategorySpinnerStrategy.selectCategoryByName(product.getCategory().getUiName());
    }

    private void enterProductName() {
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
        if (product.getProductType() == Product.ProductType.SetMatch) {
            productUploadPage1Strategy.enterScreenQualityName(product.getProductName());
        } else {
            productUploadPage1Strategy.enterCatalogName(product.getProductName());
        }
    }

    private void chooseFabrics() {
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
        productUploadPage1Strategy.clickAddFabricButton();
        AddFabricPageStrategy addFabricPageStrategy = AddFabricPageFactory.getStrategy(this);
        for (Product.Fabric fabric : product.getFabrics()) {
            addFabricPageStrategy.clickFabricCheckBoxByText(fabric.getUiName());
        }
        addFabricPageStrategy.clickSave();


    }

    private void chooseWorks() {
        if (product.getCategory() == Product.Category.BlazersAndSuits ||
                product.getCategory() == Product.Category.Jeans ||
                product.getCategory() == Product.Category.Shirts ||
                product.getCategory() == Product.Category.TrousersAndChino ||
                product.getCategory() == Product.Category.Tshirts ||
                product.getCategory() == Product.Category.WinterWear ||
                product.getCategory() == Product.Category.BlazersAndSuitsSizeSet
                ) {
            return;
        }
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
        productUploadPage1Strategy.clickAddWorkButton();
        AddWorkPageStrategy addWorkPageStrategy = AddWorkPageFactory.getStrategy(this);
        for (Product.Work work : product.getWorks()) {
            addWorkPageStrategy.clickWorkCheckBoxByText(work.getUiName());
        }
        addWorkPageStrategy.clickSave();

    }

    private void chooseStyle() {
        if (product.getCategory() == Product.Category.Jackets ||
                product.getCategory() == Product.Category.Kurta ||
                product.getCategory() == Product.Category.IndoWesternSherwanis) {
            return;
        }
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
        productUploadPage1Strategy.clickAddStyleButton();
        AddStylePageStrategy addStylePageStrategy = AddStylePageFactory.getStrategy(this);
        addStylePageStrategy.clickRadioButtonProductStyle(product.getStyle().getUiName());
        addStylePageStrategy.clickSave();
    }

     private void enterMaterialDimension(){
         ProductUploadPage1Strategy productUploadPage1Strategy=ProductUploadPage1Factory.getStrategy(this);

         if (product.getCategory() == Product.Category.Dupatta||product.getCategory() == Product.Category.DupattaSet){

                 productUploadPage1Strategy.enterDupattaLength(1);//[less than 2m]
                 productUploadPage1Strategy.clickContinueButton();

                 productUploadPage1Strategy.enterDupattaLength(10);

                 productUploadPage1Strategy.enterDupattaWidth(20);
                 productUploadPage1Strategy.clickContinueButton();

                 productUploadPage1Strategy.enterDupattaWidth(61);//[not more than 60m]
                 productUploadPage1Strategy.clickContinueButton();

                 productUploadPage1Strategy.enterDupattaWidth(60);


             }
             else if(product.getCategory() == Product.Category.Leggins||product.getCategory() == Product.Category.LegginsSet){
                 productUploadPage1Strategy.enterLegginsBottomLength(20);//[not less than 21m]
                 productUploadPage1Strategy.clickContinueButton();

                 productUploadPage1Strategy.enterLegginsBottomLength(71);//[not more than 70m]
                 productUploadPage1Strategy.clickContinueButton();

                 productUploadPage1Strategy.enterLegginsBottomLength(70);

         }
             else if(product.getCategory() == Product.Category.Palazzo||product.getCategory() == Product.Category.PalazzoSet) {
                productUploadPage1Strategy.enterPalazzoBottomLength(37);//[can't less than 38 inches]
                productUploadPage1Strategy.clickContinueButton();

                productUploadPage1Strategy.enterPalazzoBottomLength(101);//[can't more than 100 inches]
                productUploadPage1Strategy.clickContinueButton();

                productUploadPage1Strategy.enterPalazzoBottomLength(100);
         }

    }

    private void chooseSizes() {
        if (product.getCategory() == Product.Category.Kurtis ||
                product.getCategory() == Product.Category.SuitReadyMadeSizeSet ||
                product.getCategory() == Product.Category.KurtisSizeSet ||
                product.getCategory() == Product.Category.BlazersAndSuits ||
                product.getCategory() == Product.Category.BlazersAndSuitsSizeSet ||
                product.getCategory() == Product.Category.GownStitched ||
                product.getCategory() == Product.Category.Jeans ||
                product.getCategory() == Product.Category.Shirts ||
                product.getCategory() == Product.Category.SuitReadyMade ||
                product.getCategory() == Product.Category.TrousersAndChino ||
                product.getCategory() == Product.Category.Tshirts ||
                product.getCategory() == Product.Category.WinterWear ||
                product.getCategory() == Product.Category.KurtisSizeSet ||
                product.getCategory() == Product.Category.GownStitchedSizeSet||
                product.getCategory() == Product.Category.BlouseSizeSet ) {

            ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
            for (Product.Size size : product.getSizes()) {
                productUploadPage2Strategy.clickCheckBoxProductSizeByText(size.getUiName());
            }
        }
    }

    private void chooseFit() {
        if (product.getCategory() == Product.Category.BlazersAndSuits ||
                product.getCategory() == Product.Category.BlazersAndSuitsSizeSet ||
                product.getCategory() == Product.Category.Jeans ||
                product.getCategory() == Product.Category.TrousersAndChino ||
                product.getCategory() == Product.Category.Shirts) {
            ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
            productUploadPage1Strategy.clickRadioButtonProductFit(product.getFit().getUiName());

        }
    }


    private void chooseSleeve() {
        if (product.getCategory() == Product.Category.Tshirts ||
                product.getCategory() == Product.Category.Shirts ||
                product.getCategory() == Product.Category.WinterWear) {
            ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
            productUploadPage1Strategy.clickRadioButtonProductSleeveByText(product.getSleeve().getUiName());

        }
    }

    private void chooseNeckType() {
        if (product.getCategory() == Product.Category.Tshirts ||
                product.getCategory() == Product.Category.Shirts ||
                product.getCategory() == Product.Category.WinterWear) {
            ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
            productUploadPage1Strategy.clickRadioButtonProductNeckType(product.getNeckType().getUiName());

        }
    }

    private void chooseStretch() {
        if (product.getCategory() == Product.Category.Jeans ||
                product.getCategory() == Product.Category.TrousersAndChino) {
            ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
            productUploadPage1Strategy.clickRadioButtonProductStretch(product.getStretch().getUiName());

        }
    }

    private void chooseRise() {
        if (product.getCategory() == Product.Category.TrousersAndChino) {
            ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
            productUploadPage1Strategy.clickRadioButtonProductRise(product.getRise().getUiName());

        }
    }

    public void chooseOccasionWear() {
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
        productUploadPage1Strategy.clickOccassionDressCheckbox("Party Wear");

    }

    private void enterMaterialLength() {
        if (product.getCategory() == Product.Category.DressMaterialsDressUnstitched ||
             product.getCategory() == Product.Category.DressMaterialsUnstitchedColorSet) {
            ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
            productUploadPage1Strategy.enterTopMaterialLength(9);
            productUploadPage1Strategy.enterBottomMaterialLength(9);
            productUploadPage1Strategy.enterDupattaLength(9);

        }
    }

    private void chooseType() {
        if (product.getCategory() == Product.Category.WinterWear) {
            ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
            productUploadPage1Strategy.clickRadioButtonProductType(product.getWinterWearType().getUiName());

        }
    }

    private void keepTheProductLiveForDays() {
        ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
        productUploadPage1Strategy.setCatalogEnableDurationField("9");
        productUploadPage1Strategy.clickContinueButton();
        productUploadPage1Strategy.setCatalogEnableDurationField("20");
        productUploadPage1Strategy.clickContinueButton();
    }

    private void keepSetMatchingLiveDays(){
        ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
        productUploadPage2Strategy.keepSetMatchingLiveTextbox("9");
        productUploadPage2Strategy.clickSubmitButton();
        productUploadPage2Strategy.keepSetMatchingLiveTextbox("20");
        productUploadPage2Strategy.clickSubmitButton();
    }

    private void addMoreImagesOfSameDesign(){
        ProductUploadPage2Strategy productUploadPage2Strategy= ProductUploadPage2Factory.getStrategy(this);
        productUploadPage2Strategy.clickAddMoreImagesOfSameDesign();
        SelectPhotoAlbumPageStrategy selectPhotoAlbumPageStrategy = SelectPhotoAlbumPageFactory.getStrategy(this);
        selectPhotoAlbumPageStrategy.selectImagesPhotoAlbum(0);
        TabToSelectImageStrategy tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
        tabToSelectImageStrategy.selectImagesForCatalogDesign(0);
        tabToSelectImageStrategy.selectImagesForCatalogDesign(1);
        tabToSelectImageStrategy.selectImagesForCatalogDesign(2);
        tabToSelectImageStrategy.selectImagesForCatalogDesign(3);
        tabToSelectImageStrategy = TabToSelectImageFactory.getStrategy(this);
        tabToSelectImageStrategy.clickAddButton();

    }



    private void upload() {
        chooseProductType();
        enterProductName();
        chooseCategory();
        chooseFabrics();
        chooseWorks();
        chooseStyle();
        chooseFit();
       // chooseStitching();
        enterMaterialLength();
        chooseSleeve();
        chooseNeckType();
        chooseStretch();
        chooseRise();
        chooseType();
        if(product.getCategory()==Product.Category.KurtisSizeSet||
                product.getCategory()==Product.Category.SuitReadyMadeSizeSet||
                product.getCategory()==Product.Category.GownStitchedSizeSet||
                product.getCategory()==Product.Category.BlouseSizeSet ||
                product.getCategory()==Product.Category.LehengasSizeSet||
                product.getCategory() == Product.Category.GownSemiStitchedSizeSet) {
            chooseSizes();
        }
        chooseOccasionWear();
        if (product.getProductType() == Product.ProductType.Catalog || product.getProductType() == Product.ProductType.NonCatalog) {
            keepTheProductLiveForDays();
        } else {
            addDesigns(product.getNumberOfDesigns());
            enterPrice(product.getProductPrice());
            ProductUploadPage1Strategy productUploadPage1Strategy = ProductUploadPage1Factory.getStrategy(this);
            productUploadPage1Strategy.clickContinueButton();
        }


        if (product.getProductType() == Product.ProductType.Catalog || product.getProductType() == Product.ProductType.NonCatalog) {
            chooseSizes();
        }
        if (product.getCategory() == Product.Category.KurtisSizeSet ||
            product.getCategory() == Product.Category.SuitReadyMadeSizeSet ||
            product.getCategory() == Product.Category.GownStitchedSizeSet||
            product.getCategory() == Product.Category.BlouseSizeSet||
                product.getCategory() == Product.Category.GownSemiStitchedSizeSet  ) {
            ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
            productUploadPage2Strategy.enterScreenNameOrNumber("ScreenMultiSet");

        } else if (product.getCategory() == Product.Category.SareesColorSet ||
                product.getCategory() == Product.Category.DressMaterialsUnstitchedColorSet) {
            ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
            productUploadPage2Strategy.enterScreenNameOrNumber("ScreenMultiSet");
            productUploadPage2Strategy.enterScreenSetColorName("Red");
        }

        if (product.getProductType() == Product.ProductType.Catalog || product.getProductType() == Product.ProductType.NonCatalog) {
            ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
            switch (product.getSellingProductAs()) {
                case FullCatalog:
                    productUploadPage2Strategy.clickFullCatalogOnly();
                    break;
                case SinglePiecesAndFullSetBoth:
                    productUploadPage2Strategy.clickSinglePieceAndFullCatalogBoth();
                    break;
            }
        }

        uploadCoverPhoto();

        if (product.getProductType() == Product.ProductType.Catalog || product.getProductType() == Product.ProductType.NonCatalog) {
            addDesigns(product.getNumberOfDesigns());
            enterPrice(product.getProductPrice());
            ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
            String firstDesignPrice = productUploadPage2Strategy.getFirstDesignPrice();
            String secondDesignPrice = productUploadPage2Strategy.getSecondDesignPrice();
            //  Assert.assertEquals(firstDesignPrice,secondDesignPrice);

        }
        else if(product.getProductType() == Product.ProductType.SetMatch){
            keepSetMatchingLiveDays();
            }

        ProductUploadPage2Strategy productUploadPage2Strategy = ProductUploadPage2Factory.getStrategy(this);
        //   productUploadPage2Strategy.clickSubmitButton();



    }



    protected void run() {
        sellerLogin();
        upload();



    }
}





























