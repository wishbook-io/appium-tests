package com.wishbook.catalog.PageObject.ChatPage;

import com.wishbook.catalog.PageObject.Core.AndroidLocator;
import com.wishbook.catalog.PageObject.Core.BasePageObject;
import com.wishbook.catalog.TestCases.TestCase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ChatPageObject extends BasePageObject {

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/txt_resolve")
    private WebElement resloveButton;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = "com.wishbook.catalog:id/conversation_message")
    private  WebElement chatEditorBox;

    @SuppressWarnings("unused")
    @AndroidFindBy(id = AndroidLocator.MY_TOOLBAR)
    private WebElement toolBar;


    public ChatPageObject(TestCase testCase) {
        super(testCase);
    }

    @SuppressWarnings("unused")
    public void clickResolve() {
        resloveButton.click();
    }

    @SuppressWarnings("unused")

    public void BackChatButton() {
        toolBar.findElement(By.className("android.widget.ImageButton")).click();
    }

}
