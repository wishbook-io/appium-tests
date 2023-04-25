package com.wishbook.catalog.PageObject.SelectSizeQuantityPage;


import com.wishbook.catalog.TestCases.TestCase;

public class  SelectSizeQuantityPageFactory {
    public static  SelectSizeQuantityPageStrategy getStrategy(TestCase testCase) {
         SelectSizeQuantityPageStrategy strategy = null;
        if (testCase.getTest().getTestConfiguration().isAndroid()) {
            strategy = new  SelectSizeQuantityPageAndroidObject(testCase);
        }
        return strategy;
    }
}