package org.autom5;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.autom5.PagesMenuRessources.PageCalendrier;
import org.autom5.PagesMenuRessources.PageCreerCritere;
import org.autom5.PagesMenuRessources.PageFormulaireCalendrier;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CAL_01_Administration {

	WebDriver driver;
	
	@Before
	public void initialisations() throws InterruptedException {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}	
	

	@Test
	
	//	[Connexion à l'application - Profil Admin - 01]
	public void test() throws InterruptedException, IOException {
		//Accéder à l’application et se connecter en tant que admin/admin
		driver.get("http://localhost:8090/libreplan/");	
		PageCnx pageCnx = PageFactory.initElements(driver, PageCnx.class);
		PageIndex pageIndex = pageCnx.sidentifier("admin", "admin", driver);
		Thread.sleep(1000);

		//Vérifier la bonne connexion
		assertTrue(pageIndex.btn_deconnexion.isEnabled());
		assertEquals(pageIndex.txt_utilisateurConnecte.getText(),"utilisateur: admin");
		
		
		//	[Accéder à la page d'administration des calendriers - 02]
		// Se rendre sur la page à tester l'aide de la méthode selectionnerMenu de la PageAbstract: exemple avec Ressources / Formulaires Qualité		
		pageIndex.selectionnerMenu(driver, "Ressources", "Calendriers");
		
		//	[Instanciation de la PageCalendrier et vérification du contenu]
		PageCalendrier PageCalendrier = PageFactory.initElements(driver, PageCalendrier.class);
		assertEquals("Nom", PageCalendrier.calendrier_nom.getText());
		// log 
		assertEquals("Héritages à jour", PageCalendrier.calendrier_heritages.getText());
		// log 
		assertEquals("Hérité de la date", PageCalendrier.calendrier_date.getText());		
		// log 
		assertEquals("Opérations", PageCalendrier.calendrier_operations.getText());	
		// log 
		assertTrue("le bouton créer n'existe pas", PageCalendrier.btn_creer.isDisplayed());
		OutilTechnique.screenShot(driver, "CAL_01_tableau_calendrier");
		
		
		// [Créer un calendrier - Accès au formulaire de création - 03]
		PageFormulaireCalendrier PageFormulaireCalendrier = PageCalendrier.clicBtnCreer(driver);
		//Instanciation de la PageFormulaireCalendrier et vérification du contenu		
		
		assertTrue("le bouton Enregistrer n'existe pas", PageFormulaireCalendrier.btn_enregistrer.isEnabled());
		assertTrue("le bouton Sauvegarder et continuer n'existe pas", PageFormulaireCalendrier.btn_sauvegarder_continuer.isEnabled());
		assertTrue("le bouton Annuler n'existe pas", PageFormulaireCalendrier.btn_annuler.isEnabled());	
		OutilTechnique.screenShot(driver, "CAL_01_formulaire_calendrier");
		
		//[	Créer un calendrier - bouton [Enregistrer] - 04]
				
		OutilTechnique.remplirChampTexte(PageFormulaireCalendrier.champs_calendrier_nom, "Calendrier - Test 1");		
		PageFormulaireCalendrier.btn_enregistrer.click();			
		assertEquals("Calendrier - Test 1", PageCalendrier.calendrier_tableau_test1.getText());
		OutilTechnique.screenShot(driver, "CAL_01_tableau_calendrier");	
		
		//[	Créer un calendrier - bouton [Enregistrer] - 05]
		
		PageCalendrier.calendrier_derive_titre_tableau.click();
		assertEquals("Dérivé du calendrier Calendrier - Test 1", PageFormulaireCalendrier.type_calendrier.getText());
		
		// [Créer un calendrier dérivé - nom non conforme - 06]
		OutilTechnique.remplirChampTexte(PageFormulaireCalendrier.champs_calendrier_nom, "Calendrier - Test 1");
		PageFormulaireCalendrier.btn_sauvegarder_continuer.click();
		assertEquals("Calendrier - Test 1 existe déjà", PageFormulaireCalendrier.erreur1_calendrier.getText());
		OutilTechnique.screenShot(driver, "CAL_01_erreur_calendrier");	
		
		// [Créer un calendrier dérivé - bouton [Enregistrer et continuer] - 07 ]
		
		OutilTechnique.remplirChampTexte(PageFormulaireCalendrier.champs_calendrier_nom, "Calendrier - Test Calendrier Dérivé");
		PageFormulaireCalendrier.btn_sauvegarder_continuer.click();	
		assertEquals("Calendrier de base \"Calendrier - Test Calendrier Dérivé\" enregistré", PageFormulaireCalendrier.validation_calendrier.getText());
		PageFormulaireCalendrier.btn_annuler.click();	
		OutilTechnique.screenShot(driver, "CAL_01_erreur_calendrier");	
		
			
	
	}
	//@After
		//public void fermerNavigateur () {
		//	driver.quit();
		//}
}
