package com.wishbook.catalog.PageObject.BottomTabPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.TestCases.TestCase;

public class BottomTabPageAndroidObject extends BottomTabPageObject implements BottomTabPageStrategy {
    public BottomTabPageAndroidObject(TestCase testCase) {
        super(testCase);
        AndroidHelper.allowPermission(testCase.getTest());
        AndroidHelper.allowPermission(testCase.getTest());
    }
}
