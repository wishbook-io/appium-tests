package com.wishbook.catalog.PageObject.Core;



import com.wishbook.catalog.Execution.Core.BaseTest;
import com.wishbook.catalog.TestCases.TestCase;
import com.wishbook.catalog.TestCases.TestCaseOptions;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Set;


/**
 * Created by wishbook on 9/4/18.
 */
@SuppressWarnings("unused")
public class AndroidHelper {

    //region Permissions
    public static void allowPermission(BaseTest test){
        if(!test.getTestConfiguration().isAutoGrantPermissions()) {
            WebDriver driver = test.getDriver();
            List<WebElement> elements = driver.findElements(By.id(AndroidLocator.PERMISSION_ALLOW));
            if(!elements.isEmpty()){
                elements.get(0).click();
            }
        }
    }
    //endregion

    //region Camera
    public static final String SAMSUNG_SHUTTER_BUTTON = "MENUID_SHUTTER";
    public static final String SAMSUNG_DONE_BUTTON = "com.sec.android.app.camera:id/okay";

    public static final String V1_SHUTTER_BUTTON = "com.android.camera:id/v1_shutter_button_internal";
    public static final String V1_DONE_BUTTON = "com.android.camera:id/v1_btn_done";

    public static final String V2_SHUTTER_BUTTON = "com.android.camera:id/v2_shutter_button_internal";
    public static final String V2_DONE_BUTTON = "com.android.camera:id/v2_btn_done";

    public static final String V3_SHUTTER_BUTTON = "com.android.camera:id/v3_shutter_button_internal";
    public static final String V3_DONE_BUTTON = "com.android.camera:id/v3_btn_done";

    public static final String V4_SHUTTER_BUTTON = "com.android.camera:id/`";
    public static final String V4_DONE_BUTTON = "com.android.camera:id/v4_btn_done";

    public static final String V5_SHUTTER_BUTTON = "com.android.camera:id/v5_shutter_button_internal";
    public static final String V5_DONE_BUTTON = "com.android.camera:id/v5_btn_done";

    public static final String V6_SHUTTER_BUTTON = "com.android.camera:id/v6_shutter_button_internal";
    public static final String V6_DONE_BUTTON = "com.android.camera:id/v6_btn_done";


    private static final HashMap<String,String> cameraShutterButtonIdSaveButtonIdMap;
    static
    {
        cameraShutterButtonIdSaveButtonIdMap =  new HashMap<String, String>();
        cameraShutterButtonIdSaveButtonIdMap.put(SAMSUNG_SHUTTER_BUTTON,SAMSUNG_DONE_BUTTON);
        cameraShutterButtonIdSaveButtonIdMap.put(V1_SHUTTER_BUTTON,V1_DONE_BUTTON);
        cameraShutterButtonIdSaveButtonIdMap.put(V2_SHUTTER_BUTTON,V2_DONE_BUTTON);
        cameraShutterButtonIdSaveButtonIdMap.put(V3_SHUTTER_BUTTON,V3_DONE_BUTTON);
        cameraShutterButtonIdSaveButtonIdMap.put(V4_SHUTTER_BUTTON,V4_DONE_BUTTON);
        cameraShutterButtonIdSaveButtonIdMap.put(V5_SHUTTER_BUTTON,V5_DONE_BUTTON);
        cameraShutterButtonIdSaveButtonIdMap.put(V6_SHUTTER_BUTTON,V6_DONE_BUTTON);
    }
    public static void takePic(AndroidDriver driver){
        boolean picTaken = false;
        List<WebElement> elements = driver.findElements(By.id("net.sourceforge.opencamera:id/take_photo"));
        if(elements!=null && elements.size()>0){
            elements.get(0).click();
            picTaken=true;
        }
        if(!picTaken){
            Set<String> ids = cameraShutterButtonIdSaveButtonIdMap.keySet();
            for(String id:ids){
                boolean shutterButtonClicked = false;
                boolean doneButtonClicked = false;
                String doneButtonId = cameraShutterButtonIdSaveButtonIdMap.get(id);
                List<WebElement> shutterButtons = driver.findElements(By.id(id));
                if(shutterButtons!=null && shutterButtons.size()>0){
                    shutterButtons.get(0).click();
                    shutterButtonClicked=true;
                }
                List<WebElement> doneButtons = driver.findElements(By.id(doneButtonId));
                if(doneButtons!=null && doneButtons.size()>0){
                    doneButtons.get(0).click();
                    doneButtonClicked=true;
                }
                picTaken=shutterButtonClicked&&doneButtonClicked;
                if(picTaken){
                    break;
                }
            }

        }

    }
    //endregion

    //region scroll
    public enum ScrollDirection{
        Up,
        Down
    }
    public static WebElement getScrollableItem(By locator,
                                               ScrollDirection scrollDirection,
                                               int maxIterations,
                                               MobileDriver driver) {
        WebElement element = null;
        int iterations=0;
        do {
            try {
                element = driver.findElement(locator);
            }catch (NoSuchElementException exception){

            }
            if(element==null){
                //if pressX was zero it didn't work for me
                int pressX = driver.manage().window().getSize().width / 2;
                // 4/5 of the screen as the bottom finger-press point
                int bottomY = driver.manage().window().getSize().height * 4 / 5;
                // just non zero point, as it didn't scroll to zero normally
                int topY = driver.manage().window().getSize().height / 8;
                //scroll with TouchAction by itself
                if(scrollDirection==ScrollDirection.Down) {
                    scroll(pressX, bottomY, pressX, topY, driver);
                }else{
                    scroll(pressX, topY, pressX, bottomY, driver);
                }
            }else{
                break;
            }
            iterations++;

        }while(iterations<=maxIterations );
        return element;
    }
    private static void scroll(int fromX, int fromY, int toX, int toY,MobileDriver driver) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(fromX,fromY)).moveTo(PointOption.point(toX,toY)).release().perform();
    }

    public static WebElement getScrollableItemByClassName(AndroidDriver driver, int scrollableInstance, String className, int itemInstance){
        String text = "new UiScrollable(new UiSelector().scrollable(true).instance(%1$d)).scrollIntoView(new UiSelector().className(%2$s).instance(%3$d))";
        String uiAutomatorText = String.format(text,scrollableInstance,className,itemInstance);
        return driver.findElementByAndroidUIAutomator(uiAutomatorText);
    }
    public static WebElement getScrollableItemByResourceId(AndroidDriver driver, int scrollableInstance, String id){
        String text = "new UiScrollable(new UiSelector().scrollable(true).instance(%1$d)).scrollIntoView(new UiSelector().resourceId(\"%2$s\"))";
        String uiAutomatorText = String.format(text,scrollableInstance,id);
        return driver.findElementByAndroidUIAutomator(uiAutomatorText);
    }
    public static WebElement getScrollableItemByText(AndroidDriver driver, String scrollableResourceId, String className, String elementText) {
       String text="new UiScrollable(new UiSelector().resourceId(\"%1$s\")).getChildByText(new UiSelector().className(\"%2$s\"), \"%3$s\")";
       String uiAutomatorText= String.format(text,scrollableResourceId,className,elementText);
       return driver.findElementByAndroidUIAutomator(uiAutomatorText);
    }

    public static WebElement getScrollableItemByResourceIdIndex(AndroidDriver driver, int scrollableInstance, String id, int itemInstance){
        String text = "new UiScrollable(new UiSelector().scrollable(true).instance(%1$d)).scrollIntoView(new UiSelector().resourceId(\"%2$s\").instance(%3$d)))";
        String uiAutomatorText = String.format(text,scrollableInstance,id,itemInstance);
        return driver.findElementByAndroidUIAutomator(uiAutomatorText);
    }



    //endregion


    public static WebElement scrolling(ScrollDirection scrollDirection,
                                       int maxIterations,
                                       MobileDriver driver) {
        WebElement element = null;
        int iterations=0;
        do {
            try {
            }catch (NoSuchElementException exception){

            }
            if(element==null){
                //if pressX was zero it didn't work for me
                int pressX = driver.manage().window().getSize().width / 2;
                // 4/5 of the screen as the bottom finger-press point
                int bottomY = driver.manage().window().getSize().height * 4 / 5;
                // just non zero point, as it didn't scroll to zero normally
                int topY = driver.manage().window().getSize().height / 8;
                //scroll with TouchAction by itself
                if(scrollDirection==ScrollDirection.Down) {
                    scroll(pressX, bottomY, pressX, topY, driver);
                }else{
                    scroll(pressX, topY, pressX, bottomY, driver);
                }
            }else{
                break;
            }
            iterations++;

        }while(iterations<=maxIterations );
        return element;
    }



}
