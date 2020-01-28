package com.byblosTestAuto.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.byblosTestAuto.stepdefs.Configuration;

import junit.framework.Assert;

public class BYBPROD10631 {

	
	static Configuration config = Configuration.getInstance();
	

	private static WebDriver driver ;
	
	
	
	

	@FindBy(xpath = "//input[@id='email']")
	static WebElement input_login;

	@FindBy(xpath = "//input[@id='password']")
	static WebElement input_password;

	@FindBy(xpath = "//button[@class='btn btn-primary button-login']")
	static WebElement btn_connect;

	@FindBy(xpath = "//byblos-menu-list//accordion-group[1]//div[1]//div[1]//div[1]//div[1]//div[1]")
	static WebElement btn_fiche;

	@FindBy(xpath = "//img[contains(@class,'nav-item__profile-member-photo')]")
	static WebElement btn_avatar;

	@FindBy(xpath = "//html/body/app-root/div/app-content-layout/app-header/header/div/div/div[6]/div/div/div[1]/ul/perfect-scrollbar/div/div[1]/li[12]/button/img")
	static WebElement btn_deconnexion;

	public BYBPROD10631(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	

	// @When("j'appuie sur le Menu ma fiche RH")
	public void j_appuie_sur_le_Menu_ma_fiche_RH() throws InterruptedException {

			driver.findElement(By.xpath("//button[@class='button-open-menu']")).click();

		Thread.sleep(1000);

		btn_fiche.click();
		Thread.sleep(2000);
	}

	// @Then("redirection vers la rubrique Informations professionnelles")
	public void redirection_vers_la_rubrique_Informations_professionnelles() throws InterruptedException {

		Thread.sleep(1000);
		String Rubique = driver.findElement(By.xpath("//*[@id=\"box-navicon\"]/span/span")).getText();
		Assert.assertEquals("Informations", Rubique);
	}

	// @Then("je navigue entre les differents {string}")
	public void je_navigue_entre_les_differents() throws InterruptedException {

		List<String> expectedResult = new ArrayList<String>();
		expectedResult.add("Contrat");
		expectedResult.add("Fonction");
		expectedResult.add("Rémunération");
		expectedResult.add("Frais");
		expectedResult.add("Matériel");
		
		
		
		for (int j = 1; j <= expectedResult.size(); j++) {

			List<String> actualResult = new ArrayList<String>();

			String myList = driver.findElement(By.xpath(
					"//html[1]/body[1]/app-root[1]/div[1]/app-content-layout[1]/div[1]/app-fiche-rh[1]/div[1]/div[1]/div[1]/app-infos-professionnelles[1]/div[1]/div[1]/ul[1]/li["
							+ j + "]/div[2]/span[1]"))
					.getText();
		
			actualResult.add(myList);

			System.out.println(myList);
			System.out.println(actualResult);
			Thread.sleep(500);

			driver.findElement(By.xpath(
					"//html[1]/body[1]/app-root[1]/div[1]/app-content-layout[1]/div[1]/app-fiche-rh[1]/div[1]/div[1]/div[1]/app-infos-professionnelles[1]/div[1]/div[1]/ul[1]/li[" +j + "]/div[1]/i[1]"))
					.click();
			
			Thread.sleep(1000);
			for (String expected : expectedResult) {
				if (actualResult.contains(expected)) {
					System.out.println("onglet verified");
				} else {
					System.out.println("onglet verification failed");
				}
			}
		}
		
		btn_avatar.click();
		Thread.sleep(1000);
		btn_deconnexion.click();
		driver.close();
	}
	
}








