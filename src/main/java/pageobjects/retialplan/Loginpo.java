package pageobjects.retialplan;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.excelutil;

public class Loginpo {
	
	
	Logger log =org.apache.log4j.LogManager.getLogger(Loginpo.class.getName());
    WebDriver driver;
    
    
    
  
    @FindBy(xpath="//*[@id='form:username']")
    WebElement username;
    
    
    @FindBy(xpath="//*[@id='form:password']")
    WebElement password;
    
	
	@FindBy(css="span.ui-button-text.ui-c")
	WebElement Loginbutton;
	
	
	
	public Loginpo(WebDriver driver)
	{
		this.driver=driver;
        PageFactory.initElements(driver, this);
    	BasicConfigurator.configure();	
    	act = new Actions(driver); 
    	 eu =new excelutil();
	}
	
	
	public Actions act;
	
	public excelutil eu;
	
	public void username() throws IOException
	{
		
		String user =eu.readexcel("Credentials", 1,0);
		username.sendKeys(user);
		log.info("Username has been Entered");
	}
	
	
	
	public void password() throws IOException
            
	{
		String pass=eu.readexcel("Credentials", 1,1 );
		password.sendKeys(pass);
		log.info("Password has been entered");
	}
	
	
	public void login()
	{
		
		Loginbutton.click();
	log.info("Login Button has been clicked");
	
	}
	
	
}
