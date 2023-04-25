# Appium tests

Contains automation test suite for the Wishbook mobile app. While this has been exhaustively tested on Android version, an attempt has been made to use the same names for selectors in the ReactNative version too - hence it should work there too.

## Files to change:
1. src/test/java/com/wishbook/catalog/ExcelData/AppiumInput.xlsx - has the test credentials for the different types of users. This file needs to be updated by the users created on the version of the app being tested.
2. src/test/java/com/wishbook/catalog/PageObject/FilterPage/FilterPageObject.java - has the selectors for the filter page. This file needs to be updated if the filter page is changed.
3. testNg.xml, src/test/java/com/wishbook/catalog/Execution/Core/TestConfiguration.java - ie the definition of appiumServerURL. The app is assumed to be running on the localhost via a connected device. The appium server is assumed to be running on port 4723.
