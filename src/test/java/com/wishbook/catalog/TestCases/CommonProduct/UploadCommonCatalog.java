package com.wishbook.catalog.TestCases.CommonProduct;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductTestCaseHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductUploadHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;

public class UploadCommonCatalog extends TestCase {

    public UploadCommonCatalog(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer,true));

    }

    protected void run() {
        ProductUploadHelper productUploadHelper = new ProductUploadHelper(this,ProductTestCaseHelper.SetType.SingleColorSet,ProductTestCaseHelper.PhotoshootType.Catalog);
        productUploadHelper.execute();
        getTest().setCommonCatalogName(productUploadHelper.getCatalogName());
        getTest().setCommonCatalogBrandName(productUploadHelper.getSelectedBrandName());
        getTest().setCommonCatalogCategory(productUploadHelper.getSelectedCategory());
        getTest().setCommonCatalogFabric(productUploadHelper.getSelectedFabric());
        getTest().setCommoncatalogWork(productUploadHelper.getSelectedWork());
        new LoginHelper(this).logout();

    }
}
