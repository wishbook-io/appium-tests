package com.wishbook.catalog.TestCases.RejectBuyers;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.BuyerDetailsPage.BuyerDetailsFactory;
import com.wishbook.catalog.PageObject.BuyerDetailsPage.BuyerDetailsStrategy;
import com.wishbook.catalog.PageObject.BuyersRejectedPage.BuyersRejectedPageFactory;
import com.wishbook.catalog.PageObject.BuyersRejectedPage.BuyersRejectedPageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.MyNetworkPage.MyNetworkPageFactory;
import com.wishbook.catalog.PageObject.MyNetworkPage.MyNetworkPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

/**
 * Created by wishbook on 5/5/18.
 */

public class RejectBuyers extends TestCase {
    @SuppressWarnings("unused")
    public RejectBuyers(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));

    }


    @Override
    protected void run() {

        //region Login As Manufacturer
         System.out.println("Login Manufacturer");
        //endregion

        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickMyNetwork();
        MyNetworkPageStrategy myNetworkPageStrategy = MyNetworkPageFactory.getStrategy(this);
        myNetworkPageStrategy.clickSearchButton();
        myNetworkPageStrategy = MyNetworkPageFactory.getStrategy(this);
        myNetworkPageStrategy.clicksearchbar();
        myNetworkPageStrategy.enterBuyerName("Bhasker");
        //region Wait
        try {Thread.sleep(10000);} catch (InterruptedException e) {e.printStackTrace();
        }//endregion
        String selectedBuyer = myNetworkPageStrategy.getSelectedBuyerName();
        System.out.println("BuyerSelectedToReject= "+selectedBuyer);
        myNetworkPageStrategy.selectSearchedBuyerName();
        BuyerDetailsStrategy buyerDetailsStrategy = BuyerDetailsFactory.getStrategy(this);
        buyerDetailsStrategy.clickRejectBuyerButton();
        myNetworkPageStrategy = MyNetworkPageFactory.getStrategy(this);
        myNetworkPageStrategy.BackMyNetworkButton();
        myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickRejectedBuyersButton();
        System.out.println("Buyer Rejected");
        //region wait
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //endregion
        BuyersRejectedPageStrategy buyersRejectedPageStrategy = BuyersRejectedPageFactory.getStrategy(this);
        String rejectedBuyer = buyersRejectedPageStrategy.getBuyerName(1);
        System.out.println("sameGettingInRejectBuyerList= "+rejectedBuyer);
        Assert.assertEquals(selectedBuyer, rejectedBuyer);
        buyersRejectedPageStrategy.clickRejectedBuyer(4);
        buyerDetailsStrategy = BuyerDetailsFactory.getStrategy(this);
        buyerDetailsStrategy.clickApproveButton();
        System.out.println("Buyer Approved");
        buyersRejectedPageStrategy = BuyersRejectedPageFactory.getStrategy(this);
        buyersRejectedPageStrategy.BackBuyersRejctedButton();
        myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickMyNetwork();
        myNetworkPageStrategy = MyNetworkPageFactory.getStrategy(this);
        myNetworkPageStrategy.clickSearchButton();
        myNetworkPageStrategy = MyNetworkPageFactory.getStrategy(this);
        myNetworkPageStrategy.clicksearchbar();
        myNetworkPageStrategy.enterBuyerName("Bhasker");
        //region wait
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//endregion
        String BuyerName = myNetworkPageStrategy.getSelectedBuyerName();
        System.out.println("ApprovedBuyer= "+BuyerName);
        Assert.assertEquals(rejectedBuyer, BuyerName);

}
}
