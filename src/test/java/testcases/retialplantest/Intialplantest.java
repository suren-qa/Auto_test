package testcases.retialplantest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Utilities.excelutil;
import pageobjects.retialplan.Intialplanpo;

public class Intialplantest extends Logintest {

	
	
	
	
	@Test (priority=2)
	public void intialnavi() throws IOException
	{
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Intialplanpo ip =new Intialplanpo(driver);
		
	    ip.Operationalnavigation();
        ip.OperationalnavigationRetailproductionplan();
        ip.OperationalnavigationIntialplan();
        ip.Operationalnavigationaddbutton();
        ip.planame();
        ip.region();
        ip.product();
        ip.baspercent();
        ip.generateplan();
        
	
		
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
