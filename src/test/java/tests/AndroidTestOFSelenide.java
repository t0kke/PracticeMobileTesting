package tests;

import io.appium.java_client.MobileBy;
import lifecycle.MobileTestLifeCycleExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;

@ExtendWith(MobileTestLifeCycleExtension.class)
public class AndroidTestOFSelenide {
	@Test
	void searchByName() {
		step("Type search", () -> {
			$(AccessibilityId("Search Wikipedia")).click();
			$(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
		});
		step("Verify content found", () ->
				$$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
						.shouldHave(sizeGreaterThan(0)));
	}
}
