package com.wishbook.catalog.TestCases.ClearanceDiscount;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.DiscountSettingPage.DiscountSettingPageFactory;
import com.wishbook.catalog.PageObject.DiscountSettingPage.DiscountSettingPageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageFactory;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class ClearanceDiscountTest extends TestCase {

    private float wishbookMargin=5;
    private float wishbookMaxDicount=7;
    private float clearanceDiscount;
    private float productPrice=1500;
    private float productPriceAfterAddingMarginForSinglePiece=1600;
    private float fullCatalogDiscount;
    private float singlePieceDiscount;

    public ClearanceDiscountTest(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));

    }

    public void searchUploadedCatalog(){
        CatalogSearchHelper catalogSearchHelper= new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(getTest().getCommonSinglePieceCatalogName());
    }

    public void getDiscountsForFullAndSingle(){
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickDiscountSettingsButton();
        DiscountSettingPageStrategy discountSettingPageStrategy = DiscountSettingPageFactory.getStrategy(this);
        fullCatalogDiscount=discountSettingPageStrategy.getFullCatalogDiscount();
        singlePieceDiscount=discountSettingPageStrategy.getSinglePieceDiscount();
        System.out.println("fullCatalogDiscount : " +fullCatalogDiscount);
        System.out.println("singlePieceDiscount : " +singlePieceDiscount);
        discountSettingPageStrategy.getSinglePieceDiscount();
        discountSettingPageStrategy.BackBrandSearchButton();
    }

    public void checkPricesAtSellerSide(){
        searchUploadedCatalog();
        CatalogDetailsPageStrategy catalogDetailsPageStrategy= CatalogDetailsPageFactory.getStrategy(this);
        float fullPrice=catalogDetailsPageStrategy.getFullCatalogPrice();
        float sellerSideFullCatalogPrice= productPrice-(fullCatalogDiscount/100*productPrice);
        Assert.assertEquals(fullPrice,sellerSideFullCatalogPrice);
        float singlePrice=catalogDetailsPageStrategy.getSinglePrice();
        float sellerSideSinglePiecePrice= productPriceAfterAddingMarginForSinglePiece-(singlePieceDiscount/100*productPriceAfterAddingMarginForSinglePiece);
        Assert.assertEquals(singlePrice,sellerSideSinglePiecePrice);
        catalogDetailsPageStrategy.BackCatalogButton();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.searchCatalogName("");
        searchPageStrategy.BackHomeSearchButton();
    }

    public void checkPriceAtBuyerSide(){
        searchUploadedCatalog();
        CatalogDetailsPageStrategy catalogDetailsPageStrategy= CatalogDetailsPageFactory.getStrategy(this);
        float  wholesaleMarkedDisplayPrice_actual=catalogDetailsPageStrategy.getMarkedWholesalePrice();
        if(productPrice>1000) {
            float  wholesaleMarkedDisplayPrice_Expected=productPrice + (14 * productPrice/100);
            Assert.assertEquals(wholesaleMarkedDisplayPrice_actual,wholesaleMarkedDisplayPrice_Expected);

        }
        else{
            System.out.println("less than 1000");
        }

        float buyerSideFullCatalogPrice_actual=catalogDetailsPageStrategy.getFullCatalogPrice();
        float minDiscountValueForFullCatalog=((Math.min((fullCatalogDiscount - wishbookMargin), wishbookMaxDicount)));
        float buyerSideFullCatalogPrice_expected = productPrice - clearanceDiscount - (productPrice*minDiscountValueForFullCatalog/100);
        Assert.assertEquals(buyerSideFullCatalogPrice_actual,buyerSideFullCatalogPrice_expected);


        float buyerSideSinglePiecePrice_actual=catalogDetailsPageStrategy.getSinglePrice();
        float moreThanThousandAddFourteenPer=14 * productPrice/100;
        System.out.println(moreThanThousandAddFourteenPer);
        float minDiscountValueForSinglePieces=((Math.min((singlePieceDiscount - wishbookMargin), wishbookMaxDicount)));
        float buyerSideSinglePiecePrice_expected =(float) Math.floor((productPrice + moreThanThousandAddFourteenPer) - clearanceDiscount -  (((productPrice + moreThanThousandAddFourteenPer)*minDiscountValueForSinglePieces)/100));Assert.assertEquals(buyerSideSinglePiecePrice_actual,buyerSideSinglePiecePrice_expected);

        float actualFullCatalogDiscountOff=catalogDetailsPageStrategy.getFullClearanceDiscountOff();
        float expectedFullCatalogDiscountOff= ((wholesaleMarkedDisplayPrice_actual- buyerSideFullCatalogPrice_actual)/wholesaleMarkedDisplayPrice_actual)*100;
        float ceilA=(float) Math.ceil(expectedFullCatalogDiscountOff);
        System.out.println("Discount On Full Catalog :"+ceilA);
        Assert.assertEquals(actualFullCatalogDiscountOff,ceilA);

        float actualSinglePieceDiscountOff=catalogDetailsPageStrategy.getSingleClearanceDiscountOff();
        float expectedSinglePieceDiscountOff=((wholesaleMarkedDisplayPrice_actual- buyerSideSinglePiecePrice_actual)/wholesaleMarkedDisplayPrice_actual)*100;
        float ceilB=(float) Math.floor(expectedSinglePieceDiscountOff);
        System.out.println("Discount on Single Piece : " +ceilB);
        Assert.assertEquals(actualSinglePieceDiscountOff,ceilB);
    }

    public void addClearanceDiscount(){
        searchUploadedCatalog();
        CatalogDetailsPageStrategy catalogDetailsPageStrategy= CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickClearanceDiscountLink();


    }
    public void logout(){
        new LoginHelper(this).logout();

    }
    public void loginBuyer(){
        new LoginHelper(this).loginAsTestRetailer();

    }
    public void loginSeller(){
        new LoginHelper(this).loginAsTestManufacturer();
    }


    @Override
    protected void run(){
        getDiscountsForFullAndSingle();
        checkPricesAtSellerSide();
        logout();
        loginBuyer();
        checkPriceAtBuyerSide();
        logout();
        loginSeller();




    }
}
