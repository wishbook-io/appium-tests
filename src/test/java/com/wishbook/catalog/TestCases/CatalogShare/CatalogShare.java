package com.wishbook.catalog.TestCases.CatalogShare;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageFactory;
import com.wishbook.catalog.PageObject.MyCatalogPage.MyCatalogPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.*;
import com.wishbook.catalog.TestCases.TestCaseOptions;


/**
 * Created by wishbook on 6/4/18.
 */

public class CatalogShare extends TestCase {
    @SuppressWarnings("unused")
    public CatalogShare(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsWholeSaler));

    }

    @Override
    public void run() {
        ProductUploadHelper productUploadHelper = new ProductUploadHelper(this,ProductTestCaseHelper.SetType.SingleColorSet,ProductTestCaseHelper.PhotoshootType.Catalog);
        productUploadHelper.execute();

        CatalogSharingHelper catalogSharingHelper= new CatalogSharingHelper(this);
        catalogSharingHelper.catalogShareInMyCatalogIndividualCatalogs(productUploadHelper.getCatalogName(),"6888877777");
        MyCatalogPageStrategy myCatalogPageStrategy1 = MyCatalogPageFactory.getStrategy(this);
        myCatalogPageStrategy1.clickCloseSearchButton();
        myCatalogPageStrategy1.BackCatalogButton();
        new LoginHelper(this).logout();
        new LoginHelper(this).loginAsTestRetailer();
        CatalogSearchHelper catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.searchCatalogInReceived(productUploadHelper.getCatalogName());

    }

}
