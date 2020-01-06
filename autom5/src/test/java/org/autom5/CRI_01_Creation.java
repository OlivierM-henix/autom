package org.autom5;

import static org.junit.Assert.*;

import java.io.IOException;
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

public class CRI_01_Creation {
	
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
	

	@Test
	public void test() throws InterruptedException, IOException {
		//Accéder à l’application et se connecter en tant que admin/admin
		driver.get("http://localhost:8090/libreplan/");	
		PageCnx pageCnx = PageFactory.initElements(driver, PageCnx.class);
		PageIndex pageIndex = pageCnx.sidentifier("admin", "admin", driver);
		Thread.sleep(1000);

		//Vérifier la bonne connexion
		assertTrue(pageIndex.btn_deconnexion.isEnabled());
		assertEquals(pageIndex.txt_utilisateurConnecte.getText(),"utilisateur: admin");

		// Se rendre sur la page à tester l'aide de la méthode selectionnerMenu de la PageAbstract: exemple avec Ressources / Formulaires Qualité
		// Adapter les noms à votre page !!!
		pageIndex.selectionnerMenu(driver, "Ressources", "Critère");
		PageFormulaireQualite pageFormulaireQualite = PageFactory.initElements(driver, PageFormulaireQualite.class);
		
		
		// Initialisation de la PageCritere : verification des champs dans le tableau et clic sur le bouton "Continuer"
		PageCritere PageCritere = PageFactory.initElements(driver, PageCritere.class);
		assertEquals("Nom", PageCritere.getCritere_nom().getText());
		// log 
		assertEquals("Code", PageCritere.getCritere_code().getText());
		// log 
		assertEquals("Type", PageCritere.getCritere_type().getText());
		// log 
		assertEquals("Activé", PageCritere.getCritere_active().getText());
		// log 
		assertEquals("Opérations", PageCritere.critere_operations.getText());
		// log 
		assertTrue("le bouton créer n'existe pas", PageCritere.btn_creer.isDisplayed());
		PageCreerCritere PageCreerCritere = PageCritere.clicBtnCreer(driver);
		OutilTechnique.screenShot(driver, "CRI_01_tableau");
		
		
		
		assertTrue("le bouton Enregistrer n'existe pas", PageCreerCritere.btn_enregistrer.isEnabled());
		assertTrue("le bouton Sauvegarder et continuer n'existe pas", PageCreerCritere.btn_sauvegarder_continuer.isEnabled());
		assertTrue("le bouton Annuler n'existe pas", PageCreerCritere.btn_annuler.isEnabled());	
		
		//assertEquals("PARTICIPANT", PageCreerCritere.type_creer_critere.getText());
		
		OutilTechnique.screenShot(driver, "CRI_01_formulaire_creation");
		
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Critère - Test bouton [Annuler]");
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "Critère - Test bouton [Annuler]");				
		PageCritere = PageCreerCritere.clicBtnAnnuler(driver);		
		assertFalse("Critère - Test bouton [Annuler]", false);		
		OutilTechnique.screenShot(driver, "CRI_01_tableau_annulation");
		
		PageCritere.clicBtnCreer(driver);
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Critère - Test bouton [Enregistrer]");
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "Critère - Test bouton [Enregistrer]");
		PageCritere = PageCreerCritere.clicBtnEnregistrer(driver);
		assertTrue("Critère - Test bouton [Enregistrer]", true);		
		OutilTechnique.screenShot(driver, "CRI_01_tableau_enregistrer");
		Thread.sleep(1000);
		
		PageCreerCritere = PageCritere.clicBtnCreer(driver);
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Test bouton [Sauver et continuer]");
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "Test bouton [Sauver et continuer]");
		PageCreerCritere.clicBtnSauvegarderContinuer(driver);
		assertEquals("Type de critère \"Test bouton [Sauver et continuer]\" enregistré", PageCreerCritere.critere_message_sauvegarde.getText());
		assertEquals("Modifier Type de critère: Test bouton [Sauver et continuer]", PageCreerCritere.critere_titre.getText());
		OutilTechnique.screenShot(driver, "CRI_01_message_sauvegarder");
		PageCritere = PageCreerCritere.clicBtnAnnuler(driver);	
		
		//verification de l'enregistrement dans le tableau
		//assertEquals("Types de critères Liste", PageCritere.critere_titre.getText());
		assertEquals("Test bouton [Sauver et continuer]", PageCritere.critere_selection_titre_tableau.getText());
		PageCritere.critere_modification_titre_tableau.click();
		
		
		
		
		/* Suppression
		 
		PageCritere.critere_supression_titre_tableau.click();
		PageCritere.critere_valider_supression.click();
		
		*/
		
		
		
		
	
		
		
		
		
		
		
		
		
		
	}


	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
