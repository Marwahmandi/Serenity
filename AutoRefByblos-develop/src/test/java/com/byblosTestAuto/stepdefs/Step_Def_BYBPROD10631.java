package com.byblosTestAuto.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.byblosTestAuto.pages.BYBPROD10631;
import com.byblosTestAuto.pages.ByBPROD9427_Page;

import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class Step_Def_BYBPROD10631 {

	
		
	
	static Configuration config = Configuration.getInstance();

	
	//WebDriver driver = null;
	
	HookTest hook = new HookTest();
	
	@Given("je me conncete en tant que collaborateur")
	public void je_me_conncete_en_tant_que_collaborateur() throws InterruptedException {

		BYBPROD10631 bYBPROD10631 = new BYBPROD10631(hook.getDriver());

		//bYBPROD10631.je_me_conncete_en_tant_que_collaborateur();
		Thread.sleep(3000);

	}

	@When("j'appuie sur le Menu ma fiche RH")
	public void j_appuie_sur_le_Menu_ma_fiche_RH() throws InterruptedException {

		BYBPROD10631 byBPROD10631 = new BYBPROD10631(hook.getDriver());

		byBPROD10631.j_appuie_sur_le_Menu_ma_fiche_RH();

		Thread.sleep(3000);

	}

	@Then("redirection vers la rubrique Informations professionnelles")
	public void redirection_vers_la_rubrique_Informations_professionnelles() throws InterruptedException {

		BYBPROD10631 byBPROD10631 = new BYBPROD10631(hook.getDriver());

		byBPROD10631.redirection_vers_la_rubrique_Informations_professionnelles();

	}

	@Then("je navigue entre les differents onglets")
	public void je_navigue_entre_les_differents_onglets() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions

		BYBPROD10631 bYBPROD10631 = new BYBPROD10631(hook.getDriver());

		bYBPROD10631.je_navigue_entre_les_differents();
	}

}
