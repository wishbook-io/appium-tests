package com.wishbook.catalog.TestCases.CommonProduct;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductTestCaseHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductUploadHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;

public class UploadCommonScreen extends TestCase {
    public UploadCommonScreen(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer,true));
    }

    protected void run() {
        ProductUploadHelper productUploadHelper = new ProductUploadHelper(this,ProductTestCaseHelper.SetType.MultiSet,ProductTestCaseHelper.PhotoshootType.WhiteBackgroundOrFaceCut);
        productUploadHelper.execute();
        getTest().setCommonScreenName(productUploadHelper.getScreenName());
        getTest().setCommonScreenBrand(productUploadHelper.getSelectedBrandName());
        getTest().setCommonScreenCategory(productUploadHelper.getSelectedCategory());

        new LoginHelper(this).logout();

    }
}
