package driver;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriver implements WebDriverProvider {

	@Override
	public WebDriver createDriver(DesiredCapabilities capabilities) {
		capabilities.setCapability("browserstack.user", ConfigHelper.getBrowserstackUser());
		capabilities.setCapability("browserstack.key", ConfigHelper.getBrowserstackKey());
		capabilities.setCapability("app", ConfigHelper.getBrowserstackAppUrl());
		capabilities.setCapability("device", "Google Pixel 3");
		capabilities.setCapability("os_version", "9.0");
		capabilities.setCapability("project", "First Java Project");
		capabilities.setCapability("build", "Java Android");
		capabilities.setCapability("name", "first_test");

		return new AndroidDriver(getBrowserstackUrl(), capabilities);
	}

	public static URL getBrowserstackUrl() {
		try {
			return new URL("http://hub.browserstack.com/wd/hub");
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
}
