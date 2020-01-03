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

public class CRI_01_Creation {
	
	WebDriver driver;
	
	@Before
	public void initialisations() throws InterruptedException {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}


	/*@After
	public void fermerNavigateur () {
		driver.quit();
	}
	*/

	@Test
	public void test() throws InterruptedException {
		//Accéder à l’application et se connecter en tant que admin/admin
		driver.get("http://localhost:8090/libreplan/");	
		PageCnx pageCnx = PageFactory.initElements(driver, PageCnx.class);
		PageIndex pageIndex = pageCnx.sidentifier("admin", "admin", driver);
		Thread.sleep(5000);

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
		assertEquals("Code", PageCritere.getCritere_code().getText());
		assertEquals("Type", PageCritere.getCritere_type().getText());
		assertEquals("Activé", PageCritere.getCritere_active().getText());
		assertEquals("Opérations", PageCritere.critere_operations.getText());
		assertTrue(PageCritere.btn_creer.isDisplayed());
		
		//Capture d'écran - Ouverture de PageCreerCritere : vérifier que les boutons et champs sont présents dans la page
		PageCreerCritere PageCreerCritere = PageCritere.clicBtnCreer(driver);
		//assertTrue(PageCreerCritere.btn_enregistrer.isDisplayed());
		//assertTrue(PageCreerCritere.btn_sauvegarder_continuer.isDisplayed());
		//assertTrue(PageCreerCritere.btn_annuler.isDisplayed());
		//assertEquals("Modifier", PageCreerCritere.creer_critere_modifier.getText());
		//Capture d'écran - Capture pour le testeur de l'état du tableau proposé. A ajouter, les checkboxes qui doivent être cochées par défaut
		
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Critère - Test bouton [Annuler]");
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "Critère - Test bouton [Annuler]");
		assertEquals("PARTICIPANT", PageCreerCritere.type_creer_critere.getText());		
		PageCritere = PageCreerCritere.clicBtnAnnuler(driver);		
		assertFalse("Critère - Test bouton [Annuler]", true);
		//Capture d'écran - Test de la fonctionnalité annuler. Les modifications ne doivent pas être enregistrées dans la PageCritere
		
		PageCreerCritere = PageCritere.clicBtnCreer(driver);
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Critère - Test bouton [Enregistrer]");
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "Critère - Test bouton [Enregistrer]");
		PageCritere = PageCreerCritere.clicBtnEnregistrer(driver);
		assertTrue("Critère - Test bouton [Enregistrer]", true);
		
		//Capture d'écran - Retour PageCritere : vérifier qu'aucune modification du tableau n'a été prise en compte
		PageCreerCritere = PageCritere.clicBtnCreer(driver);
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Test bouton [Sauver et continuer]");
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "Test bouton [Sauver et continuer]");
		PageCreerCritere.clicBtnSauvegarderContinuer(driver);
		
		
				
	}

}
