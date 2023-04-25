package com.wishbook.catalog.PageObject.TransferSalesOrderDialog;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class TransferSalesOrderDialogFactory {

    public static TransferSalesOrderDialogStrategy getStrategy(TestCase testCase) {

        TransferSalesOrderDialogStrategy strategy= null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new TransferSalesOrderDialogAndroidObject(testCase);
        }
        return strategy;
    }

}
