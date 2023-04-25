package com.wishbook.catalog.TestCases.TestCaseHelper;

import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageFactory;
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageStrategy;
import com.wishbook.catalog.PageObject.SelectBuyerGroupSpinner.SelectBuyerGroupSpinnerFactory;
import com.wishbook.catalog.PageObject.SelectBuyerGroupSpinner.SelectBuyerGroupSpinnerStrategy;
import com.wishbook.catalog.PageObject.ShareCatalogEnterBuyerName.ShareCatalogEnterBuyerNameFactory;
import com.wishbook.catalog.PageObject.ShareCatalogEnterBuyerName.ShareCatalogEnterBuyerNameStrategy;
import com.wishbook.catalog.PageObject.ShareCatalogPage.ShareCatalogPageFactory;
import com.wishbook.catalog.PageObject.ShareCatalogPage.ShareCatalogPageStrategy;
import com.wishbook.catalog.PageObject.ShareDialog.ShareDialogPageFactory;
import com.wishbook.catalog.PageObject.ShareDialog.ShareDialogStrategy;
import com.wishbook.catalog.TestCases.TestCase;

/**
 * Created by wishbook on 23/5/18.
 */

public class CatalogSharingHelper extends BaseTestCaseHelper {

    private String buyerToBeSearched = "8686898989";//onlineRetailer
    private int searchedBuyerIndex = 0;
    private String newCatalogPriceToBeEnter = "542";
    private boolean isGroupShare = true;
    private int buyerGroupSpinnerIndex = 5;//online retailer


    public CatalogSharingHelper(TestCase testCase) {
        super(testCase);
    }

    public void setBuyerToBeSearched(String buyerToBeSearched) {
        this.buyerToBeSearched = buyerToBeSearched;
    }

    public void setSearchedBuyer(int searchedBuyerIndex) {
        this.searchedBuyerIndex = searchedBuyerIndex;
    }

    public void setNewCatalogPriceToBeEnter(String newCatalogPriceToBeEnter) {
        this.newCatalogPriceToBeEnter = newCatalogPriceToBeEnter;
    }


    public void setIsGroupShare(boolean isGroupShare) {
        this.isGroupShare = isGroupShare;
    }

    public void setBuyerGroupSpinnerIndex(int buyerGroupSpinnerIndex) {
        this.buyerGroupSpinnerIndex = buyerGroupSpinnerIndex;
    }


    public void shareCatalog() {

        if (isGroupShare) {
            ShareCatalogPageStrategy shareCatalogPageStrategy1 = ShareCatalogPageFactory.getStrategy(testCase);
            shareCatalogPageStrategy1.selectGroupTab();
            shareCatalogPageStrategy1.clickbuyerGroupTextField();
            SelectBuyerGroupSpinnerStrategy selectBuyerGroupSpinnerStrategy = SelectBuyerGroupSpinnerFactory.getStrategy(testCase);
            selectBuyerGroupSpinnerStrategy.selectBuyerGroup(buyerGroupSpinnerIndex);

        } else {
            ShareCatalogPageStrategy shareCatalogPageStrategy2 = ShareCatalogPageFactory.getStrategy(testCase);
            shareCatalogPageStrategy2.selectIndividualTab();
            shareCatalogPageStrategy2.clickBuyerNameTextBox();
            ShareCatalogEnterBuyerNameStrategy shareCatalogEnterBuyerNameStrategy = ShareCatalogEnterBuyerNameFactory.getStrategy(testCase);
            shareCatalogEnterBuyerNameStrategy.enterBuyerToBeSearch(buyerToBeSearched);
            shareCatalogEnterBuyerNameStrategy.clickSearchedBuyer(searchedBuyerIndex);
        }
        ShareCatalogPageStrategy shareCatalogPageStrategy = ShareCatalogPageFactory.getStrategy(testCase);
        shareCatalogPageStrategy.shareAtDifferentPriceRadioButton();
        shareCatalogPageStrategy.enterNewPriceTextBox(newCatalogPriceToBeEnter);
        shareCatalogPageStrategy.clickDoneButton();
    }
    public void shareCommonIndividualCatalogs(String numberCatalogToBeShare) {
        CatalogSharingHelper catalogSharingHelper=new CatalogSharingHelper(testCase);
        catalogSharingHelper.setIsGroupShare(false);
        catalogSharingHelper.setBuyerToBeSearched(numberCatalogToBeShare);
        catalogSharingHelper.setSearchedBuyer(0);
        catalogSharingHelper.setNewCatalogPriceToBeEnter("854");
        catalogSharingHelper.shareCatalog();
    }
    public void shareCommonGroupCatalog(int indexOfGroup) {
        CatalogSharingHelper catalogSharingHelper1=new CatalogSharingHelper(testCase);
        catalogSharingHelper1.setIsGroupShare(true);
        catalogSharingHelper1.setBuyerGroupSpinnerIndex(indexOfGroup);
        catalogSharingHelper1.setNewCatalogPriceToBeEnter("545");
        catalogSharingHelper1.shareCatalog();
        }

    public void catalogShareInMyCatalogIndividualCatalogs(String catalogName,String numberCatalogToBeShare) {
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(testCase);
        myBusinessPageStrategy.clickMyCatalogs();
        MyCatalogPageStrategy myCatalogPageStrategy = MyCatalogPageFactory.getStrategy(testCase);
        myCatalogPageStrategy.clickSearchIcon();
        myCatalogPageStrategy.enterText(catalogName);
        myCatalogPageStrategy.clickShareButton();
        ShareDialogStrategy shareDialogStrategy= ShareDialogPageFactory.getStrategy(testCase);
        shareDialogStrategy.clickShareOnWishbook();
        CatalogSharingHelper catalogSharingHelper=new CatalogSharingHelper(testCase);
        catalogSharingHelper.setIsGroupShare(false);
        catalogSharingHelper.setBuyerToBeSearched(numberCatalogToBeShare);
        catalogSharingHelper.setSearchedBuyer(0);
        catalogSharingHelper.shareCatalog();
        System.out.println("Catalog1 Shared With Retailer Individually  " + catalogName);

    }
    public void catalogShareInMyCatalogGroupCatalogs(String catalogName,int indexOfGroup) {

        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(testCase);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(testCase);
        myBusinessPageStrategy.clickMyCatalogs();
        MyCatalogPageStrategy myCatalogPageStrategy = MyCatalogPageFactory.getStrategy(testCase);
        myCatalogPageStrategy.clickSearchIcon();
        myCatalogPageStrategy.enterText(catalogName);
        myCatalogPageStrategy.clickShareButton();
        ShareDialogStrategy shareDialogStrategy= ShareDialogPageFactory.getStrategy(testCase);
        shareDialogStrategy.clickShareOnWishbook();
        CatalogSharingHelper catalogSharingHelper1=new CatalogSharingHelper(testCase);
        catalogSharingHelper1.setIsGroupShare(true);
        catalogSharingHelper1.setBuyerGroupSpinnerIndex(indexOfGroup);
        catalogSharingHelper1.shareCatalog();
        System.out.println("Catalog1 Shared With Retailer Group  " + catalogName);

    }
}
