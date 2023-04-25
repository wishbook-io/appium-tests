package com.wishbook.catalog.PageObject.MyViewersPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MyViewersPageObect extends BasePageObject {

    //region elements
    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.GET_CATALOGNAME_MY_VIEWSER)
    private WebElement catalogNameMyViewer ;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.GET_CATALOGBRAND_NAME_MY_VIEWERS)
    private WebElement brandNameMyViewer;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.GET_BUYER_COMAPANY_MY_VIEWERS)
    private WebElement recentCompanyName;

    //endregion

    //region constructor
    public MyViewersPageObect(TestCase testCase) {
        super(testCase);
    }
    //endregion

    //region Services

    @SuppressWarnings("unused")

    public String getCatatlogNameMyViewer() {
        return catalogNameMyViewer.getText();
    }
    @SuppressWarnings("unused")

    public String getBrandNameMyViewer() {
        return brandNameMyViewer.getText();
    }
    @SuppressWarnings("unused")

    public String getCompanyNameRecentlyViewed() {
        return recentCompanyName.getText();
    }

    //endregion




}
