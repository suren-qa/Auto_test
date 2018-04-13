package testcases.retialplantest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pageobjects.retialplan.Loginpo;

public class Logintest extends Testbase{

	
	
	
	
	/*Checks The login functionallity*/
	@Test (priority=1)
	public void logintest() throws IOException
	{
	
	Loginpo lp = new Loginpo(driver);
	driver.manage().window().maximize();
	lp.username();
	lp.password();
	lp.login();
    String actual=driver.getTitle();
	assertEquals(actual,"Infotex | Dashboard");
	
	
	

		
	}
	
	
	
}
