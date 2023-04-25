package com.wishbook.catalog.TestCases.Profile;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.ProfilePage.ProfilePageFactory;
import com.wishbook.catalog.PageObject.ProfilePage.ProfilePageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

/**
 * Created by wishbook on 17/4/18.
 */

public class Profile extends TestCase {
    @SuppressWarnings("unused")
    public Profile(BaseTest test) {
        super(test,new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsUser));

    }

    public void run() {
        BottomTabPageStrategy bottomTabPageStrategy= BottomTabPageFactory.getStrategy(this);
        bottomTabPageStrategy.clickMyBusiness();
        MyBusinessPageStrategy myBusinessPageStrategy= MyBusinessPageFactory.getStrategy(this);
        myBusinessPageStrategy.clickProfileLogo();
        ProfilePageStrategy profilePageStrategy= ProfilePageFactory.getStrategy(this);

        profilePageStrategy.enterName("");
        profilePageStrategy.enterCompanyName("");
        profilePageStrategy.enterEmailId("");
        profilePageStrategy.enterAddress("");
        profilePageStrategy.enterPincode(0);
        profilePageStrategy.enterGSTNumber(0);
        profilePageStrategy.clickSaveChanges();
        System.out.println("case 1 all blank");

        profilePageStrategy.enterName("sandip Bhatolia");
        profilePageStrategy.clickSaveChanges();
        String actualEnteredName=profilePageStrategy.getEnteredName().toLowerCase();
        System.out.println(actualEnteredName);
        System.out.println("case 2");

        profilePageStrategy.enterCompanyName("Bhatoliagroups");
        profilePageStrategy.clickSaveChanges();
        String actualCompanyName=profilePageStrategy.getCompananyName().toLowerCase();
        System.out.println(actualCompanyName);
        System.out.println("case 3");

        String actualPhone=profilePageStrategy.getPhoneNumber();
        System.out.println(actualPhone);


        profilePageStrategy.enterEmailId("a@gmail.com");
        profilePageStrategy.clickSaveChanges();
        String actualEmailId=profilePageStrategy.getEmailId();
        System.out.println(actualEmailId);
        System.out.println("case 4");

        profilePageStrategy.enterAddress("south end circle");
        profilePageStrategy.clickSaveChanges();
        String actualAddress=profilePageStrategy.getAddress();
        System.out.println(actualAddress);
        System.out.println("case 5");

        profilePageStrategy.selectState("Gujarat");
        profilePageStrategy.selectCity("Surat");



        profilePageStrategy.enterPincode(834001);
        int actualPincode=profilePageStrategy.getPincode();
        System.out.println(actualPincode);
        System.out.println("case 7");

        profilePageStrategy.enterGSTNumber(123456789321L);
        String actualGst=profilePageStrategy.getGst();
        System.out.println(actualGst);
        System.out.println("case 8");


        String actualState =profilePageStrategy.getState();
        System.out.println(actualState);


        String actualCity=profilePageStrategy.getCity();
        System.out.println(actualCity);


        profilePageStrategy.clickSaveChanges();


        myBusinessPageStrategy= MyBusinessPageFactory.getStrategy(this);
        String userNameAtLogo=myBusinessPageStrategy.getUserNameOnBusinessTab().toLowerCase();
        String userCompanyNameAtlLogo=myBusinessPageStrategy.getUserCompanyNameOnBusinessTab().toLowerCase();


        myBusinessPageStrategy.clickProfileLogo();
        profilePageStrategy= ProfilePageFactory.getStrategy(this);
        String ExpectedEnteredName=profilePageStrategy.getEnteredName().toLowerCase();
        String ExpectedCompanyName=profilePageStrategy.getCompananyName().toLowerCase();
        String ExpectedPhone=profilePageStrategy.getPhoneNumber();
        String ExpectedEmailId=profilePageStrategy.getEmailId();
        String ExpectedAddress=profilePageStrategy.getAddress().toLowerCase();
        String ExpectedCity=profilePageStrategy.getCity().toLowerCase();
        String ExpectedState=profilePageStrategy.getState().toLowerCase();
        int ExpectedPincode=profilePageStrategy.getPincode();
        String ExpectedGst=profilePageStrategy.getGst();


        Assert.assertEquals(actualEnteredName,ExpectedEnteredName);
        Assert.assertEquals(actualCompanyName,ExpectedCompanyName);
        Assert.assertEquals(actualPhone,ExpectedPhone);
        Assert.assertEquals(actualEmailId,ExpectedEmailId);
        Assert.assertEquals(actualAddress,ExpectedAddress);
        Assert.assertEquals(actualPincode,ExpectedPincode);
        Assert.assertEquals(actualGst,ExpectedGst);
//        Assert.assertEquals(actualCity,ExpectedCity);
//        Assert.assertEquals(actualState,ExpectedState);
        Assert.assertEquals(actualEnteredName,userNameAtLogo);
        Assert.assertEquals(actualCompanyName,userCompanyNameAtlLogo);



        //case9

    }
}
