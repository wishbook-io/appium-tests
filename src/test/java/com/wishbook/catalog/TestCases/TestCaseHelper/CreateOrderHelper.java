package com.wishbook.catalog.TestCases.TestCaseHelper;

import com.wishbook.catalog.PageObject.PaymentCardDetailsPage.PaymentCardDetailsPageFactory;
import com.wishbook.catalog.PageObject.PaymentCardDetailsPage.PaymentCardDetailsPageStrategy;
import com.wishbook.catalog.PageObject.PaymentDialogPage.PaymentDialogFactory;
import com.wishbook.catalog.PageObject.PaymentDialogPage.PaymentDialogStrategy;
import com.wishbook.catalog.PageObject.PaymentOptionsPage.PaymentOptionsPageFactory;
import com.wishbook.catalog.PageObject.PaymentOptionsPage.PaymentOptionsPageStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageFactory;
import com.wishbook.catalog.PageObject.ShipmentAndPaymentPage.ShipmentAndPaymentPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;

public class CreateOrderHelper extends BaseTestCaseHelper {

    @SuppressWarnings("unused")
    private int orderNumber;

    @SuppressWarnings("unused")
    public int getOrderNumber() {
        return orderNumber;
    }


    public CreateOrderHelper(TestCase testCase) {
        super(testCase);
    }


    public void createOrderOnCredit() {

        //region wait
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//endregion
        ShipmentAndPaymentPageStrategy shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(testCase);
        shipmentAndPaymentPageStrategy.selectShipmentAddress(0);
        shipmentAndPaymentPageStrategy.clickDoneButton();
        }

    public void createOrderUsingOtherPayments() {

        //region wait
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//endregion
        ShipmentAndPaymentPageStrategy shipmentAndPaymentPageStrategy = ShipmentAndPaymentPageFactory.getStrategy(testCase);
        shipmentAndPaymentPageStrategy.selectShipmentAddress(0);
       // shipmentAndPaymentPageStrategy.clickOtherPaymentMode();
        shipmentAndPaymentPageStrategy.clickEnterPaymentDetails();
        PaymentDialogStrategy paymentDialogStrategy= PaymentDialogFactory.getStrategy(testCase);

        paymentDialogStrategy.clickSavePaymentButton();

    }

    public void createOrderUsingCashFree() {
        ShipmentAndPaymentPageStrategy shipmentAndPaymentPageStrategy= ShipmentAndPaymentPageFactory.getStrategy(testCase);
        shipmentAndPaymentPageStrategy.selectPaymentModeAtIndex(0);
        shipmentAndPaymentPageStrategy.clickProceedForPaymentButton();
        PaymentOptionsPageStrategy paymentOptionsPageStrategy=PaymentOptionsPageFactory.getStrategy(testCase);
//        paymentOptionsPageStrategy.clickDebitCard();
        PaymentCardDetailsPageStrategy paymentCardDetailsPageStrategy= PaymentCardDetailsPageFactory.getStrategy(testCase);
        paymentCardDetailsPageStrategy.enterCardNumber("4012888888881881");
        paymentCardDetailsPageStrategy.enterCardHolderName("testing");
//        paymentCardDetailsPageStrategy.clickMonthTextFiled();
//        paymentCardDetailsPageStrategy.selectCardExpiryMonth(8);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        paymentCardDetailsPageStrategy.clickYearTextField();
//        paymentCardDetailsPageStrategy.selectCardExpiryYear(1);
//        paymentCardDetailsPageStrategy.clickMonthTextFiled();
        paymentCardDetailsPageStrategy.selectCardExpiryMonth(8);
        paymentCardDetailsPageStrategy.enterCvvNumber("123");
        paymentCardDetailsPageStrategy.clickPayButton();
        paymentCardDetailsPageStrategy.clickSuccessButton();
        PopUpPageStrategy popUpPageStrategy= PopUpPageFactory.getStrategy(testCase);
        popUpPageStrategy.clickOk();


    }

}
