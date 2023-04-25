package com.wishbook.catalog.PageObject.WishbookRewardPoints;

import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishbookRewardPointsObject extends BasePageObject {


    //region element
    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_total_earn")
    private WebElement totalRemainingRewardPoints;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private WebElement backButton;
    //endregion


    //region constructor
    public WishbookRewardPointsObject(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region services

     public float getTotalRewardPoints(){
        return Float.parseFloat(totalRemainingRewardPoints.getText());
     }

     public void clickBackButton(){
        backButton.click();
     }



    //endregion

}
