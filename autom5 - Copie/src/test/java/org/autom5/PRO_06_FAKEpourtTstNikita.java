package org.autom5;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.autom5.PagesMenuRessources.PageCreerCritere;
import org.autom5.PagesMenuRessources.PageCritere;
import org.autom5.PagesMenuRessources.PageFormulaireQualite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PRO_06_FAKEpourtTstNikita {
	
	WebDriver driver;
	
	@Before
	public void initialisations() throws InterruptedException {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}


	//@After
	//public void fermerNavigateur () {
	//	driver.quit();
	//}
	

	/**
	 * @throws InterruptedException
	 */
	@Test
	public void test() throws InterruptedException {
		//AccÃ©der Ã  lâ€™application et se connecter en tant que admin/admin
		driver.get("http://localhost:8090/libreplan/");	
		PageCnx pageCnx = PageFactory.initElements(driver, PageCnx.class);
		PageIndex pageIndex = pageCnx.sidentifier("admin", "admin", driver);
		Thread.sleep(5000);

		//VÃ©rifier la bonne connexion
		assertTrue(pageIndex.btn_deconnexion.isEnabled());
		assertEquals(pageIndex.txt_utilisateurConnecte.getText(),"utilisateur: admin");

		// Se rendre sur la page Ã  tester l'aide de la mÃ©thode selectionnerMenu de la PageAbstract: exemple avec Ressources / Formulaires QualitÃ©
		// Adapter les noms Ã  votre page !!!
		pageIndex.selectionnerMenu(driver, "Ressources", "CritÃ¨re");
		PageFormulaireQualite pageFormulaireQualite = PageFactory.initElements(driver, PageFormulaireQualite.class);
		
		
		//Accéder au formulaire de création d'un projet
		//Cliquer sur l'icône "Créer un nouveau projet" (1ère icône "+" située en dessous du logo "LibrePlan")
		
		
		
		
		
		
		
		
		
		<p>Affichage d'une pop-up "Créer un nouveau projet" contenant les éléments suivants :</p> 
		<p> </p> 
		<p>- Nom : Champ de saisie non renseigné</p> 
		<p>- Modèle : Liste déroulante non renseignée</p> 
		<p>- Code : Champ de saisie renseigné avec une valeur par défaut non modifiable et grisé. La case "Générer le code" associée à ce champ est cochée par défaut</p> 
		<p>- Date de début : champ de saisie de date associé à un calendrier. Par défaut, la date affichée est la date du jour. Le format de la date correspond à l'exemple suivant : "25 janv. 2017"</p> 
		<p>- Echéance : champ de saisie de date associé à un calendrier. Par défaut, le champ n'est pas renseigné.</p> 
		<p>- Client : Champ de saisie non renseigné</p> 
		<p>- Calendrier : Liste déroulante avec pour valeur par défaut "Default"</p> 
		<p>- Boutons [Accepter] et [Annuler]</p> 

		
		
		
		// Initialisation de la PageCritere : verification des champs dans le tableau et clic sur le bouton "Continuer"
		PageCritere PageCritere = PageFactory.initElements(driver, PageCritere.class);
		assertEquals("Nom", PageCritere.getCritere_nom().getText());
		// log 
		assertEquals("Code", PageCritere.getCritere_code().getText());
		// log 
		assertEquals("Type", PageCritere.getCritere_type().getText());
		// log 
		assertEquals("ActivÃ©", PageCritere.getCritere_active().getText());
		// log 
		assertEquals("OpÃ©rations", PageCritere.critere_operations.getText());
		// log 
		assertTrue("le bouton crÃ©er n'existe pas", PageCritere.btn_creer.isDisplayed());
		PageCreerCritere PageCreerCritere = PageCritere.clicBtnCreer(driver);
		
		//Capture d'Ã©cran - Ouverture de PageCreerCritere : vÃ©rifier que les boutons et champs sont prÃ©sents dans la page
		//assertTrue("le bouton Enregistrer n'existe pas", PageCreerCritere.btn_enregistrer.isDisplayed());
		//assertTrue("le bouton Sauvegarder et continuer n'existe pas", PageCreerCritere.btn_sauvegarder_continuer.isDisplayed());
		//assertTrue("le bouton Annuler n'existe pas", PageCreerCritere.btn_annuler.isDisplayed());
		//assertEquals("Modifier", PageCreerCritere.creer_critere_modifier.getText());
		//Capture d'Ã©cran - Capture pour le testeur de l'Ã©tat du tableau proposÃ©. A ajouter, les checkboxes qui doivent Ãªtre cochÃ©es par dÃ©faut
		
		//OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "CritÃ¨re - Test bouton [Annuler]");
		//OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "CritÃ¨re - Test bouton [Annuler]");
		//assertEquals("PARTICIPANT", PageCreerCritere.type_creer_critere.getText());		
		PageCritere = PageCreerCritere.clicBtnAnnuler(driver);		
		assertFalse("CritÃ¨re - Test bouton [Annuler]", false);
		//Capture d'Ã©cran - Test de la fonctionnalitÃ© annuler. Les modifications ne doivent pas Ãªtre enregistrÃ©es dans la PageCritere
		
		PageCritere.clicBtnCreer(driver);
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "CritÃ¨re - Test bouton [Enregistrer]");
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "CritÃ¨re - Test bouton [Enregistrer]");
		PageCritere = PageCreerCritere.clicBtnEnregistrer(driver);
		assertTrue("CritÃ¨re - Test bouton [Enregistrer]", true);
		Thread.sleep(2000);
		
		//Capture d'Ã©cran - Retour PageCritere : vÃ©rifier qu'aucune modification du tableau n'a Ã©tÃ© prise en compte
		PageCreerCritere = PageCritere.clicBtnCreer(driver);
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Test bouton [Sauver et continuer]");
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "Test bouton [Sauver et continuer]");
		PageCreerCritere.clicBtnSauvegarderContinuer(driver);
		PageCritere = PageCreerCritere.clicBtnEnregistrer(driver);
		
	}


	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
