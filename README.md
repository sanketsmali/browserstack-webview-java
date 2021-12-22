# BrowserStack WebView Java [Android]

This repository demonstrates to switch from Native to WebView  on BrowserStack App Automate.

One of the most common use case in native mobile apps development is sending and receiving data from WebView to native and vice versa. Many mobile applications have common features like login with third party vendor in which, native layer should interact with embedded webview. Or payment gateways which sends back success/failure/token etc to native to proceed. Which ever the scenario , interaction between native layer and webview is essential. The context switching is demonstrated in this reposotiry

Setup:
- Clone the repo
- Update the BrowserStackSample file with your BROWSERSTACK_USERNAME, BROWSERSTACK_ACCESS_KEY and App URL 

Running the test:

To run the test, 

  ```mvn test -P android-first-test  ```

Viewing the results:
Go to your App Automate dashboard to view the results.


Reference: 
- https://medium.com/@sreeharikv112/communication-from-webview-to-native-ios-android-app-6d842cefe02d

