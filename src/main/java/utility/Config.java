package utility;

import java.io.File;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Config {

	public static final String baseUrl = "http://172.25.115.76:8080/era/webconsole/";

	public static void browserSetUp() {
		Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.Instance.manage().window().maximize();
		Driver.Instance.navigate().to(Config.baseUrl);
	}

	public static void captureScreenshot(WebDriver driver, String screnshotName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/" + screnshotName + ".png"));
	}

//	public static void explicitWait(WebDriver driver, WebElement webelement) {
//		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(webelement));
//	}
	
//	public static void explicitWaitLoginForm(WebDriver driver, WebElement webelement) {
//		new WebDriverWait(driver, 10).ignoring(NoSuchElementException.class).until(ExpectedConditions.invisibilityOf(webelement));
//	}
	
	public static void waitUntil(WebDriver driver, WebElement webElement) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.attributeToBe(webElement, "title", "Logout"));
	}

//	public static void waitExpl(WebElement webelement) {
//		new FluentWait<WebDriver>(Driver.Instance).withTimeout(Duration.of(10, ChronoUnit.SECONDS)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(webelement));
//	}

}
