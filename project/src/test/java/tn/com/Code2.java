package tn.com;

import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Code2 {


	 
	  @When("^I enter invalid data on the page$") 
	   public void enterData(DataTable table){ 
		  List<List<String>> data = table.raw();
		  
		  System.out.println(data.size());
		  System.out.println(data.get(1).get(1)); 
	      System.out.println(data.get(2).get(1)); 
	      System.out.println(data.get(3).get(1)); 
	      System.out.println(data.get(4).get(1));
	      System.out.println(data.get(5).get(1));
	      System.out.println(data.get(6).get(1));
	      System.out.println(data.get(0).get(0));
	  }
	
	
	
	
	
	
	
	
}
