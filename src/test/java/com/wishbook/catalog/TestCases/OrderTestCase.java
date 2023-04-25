package com.wishbook.catalog.TestCases;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CODConfirmationPage.CODConfirmationPageFactory;
import com.wishbook.catalog.PageObject.CODConfirmationPage.CODConfirmationPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageFactory;
import com.wishbook.catalog.PageObject.CatalogPublicPage.CatalogPublicPageStrategy;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarFactory;
import com.wishbook.catalog.PageObject.CatalogToolBar.CatalogToolBarStrategy;
import com.wishbook.catalog.PageObject.ChangeResaleAmountPage.ChangeResaleAmountPageFactory;
import com.wishbook.catalog.PageObject.ChangeResaleAmountPage.ChangeResaleAmountPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.ManageDeliveryPage.ManageDeliveryPageFactory;
import com.wishbook.catalog.PageObject.ManageDeliveryPage.ManageDeliveryPageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageFactory;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageStrategy;
import com.wishbook.catalog.PageObject.NavigationDrawerPage.AppBarPageStrategy;
import com.wishbook.catalog.PageObject.NavigationDrawerPage.AppBarPageFactory;
import com.wishbook.catalog.PageObject.OrderList.OrderListFactory;
import com.wishbook.catalog.PageObject.OrderList.OrderListStrategy;
import com.wishbook.catalog.PageObject.OrderPage.OrderPageFactory;
import com.wishbook.catalog.PageObject.OrderPage.OrderPageStrategy;
import com.wishbook.catalog.PageObject.OrderReceiptPage.OrderReceiptPageFactory;
import com.wishbook.catalog.PageObject.OrderReceiptPage.OrderReceiptPageStrategy;
import com.wishbook.catalog.PageObject.PaymentCardDetailsPage.PaymentCardDetailsPageFactory;
import com.wishbook.catalog.PageObject.PaymentCardDetailsPage.PaymentCardDetailsPageStrategy;
import com.wishbook.catalog.PageObject.PaymentDialogPage.PaymentDialogFactory;
import com.wishbook.catalog.PageObject.PaymentDialogPage.PaymentDialogStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.PageObject.ProductSpinner.ProductSpinnerFactory;
import com.wishbook.catalog.PageObject.ProductSpinner.ProductSpinnerStrategy;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageFactory;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageStrategy;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageFactory;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageStrategy;
import com.wishbook.catalog.PageObject.WishbookRewardPoints.WishbookRewardPointsFactory;
import com.wishbook.catalog.PageObject.WishbookRewardPoints.WishbookRewardPointsStrategy;
import com.wishbook.catalog.TestCases.TestCaseHelper.*;
import org.testng.Assert;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class OrderTestCase extends TestCase {

    public enum PaymentMethod {
        Cashfree,
        NEFT,
        Cheque,
        Other,
        COD,
        WishbookCredit
    }


    public enum ProductOrderType {
        FullCatalog,
        CatalogSinglePiece,
        FullNonCatalog,
        NonCatalogSinglePiece,
        ScreenSet
    }

    public enum CashOnDeliveryOrder{
        OrderLessThanSixtyThousand,
        OrderMoreThanSixtyThousand
    }


    private static final String DASHES = new String(new char[80]).replace("\0", "-");
    private static String cheapCatalogWithDiscount;
    private static String cheapCatalogWithoutDiscount;
    private static String cheapNonCatalogWithDiscount;
    private static String cheapNonCatalogWithoutDiscount;
    private static String cheapScreenSetWithDiscount;
    private static String cheapScreenSetWithoutDiscount;
    private float defaultResaleAmount = 0;
    private String name = "";
    private int codOrderExceedSixtyThousand = 6000;
    private boolean resellerOrder;
    private PaymentMethod paymentMethod = PaymentMethod.Cashfree;
    private ProductOrderType productOrderType = ProductOrderType.FullCatalog;
    private boolean discountEnabled = false;
    private float priceOfTheProductOrdered = 0;
    private float totalAmountToBePaidForOrder = 0;
    private float totalAmountAfterApplyingRewardPoints;
    private float priceAfterGstForSingleItemIntoCart;
    private int getQuantityIntoCart;
    private float getResaleAmountOnShipmentPageAfterEnteredResaleAmt;
    private float getResaleAmountOnChageResalePopUpAfterEnteredResaleAmt;
    private float getOrderAmountInChangeResaleAmountPopup;
    private float rewardPointsOnShpimentPage = 0;
    private float totalAmountToBeCollectedOnCODReConfirmPage;
    private float marginAmtOnCODReConfirmPage;

    public OrderTestCase(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.DontLogin));
    }

    public void setResellerOrder(boolean resellerOrder) {
        this.resellerOrder = resellerOrder;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setProductOrderType(ProductOrderType productOrderType) {
        this.productOrderType = productOrderType;
    }

    public void setDiscountEnabled(boolean discountEnabled) {
        this.discountEnabled = discountEnabled;
    }

    private void printTestCaseDetails() {
        System.out.println(DASHES);
        System.out.println("Is reseller order? : " + resellerOrder);
        System.out.println("Payment method : " + paymentMethod.toString());
        System.out.println("ProductOrderType : " + productOrderType.toString());
        System.out.println("Discount enabled? : " + discountEnabled);
        System.out.println(DASHES);
    }

    private void ensureUploads() {

        if (cheapCatalogWithDiscount == null) {
            new LoginHelper(this).loginAsTestManufacturer();
            ProductUploadHelper productUploadHelper = new ProductUploadHelper(this, ProductTestCaseHelper.SetType.SingleColorSet, ProductTestCaseHelper.PhotoshootType.Catalog);
            productUploadHelper.setPrice(1000);
            int price = productUploadHelper.getPrice();
            System.out.println("Price For Product" + price);
            productUploadHelper.execute();
            cheapCatalogWithDiscount = productUploadHelper.getCatalogName();
            System.out.println("\n");
            new LoginHelper(this).logout();
        }

//        if (cheapCatalogWithoutDiscount == null) {
//            new LoginHelper(this).loginAsWholesalerCatalogUploader();
//            System.out.println("--upload catalog without discount--");
//            ProductUploadHelper productUploadHelper = new ProductUploadHelper(this, ProductTestCaseHelper.SetType.SingleColorSet, ProductTestCaseHelper.PhotoshootType.Catalog);
//            productUploadHelper.setPrice(1000);
//            int price = productUploadHelper.getPrice();
//            System.out.println("Price For Product" + price);
//            productUploadHelper.execute();
//            cheapCatalogWithoutDiscount = productUploadHelper.getCatalogName();
//            System.out.println("\n");
//            new LoginHelper(this).logout();
//        }
//
//
//        if (cheapNonCatalogWithDiscount == null) {
//            new LoginHelper(this).loginAsTestManufacturer();
//            System.out.println("--cheap NonCatalog With Discount--");
//            ProductUploadHelper productUploadHelper = new ProductUploadHelper(this, ProductTestCaseHelper.SetType.SingleColorSet, ProductTestCaseHelper.PhotoshootType.WhiteBackgroundOrFaceCut);
//            productUploadHelper.setPrice(1000);
//            int price = productUploadHelper.getPrice();
//            System.out.println("Price For Product" + price);
//            productUploadHelper.execute();
//            cheapNonCatalogWithDiscount = productUploadHelper.getCatalogName();
//            System.out.println("\n");
//            new LoginHelper(this).logout();
//        }

//        if (cheapNonCatalogWithoutDiscount == null) {
//            new LoginHelper(this).loginAsWholesalerCatalogUploader();
//            System.out.println("--cheap NonCatalog Without Discount--");
//            ProductUploadHelper productUploadHelper = new ProductUploadHelper(this, ProductTestCaseHelper.SetType.SingleColorSet, ProductTestCaseHelper.PhotoshootType.WhiteBackgroundOrFaceCut);
//            productUploadHelper.setPrice(1000);
//            int price = productUploadHelper.getPrice();
//            System.out.println("Price For Product" + price);
//            productUploadHelper.execute();
//            cheapNonCatalogWithoutDiscount = productUploadHelper.getCatalogName();
//            System.out.println("\n");
//            new LoginHelper(this).logout();
//        }

//
//        if (cheapScreenSetWithDiscount == null) {
//            new LoginHelper(this).loginAsTestManufacturer();
//            System.out.println("-- cheap Screen Set With Discount--");
//            ProductUploadHelper productUploadHelper = new ProductUploadHelper(this, ProductTestCaseHelper.SetType.MultiSet, ProductTestCaseHelper.PhotoshootType.WhiteBackgroundOrFaceCut);
//            productUploadHelper.setPricesPerPieces(1000);
//            productUploadHelper.execute();
//            cheapScreenSetWithDiscount = productUploadHelper.getScreenName();
//            System.out.println("\n");
//            new LoginHelper(this).logout();
//        }
//
//        if (cheapScreenSetWithoutDiscount == null) {
//            new LoginHelper(this).loginAsWholesalerCatalogUploader();
//            System.out.println("-- cheap Screen Set Without Discount--");
//            ProductUploadHelper productUploadHelper = new ProductUploadHelper(this, ProductTestCaseHelper.SetType.MultiSet, ProductTestCaseHelper.PhotoshootType.WhiteBackgroundOrFaceCut);
//            productUploadHelper.setPrice(1000);
//            productUploadHelper.execute();
//            cheapScreenSetWithoutDiscount = productUploadHelper.getScreenName();
//            System.out.println("\n");
//            new LoginHelper(this).logout();
//        }


    }


    private void buyerLogin() {
        System.out.println("\n Buyer Login");
        if (resellerOrder) {
            new LoginHelper(this).loginAsTestReseller();

        } else if (paymentMethod == PaymentMethod.WishbookCredit) {
            new LoginHelper(this).loginAsTestWholesaler();

        } else {
            new LoginHelper(this).loginAsTestRetailer();


        }
    }

    private void selectAProductToOrder() {

        if (productOrderType == ProductOrderType.FullCatalog || productOrderType == ProductOrderType.CatalogSinglePiece) {
            if (discountEnabled) {
                name = cheapCatalogWithDiscount;
                priceOfTheProductOrdered = 1000;
                System.out.println("For WB money is Full Order Cheap catalog With discount");
            } else {
                name = cheapCatalogWithoutDiscount;
                priceOfTheProductOrdered = 1000;
                System.out.println("For WB money is Full Order Cheap catalog Without discount");

            }
        }


        if (productOrderType == ProductOrderType.FullNonCatalog || productOrderType == ProductOrderType.NonCatalogSinglePiece) {
            if (discountEnabled) {
                name = cheapNonCatalogWithDiscount;
                priceOfTheProductOrdered = 1000;
                System.out.println("Cheap Noncatalog With discount WB money is Full");

            } else {

                name = cheapNonCatalogWithoutDiscount;
                priceOfTheProductOrdered = 1000;
                System.out.println("Cheap Notcatalog Without discount WB money is Full");

            }
        }

        if (productOrderType == ProductOrderType.ScreenSet) {
            if (discountEnabled) {
                name = cheapScreenSetWithDiscount;
                priceOfTheProductOrdered = 1000;
            } else {

                name = cheapScreenSetWithoutDiscount;
                priceOfTheProductOrdered = 1000;
            }
        }


        addProductToCart("test_ffqbtrjp", 1);
        ManageDeliveryPageStrategy manageDeliveryPageStrategy = ManageDeliveryPageFactory.getStrategy(this);
        ShipmentAndPaymentPageStrategy shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
        shipmentAndPaymentPageStrategy.clickDeliveryAddress();
        if (getTest().getTestConfiguration().getDevelopmentFramework() == TestConfiguration.DevelopmentFramework.NativeAndroid) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            manageDeliveryPageStrategy.selectAddressRadioButton(0);
        }

        if (paymentMethod == PaymentMethod.COD && getTest().getTestConfiguration().getDevelopmentFramework() == TestConfiguration.DevelopmentFramework.NativeAndroid) {
            manageDeliveryPageStrategy.selectAddressRadioButton(0);


        }
    }


    private void handleChangeResaleAmount() {
        ShipmentAndPaymentPageStrategy shipmentAndPaymentPageStrategy=ShipmentAndPaymentPageFactory.getStrategy(this);
        shipmentAndPaymentPageStrategy.clickChangeResaleLink();
        ChangeResaleAmountPageStrategy changeResaleAmountPageStrategy = ChangeResaleAmountPageFactory.getStrategy(this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getOrderAmountInChangeResaleAmountPopup = changeResaleAmountPageStrategy.getOrderAmountResaleAmountChangePopup();
        Assert.assertEquals(getOrderAmountInChangeResaleAmountPopup, totalAmountToBePaidForOrder);
        changeResaleAmountPageStrategy.clickCloseButton();

        shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
        float orderAmountShipmentPage = shipmentAndPaymentPageStrategy.getOrderAmountShipmentPage();
        Assert.assertEquals(orderAmountShipmentPage, totalAmountToBePaidForOrder);

        float resaleAmountOnShipmentBeforeEnterResaleAmount = shipmentAndPaymentPageStrategy.getResaleAmountShipmentPage();
        Assert.assertEquals(resaleAmountOnShipmentBeforeEnterResaleAmount, defaultResaleAmount);
        shipmentAndPaymentPageStrategy.clickChangeResaleLink();

        changeResaleAmountPageStrategy = ChangeResaleAmountPageFactory.getStrategy(this);
        Assert.assertEquals(getOrderAmountInChangeResaleAmountPopup, totalAmountToBePaidForOrder);
        int itemQuantity = changeResaleAmountPageStrategy.getItemQuantityResaleAmountChangePopup();
        Assert.assertEquals(itemQuantity, getQuantityIntoCart);

        changeResaleAmountPageStrategy.enterResaleAmountIntoTextBox(99);
        changeResaleAmountPageStrategy.clickDoneButton();
        changeResaleAmountPageStrategy.enterResaleAmountIntoTextBox(4000);

        float resaleAmountOnPopUp=changeResaleAmountPageStrategy.getResaleAmountResaleAmountChangePopup();
        getResaleAmountOnChageResalePopUpAfterEnteredResaleAmt=changeResaleAmountPageStrategy.getEnteredAmountIntoTextBox();
        System.out.println("getResaleAmountOnChageResalePopUpAfterEnteredResaleAmt :"+getResaleAmountOnChageResalePopUpAfterEnteredResaleAmt);
        Assert.assertEquals(resaleAmountOnPopUp,getResaleAmountOnChageResalePopUpAfterEnteredResaleAmt);
        changeResaleAmountPageStrategy.clickDoneButton();

        shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
        getResaleAmountOnShipmentPageAfterEnteredResaleAmt = shipmentAndPaymentPageStrategy.getResaleAmountShipmentPage();
        Assert.assertEquals(getResaleAmountOnShipmentPageAfterEnteredResaleAmt,getResaleAmountOnChageResalePopUpAfterEnteredResaleAmt);


        //region resaleMargin
//        changeResaleAmountPageStrategy.enterResaleMarginPercent(10);
//        changeResaleAmountPageStrategy.clickSaveDefaultMargin();
//        float actualResaleAmount = changeResaleAmountPageStrategy.getEnteredAmountIntoTextBox();
//        float resaleMarginPercentInPopup = changeResaleAmountPageStrategy.getResaleMarginPercent();
//        float productPriceIncludingGst = changeResaleAmountPageStrategy.getItemPriceInclGSTResaleAmountChangePopup();
//        float calculatedMargin = resaleMarginPercentInPopup * productPriceIncludingGst / 100;
//        float expectedResaleAmount = calculatedMargin + productPriceIncludingGst;
//        Assert.assertEquals(actualResaleAmount, expectedResaleAmount);
//        Assert.assertEquals(productPriceIncludingGst, priceAfterGstForSingleItemIntoCart);
//        changeResaleAmountPageStrategy.clickDoneButton();

        //endregion

    }


    private void addProductToCart(String productName, int quantity) {
        // region check purchase order counts
        if (getTest().getTestConfiguration().getDevelopmentFramework() == TestConfiguration.DevelopmentFramework.NativeAndroid) {
            BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
            bottomTabPageStrategy.clickOrderButton();
            OrderPageStrategy orderPageStrategy = OrderPageFactory.getStrategy(this);
            int totalPurchaseOrdersBefore = orderPageStrategy.getTotalPurchaseOrder();
            int pendingPurchaseOrdersBefore = orderPageStrategy.getPendingPurchaseOrder();
            int dispatchedPurchaseOrdersBefore = orderPageStrategy.getDispatchedPurchaseOrder();
            int cancelledPurchaseOrdersBefore = orderPageStrategy.getCancelledPurchaseOrder();
            Assert.assertEquals(totalPurchaseOrdersBefore, pendingPurchaseOrdersBefore + dispatchedPurchaseOrdersBefore + cancelledPurchaseOrdersBefore);
        }
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);

        if (getTest().getTestConfiguration().getDevelopmentFramework() == TestConfiguration.DevelopmentFramework.ReactNative) {
            bottomTabPageStrategy.clickProductsButton();
            if (productOrderType == ProductOrderType.FullNonCatalog || productOrderType == ProductOrderType.ScreenSet) {
                CatalogToolBarStrategy catalogToolBarStrategy = CatalogToolBarFactory.getStrategy(this);
                ProductSpinnerStrategy productSpinnerStrategy = ProductSpinnerFactory.getStrategy(this);
                catalogToolBarStrategy.clickProductTypeSpinner();
                productSpinnerStrategy.clickNonCatalogSpinner();
            }
            CatalogPublicPageStrategy catalogPublicPageStrategy = CatalogPublicPageFactory.getStrategy(this);
            catalogPublicPageStrategy.clickSearchIcon();
            SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(this);
            searchPageStrategy.searchCatalogName(productName);
            searchPageStrategy.clickSearchedProduct();
        } else {


            bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
            bottomTabPageStrategy.clickHomeButton();
            HomePageStrategy homePageStrategy = HomePageFactory.getStrategy(this);
            homePageStrategy.clickSearch();
            SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(this);
            searchPageStrategy.searchCatalogName(productName);
            searchPageStrategy.clickSearchedProduct();
        }
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.getCatalogName().toLowerCase();
        catalogDetailsPageStrategy.clickAddToCartButton();
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartIcon();
        MyCartPageStrategy myCartPageStrategy = MyCartPageFactory.getStrategy(this);
        if (quantity > 1) {
            for (int i = 0; i < quantity; ++i) {
                myCartPageStrategy = MyCartPageFactory.getStrategy(this);
                myCartPageStrategy.clickIncreaseCatalogQuantity();
            }
        }

        getQuantityIntoCart = myCartPageStrategy.getCatalogQuantity();
//        float productPrice = myCartPageStrategy.getCatalogPriceOnMyCart() * 3;
//        float discountPercent = myCartPageStrategy.getDiscountOnMycart();
//
//        System.out.println("getQuantityIntoCart " + getQuantityIntoCart);
//        System.out.println("productPrice " + productPrice);
//        System.out.println("discountPercent " + discountPercent);
//
//        discountedCalculatedAmount = getQuantityIntoCart * productPrice * discountPercent / 100;
//        BigDecimal.valueOf(discountedCalculatedAmount).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
//
//        priceBeforeDiscount = getQuantityIntoCart * productPrice;
//        float priceAfterDiscount = priceBeforeDiscount - discountedCalculatedAmount;
//        float actualPriceAfterDiscount = myCartPageStrategy.getIndividualItemsDiscountedPrice();

        priceAfterGstForSingleItemIntoCart = myCartPageStrategy.getIndividualItemsDiscountedAfterGstPrice();
        float grandTotalPrice = myCartPageStrategy.getGrandTotalPrice();
        Assert.assertEquals(priceAfterGstForSingleItemIntoCart, grandTotalPrice);
        myCartPageStrategy.clickPlaceOrderButton();
        //endregion
    }

    private void performShippingAndPaymentDetailsPageChecks() {
        ShipmentAndPaymentPageStrategy shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
//        if(getTest().getTestConfiguration().getDevelopmentFramework()==TestConfiguration.DevelopmentFramework.ReactNative){
//            shipmentAndPaymentPageStrategy.selectShipmentAddress(7);
//        }
        float totalOrderAmount = shipmentAndPaymentPageStrategy.getTotalOrderAmount();
        float totalDiscount = shipmentAndPaymentPageStrategy.getTotalDiscount();
        float totalGst = shipmentAndPaymentPageStrategy.getTotalGst();
        float deliveryCharges = shipmentAndPaymentPageStrategy.getDeliveryCharge();
        totalAmountToBePaidForOrder = shipmentAndPaymentPageStrategy.getTotalPayableAmount();
        System.out.println(totalAmountToBePaidForOrder);
        float totalAmountCalculationBeforeApplyingReward = totalOrderAmount - totalDiscount + totalGst + deliveryCharges;
        totalAmountCalculationBeforeApplyingReward =BigDecimal.valueOf(totalAmountCalculationBeforeApplyingReward).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        System.out.println(+totalOrderAmount + "," + totalDiscount + "," + totalGst + "," + "," + deliveryCharges);
        Assert.assertEquals(totalAmountToBePaidForOrder, totalAmountCalculationBeforeApplyingReward);
        rewardPointsOnShpimentPage = shipmentAndPaymentPageStrategy.getRewardPointsAmount();
        float payableAmount = shipmentAndPaymentPageStrategy.getTotalPayableAmountAfterApplyingRewardPoints();
        totalAmountAfterApplyingRewardPoints = totalAmountToBePaidForOrder - rewardPointsOnShpimentPage;
        totalAmountAfterApplyingRewardPoints = BigDecimal.valueOf(totalAmountAfterApplyingRewardPoints).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        Assert.assertEquals(payableAmount, totalAmountAfterApplyingRewardPoints);
        System.out.println("Shipment is done");

        if (getTest().getTestConfiguration().getDevelopmentFramework() == TestConfiguration.DevelopmentFramework.NativeAndroid) {
            if (resellerOrder==false) {

            } else if (resellerOrder==true) {
                Assert.assertTrue(shipmentAndPaymentPageStrategy.changeLinkIsDisplayed());
                Assert.assertTrue(shipmentAndPaymentPageStrategy.resaleAmountShipmentPageIsDisplayed());
                Assert.assertTrue(shipmentAndPaymentPageStrategy.orderAmountShipmentPageIsDisplayed());
                //  Assert.assertTrue(shipmentAndPaymentPageStrategy.resellerOrderToggleIsDisplayed());
                // handleChangeResaleAmount();
            }
        }
    }


//-------------------------------------------------------------------------------------------

    private void placeOrder() {
        ShipmentAndPaymentPageStrategy shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);

        if (paymentMethod == PaymentMethod.Cashfree  && resellerOrder==false) {
            shipmentAndPaymentPageStrategy.clickCashFreePaymentMode();
            shipmentAndPaymentPageStrategy.clickProceedForPaymentButton();
            paymentUsingCashFree();

        } else if (paymentMethod == PaymentMethod.Cashfree  && resellerOrder==true) {
            handleChangeResaleAmount();
            shipmentAndPaymentPageStrategy.clickProceedForPaymentButton();
            paymentUsingCashFree();
        }


         else if (paymentMethod == PaymentMethod.Cheque && resellerOrder==false) {
              shipmentAndPaymentPageStrategy.clickChequePaymentMode();
              shipmentAndPaymentPageStrategy.clickEnterPaymentDetails();
              PaymentDialogStrategy paymentDialogStrategy = PaymentDialogFactory.getStrategy(this);
              float getAmountAtPaymentPopup = paymentDialogStrategy.getAmount();
              Assert.assertEquals(getAmountAtPaymentPopup, totalAmountAfterApplyingRewardPoints);
              paymentDialogStrategy.enterBankNameInDetails("SBI");
              paymentDialogStrategy.enterCheQueNumber(66450);
              paymentDialogStrategy.clickSavePaymentButton();
          }
            else if (paymentMethod == PaymentMethod.Cheque && resellerOrder==true) {
                handleChangeResaleAmount();
                shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
                shipmentAndPaymentPageStrategy.clickChequePaymentMode();
                shipmentAndPaymentPageStrategy.clickEnterPaymentDetails();
                PaymentDialogStrategy paymentDialogStrategy = PaymentDialogFactory.getStrategy(this);
                float getAmountAtPaymentPopup = paymentDialogStrategy.getAmount();
                Assert.assertEquals(getAmountAtPaymentPopup, totalAmountAfterApplyingRewardPoints);
                paymentDialogStrategy.enterBankNameInDetails("SBI");
                paymentDialogStrategy.enterCheQueNumber(66450);
                paymentDialogStrategy.clickSavePaymentButton();
            }



          else if (paymentMethod == PaymentMethod.NEFT  && resellerOrder==false) {
              shipmentAndPaymentPageStrategy.clickNeftPaymentMode();
              shipmentAndPaymentPageStrategy.clickEnterPaymentDetails();
              PaymentDialogStrategy paymentDialogStrategy = PaymentDialogFactory.getStrategy(this);
              float getAmountAtPaymentPopup1 = paymentDialogStrategy.getAmount();
              Assert.assertEquals(getAmountAtPaymentPopup1, totalAmountAfterApplyingRewardPoints);
              paymentDialogStrategy.enterTransactionIDNEFT("ABr450");
              paymentDialogStrategy.clickSavePaymentButton();
          }
           else if (paymentMethod == PaymentMethod.NEFT  && resellerOrder==true) {
             handleChangeResaleAmount();
             shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
             shipmentAndPaymentPageStrategy.clickNeftPaymentMode();
             shipmentAndPaymentPageStrategy.clickEnterPaymentDetails();
             PaymentDialogStrategy paymentDialogStrategy = PaymentDialogFactory.getStrategy(this);
             float getAmountAtPaymentPopup1 = paymentDialogStrategy.getAmount();
             Assert.assertEquals(getAmountAtPaymentPopup1, totalAmountAfterApplyingRewardPoints);
             paymentDialogStrategy.enterTransactionIDNEFT("ABr450");
             paymentDialogStrategy.clickSavePaymentButton();
            }


       else  if (paymentMethod == PaymentMethod.COD && resellerOrder==false) {
                   if (totalAmountToBePaidForOrder < codOrderExceedSixtyThousand) {
                         shipmentAndPaymentPageStrategy.clickCODPaymentMode();
                         shipmentAndPaymentPageStrategy.clickConfirmCODOrder();
                         cashOnDeliveryConfirmationPage();


                     } else {
                               shipmentAndPaymentPageStrategy.clickCODPaymentMode();
                               PopUpPageStrategy popUpPageStrategy = PopUpPageFactory.getStrategy(this);
                               popUpPageStrategy.clickYesIWantCod();
                               shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
                               shipmentAndPaymentPageStrategy.clickProceedForPaymentButton();
                               paymentUsingCashFree();
            }

        }

       else if (paymentMethod == PaymentMethod.COD && resellerOrder==true) {
              if(totalAmountToBePaidForOrder < codOrderExceedSixtyThousand) {
                  handleChangeResaleAmount();
                  shipmentAndPaymentPageStrategy.clickCODPaymentMode();
                  shipmentAndPaymentPageStrategy.clickConfirmCODOrder();
                  cashOnDeliveryConfirmationPage();
              }
              else {
                  handleChangeResaleAmount();
                  PopUpPageStrategy popUpPageStrategy = PopUpPageFactory.getStrategy(this);
                  popUpPageStrategy.clickYesIWantCod();
                  shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(this);
                  shipmentAndPaymentPageStrategy.clickProceedForPaymentButton();
                  paymentUsingCashFree();
              }
        }



        else if (paymentMethod == PaymentMethod.WishbookCredit && resellerOrder==false) {
            shipmentAndPaymentPageStrategy.clickWishbookCreditPaymentMode();
            shipmentAndPaymentPageStrategy.clickDoneButton();

        }
    }

    public void cashOnDeliveryConfirmationPage() {
        CODConfirmationPageStrategy codConfirmationPageStrategy = CODConfirmationPageFactory.getStrategy(this);
        String actualoOrderStatusOnCODReConfirmPage = codConfirmationPageStrategy.getOrderStatus();
        String expectedOrderStatusOnCODReconfirmPage="Cod verification pending";
        Assert.assertEquals(actualoOrderStatusOnCODReConfirmPage,expectedOrderStatusOnCODReconfirmPage);

        if(resellerOrder==true) {
            marginAmtOnCODReConfirmPage = codConfirmationPageStrategy.getMarginAmount();
            float expectedMarginPrice = getResaleAmountOnChageResalePopUpAfterEnteredResaleAmt - getOrderAmountInChangeResaleAmountPopup;
            expectedMarginPrice =BigDecimal.valueOf(expectedMarginPrice).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
            Assert.assertEquals(marginAmtOnCODReConfirmPage, expectedMarginPrice);
            totalAmountToBeCollectedOnCODReConfirmPage = codConfirmationPageStrategy.getAmountToBeCollected();
            Assert.assertEquals(totalAmountToBeCollectedOnCODReConfirmPage, getResaleAmountOnChageResalePopUpAfterEnteredResaleAmt);
            System.out.println("marginAmtOnCODReConfirmPage :" + marginAmtOnCODReConfirmPage);
            System.out.println("expectedMarginPrice : " + expectedMarginPrice);
            System.out.println("totalAmountToBeCollectedOnCODReConfirmPage :" + totalAmountToBeCollectedOnCODReConfirmPage);
        }
        else if(resellerOrder==false){
            totalAmountToBeCollectedOnCODReConfirmPage = codConfirmationPageStrategy.getAmountToBeCollected();
            System.out.println("totalAmountToBeCollectedOnCODReConfirmPage :" + totalAmountToBeCollectedOnCODReConfirmPage);
            Assert.assertEquals(totalAmountToBeCollectedOnCODReConfirmPage,totalAmountAfterApplyingRewardPoints);
        }
        codConfirmationPageStrategy.clickReConfirmCodButton();

    }

    public void clickNewCreatedOrder() {
        OrderListStrategy orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickNewPurchaseOrder();
    }

    private void backToHomeTabAfterCreatingOrder() {
        OrderReceiptPageStrategy orderReceiptPageStrategy = OrderReceiptPageFactory.getStrategy(this);
        orderReceiptPageStrategy.orderReceiptBackButton();
        OrderListStrategy orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickSearchButton();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.closeSearchTextField();
        orderListStrategy.OrderListBackButton();
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickWishListButton();
        catalogDetailsPageStrategy.BackCatalogButton();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();
        HomePageStrategy homePageStrategy = HomePageFactory.getStrategy(this);
        if (getTest().getTestConfiguration().getDevelopmentFramework() == TestConfiguration.DevelopmentFramework.NativeAndroid) {

            homePageStrategy.clickAppBar(0);
        } else {
            homePageStrategy.clickAppBar();
        }

        AppBarPageStrategy navigationDrawerPageStrategy = AppBarPageFactory.getStrategy(this);
        navigationDrawerPageStrategy.clickLogout();

    }

    private void paymentUsingCashFree() {
        PaymentCardDetailsPageStrategy paymentCardDetailsPageStrategy = PaymentCardDetailsPageFactory.getStrategy(this);
        paymentCardDetailsPageStrategy.enterCardNumber("4012888888881881");
        paymentCardDetailsPageStrategy.enterCardHolderName("testing");
        paymentCardDetailsPageStrategy.selectCardExpiryMonth(2);
        paymentCardDetailsPageStrategy.selectCardExpiryYear(5);
        paymentCardDetailsPageStrategy.enterCvvNumber("123");
        // amountDisplayingOnCashFree=paymentCardDetailsPageStrategy.getPayAmount();
        paymentCardDetailsPageStrategy.clickPayButton();
        getTest().getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        paymentCardDetailsPageStrategy = PaymentCardDetailsPageFactory.getStrategy(this);
        paymentCardDetailsPageStrategy.clickSuccessButton();
        PopUpPageStrategy popUpPageStrategy = PopUpPageFactory.getStrategy(this);
        popUpPageStrategy.clickOk();
    }


    private void getOrderReceiptInfoAfterOrderCreatedBuyerSide(){
       float actualTotalPriceWithoutDiscount =0;
       float actualTotalPriceWithDiscount =0;

        OrderReceiptPageStrategy orderReceiptPageStrategy= OrderReceiptPageFactory.getStrategy(this);
        int actualOrderNumber=orderReceiptPageStrategy.getOrderNumber();
        Assert.assertTrue(orderReceiptPageStrategy.isOrderDateIsDisplaye());

        String actualOrderStatus=orderReceiptPageStrategy.getOrderStatus();
        String excpectedOrderStatus = "Order Placed";
        Assert.assertEquals(actualOrderStatus,excpectedOrderStatus);

        if (paymentMethod == PaymentMethod.Cashfree){
            String actualPaymentStatus=orderReceiptPageStrategy.getPaymentStatus();
            String expectedPaymentStatus="Paid";
            Assert.assertEquals(actualPaymentStatus,expectedPaymentStatus);

        }
        else if(paymentMethod== PaymentMethod.COD){
            String actualPaymentStatus=orderReceiptPageStrategy.getPaymentStatus();
            String expectedPaymentStatus="Partially paid";
            Assert.assertEquals(actualPaymentStatus,expectedPaymentStatus);
        }

        else {
            String actualPaymentStatus=orderReceiptPageStrategy.getPaymentStatus();
            String expectedPaymentStatus="Pending";
            Assert.assertEquals(actualPaymentStatus,expectedPaymentStatus);

        }
        String paymentDetails=orderReceiptPageStrategy.getPaymentDetails();
        System.out.println("paymentDetails :" +paymentDetails);

        if(resellerOrder==true){
            orderReceiptPageStrategy.gotoResellerHubButtonIsDisplayed();
        }

        int invoiceOrderNumber=orderReceiptPageStrategy.getInvoiceOrderNumber();
        Assert.assertTrue(orderReceiptPageStrategy.trackYourOrderButtonIsDisplayed());
        Assert.assertEquals(actualOrderNumber,invoiceOrderNumber);

        float productPrice=orderReceiptPageStrategy.getDesignPriceAtInvoiceDetails();
        float sgst=orderReceiptPageStrategy.getSgst();
        float cgst=orderReceiptPageStrategy.getCgst();
        float shippingChargeOnInvoice =orderReceiptPageStrategy.getInvoiceShippingCharge();
        float rewardPoints=orderReceiptPageStrategy.getRewardPoints();
        boolean isDiscount=orderReceiptPageStrategy.isDiscountDisplayed();

        System.out.println("productPrice : "+productPrice);
        System.out.println("sgst : "+sgst);
        System.out.println("cgst : "+cgst);
        System.out.println("shippingCharge : "+shippingChargeOnInvoice);
        System.out.println("rewardPoints : "+rewardPoints);
        System.out.println("isDiscount : "+isDiscount);


        if (isDiscount==false) {
           actualTotalPriceWithoutDiscount = productPrice + sgst + cgst + shippingChargeOnInvoice - rewardPoints;
            System.out.println("actualTotalPriceWithoutDiscount : "+actualTotalPriceWithoutDiscount);
        }
        else {
           float discount= orderReceiptPageStrategy.getDiscountInInvoice();
            actualTotalPriceWithDiscount = productPrice + sgst + cgst + shippingChargeOnInvoice - rewardPoints - discount;
            System.out.println("actualTotalPriceWithDiscount : "+actualTotalPriceWithDiscount);

        }

        if(paymentMethod == PaymentMethod.Cashfree && resellerOrder==false && isDiscount==false){
          float paidAmountWithoutDiscount=orderReceiptPageStrategy.getPaidAmount();
          Assert.assertEquals(paidAmountWithoutDiscount,actualTotalPriceWithoutDiscount);
        }
            else if(paymentMethod == PaymentMethod.Cashfree && resellerOrder==false && isDiscount==true){
            float paidAmountWitDiscount=orderReceiptPageStrategy.getPaidAmount();
            Assert.assertEquals(paidAmountWitDiscount,actualTotalPriceWithDiscount);
        }

        else if(paymentMethod == PaymentMethod.Cashfree && resellerOrder==true && isDiscount==true){
            float paidAmountWitDiscount=orderReceiptPageStrategy.getPaidAmount();
            float getCustomerAmount =orderReceiptPageStrategy.getCustomerPayableAmount();
            System.out.println("Customer Payable Amount : " +getCustomerAmount);
            Assert.assertEquals(getCustomerAmount,getResaleAmountOnShipmentPageAfterEnteredResaleAmt);
            Assert.assertEquals(paidAmountWitDiscount,actualTotalPriceWithDiscount);
        }

        else if(paymentMethod == PaymentMethod.Cashfree && resellerOrder==true && isDiscount==false){
            float paidAmountWitoutDiscount=orderReceiptPageStrategy.getPaidAmount();
            float getCustomerAmount =orderReceiptPageStrategy.getCustomerPayableAmount();
            System.out.println("Customer Payable Amount : " +getCustomerAmount);
            Assert.assertEquals(getCustomerAmount,getResaleAmountOnShipmentPageAfterEnteredResaleAmt);
            Assert.assertEquals(paidAmountWitoutDiscount,actualTotalPriceWithoutDiscount);
        }





        else if(paymentMethod == PaymentMethod.NEFT && paymentMethod==PaymentMethod.Cheque && resellerOrder==false && isDiscount==false) {
            float payableAmount=orderReceiptPageStrategy.getPayableAmount();
            Assert.assertEquals(actualTotalPriceWithoutDiscount,payableAmount);
            Assert.assertTrue(orderReceiptPageStrategy.cancelButtonIsDisplayed());

        }
        else if(paymentMethod == PaymentMethod.NEFT && paymentMethod==PaymentMethod.Cheque && resellerOrder==false && isDiscount==true){
            float payableAmountWitDiscount=orderReceiptPageStrategy.getPayableAmount();
            Assert.assertEquals(payableAmountWitDiscount,actualTotalPriceWithDiscount);
        }

        else if(paymentMethod == PaymentMethod.NEFT && paymentMethod==PaymentMethod.Cheque && resellerOrder==true && isDiscount==true) {
            float payableAmountWitDiscount=orderReceiptPageStrategy.getPayableAmount();
            float getCustomerAmount =orderReceiptPageStrategy.getCustomerPayableAmount();
            System.out.println("Customer Payable Amount : " +getCustomerAmount);
            Assert.assertEquals(getCustomerAmount,getResaleAmountOnShipmentPageAfterEnteredResaleAmt);
            Assert.assertEquals(payableAmountWitDiscount,actualTotalPriceWithDiscount);

        }
        else if(paymentMethod == PaymentMethod.NEFT && paymentMethod==PaymentMethod.Cheque && resellerOrder==true && isDiscount==false){
            float payableAmount=orderReceiptPageStrategy.getPayableAmount();
            float getCustomerAmount =orderReceiptPageStrategy.getCustomerPayableAmount();
            System.out.println("Customer Payable Amount : " +getCustomerAmount);
            Assert.assertEquals(getCustomerAmount,getResaleAmountOnShipmentPageAfterEnteredResaleAmt);
            Assert.assertEquals(actualTotalPriceWithoutDiscount,payableAmount);
            Assert.assertTrue(orderReceiptPageStrategy.cancelButtonIsDisplayed());

        }





        else if(paymentMethod == PaymentMethod.COD && resellerOrder==false && isDiscount==false) {
            float payableAmount=orderReceiptPageStrategy.getPayableAmount();
            Assert.assertEquals(actualTotalPriceWithoutDiscount,payableAmount);
            Assert.assertTrue(orderReceiptPageStrategy.cancelButtonIsDisplayed());

        }
        else if(paymentMethod == PaymentMethod.COD  && resellerOrder==false && isDiscount==true){
            float payableAmountWitDiscount=orderReceiptPageStrategy.getPayableAmount();
            Assert.assertEquals(payableAmountWitDiscount,actualTotalPriceWithDiscount);
        }

        else if(paymentMethod == PaymentMethod.COD && resellerOrder==true && isDiscount==true) {


        }
        else if(paymentMethod == PaymentMethod.COD && resellerOrder==true && isDiscount==false){
            float payableAmount=orderReceiptPageStrategy.getPayableAmount();
            float getCustomerAmount =orderReceiptPageStrategy.getCustomerPayableAmount();
            System.out.println("Customer Payable Amount : " +getCustomerAmount);
            Assert.assertEquals(getCustomerAmount,getResaleAmountOnShipmentPageAfterEnteredResaleAmt);
            Assert.assertEquals(getCustomerAmount,totalAmountToBeCollectedOnCODReConfirmPage);
            Assert.assertEquals(actualTotalPriceWithoutDiscount,payableAmount);
            Assert.assertTrue(orderReceiptPageStrategy.cancelButtonIsDisplayed());

        }

        Assert.assertTrue(orderReceiptPageStrategy.callWbSupportButtonIsDisplayed());
        Assert.assertTrue(orderReceiptPageStrategy.chatWbSupportButtonIsDisplayed());


    }

    protected void run() {
        printTestCaseDetails();
        //ensureUploads();
        buyerLogin();
        selectAProductToOrder();
        performShippingAndPaymentDetailsPageChecks();
        placeOrder();
        clickNewCreatedOrder();
        getOrderReceiptInfoAfterOrderCreatedBuyerSide();
        backToHomeTabAfterCreatingOrder();
    }

}

