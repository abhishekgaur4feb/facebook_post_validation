package Page_Object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nonnull;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	static Logger logger = Logger.getLogger("BaseClass");
	public static WebDriver driver;
	 public static boolean bResult;
	 public BaseClass(WebDriver driver){
		 BaseClass.driver = driver;
		 BaseClass.bResult = true;
		 }
	 
	// This method wait till entire DOM gets loaded completely
		public static void waitForContent() {
			ExpectedCondition<Boolean> loaded = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(@Nonnull WebDriver driver) {
					String result = "return ((document.readyState === 'complete') && ($.active == 0))";
					return (Boolean) ((JavascriptExecutor) driver).executeScript(result);
				}
			};
			try {
				new WebDriverWait(BaseClass.driver, 100).until(loaded);
			} catch (WebDriverException e) {
				loaded = new ExpectedCondition<Boolean>() {
					@Override
					public Boolean apply(@Nonnull WebDriver driver) {
						String result = "return ((document.readyState === 'complete'))";
						return (Boolean) ((JavascriptExecutor) driver).executeScript(result);
					}
				};
				new WebDriverWait(BaseClass.driver, 100).until(loaded);
			}
		}

		public static WebElement getElement(WebElement element) {
			WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 50).ignoring(StaleElementReferenceException.class);
			waitForContent();
			wait.until(ExpectedConditions.visibilityOf(element));
			WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
			return ele;
		}

		// This method gives random number
		static Random randNum = new Random();
		static Set<Integer> jobSet = new LinkedHashSet<Integer>();
		static List<Integer> list = new ArrayList<Integer>();

		public static int getRandomNumber(int maxRange) {

			while (jobSet.size() < maxRange) {
				jobSet.add(randNum.nextInt(maxRange) + 1);

			}
			// Generic function to convert set to list
			list.addAll(jobSet);

			Collections.shuffle(list);
			int randomNo = list.stream().findAny().get();
			return randomNo;
		}

		// This method to be used for the element which frequently gets changed in DOM
		// and gives StaleElementReferenceException
		public static boolean retryingClick(WebElement ele) {
			boolean result = false;
			int attempts = 0;
			while (attempts < 20) {
				try {
					waitForContent();
					retryingFindElement(ele);
					ele.click();
					result = true;
					break;
				} catch (NoSuchElementException e) {

					logger.info("Refinding the element as its throwing NoSuchElementException");

				} catch (ElementClickInterceptedException e) {

					logger.info("Refinding the element as its throwing ElementClickInterceptedException");

				} catch (StaleElementReferenceException e) {

					logger.info("Refinding the element as its throwing StaleElementReferenceException");

				} catch (TimeoutException e) {

					logger.info("Refinding the element as its throwing TimeoutException");

				} catch (Exception e) {

					logger.info("Refinding the element as its throwing exception");
				}
				waitForContent();
				attempts++;
			}
			return result;
		}

		// This method to be used for the element which frequently gets changed in DOM
		// and gives NoSuchElementException
		public static boolean retryingFindElement(WebElement ele) {
			boolean result = false;
			int attempts = 0;
			while (attempts < 20) {
				try {
					waitForContent();
					ele.isDisplayed();
					result = true;
					break;
				} catch (NoSuchElementException e) {

					logger.info("Refinding the element as its throwing NoSuchElementException");

				} catch (ElementClickInterceptedException e) {

					logger.info("Refinding the element as its throwing ElementClickInterceptedException");

				} catch (StaleElementReferenceException e) {

					logger.info("Refinding the element as its throwing StaleElementReferenceException");

				} catch (TimeoutException e) {

					logger.info("Refinding the element as its throwing TimeoutException");

				} catch (Exception e) {

					logger.info("Refinding the element as its throwing exception");
				}
				waitForContent();
				attempts++;
			}
			return result;
		}

		public static void dragAndDrop(WebElement fromElement, WebElement toElement) {

			Actions action = new Actions(BaseClass.driver);
			action.dragAndDrop(fromElement, toElement).build().perform();
			waitForContent();
		}

		public static boolean waitForAlert() {
			boolean result = false;
			int i = 0;
			while (i++ < 5) {
				try {
					Alert alert = BaseClass.driver.switchTo().alert();
					result = true;
					break;
				} catch (NoAlertPresentException e) {
					WebDriverWait wait = new WebDriverWait(BaseClass.driver, 20);
					wait.until(ExpectedConditions.alertIsPresent());
					continue;
				}
			}
			return result;
		}

	 
}
