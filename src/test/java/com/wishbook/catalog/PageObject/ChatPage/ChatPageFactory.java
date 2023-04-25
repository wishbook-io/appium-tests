package com.wishbook.catalog.PageObject.ChatPage;

import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.android.AndroidDriver;

public class ChatPageFactory {

    public static ChatPageStrategy getStrategy(TestCase testCase) {
        ChatPageStrategy strategy = null;
        if (testCase.getTest().getDriver() instanceof AndroidDriver) {
            strategy = new ChatPageAndroidObject(testCase);
        }
        return strategy;
    }
}

