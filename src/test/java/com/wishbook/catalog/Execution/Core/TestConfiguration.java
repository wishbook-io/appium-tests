package com.wishbook.catalog.Execution.Core;

import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
/**
 * Created by wishbook on 9/4/18.
 */
@SuppressWarnings("unused")
public class TestConfiguration {

    //region constants
    public static final String APPIUM_VALUE_TRUE = "true";
    public static final String APPIUM_VALUE_FALSE = "false";
    public static final String APPIUM_KEY_DEVICE_NAME = "deviceName";
    public static final String APPIUM_VALUE_ANDROID_EMULATOR="Android Emulator";
    public static final String APPIUM_KEY_BROWSER_NAME="browserName";
    public static final String APPIUM_VALUE_ANDROID="Android";
    public static final String APPIUM_VALUE_ANDROID_CHROME="Chrome";
    public static final String APPIUM_KEY_PLATFORM_VERSION="platformVersion";
    public static final String APPIUM_KEY_ANDROID_VERSION_8_0="8.0";
    public static final String APPIUM_KEY_ANDROID_VERSION_7_0 = "7.0";
    public static final String APPIUM_KEY_ANDROID_VERSION_6_0 = "6.0";
    public static final String APPIUM_KEY_ANDROID_VERSION_4_4_4 = "4.4.4";
    public static final String APPIUM_KEY_ANDROID_VERSION_5_1_1 = "5.1.1";
    public static final String APPIUM_KEY_PLATFORM_NAME="platformName";
    public static final String APPIUM_VALUE_PLATFORM_NAME_ANDROID="Android";
    public static final String APPIUM_KEY_APP_PACKAGE="appPackage";
    public static final String APPIUM_VALUE_APP_PACKAGE = "com.wishbook.catalog";
    public static final String APPIUM_KEY_AUTOMATION_NAME="automationName";
    public static final String APPIUM_VALUE_APPIUM ="Appium";
    public static final String APPIUM_VALUE_UIAUTOMATOR2="UIAutomator2";
    public static final String APPIUM_KEY_GPS_ENABLED = "gpsEnabled";
    public static final String APPIUM_KEY_APP_ACTIVITY="appActivity";
    public static final String APPIUM_VALUE_SPLASH_SCREEN_ACTIVITY="com.wishbook.catalog.SplashScreen";
    public static final String APPIUM_KEY_AUTO_GRANT_PERMISSIONS="autoGrantPermissions";
    public static final String APPIUM_KEY_PRINT_PAGE_SOURCE="printPageSourceOnFindFailure";
    public static final String APPIUM_KEY_UNICODE_KEYBOARD="unicodeKeyboard";
    public static final String APPIUM_KEY_RESET_KEYBOARD="resetKeyboard";
    public static final String APPIUM_KEY_UDID="udid";
    public static final String APPIUM_KEY_SYSTEMPORT="systemPort";
    public static final String APPIUM_KEY_APP="app";
    public static final String APPIUM_KEY_SERVER_URL="appiumServerUrl";
    public static final String APPIUM_KEY_DEVELOPMENT_FRAMEWORK="developmentFramework";
    public static final String APPIUM_KEY_SERVER_TYPE="serverType";
    //endregion

    private final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    public enum BuildType {
        PRODUCTION,
        STAGING
    }
    private BuildType buildType;
    private String appiumServerUrl = "http://127.0.0.1:4723/wd/hub";
    public enum DevelopmentFramework{
        NativeAndroid,
        ReactNative
    }
    public enum ServerType{
        Production,
        Staging
    }

    private DevelopmentFramework developmentFramework=DevelopmentFramework.NativeAndroid;
    private ServerType serverType = ServerType.Staging;

    //region set
    public void setDeviceName(String deviceName){
        desiredCapabilities.setCapability(APPIUM_KEY_DEVICE_NAME,deviceName);
    }
    public void setBrowserName(String browserName){
        desiredCapabilities.setCapability(APPIUM_KEY_BROWSER_NAME,browserName);
    }
    public void setPlatformVersion(String platformVersion){
       desiredCapabilities.setCapability(APPIUM_KEY_PLATFORM_VERSION,platformVersion);
    }
    public void setPlatformName(String platformName){
        desiredCapabilities.setCapability(APPIUM_KEY_PLATFORM_NAME,platformName);
    }
    public void setAppPackageName(String appPackageName){
      desiredCapabilities.setCapability(APPIUM_KEY_APP_PACKAGE,appPackageName);
    }
    public void setAutomationName(String automationName){
        desiredCapabilities.setCapability(APPIUM_KEY_AUTOMATION_NAME,automationName);
    }
    public void setAppActivity(String appActivity){
        desiredCapabilities.setCapability(APPIUM_KEY_APP_ACTIVITY,appActivity);
    }
    public void setAutoGrantPermissions(boolean autoGrantPermissions){
        desiredCapabilities.setCapability(APPIUM_KEY_AUTO_GRANT_PERMISSIONS,Boolean.toString(autoGrantPermissions));
    }
    public void setPrintPageSourceOnFindFailure(boolean printPageSourceOnFindFailure){
        desiredCapabilities.setCapability(APPIUM_KEY_PRINT_PAGE_SOURCE,Boolean.toString(printPageSourceOnFindFailure));
    }

    public void setBuildType(BuildType buildType){
        this.buildType = buildType;
    }

    public void setGpsEnabled(boolean value){
        desiredCapabilities.setCapability(APPIUM_KEY_GPS_ENABLED,Boolean.toString(value));
    }
    public void setUnicodeKeyboard(boolean value){
        desiredCapabilities.setCapability(APPIUM_KEY_UNICODE_KEYBOARD,Boolean.toString(value));
    }
    public void setResetKeyboard(boolean value) {
        desiredCapabilities.setCapability(APPIUM_KEY_RESET_KEYBOARD,Boolean.toString(value));
    }
    public void setUDID(String udid){
        desiredCapabilities.setCapability(APPIUM_KEY_UDID,udid);
    }
    public void setSystemPort(int systemPort){
        desiredCapabilities.setCapability(APPIUM_KEY_SYSTEMPORT,Integer.toString(systemPort));
    }
    public void setAppiumApp(String value) {
        desiredCapabilities.setCapability(APPIUM_KEY_APP,value);
    }
    public void setAppiumServerUrl(String value){
        appiumServerUrl=value;
    }
    public void setDevelopmentFramework(DevelopmentFramework developmentFramework) {
        this.developmentFramework = developmentFramework;
    }
    public void setServerType(ServerType serverType){
        this.serverType = serverType;
    }
    //endregion

    //region get
    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

    public BuildType getBuildType() {
        return buildType;
    }

    public DevelopmentFramework getDevelopmentFramework() {
        return developmentFramework;
    }

    public String getDeviceName(){
        return (String)desiredCapabilities.getCapability(APPIUM_KEY_DEVICE_NAME);
    }
    public String getBrowserName() {
        return (String)desiredCapabilities.getCapability(APPIUM_KEY_BROWSER_NAME);
    }
    public String getPlatformVersion() {
        return (String)desiredCapabilities.getCapability(APPIUM_KEY_PLATFORM_VERSION);
    }
    public String getPlatformName() {
        return (String)desiredCapabilities.getCapability(APPIUM_KEY_PLATFORM_NAME);
    }
    public boolean isAndroid(){
        return APPIUM_VALUE_ANDROID.equals(getPlatformName());
    }
    public boolean isChrome(){
        return APPIUM_VALUE_ANDROID_CHROME.equals(getBrowserName());
    }
    public String getAppPackageName() {
        return (String)desiredCapabilities.getCapability(APPIUM_KEY_APP_PACKAGE);
    }
    public String getAutomationName() {
        return (String)desiredCapabilities.getCapability(APPIUM_KEY_AUTOMATION_NAME);
    }
    public String getAppActivity() {
        return (String)desiredCapabilities.getCapability(APPIUM_KEY_APP_ACTIVITY);
    }
    public boolean isAutoGrantPermissions() {
        return Boolean.valueOf((String)desiredCapabilities.getCapability(APPIUM_KEY_AUTO_GRANT_PERMISSIONS));
    }

    public boolean isPrintPageSource() {
        return Boolean.valueOf((String)desiredCapabilities.getCapability(APPIUM_KEY_PRINT_PAGE_SOURCE));
    }
    public String getAppiumApp () {
        return (String)desiredCapabilities.getCapability(APPIUM_KEY_APP);
    }
    public String getAppiumServerUrl(){
        return appiumServerUrl;
    }
    public ServerType getServerType(){
        return serverType;
    }
    //endregion
    
    public static TestConfiguration getConfigFromJson(String json) throws Exception
    {
        JSONObject jsonObject = new JSONObject(json);
    	TestConfiguration testConfiguration = new TestConfiguration();
    	if(jsonObject.has(APPIUM_KEY_DEVICE_NAME)) {
    		testConfiguration.setDeviceName(jsonObject.getString(APPIUM_KEY_DEVICE_NAME));
    	} 
    	if(jsonObject.has(APPIUM_KEY_BROWSER_NAME)) {
    		testConfiguration.setBrowserName(jsonObject.getString(APPIUM_KEY_BROWSER_NAME));
    	}
    	if(jsonObject.has(APPIUM_KEY_PLATFORM_VERSION)) {
    		testConfiguration.setPlatformVersion(jsonObject.getString(APPIUM_KEY_PLATFORM_VERSION));
    	}
    	if(jsonObject.has(APPIUM_KEY_PLATFORM_NAME)) {
    		testConfiguration.setPlatformName(jsonObject.getString(APPIUM_KEY_PLATFORM_NAME));
    	}
    	if(jsonObject.has(APPIUM_KEY_APP_PACKAGE)) {
    		testConfiguration.setAppPackageName(jsonObject.getString(APPIUM_KEY_APP_PACKAGE));
    	}
    	if(jsonObject.has(APPIUM_KEY_AUTOMATION_NAME)) {
    		testConfiguration.setAutomationName(jsonObject.getString(APPIUM_KEY_AUTOMATION_NAME));
    	}
    	if(jsonObject.has(APPIUM_KEY_APP_ACTIVITY)) {
    		testConfiguration.setAppActivity(jsonObject.getString(APPIUM_KEY_APP_ACTIVITY));
    	}
    	if(jsonObject.has(APPIUM_KEY_AUTO_GRANT_PERMISSIONS)) {
    		testConfiguration.setAutoGrantPermissions(jsonObject.getBoolean(APPIUM_KEY_AUTO_GRANT_PERMISSIONS));
    	}
      	if(jsonObject.has(APPIUM_KEY_PRINT_PAGE_SOURCE)) {
    		testConfiguration.setPrintPageSourceOnFindFailure(jsonObject.getBoolean(APPIUM_KEY_PRINT_PAGE_SOURCE));
      	}
      	if(jsonObject.has(APPIUM_KEY_GPS_ENABLED)) {
    		testConfiguration.setGpsEnabled(jsonObject.getBoolean(APPIUM_KEY_GPS_ENABLED));
      	}
    	if(jsonObject.has(APPIUM_KEY_RESET_KEYBOARD)) {
    		testConfiguration.setResetKeyboard(jsonObject.getBoolean(APPIUM_KEY_RESET_KEYBOARD));
      	}
      	if(jsonObject.has(APPIUM_KEY_UNICODE_KEYBOARD)) {
    	    testConfiguration.setUnicodeKeyboard(jsonObject.getBoolean(APPIUM_KEY_UNICODE_KEYBOARD));
        }
      	if(jsonObject.has(APPIUM_KEY_UDID)){
    	    testConfiguration.setUDID(jsonObject.getString(APPIUM_KEY_UDID));
        }
        if(jsonObject.has(APPIUM_KEY_SYSTEMPORT)){
            testConfiguration.setSystemPort(jsonObject.getInt(APPIUM_KEY_SYSTEMPORT));
        }
        if(jsonObject.has(APPIUM_KEY_APP)){
    	    testConfiguration.setAppiumApp(jsonObject.getString(APPIUM_KEY_APP));
        }
        if(jsonObject.has(APPIUM_KEY_SERVER_URL)){
    	    testConfiguration.setAppiumServerUrl(jsonObject.getString(APPIUM_KEY_SERVER_URL));
        }
        if(jsonObject.has(APPIUM_KEY_DEVELOPMENT_FRAMEWORK)){
    	    String framework = jsonObject.getString(APPIUM_KEY_DEVELOPMENT_FRAMEWORK);
    	    try{
    	        testConfiguration.setDevelopmentFramework(DevelopmentFramework.valueOf(framework));
            }catch (Exception e){
    	        System.out.println("Please provide valid value for developmentFramework property in testNg.xml file");
    	        throw e;
            }
        }
        if(jsonObject.has(APPIUM_KEY_SERVER_TYPE)){
    	    String serverType = jsonObject.getString(APPIUM_KEY_SERVER_TYPE);
    	    try{
                testConfiguration.setServerType(ServerType.valueOf(serverType));
            }catch (Exception e){
                System.out.println("Invalid server type");
                throw e;
            }
        }
    	return testConfiguration;
    }


}
