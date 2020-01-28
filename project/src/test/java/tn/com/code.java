package tn.com;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;




public class code {

	 WebDriver driver;	


	/*
@Test
	@Given("^I want to write a step with precondition$")
	
	public void i_want_to_write_a_step_with_precondition() throws SQLException  {
	    System.setProperty("webdriver.chrome.driver","C://Users//hannachi.ext//Documents//chromedriver//chromedriver.exe");					
   
	    
	    
	    
	    WebDriver driver = new ChromeDriver();					
        		
        String baseUrl = "C:\\Users\\hannachi.ext\\Desktop\\page.html";
        driver.get(baseUrl);
        
   
        WebElement c = driver.findElement(By.xpath("/html/body/table"));
	
		List<WebElement> rows = c.findElements(By.tagName("tr"));
		System.out.println("No of rows are : " + rows.size());
        
		for (int i = 1; i <= rows.size()-1; i++) {
			String x = String.format("/html/body/table/tbody/tr[%s]/td[1]",i);
			String x1 = String.format("/html/body/table/tbody/tr[%s]/td[2]",i);
			String x2 = String.format("/html/body/table/tbody/tr[%s]/td[3]",i);
			String y = String.format("/html/body/table/tbody/tr[%s]",i);
			
		//	String y= String.format("/html/body/table",i);
			
			
			String ligne4=String.format(x2, i);
			 String ligne=driver.findElement(By.xpath(x)).getText();
			 String ligne1=driver.findElement(By.xpath(x1)).getText();
			 String lecture=driver.findElement(By.xpath(y)).getText();
		
		System.out.println("la valeur de la ligne : "+ligne);
		System.out.println(lecture);
			 
		
		if(ligne.contains("François") && ligne1.contains("e")) {
			System.out.println("Test OK");
			
			Assert.assertTrue(false);
		}
			
			{
				System.out.println("Test KO");
			}
		
		}
		}
*/
	
	 
@Step
@Given("^user navigates to facebook$") 
public void goToFacebook() throws InterruptedException, AWTException { 

	String v="aaa";
	Serenity.setSessionVariable("SapOreder").to(v);
		
	System.setProperty("webdriver.chrome.driver","C:\\\\ChromeDriver/chromedriver.exe");	
	driver=new ChromeDriver();

	
	
	
	
   // driver.navigate().to(baseUrl);  
    
    
    
    driver.get("http://demo.guru99.com/test/guru99home/"); 
    // navigates to the page consisting an iframe

    driver.manage().window().maximize();
    Thread.sleep(4000);
    driver.switchTo().frame("a077aa5e"); //switching the frame by ID
	
		System.out.println("********We are switch to the iframe*******");
		Thread.sleep(4000);
		driver.findElement(By.xpath("html/body/a/img")).click();
	    //Clicks the iframe

		System.out.println("*********We are done***************");
    
		 String x=Serenity.sessionVariableCalled("SapOreder");
		   System.out.print(x);  
     	
}


@When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$") 
public void I_enter_Username_as_and_Password_as(String arg1, String arg2) {
	  String api;
   driver.findElement(By.id("email")).sendKeys(arg1);
   driver.findElement(By.id("pass")).sendKeys(arg2);
   driver.findElement(By.id("u_0_v")).click(); 
   
  
 
} 

/*

@Step
@Then("^login should be unsuccessful$") 
public void validateRelogin() { 

   if(driver.getCurrentUrl().equalsIgnoreCase(
   "https://www.facebook.com/login.php?login_attempt=1&lwv=110")){
      System.out.println("Test Pass"); 
   } else { 
      System.out.println("Test Failed"); 
   } 
   driver.close(); 
}    
*/

}
