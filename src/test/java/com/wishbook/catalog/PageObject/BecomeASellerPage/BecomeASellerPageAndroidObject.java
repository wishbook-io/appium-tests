package com.wishbook.catalog.PageObject.BecomeASellerPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BecomeASellerPageAndroidObject extends BecomeASellerPageObject implements BecomeASellerPageStrategy {
    public BecomeASellerPageAndroidObject(TestCase testCase) {
        super(testCase);
    }



        public void clickCheckBoxProductSizeByText(String Size){
            Size = String.format("//android.widget.CheckBox[@text=\"%1$s\"]", Size);
            AndroidHelper.getScrollableItem(By.xpath(Size),
                    AndroidHelper.ScrollDirection.Down,
                    1, (AndroidDriver) getDriver()).click();

        }
    }

