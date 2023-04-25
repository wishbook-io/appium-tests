package com.wishbook.catalog.TestCases.AddToCart;

import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageFactory;
import com.wishbook.catalog.PageObject.BottomTabPage.BottomTabPageStrategy;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageFactory;
import com.wishbook.catalog.PageObject.CatalogDetailsPage.CatalogDetailsPageStrategy;
import com.wishbook.catalog.PageObject.HomePage.HomePageFactory;
import com.wishbook.catalog.PageObject.HomePage.HomePageStrategy;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageFactory;
import com.wishbook.catalog.PageObject.MyBusinessPage.MyBusinessPageStrategy;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageFactory;
import com.wishbook.catalog.PageObject.MyCartPage.MyCartPageStrategy;
import com.wishbook.catalog.PageObject.OrderPage.OrderPageFactory;
import com.wishbook.catalog.PageObject.OrderPage.OrderPageStrategy;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageFactory;
import com.wishbook.catalog.PageObject.PopUpPage.PopUpPageStrategy;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseHelper.CatalogSearchHelper;
import com.wishbook.catalog.TestCases.TestCaseHelper.LoginHelper;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import org.testng.Assert;

import java.math.BigDecimal;

public class AddToCart extends TestCase {

    private static final boolean flag = false;
    private  int itemRemovingFromCart=0;
    private int quantity=5;

    @SuppressWarnings("unused")
    public AddToCart(BaseTest test) {
        super(test, new TestCaseOptions(TestCaseOptions.InitialLoginType.LoginAsTestWholeSaler));
    }

    protected void run() {
        BottomTabPageStrategy bottomTabPageStrategy = BottomTabPageFactory.getStrategy(this);
        HomePageStrategy homePageStrategy = HomePageFactory.getStrategy(this);
        OrderPageStrategy orderPageStrategy = OrderPageFactory.getStrategy(this);
        MyBusinessPageStrategy myBusinessPageStrategy = MyBusinessPageFactory.getStrategy(this);

        if(flag) {
           System.out.println("Checking Presence Of Add to Cart Icon wait..");
           Assert.assertFalse(homePageStrategy.isCartIconDisplayed());
           System.out.println("cart icon not displayed");

           bottomTabPageStrategy.clickOrderButton();
           Assert.assertFalse(orderPageStrategy.isCartIconPresent());
           System.out.println("cart icon not displayed");

           bottomTabPageStrategy.clickMyBusiness();
           Assert.assertFalse(myBusinessPageStrategy.isCartIconPresent());
           System.out.println("cart icon not displayed");
           new LoginHelper(this).logout();
           System.out.println("Logout\n\n Login as retailer");
           new LoginHelper(this).loginAsTestWholesaler();
       }

        System.out.println("Checking Presence Of Add to Cart Icon..");
        homePageStrategy = HomePageFactory.getStrategy(this);
        Assert.assertTrue(homePageStrategy.isCartIconDisplayed());
        System.out.println("cart icon displayed");


        bottomTabPageStrategy.clickOrderButton();
        orderPageStrategy = OrderPageFactory.getStrategy(this);
        Assert.assertTrue(orderPageStrategy.isCartIconPresent());
        System.out.println("cart icon displayed");


        bottomTabPageStrategy.clickMyBusiness();
        Assert.assertTrue(myBusinessPageStrategy.isCartIconPresent());
        System.out.println("cart icon displayed");
        bottomTabPageStrategy.clickHomeButton();

        //region searching common catalog ;
        System.out.println("searching common uploaded catalog");
        CatalogSearchHelper searchHelper = new CatalogSearchHelper(this);
        searchHelper.catalogSearchInHomePageSearchButton(getTest().getCommonCatalogName());

        //endregion

        //region Catalog is in Cart ;
        System.out.println("Catalog is in Cart");
        CatalogDetailsPageStrategy catalogDetailsPageStrategy = CatalogDetailsPageFactory.getStrategy(this);
        catalogDetailsPageStrategy.clickAddToCartButton();
        catalogDetailsPageStrategy.clickAddToCartIcon();
        //endregion

        //region in cart varifying catalog in cart
        MyCartPageStrategy myCartPageStrategy = MyCartPageFactory.getStrategy(this);
        String catalogName = myCartPageStrategy.getCatalogNameMyCart().toLowerCase();
        System.out.println("CatalogName = " + catalogName);
//        Assert.assertEquals(getTest().getCommonCatalogName().toLowerCase(), catalogName);

        String fullCatalogText = myCartPageStrategy.getFullCatalogText().toLowerCase();
        System.out.println(fullCatalogText);
        myCartPageStrategy.clickIncreaseCatalogQuantity();
        //endregion

        //region calculation in cart with discount for single product
        float  itemQuantityIntoCart=myCartPageStrategy.getCatalogQuantity();
        System.out.println("Quantity of catalog is = " +itemQuantityIntoCart);
        float catalogPrice=myCartPageStrategy.getCatalogPriceOnMyCart();
        System.out.println("price of catalog before discount = " +catalogPrice);
        float discountPercent= myCartPageStrategy.getDiscountOnMycart();
        System.out.println("discount Percent is = " +discountPercent);
        float discountedAmount= itemQuantityIntoCart*catalogPrice*discountPercent/100;
        float priceAfterDiscount= itemQuantityIntoCart*catalogPrice-discountedAmount;
        float discountedPrice = myCartPageStrategy.getIndividualItemsDiscountedPrice();
        System.out.println("Discount Price is = " + discountedPrice);
        Assert.assertEquals(priceAfterDiscount,discountedPrice);
        float priceAfterGst=myCartPageStrategy.getIndividualItemsDiscountedAfterGstPrice();
        float grandTotalPrice = myCartPageStrategy.getGrandTotalPrice();
        System.out.println("Grand Total Price = " + grandTotalPrice);
        Assert.assertEquals(priceAfterGst, grandTotalPrice);
        int numberOfItems = myCartPageStrategy.getNumberOfItemsAtToolBar();
        int items = myCartPageStrategy.getCatalogQuantity();
        Assert.assertEquals(numberOfItems, items);
        //endregion


        //region calculation in cart with discount after increasing quantity
        if (quantity > 1) {
            for (int i = 0; i < quantity; ++i) {
                myCartPageStrategy = MyCartPageFactory.getStrategy(this);
                myCartPageStrategy.clickIncreaseCatalogQuantity();
            }
        }

        System.out.println("In catalog cart ");
        float  quantityAfterIncreasing=myCartPageStrategy.getCatalogQuantity();
        System.out.println("Quantity of catalog quantityAfterIncreasing = " +quantityAfterIncreasing);
        float catalogPriceAfterIncreasingQuantity=myCartPageStrategy.getCatalogPriceOnMyCart();
        System.out.println("price of catalog before discount quantityAfterIncreasing = " +catalogPriceAfterIncreasingQuantity);
        float discountPercentAfterIncreasingQuantity= myCartPageStrategy.getDiscountOnMycart();
        System.out.println("discount Percent quantityAfterIncreasing = " +discountPercentAfterIncreasingQuantity);
        float discountedAmountAfterIncreasingQuantity= quantityAfterIncreasing*catalogPriceAfterIncreasingQuantity*discountPercentAfterIncreasingQuantity/100;
        float priceAfterDiscountAfterIncreasingQuantity= quantityAfterIncreasing*catalogPriceAfterIncreasingQuantity-discountedAmountAfterIncreasingQuantity;
        float discountedPriceAfterIncreasingQuantity = myCartPageStrategy.getIndividualItemsDiscountedPrice();
        System.out.println("Discount Price quantityAfterIncreasing " + discountedPriceAfterIncreasingQuantity);
        Assert.assertEquals(priceAfterDiscountAfterIncreasingQuantity,discountedPriceAfterIncreasingQuantity);
        float priceAfterGstAfterIncreasingQuantity=myCartPageStrategy.getIndividualItemsDiscountedAfterGstPrice();
        float grandTotalPriceAfterIncreasingQuantity = myCartPageStrategy.getGrandTotalPrice();
        System.out.println("Grand Total Price quantityAfterIncreasing = " + grandTotalPriceAfterIncreasingQuantity);
        Assert.assertEquals(priceAfterGstAfterIncreasingQuantity, grandTotalPriceAfterIncreasingQuantity);
        int numberOfItemsAfterIncreasingQuantity = myCartPageStrategy.getNumberOfItemsAtToolBar();
        int itemsAfterIncreasingQuantity = myCartPageStrategy.getCatalogQuantity();
        Assert.assertEquals(numberOfItemsAfterIncreasingQuantity, itemsAfterIncreasingQuantity);
        System.out.println("out of cart");

        //endregion

        myCartPageStrategy.clickDeleteButton();
        PopUpPageStrategy popUpPageStrategy = PopUpPageFactory.getStrategy(this);
        popUpPageStrategy.clickOnNoRemoveItemFromCart();

        myCartPageStrategy = MyCartPageFactory.getStrategy(this);
        String catalogNameOnCart = myCartPageStrategy.getCatalogNameMyCart().toLowerCase();
        Assert.assertEquals(catalogName, catalogNameOnCart);

        myCartPageStrategy.clickDeleteButton();
        popUpPageStrategy = PopUpPageFactory.getStrategy(this);
        popUpPageStrategy.clickOnYesRemoveItemFromCart();

        myCartPageStrategy = MyCartPageFactory.getStrategy(this);
        String emptyMessage = myCartPageStrategy.getEmptyCart();
        String actualEmptyMessage = "You don't have any item in your Cart!";
        int numberOfItemsAfterRemoving = myCartPageStrategy.getNumberOfItemsAtToolBarAfterRemovingItems();
        Assert.assertEquals(emptyMessage, actualEmptyMessage);
        Assert.assertEquals(numberOfItemsAfterRemoving,itemRemovingFromCart);



    }
}
