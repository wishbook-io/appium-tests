package com.wishbook.catalog.TestCases.CatalogDetails;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

/**
 * Created by wishbook on 28/3/18.
 */

public class CatalogDetails extends TestCase {

    @SuppressWarnings("unused")
    public CatalogDetails(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));

    }

    public void run() {

        //region Search in MyCatalog uploaded Catalog,search for wishList Follow Buy now,send enquiry, share
        CatalogSearchHelper catalogSearchHelper = new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInMyCatalog(getTest().getCommonCatalogName());
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        String getCatalogName = catalogDetailsPageStrategy.getProductNameInMyProduct().toLowerCase();
        Assert.assertEquals(getTest().getCommonCatalogName().toLowerCase(), getCatalogName.toLowerCase());
//        String category=catalogDetailsPageStrategy.getCategory();
//        Assert.assertEquals(getTest().getCommonCatalogCategory(),category);


        String getBrandName = catalogDetailsPageStrategy.getBrandNameText();
        Assert.assertEquals(getTest().getCommonCatalogBrandName(), getBrandName);
        String getWork = catalogDetailsPageStrategy.getWorkText();
        Assert.assertEquals(getTest().getCommoncatalogWork(), getWork);
        String getFabric = catalogDetailsPageStrategy.getFabricText();
        Assert.assertEquals(getTest().getCommonCatalogFabric(), getFabric);
        catalogSearchHelper.goBackToMyBusinessPage();
        new LoginHelper(this).logout();

        //endregion
    }
}
