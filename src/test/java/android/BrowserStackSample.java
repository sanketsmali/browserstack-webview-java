package android;

import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserStackSample {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();

		// Set your access credentials
		caps.setCapability("browserstack.user", System.getenv("BROWSERSTACK_USERNAME"));
		caps.setCapability("browserstack.key", System.getenv("BROWSERSTACK_ACCESS_KEY"));

		// Set URL of the application under test
		caps.setCapability("app", "bs://<APP-UD>");

		// Specify device and os_version for testing
		caps.setCapability("device", "Google Pixel 3");
		caps.setCapability("os_version", "9.0");

		// Set other BrowserStack capabilities
		caps.setCapability("project", "First Java Project");
		caps.setCapability("build", "Java Android");
		caps.setCapability("name", "first_test");

		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://hub.browserstack.com/wd/hub"), caps);

		AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.Button")));
		searchElement.click();

		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOf(searchElement));

		Set<String> contextName = driver.getContextHandles();
		System.out.println(contextName);
		for (String contexts : contextName) {
			System.out.println(contexts);
		}

		String SwitchContextName = (String) contextName.toArray()[1];

		driver.context(SwitchContextName);

		WebElement elem = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("q"))));
		driver.findElement(By.name("q"));
		elem.sendKeys("BrowserStack");
		elem.submit();

		driver.quit();

	}

}