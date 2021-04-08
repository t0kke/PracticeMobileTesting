package lifecycle;

import com.codeborne.selenide.Configuration;
import driver.MobileDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;
import static helpers.BrowserstackHelper.getBSPublicLink;
import static io.qameta.allure.Allure.step;


public class MobileTestLifeCycleExtension implements BeforeAllCallback, AfterEachCallback, BeforeEachCallback {

	@Override
	public void beforeAll(ExtensionContext context) {
		addListener("AllureSelenide", new AllureSelenide());
		Configuration.browser = MobileDriver.class.getName();
		Configuration.startMaximized = false;
		Configuration.browserSize = null;
		Configuration.timeout = 10000;
	}

	@Override
	public void beforeEach(ExtensionContext context) {
		step("Open application", () -> open());
	}

	@Override
	public void afterEach(ExtensionContext context) {
		String sessionId = getSessionId();

		attachScreenshot("Last screenshot");
		attachPageSource();
		attachAsText("Browserstack build link", getBSPublicLink(sessionId));
		closeWebDriver();
		attachVideo(sessionId);
	}

	public static String getSessionId(){
		return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
	}
}
