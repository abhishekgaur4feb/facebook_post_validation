package Step_Defination;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Page_Object.login_page_object;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Facebook_post_step_Defination {
	Logger logger = Logger.getLogger("login_step_Defination");
	public WebDriver driver;
	
	
	@Given("^User provides the facebook Application Url$")
	public void user_provides_the_facebook_Application_Url() throws Throwable {
		driver = Hooks.driver;
	}

	@When("^User pass the Username as \"([^\"]*)\" and Password as \"([^\"]*)\" and cliks on submit button$")
	public void user_pass_the_Username_as_and_Password_as_and_cliks_on_submit_button(String username, String password) throws Throwable {
		 //Initilization
		PageFactory.initElements(driver, login_page_object.class);
		
		WebDriverWait wait2 = new WebDriverWait(driver, 50);
		WebElement element2 = wait2.until(ExpectedConditions.visibilityOf(login_page_object.username_button));
		Thread.sleep(1000);
		element2.sendKeys(username);
		
		WebDriverWait wait3 = new WebDriverWait(driver, 50);
		WebElement element3 = wait3.until(ExpectedConditions.visibilityOf(login_page_object.password_button));
		Thread.sleep(1000);
		element3.sendKeys(password);
		
		WebDriverWait wait4 = new WebDriverWait(driver, 50);
		WebElement element4 = wait4.until(ExpectedConditions.visibilityOf(login_page_object.submit));
		Thread.sleep(1000);
		element4.click();
	}

	@Then("^User should be able to see the facebook dashboard$")
	public void user_should_be_able_to_see_the_facebook_dashboard() throws Throwable {
		String Get_Url=driver.getCurrentUrl();
		System.out.println("Current Url -->"+Get_Url);
		
		
/*		try {
			Assert.assertEquals("https://www.facebook.com/login", Get_Url);
			logger.info("Assertion Passed");
			logger.info("User able to view the dashboard");
		} catch (AssertionError e) {
			logger.info("Assertion Failed");
			logger.info("Incorrect Username Password passed");
			throw e;

		}*/
	}


	@Then("^User click on create New post button$")
	public void user_click_on_create_New_post_button() throws Throwable {
	

		
		WebDriverWait wait5 = new WebDriverWait(driver, 100);
		WebElement element5= wait5.until(ExpectedConditions.visibilityOf(login_page_object.Create));
		Thread.sleep(1000);
		element5.click();
		
		WebDriverWait wait6 = new WebDriverWait(driver, 50);
		WebElement element6 = wait6.until(ExpectedConditions.visibilityOf(login_page_object.Add_Post));
		Thread.sleep(1000);
		element6.click();
	}

	@When("^User sends \"([^\"]*)\" notification it should be published$")
	public void user_sends_post_notification_it_should_be_published(String post) throws Throwable {
		WebDriverWait wait7 = new WebDriverWait(driver, 90);
		WebElement element7 = wait7.until(ExpectedConditions.visibilityOf(login_page_object.Post_Data));
		Thread.sleep(1000);
		element7.sendKeys(post);
		
		
		WebDriverWait wait8 = new WebDriverWait(driver, 50);
		WebElement element8 = wait8.until(ExpectedConditions.visibilityOf(login_page_object.Post_Submit));
		Thread.sleep(1000);
		element8.click();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
		
	}
		
}
