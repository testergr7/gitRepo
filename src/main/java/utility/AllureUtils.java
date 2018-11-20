package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;



public final class AllureUtils {
	private AllureUtils() {
	}

	@Attachment(value = "{0}", type = "image/png")
	public static synchronized byte[] makeScreenshot(WebDriver driver) {
		return TakesScreenshot.class.cast(driver).getScreenshotAs(OutputType.BYTES);
	}
}