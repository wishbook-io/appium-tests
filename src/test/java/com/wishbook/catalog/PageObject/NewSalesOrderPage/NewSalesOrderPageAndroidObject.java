package com.wishbook.catalog.PageObject.NewSalesOrderPage;


import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class NewSalesOrderPageAndroidObject extends NewSalesOrderPageObject implements NewSalesOrderPageStrategy {
    public NewSalesOrderPageAndroidObject(TestCase testCase) {
        super(testCase);
    }


    public float getDesignPrice() {
        return BasePageObject.getFloatFromString(AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,"com.wishbook.catalog:id/prod_price").getText());

        }

        public float getTotalValue(){
            return BasePageObject.getFloatFromString(AndroidHelper.getScrollableItemByResourceId((AndroidDriver)getDriver(),0,"com.wishbook.catalog:id/totalprice").getText());

        }



}