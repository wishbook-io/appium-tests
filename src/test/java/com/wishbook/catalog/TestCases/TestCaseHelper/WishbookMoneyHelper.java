package com.wishbook.catalog.TestCases.TestCaseHelper;

import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageFactory;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;

public class WishbookMoneyHelper extends BaseTestCaseHelper {


    public WishbookMoneyHelper(TestCase testCase) {
        super(testCase);
    }



    public void wishbookMoneyCheckedBoxOnShipmentPage() {
        ShipmentAndPaymentPageStrategy shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(testCase);
         //shipmentAndPaymentPageStrategy.wishBookMoneyCheckBox();


    }


}
