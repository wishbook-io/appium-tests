package com.wishbook.catalog.TestCases.CatalogEnquiry;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.ChatPage.ChatPageFactory;
import com.wishbook.catalog.PageObject.ChatPage.ChatPageStrategy;
import com.wishbook.catalog.PageObject.EnquiryDetailsDialoge.EnquiryDetailsDialogeFactory;
import com.wishbook.catalog.PageObject.EnquiryDetailsDialoge.EnquiryDetailsDialogeStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.OrderList.OrderListFactory;
import com.wishbook.catalog.PageObject.OrderList.OrderListStrategy;
import com.wishbook.catalog.PageObject.OrderPage.OrderPageFactory;
import com.wishbook.catalog.PageObject.OrderPage.OrderPageStrategy;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageFactory;
import com.wishbook.catalog.PageObject.SearchPage.SearchPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class CatalogEnquiry extends TestCase {
    @SuppressWarnings("unused")

    public CatalogEnquiry(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestRetailer));

    }

    protected void run() {
//        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(this);
//        homePageStrategy.dismissCreditRatingDialog();

        BottomTabPageStrategy bottomTabPageStrategy=BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);
        String companyName = myBusinessPageStrategy.getTextCompanyName();
        System.out.println(companyName);
        //endregion

        //region count open resolved and total enquiries before enquiry creation
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickOrderButton();
        //region wait
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//endregion
        OrderPageStrategy orderPageStrategy = OrderPageFactory.getStrategy(this);
        System.out.println("--------count Enquiries before enqiury about catalog-------");
        int totalEnqiury = orderPageStrategy.getTextTotalEnquiry();
        System.out.println("total Enquiries before enquiry = " + totalEnqiury);
        int openEnqiury = orderPageStrategy.getTextEnquiryOpen();
        System.out.println("openEnquiries before enquiry = " + openEnqiury);
        int resolvdEnqiury = orderPageStrategy.getTextEnquiryResolved();
        System.out.println("resolvedEnquiries before enquiry = " + resolvdEnqiury);

        int addTotalBeforeEnquiry = openEnqiury + resolvdEnqiury;
        Assert.assertEquals(totalEnqiury, addTotalBeforeEnquiry);
        //endregion

        //region search catalog and make enquiry about catalog
        System.out.println("creating enquiry..");
        CatalogSearchHelper catalogSearchHelper =new CatalogSearchHelper(this);
        catalogSearchHelper.catalogSearchInHomePageSearchButton(getTest().getCommonCatalogName());

        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.sendEnquiryButton();
        EnquiryDetailsDialogeStrategy enquiryDetailsDialogeStrategy = EnquiryDetailsDialogeFactory.getStrategy(this);
        enquiryDetailsDialogeStrategy.clickDispatchAndDeliveryChecbox();
        enquiryDetailsDialogeStrategy.clickFabricAndMaterialCheckBox();
        enquiryDetailsDialogeStrategy.clickSendButton();
        enquiryDetailsDialogeStrategy.enterNumberOfSet(0);
        enquiryDetailsDialogeStrategy.clickSendButton();
        enquiryDetailsDialogeStrategy.enterNumberOfSet(10);
        enquiryDetailsDialogeStrategy.clickSendButton();
        ChatPageStrategy chatPageStrategy = ChatPageFactory.getStrategy(this);
        chatPageStrategy.BackChatButton();
        catalogSearchHelper.goBackToHomePageAfterCatalogSelection();
        System.out.println("enquiry created!!!!!");
        //endregion

        //region search that catalog and check with supplier button is there
        CatalogSearchHelper catalogSearchHelper1 =new CatalogSearchHelper(this);
        catalogSearchHelper1.catalogSearchInHomePageSearchButton(getTest().getCommonCatalogName());

        catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        Boolean v = catalogDetailsPageStrategy.ChatWithSupplierButtonIsDisplayed();
        Assert.assertTrue(v);
        System.out.println("chat with supplier button is there " + v);
        catalogSearchHelper.goBackToHomePageAfterCatalogSelection();
        //endregion

        //region changes in enquiries after enquiry created open is increased by 1
        bottomTabPageStrategy.clickOrderButton();
        //region wait
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//endregion

        orderPageStrategy = OrderPageFactory.getStrategy(this);
        System.out.println("--------count Enquiries After enqiury about catalog-------");
        int totalAfterEnqiury = orderPageStrategy.getTextTotalEnquiry();
        int totalVerify = totalEnqiury + 1;
        Assert.assertEquals(totalVerify, totalAfterEnqiury);
        System.out.println("total Enquiries After enquiry = " + totalAfterEnqiury);

        int openAfterEnqiury = orderPageStrategy.getTextEnquiryOpen();
        System.out.println("openEnquiries After enquiry = " + openAfterEnqiury);
        int verifyOpen = openEnqiury + 1;
        Assert.assertEquals(verifyOpen, openAfterEnqiury);


        int resolvdAfterEnqiury = orderPageStrategy.getTextEnquiryResolved();
        System.out.println("resolvedEnquiries After enquiry = " + resolvdAfterEnqiury);
        Assert.assertEquals(resolvdAfterEnqiury, resolvdEnqiury);
        //endregion

        //region search enquiry in open by catalog name
        orderPageStrategy.openEnquiryButton();
        OrderListStrategy orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickOnSearchIconForEnquiryLead();
        orderListStrategy.enterCatalogNameSearchTextField(getTest().getCommonCatalogName());

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orderListStrategy=OrderListFactory.getStrategy(this);
        String status = orderListStrategy.getTextLeadEnquiryStatus();
        System.out.println("status of enquiry = "+status);
        String OpenStatus = "Status: Open";
        Assert.assertEquals(OpenStatus, status);
        orderListStrategy.clickSearchedLeadsEnquiry();
        chatPageStrategy = ChatPageFactory.getStrategy(this);

        chatPageStrategy.BackChatButton();
        SearchPageStrategy searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.clearSearchTextField();
        searchPageStrategy.closeSearchTextField();
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickOnSearchIconForEnquiryLead();
        orderListStrategy.OrderListBackButton();
        //endregion

        //region Logout as retailer
        new LoginHelper(this).logout();
        System.out.println("\n");
        //endregion

        //region login as manufacturer
        System.out.println("login as manufacturer");
        new LoginHelper(this).loginAsTestManufacturer();
        //endregion

        //region check open leads increased by 1 search in open leads and resolved it

        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickOrderButton();
        orderPageStrategy.openLeadButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickOnSearchIconForEnquiryLead();
        orderListStrategy.enterCatalogNameSearchTextField(companyName);
        orderListStrategy.clickSearchedLead(8);
        orderListStrategy.clickOnSearchIconForEnquiryLead();
        orderListStrategy.enterCatalogNameSearchTextField(getTest().getCommonCatalogName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String status6 = orderListStrategy.getTextLeadEnquiryStatus();
        System.out.println("status of enquiry = "+status6);
        String OpenLeadStatus = "Status: Open";
        Assert.assertEquals(OpenLeadStatus, status6);


        orderListStrategy.clickSearchedLead(8);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chatPageStrategy = ChatPageFactory.getStrategy(this);
        chatPageStrategy.clickResolve();
        chatPageStrategy = ChatPageFactory.getStrategy(this);
        chatPageStrategy.BackChatButton();
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.clearSearchTextField();
        searchPageStrategy.closeSearchTextField();
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.OrderListBackButton();

        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.closeSearchTextField();
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickOnSearchIconForEnquiryLead();
        orderListStrategy.OrderListBackButton();
        //endregion

        //region open leads decreased by 1 and resolved increased by 1 total remain same
        bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickOrderButton();

        //endregion

        //region after resoving lead goto open leads to resolved lead and check it in open leads
        orderPageStrategy=OrderPageFactory.getStrategy(this);
        orderPageStrategy.openLeadButton();
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickOnSearchIconForEnquiryLead();
        orderListStrategy.enterCatalogNameSearchTextField(getTest().getCommonCatalogName());
        String message = "No items to display";
        String noCatalogMessage = searchPageStrategy.noDataFoundTextLead();
        Assert.assertEquals(message, noCatalogMessage);
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.closeSearchTextField();
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickOnSearchIconForEnquiryLead();
        orderListStrategy.OrderListBackButton();
        //endregion

        //region logout as manufacturer
        new LoginHelper(this).logout();
        System.out.println("\n");
        //endregion

        //region login as retailer
        new LoginHelper(this).loginAsTestRetailer();
//        homePageStrategy= HomePageFactory.getStrategy(this);
//        homePageStrategy.dismissCreditRatingDialog();
        //endregion

        //region Count total Enquiries is same ,Open decreased by 1 and Resolved, Notification is increased by 1
        bottomTabPageStrategy.clickOrderButton();
        //region wait
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }//endregion
        orderPageStrategy = OrderPageFactory.getStrategy(this);
        System.out.println("--------count Enquiries After enqiury Resolved-------");
        int totalAfterEnqiuryResolved = orderPageStrategy.getTextTotalEnquiry();
        Assert.assertEquals(totalVerify, totalAfterEnqiuryResolved);
        System.out.println("total Enquiries After enquiry = " + totalAfterEnqiuryResolved);

        int openAfterEnqiuryResolved = orderPageStrategy.getTextEnquiryOpen();
        System.out.println("openEnquiries After enquiry Resolved  = " + openAfterEnqiuryResolved);
        int verifyOpenResolved = verifyOpen - 1;
        Assert.assertEquals(openAfterEnqiuryResolved, verifyOpenResolved);


        int resolvdAfterEnqiuryResolved = orderPageStrategy.getTextEnquiryResolved();
        System.out.println("resolvedEnquiries After enquiry = " + resolvdAfterEnqiuryResolved);
        int verifyCloseResolved = resolvdEnqiury + 1;
        Assert.assertEquals(resolvdAfterEnqiuryResolved, verifyCloseResolved);
        //endregion

        //region verify it should not be in open enquiry and check in resloved
        orderPageStrategy.openEnquiryButton();
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickOnSearchIconForEnquiryLead();
        orderListStrategy.enterCatalogNameSearchTextField(getTest().getCommonCatalogName());
        String message1 = "No items to display";
        String noCatalogMessage1 = searchPageStrategy.noDataFoundTextLead();
        Assert.assertEquals(message1, noCatalogMessage1);
        searchPageStrategy = SearchPageFactory.getStrategy(this);
        searchPageStrategy.closeSearchTextField();
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.OrderListBackButton();

        orderPageStrategy.resolvedEnquiryButton();
        orderListStrategy = OrderListFactory.getStrategy(this);
        orderListStrategy.clickOnSearchIconForEnquiryLead();
        orderListStrategy.enterCatalogNameSearchTextField(getTest().getCommonCatalogName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String status2 = orderListStrategy.getTextLeadEnquiryStatus();
        System.out.println("status of enquiry = "+status2);
        String OpenStatus1 = "Status: Resolved";
        Assert.assertEquals(OpenStatus1, status2);
        orderListStrategy.clickSearchedLeadsEnquiry();
        //endregion


    }
}
