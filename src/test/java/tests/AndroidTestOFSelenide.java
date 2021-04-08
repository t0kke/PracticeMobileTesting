package tests;

import io.appium.java_client.MobileBy;
import lifecycle.MobileTestLifeCycleExtension;
import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("Проверка поиска по наименованию")
	void searchByName() {
		step("Тапнуть по полю поиска и ввести 'BrowserStack'", () -> {
			$(AccessibilityId("Search Wikipedia")).click();
			$(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
		});
		step("Проверить результаты поиска, что он не равен 0", () ->
				$$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
						.shouldHave(sizeGreaterThan(0)));
	}
}
