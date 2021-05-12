package Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
//inheritance
public class login_page_object extends BaseClass {
	//constructor //super
	public login_page_object(WebDriver driver) {
		super(driver);
	}
	
	//Page factory Annotation
	
	@FindBy(how=How.XPATH, using="//input[@id='email']")
	public static WebElement username_button;
	
	@FindBy(how=How.XPATH, using="//input[@id='pass']")
	public static WebElement password_button;
	
	@FindBy(how=How.XPATH, using="//button[normalize-space()='Log In']")
	public static WebElement submit;
	
	@FindBy(how=How.XPATH, using="//div[@aria-label='Create']//i[@class='hu5pjgll lzf7d6o1 sp_rVltL32NiqI_1_5x sx_086df9']")
	public static WebElement Create;
	
	@FindBy(how=How.XPATH, using="//span[normalize-space()='Post']")
	public static WebElement Add_Post;
	
	@FindBy(how=How.XPATH, using="//div[@data-block='true']")
	public static WebElement Post_Data;
	
	
	@FindBy(how=How.XPATH, using="//body/div/div/div/div/div/div/div[@role='dialog']/form[@method='POST']/div/div/div/div/div/div/div/div[@aria-label='Post']/div/div[1]")
	public static WebElement Post_Submit;
}
