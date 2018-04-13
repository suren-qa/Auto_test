package pageobjects.retialplan;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.excelutil;



public class Intialplanpo {


	Logger log =org.apache.log4j.LogManager.getLogger(Intialplanpo.class.getName());
    WebDriver driver;
	
	@FindBy(xpath="//span[text()='Operational']")
	WebElement operationmousehover;
	
	
	@FindBy(xpath="//span[text()='Retail Production Plan']")
	WebElement Retailproductionplan ;
	
	@FindBy(xpath=".//*[@id='j_idt259']")
	WebElement Intialplan;
	
	@FindBy(xpath="//*[@id='j_idt597:addButton']")
	WebElement  addbutton;
	
	
	@FindBy(xpath="//*[@id='retailPlan:planName']")
	WebElement Enterplaname;
	
	@FindBy(xpath="//*[@id='retailPlan:regionMenu_label']")
	java.util.List<WebElement> enteregion;
	

	
	@FindBy(xpath="//*[@id='retailPlan:categoryMenu_label']")
	java.util.List<WebElement>  enterproduct;
	
	
	@FindBy(xpath="//*[@id='retailPlan:baseStockPercentage']")
	WebElement enterbase;
	
	@FindBy(xpath="//*[@id='accordion-control-right-group1']/div/div[1]/div[2]/div/div[6]/input[2]")
	WebElement clickgenerat;	
	
    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[2]/a")
    WebElement enterdate; 
	
    @FindBy(xpath="//*[@id='form']/div[2]/div/div[4]/div[1]/div[3]/div[3]/div/div/div/div[2]/div[2]/div[2]/div/input[3]")
	WebElement submit;
	
    
	public Intialplanpo(WebDriver driver)
	{
		this.driver=driver;
        PageFactory.initElements(driver, this);
    	BasicConfigurator.configure();	
    	act = new Actions(driver); 
    	eu =new excelutil();
	}
	
	public excelutil eu;
	public Actions act;
	
	public void Operationalnavigation()
	{
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        log.info("Wait Introduced");  
		act.moveToElement(operationmousehover).click().build().perform();
		log.info(" Performed mouseover operation tab");	
	}
	
public void  OperationalnavigationRetailproductionplan()
	
{

Retailproductionplan.click();
log.info("Clicked Retial menu ");
}


public void  OperationalnavigationIntialplan()
{

Intialplan.click();
log.info(" clicked Intial Plan Menu");
}

public void Operationalnavigationaddbutton()
{
	log.info("Going to click  add button");
addbutton.click();
}

public void planame()
{
	
try {
	String planame =eu.readexcel("Intial",2,1);
	Enterplaname.sendKeys(planame);
	log.info("planame entered");
} catch (IOException e) {

	log.error("Unable to retrivedata for plan name" ,e);
}
}

public void region() throws IOException
{
	String region =eu.readexcel("Intial",2,2);
for (WebElement r:enteregion)
{
	
	if(r.getText().equalsIgnoreCase(region))
	{
		r.click();
}       log.info("clicked region" );
}	
}


public void product() throws IOException
{
	

	String product =eu.readexcel("Intial",2,3);
for (WebElement r:enterproduct)
{
	
	if(r.getText().equalsIgnoreCase(product))
	{
		r.click();
}   log.info("Clicked prodcut");
}	
}

public void baspercent() throws IOException
{
	
String num =eu.readexcel("Intial", 2, 4);
enterbase.sendKeys(num);
log.info("basepercententerd");

}

public void generateplan()
{
	
clickgenerat.click();
log.info("plan generated");

}

public void duedate() throws IOException
{

	String date=eu.readexcel("Intial", 2, 5);
	enterdate.sendKeys(date);

log.info("duedate enterd");


}

public void submitplan()

{
	
submit.click();
log.info("plan submitted");
}

}
