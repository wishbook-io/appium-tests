package com.wishbook.catalog.TestCases.TestCaseHelper;

import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageFactory;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;

@SuppressWarnings("unused")
public class AddToCartHelper extends BaseTestCaseHelper {
    public AddToCartHelper(TestCase testCase) {
        super(testCase);
    }

    public void addToCart() {
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(testCase);
        catalogDetailsPageStrategy.clickAddToCartButton();
        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(testCase);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catalogDetailsPageStrategy.clickAddToCartIcon();
        MyCartPageStrategy myCartPageStrategy = MyCartPageFactory.getStrategy(testCase);
        myCartPageStrategy.clickPlaceOrderButton();
    }
}
