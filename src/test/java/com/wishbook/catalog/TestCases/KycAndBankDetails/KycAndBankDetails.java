package com.wishbook.catalog.TestCases.KycAndBankDetails;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.KycAndBankDeatilsPage.KycAndBankDetailsPageFactory;
import com.wishbook.catalog.PageObject.KycAndBankDeatilsPage.KycAndBankDetailsPageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

public class KycAndBankDetails extends TestCase {
    public KycAndBankDetails(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestManufacturer));
    }

    protected void run() {

        BottomTabPageStrategy bottomTabPageStrategy= BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy= MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickKycBankDetails();

        KycAndBankDetailsPageStrategy kycAndBankDetailsPageStrategy= KycAndBankDetailsPageFactory.getStrategy(this);
        kycAndBankDetailsPageStrategy.enterGstNumber("1234432567y879");
        kycAndBankDetailsPageStrategy.clickOnSaveButton();




        kycAndBankDetailsPageStrategy.enterGstNumber("1234432567y879h");
        kycAndBankDetailsPageStrategy.enterBankName("state bank");


        java.util.Random rng = new java.util.Random();
        long first14 = (rng.nextLong() % 100000000000000L) + 5200000000000000L;
        kycAndBankDetailsPageStrategy.enterAccountNumber(first14);

        kycAndBankDetailsPageStrategy.enterIFSCcode("grt3736281g");

        kycAndBankDetailsPageStrategy.enterAccountHolderName("sandip bhatolia");
        kycAndBankDetailsPageStrategy.clickOnSaveButton();

        myBusinessPageStrategy= MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickKycBankDetails();

        long accNumber1=kycAndBankDetailsPageStrategy.getAccountNumber();
        Assert.assertEquals(first14,accNumber1);

        kycAndBankDetailsPageStrategy.clickKycBackPage();
        new LoginHelper(this).logout();

        new LoginHelper(this).loginAsTestRetailer();
        HomePageStrategy homePageStrategy= HomePageFactory.getStrategy(this);
        homePageStrategy.dismissCreditRatingDialog();

        bottomTabPageStrategy= BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        myBusinessPageStrategy.clickKycBankDetails();

        kycAndBankDetailsPageStrategy= KycAndBankDetailsPageFactory.getStrategy(this);
        kycAndBankDetailsPageStrategy.enterGstNumber("1234432567y999");
        kycAndBankDetailsPageStrategy.clickOnSaveButton();

        kycAndBankDetailsPageStrategy.enterGstNumber("1234432567y879h");
        kycAndBankDetailsPageStrategy.enterBankName("state bank");


        java.util.Random rng1 = new java.util.Random();
        long firs114 = (rng1.nextLong() % 100000000000000L) + 5200000000000000L;
        kycAndBankDetailsPageStrategy.enterAccountNumber(firs114);


        kycAndBankDetailsPageStrategy.enterIFSCcode("grt3736281g");
        kycAndBankDetailsPageStrategy.enterAccountHolderName("sandip bhatolia");
        kycAndBankDetailsPageStrategy.clickOnSaveButton();

        myBusinessPageStrategy= MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickKycBankDetails();

        long accNumber11=kycAndBankDetailsPageStrategy.getAccountNumber();
        Assert.assertEquals(firs114,accNumber11);
        kycAndBankDetailsPageStrategy.clickKycBackPage();




    }
}
