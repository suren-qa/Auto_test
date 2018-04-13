package testcases.retialplantest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;


public class Testbase {


Logger log =org.apache.log4j.LogManager.getLogger(Testbase.class.getName());

 WebDriver driver;	

@BeforeSuite
public WebDriver defaultintilization()
{

	BasicConfigurator.configure();
	
 log.info("Method has been intitalized");		
	Properties pro = new Properties();
	
try {
FileInputStream fis = new FileInputStream("C:/Users/FT-User/Cooptex/resources/application.properties");
pro.load(fis);

} catch (FileNotFoundException e) {

log.error("Exception Occured unable to find the path " ,e);
} catch (IOException e) {
// TODO Auto-generated catch block
log.error("Exception Occured unable to load file " ,e);
}		



String Browser = pro.getProperty("BROWSER");
String URL =pro.getProperty("URL");


log.info("Calling the Browser for defined properties");
if (Browser.equals("CHROME"))
{

System.setProperty("webdriver.chrome.driver","C:/Users/FT-User/Desktop/chromedriver.exe");
driver=new ChromeDriver();
log.info("Chrome Browser Invoked");
}
if (Browser.equals("FIREFOX"))

{

System.setProperty("webdriver.gecko.driver","C:/Users/FT-User/Desktop/geckodriver.exe");
driver=new FirefoxDriver();
log.info("firefox");


}


driver.get(URL);
log.info("configured url has been initalized");



return driver;

}
}
