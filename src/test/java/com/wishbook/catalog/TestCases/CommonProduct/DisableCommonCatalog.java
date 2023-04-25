package com.wishbook.catalog.TestCases.CommonProduct;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;

public class DisableCommonCatalog extends TestCase {

    public DisableCommonCatalog(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));
    }

    protected void run() {
        BottomTabPageStrategy bottomTabPageStrategy= BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy= MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickMyCatalogs();
        CatalogSearchHelper catalogSearchHelper= new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInMyCatalog(getTest().getCommonCatalogName());
        CatalogDetailsPageStrategy catalogDetailsPageStrategy= CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickStopSelling();

    }
}
