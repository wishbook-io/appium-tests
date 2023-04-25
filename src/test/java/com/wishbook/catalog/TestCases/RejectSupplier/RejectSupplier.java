package com.wishbook.catalog.TestCases.RejectSupplier;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.MyNetworkPage.MyNetworkPageFactory;
import com.wishbook.catalog.PageObject.MyNetworkPage.MyNetworkPageStrategy;
import com.wishbook.catalog.PageObject.SuppliersDetailsPage.SupplierDetailsPageFactory;
import com.wishbook.catalog.PageObject.SuppliersDetailsPage.SupplierDetailsPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseOptions;


/**
 * Created by wishbook on 15/5/18.
 */

public class RejectSupplier extends TestCase {
    @SuppressWarnings("unused")
    public RejectSupplier(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestRetailer));

    }

    @Override
    protected void run() {

        //region Login As Retailer
        System.out.println("Login Retailer");
        //endregion

        //region Remove Supplier
        System.out.println("Supplier Removing...");
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickMyNetwork();
        MyNetworkPageStrategy myNetworkPageStrategy = MyNetworkPageFactory.getStrategy(this);
        myNetworkPageStrategy.clickSearchButton();
        myNetworkPageStrategy = MyNetworkPageFactory.getStrategy(this);
        myNetworkPageStrategy.clicksearchbar();
        myNetworkPageStrategy.enterBuyerName("9925024856");
        //region Wait
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//endregion
        String selectedSupplierName = myNetworkPageStrategy.getSelectedSupplierName();
        System.out.println("SupplierSelectedToReject= " + selectedSupplierName);
        myNetworkPageStrategy.clickSelectedSupplier();
        SupplierDetailsPageStrategy supplierDetailsPageStrategy = SupplierDetailsPageFactory.getStrategy(this);
        supplierDetailsPageStrategy.clickRemoveSupplier();

        myNetworkPageStrategy = MyNetworkPageFactory.getStrategy(this);
        myNetworkPageStrategy.BackMyNetworkButton();
        System.out.println("Supplier Removed");
        //endregion

        //region Checking In Rejected Suppliers and approve
//        System.out.println("Searching in Rejected Suppliers");
//        myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
//        myBusinessPageStrategy.clickRejectedSuppliersButton();
//        SupplierRejectedPageStrategy supplierRejectedPageStrategy = SupplierRejectedPageFactory.getStrategy(this);
//        String rejectedSupplier=supplierRejectedPageStrategy.getSupplierName(1);
//        System.out.println("RejectedSupplier is = "+rejectedSupplier);
//        Assert.assertEquals(selectedSupplierName,rejectedSupplier);
//        System.out.println("Suppliers are matched!!!");
//        supplierRejectedPageStrategy.clickRejectedSupplier(1);
//        System.out.println("Supplier Approving...");
//        supplierDetailsPageStrategy = SupplierDetailsPageFactory.getStrategy(this);
//        supplierDetailsPageStrategy.clickApproveButton();
//        System.out.println("Approved Supplier");
//        SupplierRejectedPageStrategy supplierRejectedPageStrategy1 = SupplierRejectedPageFactory.getStrategy(this);
//        supplierRejectedPageStrategy1.BackSupplierRejctedButton();
//        //endregion
//
//        //region go to My network and  verify rejected Supplier
//        System.out.println("searching rejected supplier in my network... ");
//        myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
//        myBusinessPageStrategy.clickMyNetwork();
//        myNetworkPageStrategy = MyNetworkPageFactory.getStrategy(this);
//        myNetworkPageStrategy.clickSearchButton();
//        myNetworkPageStrategy = MyNetworkPageFactory.getStrategy(this);
//        myNetworkPageStrategy.clicksearchbar();
//        myNetworkPageStrategy.enterBuyerName("7676797979");
//        //region wait
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }//endregion
//        String supplierName=myNetworkPageStrategy.getSelectedSupplierName();
//        Assert.assertEquals(rejectedSupplier,supplierName);
//        System.out.println("supplier is present in my network");
////        //endregion

    }

}
