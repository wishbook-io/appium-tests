package com.wishbook.catalog.TestCases.UploadCatalogs;

import com.wishbook.catalog.Execution.Core.BaseTest;


import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductTestCaseHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.UploadUiHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;

/**
 * Created by wishbook on 15/3/18.
 */

public class ProductUIValidation extends TestCase {

    @SuppressWarnings("unused")
    public ProductUIValidation(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestWholeSaler));

    }

    public void run() {
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.dismissCreditRatingDialog();

        //uploding Catalog ui is done reseller uploading single Design

        UploadUiHelper uploadUiHelper=new UploadUiHelper(this,ProductTestCaseHelper.SetType.SingleColorSet,ProductTestCaseHelper.PhotoshootType.WhiteBackgroundOrFaceCut);
        uploadUiHelper.execute();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UploadUiHelper uploadUiHelper1= new UploadUiHelper(this,ProductTestCaseHelper.SetType.MultiSet,ProductTestCaseHelper.PhotoshootType.WhiteBackgroundOrFaceCut);
        uploadUiHelper1.execute();



    }
}
