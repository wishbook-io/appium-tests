package com.wishbook.catalog.PageObject.CameraPage;

import com.wishbook.catalog.PageObject.Core.AndroidHelper;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;

import io.appium.java_client.android.AndroidDriver;

public class CameraPageAndroidObject extends BasePageObject implements CameraPageStrategy {
    public CameraPageAndroidObject(TestCase testCase) {
        super(testCase);
    }

    public void takePic() {
        AndroidHelper.takePic((AndroidDriver) getDriver());
    }

}
