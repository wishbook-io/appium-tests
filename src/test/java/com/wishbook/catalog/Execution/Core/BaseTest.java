package com.wishbook.catalog.Execution.Core;

import com.wishbook.catalog.PageObject.BecomeASellerPage.BecomeASellerPageFactory;
import com.wishbook.catalog.PageObject.BecomeASellerPage.BecomeASellerPageStrategy;
import com.wishbook.catalog.TestCases.AddToCart.AddToCart;
import com.wishbook.catalog.TestCases.BecomeSeller.BecomeSeller;
import com.wishbook.catalog.TestCases.CatalogBrowsing.CatalogBrowsing;
import com.wishbook.catalog.TestCases.CatalogCategories.CatalogCategories;
import com.wishbook.catalog.TestCases.CatalogDetails.CatalogDetails;
import com.wishbook.catalog.TestCases.CatalogEnquiry.CatalogEnquiry;
import com.wishbook.catalog.TestCases.ChangePassword.ChangePassword;
import com.wishbook.catalog.TestCases.ClearanceDiscount.ClearanceDiscountTest;
import com.wishbook.catalog.TestCases.CommonProduct.UploadCommonSinglePieceAndFullCatalog;
import com.wishbook.catalog.TestCases.ExploringProducts.ProductUIValidation;
import com.wishbook.catalog.TestCases.Filter.FilterProducts;
import com.wishbook.catalog.TestCases.HomePageUI.HomePageUiManufacturer;
import com.wishbook.catalog.TestCases.HomePageUI.HomePageUiRetailer;
import com.wishbook.catalog.TestCases.HomePageUI.HomePageUiWholesaler;
import com.wishbook.catalog.TestCases.KycAndBankDetails.KycAndBankDetails;
import com.wishbook.catalog.TestCases.Login.Login;
import com.wishbook.catalog.TestCases.MyFilter.MyFilter;
import com.wishbook.catalog.TestCases.Product;
import com.wishbook.catalog.TestCases.CommonProduct.DisableCommonCatalog;
import com.wishbook.catalog.TestCases.CommonProduct.UploadCommonCatalog;
import com.wishbook.catalog.TestCases.CommonProduct.UploadCommonScreen;
import com.wishbook.catalog.TestCases.OrderTestCase;
import com.wishbook.catalog.TestCases.ExploringProducts.ExploringNonCatalog;
import com.wishbook.catalog.TestCases.ExploringProducts.ExploringScreen;
import com.wishbook.catalog.TestCases.ProductTab.ProductTabTest;
import com.wishbook.catalog.TestCases.Profile.Profile;
import com.wishbook.catalog.TestCases.PurchaseOrderCancel.PurchaseOrderCancelRetailer;
import com.wishbook.catalog.TestCases.Registration.Registration;
import com.wishbook.catalog.TestCases.ReselleProductShare.ResellerProductShare;
import com.wishbook.catalog.TestCases.ResellerCatalog.ResellerSinglePieces;
import com.wishbook.catalog.TestCases.ResellerCatalog.ResellerUploadingSingleDesignsWithMargins;
import com.wishbook.catalog.TestCases.SalesPersonLogin.SalesPersonLogin;
import com.wishbook.catalog.TestCases.ShippingCharge.ShipmentCharges;
import com.wishbook.catalog.TestCases.SortingProducts.SortingProducts;
import com.wishbook.catalog.TestCases.UploadProductTest;
import com.wishbook.catalog.TestCases.UploadedCatalogInSearch.UploadedCatalogInSearch;
import com.wishbook.catalog.TestCases.WishListCatalogs.WishListCatalogs;
import com.wishbook.catalog.TestCases.WishbookMoneyTest.WishbookMoneyVisibility;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by wishbook on 13/3/18.
 */

public class BaseTest {
    private WebDriver driver;
    private TestConfiguration testConfiguration;

    //region GetSet Methods For Common Products
    private String commonCatalogName;
    private String commonScreenName;
    private String commonCatalogBrandName;
    private String commonCatalogCategory;
    private String commoncatalogWork;
    private String commonCatalogFabric;
    private String commonScreenCategory;
    private String commonScreenBrand;
    private boolean uploadCommonCatalog = true;
    private boolean uploadCommonScreen = true;
    private boolean uploadSinglePiece=true;

    public String getCommonSinglePieceCatalogName() {
        return commonSinglePieceCatalogName;
    }

    public void setCommonSinglePieceCatalogName(String commonSinglePieceCatalogName) {
        this.commonSinglePieceCatalogName = commonSinglePieceCatalogName;
    }

    private String commonSinglePieceCatalogName;


    public WebDriver getDriver() {
        return driver;
    }

    public TestConfiguration getTestConfiguration() {
        return testConfiguration;
    }

    public String getCommonCatalogBrandName() {
        return commonCatalogBrandName;
    }

    public void setCommonCatalogBrandName(String commonCatalogBrandName) {
        this.commonCatalogBrandName = commonCatalogBrandName;
    }

    @SuppressWarnings("unused")
    public String getCommonCatalogCategory() {
        return commonCatalogCategory;
    }

    public void setCommonCatalogCategory(String commonCatalogCategory) {
        this.commonCatalogCategory = commonCatalogCategory;
    }

    public String getCommoncatalogWork() {
        return commoncatalogWork;
    }

    public void setCommoncatalogWork(String commoncatalogWork) {
        this.commoncatalogWork = commoncatalogWork;
    }

    public String getCommonCatalogFabric() {
        return commonCatalogFabric;
    }

    public void setCommonCatalogFabric(String commonCatalogFabric) {
        this.commonCatalogFabric = commonCatalogFabric;
    }

    public String getCommonScreenName() {

        return commonScreenName;
    }

    public void setCommonScreenName(String commonScreenName) {
        this.commonScreenName = commonScreenName;
    }

    public String getCommonScreenCategory() {
        return commonScreenCategory;
    }

    public void setCommonScreenCategory(String commonScreenCategory) {
        this.commonScreenCategory = commonScreenCategory;
    }

    public String getCommonScreenBrand() {
        return commonScreenBrand;
    }

    public void setCommonScreenBrand(String commonScreenBrand) {
        this.commonScreenBrand = commonScreenBrand;
    }

    public String getCommonCatalogName() {
        return commonCatalogName;
    }

    public void setCommonCatalogName(String commonCatalogName) {
        this.commonCatalogName = commonCatalogName;
    }
//endregion

    public void uploadCommonScreen() throws Exception {
        if (uploadCommonScreen) {
            uploadCommonScreen = false;
            UploadCommonScreen up = new UploadCommonScreen(this);
            up.execute();
        }
    }

    private void uploadCommonCatalog() throws Exception {
        if (uploadCommonCatalog) {
            uploadCommonCatalog = false;
            UploadCommonCatalog u = new UploadCommonCatalog(this);
            u.execute();
        }
    }

    private void uploadCommonSinglePieceFullCatalog() throws Exception{
        if(uploadSinglePiece){
            uploadSinglePiece=false;
        UploadCommonSinglePieceAndFullCatalog commonSinglePieceAndFullCatalog= new UploadCommonSinglePieceAndFullCatalog(this);
        commonSinglePieceAndFullCatalog.execute();

        }

    }


    @BeforeMethod(alwaysRun = true)
    @Parameters(value = {"config"})
    public void setUp(String config) throws Exception {
        System.out.println(config);

        testConfiguration = TestConfiguration.getConfigFromJson(config);
        if (testConfiguration.isAndroid()) {
            DesiredCapabilities capabilities = testConfiguration.getDesiredCapabilities();
            String apkPath = testConfiguration.getAppiumApp();
            if (apkPath != null && apkPath.length() > 0) {
                capabilities.setCapability("fullReset", "true");
                capabilities.setCapability("noReset", "false");
            }
            driver = new AndroidDriver(new URL(testConfiguration.getAppiumServerUrl()), capabilities);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


            //uploadCommonScreen();
            //uploadCommonNonCatalog();
             //uploadCommonCatalog();


        }

    }


    @AfterMethod(alwaysRun = true)
    public void End() {
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println("Failed to close driver..." + e.toString());
        }
    }


    private void runOrderRegressionTest(boolean resellerOrder,
                                        OrderTestCase.PaymentMethod paymentMethod,
                                        OrderTestCase.ProductOrderType productOrderType,
                                        boolean discount) throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            OrderTestCase testCase = new OrderTestCase(this);
            testCase.setResellerOrder(resellerOrder);
            testCase.setPaymentMethod(paymentMethod);
            testCase.setProductOrderType(productOrderType);
            testCase.setDiscountEnabled(discount);
            testCase.execute();
        }

    }


    private void runUploadProductRegressionTest(Product product) throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            UploadProductTest test = new UploadProductTest(this);
            test.setProduct(product);
            test.execute();
        }

    }



     //region normaL

    @Test(priority = -144,alwaysRun = false)
    public void clearanceDiscount() throws Exception{
        uploadCommonSinglePieceFullCatalog();
        ClearanceDiscountTest clearanceDiscount= new ClearanceDiscountTest(this);
        clearanceDiscount.execute();
    }
    @Test(priority = 0, alwaysRun = true)
    public void loginUser() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            Login login = new Login(this);
            login.execute();
        }
    }

    @Test(priority = 1, alwaysRun = true)
    public void registration() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            Registration registration = new Registration(this);
            registration.execute();

        }
    }

    @Test(priority = 2, alwaysRun = true)
    public void wishListCatalogs() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            WishListCatalogs wishListCatalogs = new WishListCatalogs(this);
            wishListCatalogs.execute();
        }
    }

    @Test(priority = 3, alwaysRun = true)
    public void addToCart() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            AddToCart addToCart = new AddToCart(this);
            addToCart.execute();
        }
    }

    @Test(priority = 4, alwaysRun = true)
    public void changePassword() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            ChangePassword changePassword = new ChangePassword(this);
            changePassword.execute();
        }
    }

    //Android
    @Test(priority = 5, alwaysRun = true)
    public void profileUser() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            Profile profile = new Profile(this);
            profile.execute();
        }
    }

    @Test(priority = 6, alwaysRun = true)
    public void createEnquiry() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            CatalogEnquiry catalogEnquiry = new CatalogEnquiry(this);
            catalogEnquiry.execute();
        }
    }


    @Test(priority = 8, alwaysRun = true)
    public void kycBankDetails() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            KycAndBankDetails kycAndBankDetails = new KycAndBankDetails(this);
            kycAndBankDetails.execute();
        }
    }

    @Test(priority = 9, enabled = false)
    public void sortingProduct() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            SortingProducts sortingProducts = new SortingProducts(this);
            sortingProducts.execute();
        }
    }


    @Test(priority = 10, alwaysRun = true)
    public void purchaseOrderCancelRetailer() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            PurchaseOrderCancelRetailer purchaseOrderCancelRetailer = new PurchaseOrderCancelRetailer(this);
            purchaseOrderCancelRetailer.execute();
        }
    }

    @Test(priority = 11, alwaysRun = true)
    public void resellerShareProduct() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            ResellerProductShare resellerProductShare = new ResellerProductShare(this);
            resellerProductShare.execute();

        }
    }


    @Test(priority = 12)
    public void filterProducts() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            FilterProducts filterProducts = new FilterProducts(this);
            filterProducts.execute();
        }
    }

    @Test(priority = 13)
    public void myFilterTest() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            MyFilter myFilter = new MyFilter(this);
            myFilter.execute();
        }

    }


    @Test(priority = 15)
    public void productTabCategory() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            ProductTabTest productTabTest = new ProductTabTest(this);
            productTabTest.execute();
        }
    }

    @Test(priority = 16)
    public void manufacturerHomePage() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            HomePageUiManufacturer homePageUiManufacturer = new HomePageUiManufacturer(this);
            homePageUiManufacturer.execute();

        }
    }
    @Test(priority = 4)
    public void becomeSellerTest() throws Exception {
        if (testConfiguration.getServerType() == TestConfiguration.ServerType.Staging) {
            BecomeSeller becomeSeller = new BecomeSeller(this);
            becomeSeller.execute();

        }

    }


    //endregion


     //region Upload catalog Womenswear
    @Test(priority = 1)
    public void uploadFullCatalogWomenSarees() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.Catalog);
        product.setCategory(Product.Category.Sarees);
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setNumberOfDesigns(3);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        product.setStyle(Product.Style.ACut);
        runUploadProductRegressionTest(product);

    }


    @Test(priority = 2)
    public void uploadFullCatalogWomenKurties() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.Catalog);
        product.setCategory(Product.Category.Kurtis);
        ArrayList<Product.Size> sizes = new ArrayList<Product.Size>();
        sizes.add(Product.Size.XS);
        product.setSizes(sizes);
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        product.setStyle(Product.Style.ACut);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setNumberOfDesigns(3);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        runUploadProductRegressionTest(product);
    }

    @Test(priority = 3)
    public void uploadSuitSemiStitched(){

    }

    @Test(priority = 4)
    public void uploadFullCatalogWomenDressMaterialsUnstitched() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.Catalog);
        product.setCategory(Product.Category.DressMaterialsDressUnstitched);
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setStitchingType(Product.StitchingType.SemiStitched);
        product.setFabrics(fabrics);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setNumberOfDesigns(3);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        product.setStyle(Product.Style.ACut);
        runUploadProductRegressionTest(product);

    }


    @Test(priority = 2)
    public void uploadFullCatalogWomenBlouse() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.Catalog);
        product.setCategory(Product.Category.Blouse);
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setNumberOfDesigns(3);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        product.setStyle(Product.Style.ACut);
//        product.setSellingProductAs(Product.SellingProductAs.FullCatalog);
        runUploadProductRegressionTest(product);
    }





    @Test(priority = 4)
    public void uploadFullCatalogWomenGownSemiStitched() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.Catalog);
        product.setCategory(Product.Category.GownSemiStitched);
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setNumberOfDesigns(3);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        product.setStyle(Product.Style.ACut);
//        product.setSellingProductAs(Product.SellingProductAs.FullCatalog);
        runUploadProductRegressionTest(product);


    }

    @Test(priority = 5)
    public void uploadFullCatalogWomenGownStitched() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.Catalog);
        product.setCategory(Product.Category.GownStitched);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setNumberOfDesigns(3);
        product.setStyle(Product.Style.ACut);
        ArrayList<Product.Size> sizes = new ArrayList<Product.Size>();
        sizes.add(Product.Size.L);
        product.setSizes(sizes);
//        product.setSellingProductAs(Product.SellingProductAs.FullCatalog);
        runUploadProductRegressionTest(product);

    }


    @Test(priority = 6)
    public void uploadFullCatalogWomenLehengas() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.Catalog);
        product.setCategory(Product.Category.Lehengas);
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setNumberOfDesigns(3);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        product.setStyle(Product.Style.ACut);
//        product.setSellingProductAs(Product.SellingProductAs.FullCatalog);
        runUploadProductRegressionTest(product);

    }



    //endregion

     //region upload set
    @Test(priority = 8)
    public void uploadSetMatchingWomenKurties() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.SetMatch);
        product.setCategory(Product.Category.KurtisSizeSet);
        ArrayList<Product.Size> sizes = new ArrayList<Product.Size>();
        sizes.add(Product.Size.L);
        sizes.add(Product.Size.S);
        product.setSizes(sizes);
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        product.setStyle(Product.Style.ACut);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        runUploadProductRegressionTest(product);
    }

    @Test(priority = 9)
    public void uploadSetMatchingWomenBlouse() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.SetMatch);
        product.setCategory(Product.Category.BlouseSizeSet);
        ArrayList<Product.Size> sizes = new ArrayList<Product.Size>();
        sizes.add(Product.Size.L);
        sizes.add(Product.Size.M);
        product.setSizes(sizes);
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        product.setStyle(Product.Style.ACut);
        runUploadProductRegressionTest(product);
    }


    @Test(priority = 10)
    public void uploadSetMatchingWomenDressMaterials() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.SetMatch);
        product.setCategory(Product.Category.DressMaterialsUnstitchedColorSet);
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        product.setStyle(Product.Style.ACut);
        product.setStitchingType(Product.StitchingType.Stitched);
        runUploadProductRegressionTest(product);

    }


    @Test(priority = 11)
    public void uploadSetMatchingWomenGownSemiStitched() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.SetMatch);
        product.setCategory(Product.Category.GownSemiStitchedSizeSet);
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        product.setStyle(Product.Style.ACut);
        ArrayList<Product.Size> sizes = new ArrayList<Product.Size>();
        sizes.add(Product.Size.L);
        sizes.add(Product.Size.S);
        product.setSizes(sizes);
        runUploadProductRegressionTest(product);


    }

    @Test(priority = 12)
    public void uploadSetMatchingWomenGownStitched() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.SetMatch);
        product.setCategory(Product.Category.GownStitchedSizeSet);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setStyle(Product.Style.ACut);
        ArrayList<Product.Size> sizes = new ArrayList<Product.Size>();
        sizes.add(Product.Size.L);
        sizes.add(Product.Size.S);
        product.setSizes(sizes);
        runUploadProductRegressionTest(product);

    }


    @Test(priority = 13)
    public void uploadSetMatchingWomenLehengas() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.SetMatch);
        product.setCategory(Product.Category.LehengasSizeSet);
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        product.setStyle(Product.Style.ACut);
        ArrayList<Product.Size> sizes = new ArrayList<Product.Size>();
        sizes.add(Product.Size.L);
        sizes.add(Product.Size.S);
        product.setSizes(sizes);
        runUploadProductRegressionTest(product);

    }

    @Test(priority = 14)
    public void uploadSetMatchingWomenSarees() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.SetMatch);
        product.setCategory(Product.Category.SareesColorSet);
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        product.setStyle(Product.Style.ACut);
        runUploadProductRegressionTest(product);

    }


    @Test(priority = 15)
    public void uploadFullCatalogWomenSuitReadyMade() throws Exception {
        Product product = new Product();
        product.setProductType(Product.ProductType.SetMatch);
        product.setCategory(Product.Category.SuitReadyMadeSizeSet);
        ArrayList<Product.Size> sizes = new ArrayList<Product.Size>();
        sizes.add(Product.Size.XS);
        sizes.add(Product.Size.S);
        product.setSizes(sizes);
        ArrayList<Product.Fabric> fabrics = new ArrayList<Product.Fabric>();
        fabrics.add(Product.Fabric.ArtSilk);
        product.setFabrics(fabrics);
        ArrayList<Product.Work> works = new ArrayList<Product.Work>();
        works.add(Product.Work.Chicken);
        product.setWorks(works);
        product.setStyle(Product.Style.ACut);
        product.setProductName("test_" + RandomStringUtils.randomAlphabetic(10).toLowerCase());
        runUploadProductRegressionTest(product);


    }
    //endregion



    //region order catalog with discount
    @Test(priority = -71, alwaysRun = true)
    public void noReseller_CashFree_Zero_FullCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.Cashfree,
                OrderTestCase.ProductOrderType.FullCatalog,
                true);
    }

    @Test(priority = 2, alwaysRun = true,enabled = true)
    public void noReseller_COD_Zero_FullCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.COD,
                OrderTestCase.ProductOrderType.FullCatalog,
                true);
    }

    @Test(priority = -3, alwaysRun = true)
    public void noReseller_Cheque_Zero_FullCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.Cheque,
                OrderTestCase.ProductOrderType.FullCatalog,
                true);
    }

    @Test(priority = -4, alwaysRun = true)
    public void noReseller_NEFT_Zero_FullCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.NEFT,
                OrderTestCase.ProductOrderType.FullCatalog,
                true);
    }


    @Test(priority = 5, alwaysRun = true)
    public void noReseller_WishbookCredit_Zero_FullCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.WishbookCredit,
                OrderTestCase.ProductOrderType.FullCatalog,
                true);
    }

//endregion

    //region reseller order catalog with Discount
    @Test(priority = 16, alwaysRun = true)
    public void yesReseller_CashFree_Zero_FullCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.Cashfree,
                OrderTestCase.ProductOrderType.FullCatalog,
                true);
    }


    @Test(priority = -17, alwaysRun = true)
    public void yesReseller_Cheque_Zero_FullCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.Cheque,
                OrderTestCase.ProductOrderType.FullCatalog,
                true);
    }


    @Test(priority = -18, alwaysRun = true)
    public void yesReseller_NEFT_Zero_FullCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.NEFT,
                OrderTestCase.ProductOrderType.FullCatalog,
                true);
    }

    @Test(priority = -4, alwaysRun = true)
    public void yesReseller_COD_Zero_FullCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.COD,
                OrderTestCase.ProductOrderType.FullCatalog,
                true);
    }





    //endregion


    //region order ScreenSet with discount
    @Test(priority = 11, alwaysRun = true)
    public void noReseller_Cashfree_Zero_ScreenSet_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.Cashfree,
                OrderTestCase.ProductOrderType.ScreenSet,
                true);
    }

    @Test(priority = 12, alwaysRun = true)
    public void noReseller_Cheque_Zero_ScreenSet_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.Cheque,
                OrderTestCase.ProductOrderType.ScreenSet,
                true);
    }


    @Test(priority = 13, alwaysRun = true)
    public void noReseller_NEFT_Zero_ScreenSet_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.NEFT,
                OrderTestCase.ProductOrderType.ScreenSet,
                true);
    }

    @Test(priority = 14, alwaysRun = true)
    public void noReseller_COD_Zero_ScreenSet_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.COD,
                OrderTestCase.ProductOrderType.ScreenSet,
                true);
    }

    @Test(priority = 15, alwaysRun = true)
    public void noReseller_WishbookCredit_Zero_ScreenSet_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.WishbookCredit,
                OrderTestCase.ProductOrderType.ScreenSet,
                true);
    }

    //endregion
    
     //region Non Catalog With Discount
    @Test(priority = 6, alwaysRun = true)
    public void noReseller_CashFree_Zero_FullNonCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.Cashfree,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                true);
    }


    @Test(priority = 7, alwaysRun = true)
    public void noReseller_Cheque_Zero_FullNonCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.Cheque,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                true);
    }


    @Test(priority = 8, alwaysRun = true)
    public void noReseller_NEFT_Zero_FullNonCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.NEFT,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                true);
    }
    @Test(priority = 9, alwaysRun = true,enabled = false)
    public void noReseller_COD_Zero_FullNonCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.COD,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                true);
    }

    @Test(priority = 10, alwaysRun = true)
    public void noReseller_WishbookCredit_Zero_FullNonCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.WishbookCredit,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                true);
  }

    //endregion


     //region reseller order ScreenSet with Discount
    @Test(priority = 71, alwaysRun = true)
    public void yesReseller_Cashfree_Zero_ScreenSet_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.Cashfree,
                OrderTestCase.ProductOrderType.ScreenSet,
                true);
    }

    @Test(priority = 75, alwaysRun = true)
    public void yesReseller_Cheque_Zero_ScreenSet_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.Cheque,
                OrderTestCase.ProductOrderType.ScreenSet,
                true);
    }

    @Test(priority = 77, alwaysRun = true)
    public void yesReseller_NEFT_Zero_ScreenSet_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.NEFT,
                OrderTestCase.ProductOrderType.ScreenSet,
                true);
    }

    @Test(priority = 79, alwaysRun = true)
    public void yesReseller_COD_Zero_ScreenSet_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.COD,
                OrderTestCase.ProductOrderType.ScreenSet,
                true);
    }

    @Test(priority = 81, alwaysRun = true)
    public void yesReseller_WishbookCredit_Zero_ScreenSet_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.WishbookCredit,
                OrderTestCase.ProductOrderType.ScreenSet,
                true);
    }
    //endregion


    //region reseller order Non Catalog with discount
    @Test(priority = 58, alwaysRun = true)
    public void yesReseller_CashFree_Zero_FullNonCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.Cashfree,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                true);
    }

    @Test(priority = 62, alwaysRun = true)
    public void yesReseller_Cheque_Zero_FullNonCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.Cheque,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                true);
    }


    @Test(priority = 64, alwaysRun = true)
    public void yesReseller_NEFT_Zero_FullNonCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.NEFT,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                true);
    }

    @Test(priority = 66, alwaysRun = true)
    public void yesReseller_COD_Zero_FullNOnCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.COD,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                true);
    }


    @Test(priority = 68, alwaysRun = true)
    public void yesReseller_WishbookCredit_Zero_FullNonCatalog_WithDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.WishbookCredit,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                true);
    }

    //endregion



    //region order catalog without Discount
    @Test(priority = 84, alwaysRun = true)
    public void noReseller_Cashfree_Zero_FullCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.Cashfree,
                OrderTestCase.ProductOrderType.FullCatalog,
                false);
    }

    @Test(priority = 88, alwaysRun = true)
    public void noReseller_Cheque_Zero_FullCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.Cheque,
                OrderTestCase.ProductOrderType.FullCatalog,
                false);
    }

    @Test(priority = 90, alwaysRun = true)
    public void noReseller_NEFT_Zero_FullCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.NEFT,
                OrderTestCase.ProductOrderType.FullCatalog,
                false);
    }


    @Test(priority = 92, alwaysRun = true)
    public void noReseller_COD_Zero_FullCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.COD,
                OrderTestCase.ProductOrderType.FullCatalog,
                false);
    }


    @Test(priority = 94, alwaysRun = true)
    public void noReseller_WishbookCredit_Zero_FullCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.WishbookCredit,
                OrderTestCase.ProductOrderType.FullCatalog,
                false);
    }
    //endregion

    //region order non catalog without Discount
    @Test(priority = 97, alwaysRun = true)
    public void noReseller_CashFree_Zero_FullNonCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.Cashfree,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                false);
    }

    @Test(priority = 101, alwaysRun = true)
    public void noReseller_Cheque_Zero_FullNonCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.Cheque,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                false);
    }


    @Test(priority = 103, alwaysRun = true)
    public void noReseller_NEFT_Zero_FullNonCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.NEFT,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                false);
    }

    @Test(priority = 105, alwaysRun = true)
    public void noReseller_COD_Zero_FullNonCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.COD,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                false);
    }

    @Test(priority = 107, alwaysRun = true)
    public void noReseller_WishbookCredit_Zero_FullNonCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.WishbookCredit,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                false);
    }

    //endregion

    //region order ScreenSet Without Discount
    @Test(priority = 110, alwaysRun = true)
    public void noReseller_Cashfree_Zero_ScreenSet_WithOutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.Cashfree,
                OrderTestCase.ProductOrderType.ScreenSet,
                false);
    }



    @Test(priority = 114, alwaysRun = true)
    public void noReseller_Cheque_Zero_ScreenSet_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.Cheque,
                OrderTestCase.ProductOrderType.ScreenSet,
                false);
    }

    @Test(priority = 116, alwaysRun = true)
    public void noReseller_NEFT_Zero_ScreenSet_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.NEFT,
                OrderTestCase.ProductOrderType.ScreenSet,
                false);
    }


    @Test(priority = 118, alwaysRun = true)
    public void noReseller_COD_Zero_ScreenSet_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.COD,
                OrderTestCase.ProductOrderType.ScreenSet,
                false);
    }

    @Test(priority = 120, alwaysRun = true)
    public void noReseller_WishbookCredit_Zero_ScreenSet_WithoutDiscount() throws Exception {
        runOrderRegressionTest(false, OrderTestCase.PaymentMethod.WishbookCredit,
                OrderTestCase.ProductOrderType.ScreenSet,
                false);
    }

    //endregion


    //region reseller order catalog without Discount
    @Test(priority = 123, alwaysRun = true)
    public void yesReseller_CashFree_Zero_FullCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.Cashfree,
                OrderTestCase.ProductOrderType.FullCatalog,
                false);
    }

    @Test(priority = 127, alwaysRun = true)
    public void yesReseller_Cheque_Zero_FullCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.Cheque,
                OrderTestCase.ProductOrderType.FullCatalog,
                false);
    }

    @Test(priority = 129, alwaysRun = true)
    public void yesReseller_NEFT_Zero_FullCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.NEFT,
                OrderTestCase.ProductOrderType.FullCatalog,
                false);
    }

    @Test(priority = 131, alwaysRun = true)
    public void yesReseller_COD_Zero_FullCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.COD,
                OrderTestCase.ProductOrderType.FullCatalog,
                false);
    }

    @Test(priority = 134, alwaysRun = true)
    public void yesReseller_WishbookCredit_Zero_FullCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.WishbookCredit,
                OrderTestCase.ProductOrderType.FullCatalog,
                false);
    }


    //endregion

    //region reseller order Non Catalog Without Discount
    @Test(priority = 137, alwaysRun = true)
    public void yesReseller_CashFree_Zero_FullNonCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.Cashfree,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                false);
    }

    @Test(priority = 141, alwaysRun = true)
    public void yesReseller_Cheque_Zero_FullNonCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.Cheque,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                false);
    }

    @Test(priority = 143, alwaysRun = true)
    public void yesReseller_NEFT_Zero_FullNonCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.NEFT,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                false);
    }

    @Test(priority = 145, alwaysRun = true)
    public void yesReseller_COD_Zero_FullNonCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.COD,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                false);
    }

    @Test(priority = 147, alwaysRun = true)
    public void yesReseller_WishbookCredit_Zero_FullNonCatalog_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.WishbookCredit,
                OrderTestCase.ProductOrderType.FullNonCatalog,
                false);
    }
    //endregion

    //region reseller order ScreenSet without Discount
    @Test(priority = 150, alwaysRun = true)
    public void yesReseller_Cashfree_Zero_ScreenSet_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.Cashfree,
                OrderTestCase.ProductOrderType.ScreenSet,
                false);
    }

    @Test(priority = 154, alwaysRun = true)
    public void yesReseller_Cheque_Zero_ScreenSet_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.Cheque,
                OrderTestCase.ProductOrderType.ScreenSet,
                false);
    }

    @Test(priority = 156, alwaysRun = true)
    public void yesReseller_NEFT_Zero_ScreenSet_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.NEFT,
                OrderTestCase.ProductOrderType.ScreenSet,
                false);
    }

    @Test(priority = 158, alwaysRun = true)
    public void yesReseller_COD_Zero_ScreenSet_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.COD,
                OrderTestCase.ProductOrderType.ScreenSet,
                false);
    }

    @Test(priority = 160, alwaysRun = true)
    public void yesReseller_WishbookCredit_Zero_ScreenSet_WithoutDiscount() throws Exception {
        runOrderRegressionTest(true, OrderTestCase.PaymentMethod.WishbookCredit,
                OrderTestCase.ProductOrderType.ScreenSet,
                false);
    }

    //endregion




}




