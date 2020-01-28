package com.byblosTestAuto.stepdefs;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.byblosTestAuto.pages.ByBPROD9427_Page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step_Def_ByBPROD9427 {

	static Configuration config = Configuration.getInstance();

	ByBPROD9427_Page bprod9427_Page = new ByBPROD9427_Page();

	WebDriver driver = null;

	HookTest hook = new HookTest();

	WebElement icon_user = null;

	String ICON_USER_XPATH = null;

	WebElement bouton_remplir_cra = null;

	String BOUTON_REMPLIR_CRA_XPATH = null;

	String name = null;

	String username = null;

	String username_xpath = config.getProperty("username_xpath");

	String CLIENT_CRA_XPATH = null;

	String client_cra_ihm = null;

	String MISSION_CRA_XPATH = null;

	String mission_cra_ihm = null;

	String mission_et_client = null;

	@Given("^je suis dans l'espace de \"([^\"]*)\"$")
	public void je_suis_dans_lespace_de(String usernameInFeature) throws Throwable {

		username = usernameInFeature.split("\\s")[0];

		ICON_USER_XPATH = config.getProperty("icon_user_xpath");

		icon_user = hook.getDriver().findElement(By.xpath(ICON_USER_XPATH));

		icon_user.click();

		Thread.sleep(1000);

		name = hook.getDriver().findElement(By.xpath(username_xpath)).getText();

		assertTrue(name.contains(username));

	}

	@When("^j accede à mon CRA du mois courant$")
	public void acceder_cra_mois_courant() throws Throwable {

		Thread.sleep(2000);

		BOUTON_REMPLIR_CRA_XPATH = config.getProperty("bouton_remplir_cra_xpath");

		bouton_remplir_cra = hook.getDriver().findElement(By.xpath(BOUTON_REMPLIR_CRA_XPATH));

		bouton_remplir_cra.click();

		Thread.sleep(6000);

	}

	@Then("^le nom de la mission \"Nom_mission\" avec le client \"Nom_client\" sont affichés$")
	public void Verifier_laffichage_du_nom_mission_et_nom_client() throws Throwable {

		CLIENT_CRA_XPATH = config.getProperty("client_cra_xpath");

		client_cra_ihm = hook.getDriver().findElement(By.xpath(CLIENT_CRA_XPATH)).getText();

		MISSION_CRA_XPATH = config.getProperty("mission_cra_xpath");

		mission_cra_ihm = hook.getDriver().findElement(By.xpath(MISSION_CRA_XPATH)).getText();

		mission_et_client = bprod9427_Page.get_mission_et_client_depuis_BD();

		mission_et_client = mission_et_client.trim();

		mission_cra_ihm = mission_et_client.trim();

		client_cra_ihm = client_cra_ihm.trim();

		assertTrue(mission_et_client.contains(mission_cra_ihm));
		assertTrue(mission_et_client.contains(client_cra_ihm));

		Thread.sleep(3000);
		

	}

	@When("jhzdgfjz")
	public void jhzdgfjz() throws Throwable{
System.out.println("ok");
	}

}
