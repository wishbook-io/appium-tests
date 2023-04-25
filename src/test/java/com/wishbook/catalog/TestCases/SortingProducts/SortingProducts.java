package com.wishbook.catalog.TestCases.SortingProducts;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.ProductTab.ProductTabFactory;
import com.wishbook.catalog.PageObject.ProductTab.ProductTabStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.ProductTestCaseHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.SortingHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;

/**
 * Created by wishbook on 26/3/18.
 */

public class SortingProducts extends TestCase {
    @SuppressWarnings("unused")
    public SortingProducts(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestWholeSaler));

    }

    public void run() {
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickProductsButton();
        ProductTabStrategy productTabStrategy = ProductTabFactory.getStrategy(this);
        productTabStrategy.clickSareesCategory();



    }

}