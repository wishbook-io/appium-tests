package com.wishbook.catalog.PageObject.CatalogDetailsPage;

import com.wishbook.catalog.Execution.Core.TestConfiguration;
import com.wishbook.catalog.PageObject.HomePage.HomePageAndroidObject;
import com.wishbook.catalog.PageObject.HomePage.HomePageReactNativeObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class CatalogDetailsPageFactory {
  public static CatalogDetailsPageStrategy getStrategy(TestCase testCase) {
        CatalogDetailsPageStrategy strategy = null;
      TestConfiguration.DevelopmentFramework framework = testCase.getTest().getTestConfiguration().getDevelopmentFramework();
      switch (framework){
          case ReactNative:strategy= new CatalogDetailsReactNativeObject(testCase);
              break;
          case NativeAndroid:strategy=new CatalogDetailsPageAndroidObject(testCase);
              break;
      }
      return strategy;
  }
}
