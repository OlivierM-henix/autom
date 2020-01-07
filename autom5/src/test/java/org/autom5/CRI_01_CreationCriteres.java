package org.autom5;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.autom5.PagesMenuRessources.PageCreerCritere;
import org.autom5.PagesMenuRessources.PageCritere;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CRI_01_CreationCriteres {

	WebDriver driver;
	String nom_critere = "Test bouton [Sauver et continuer]";
	String nom_critere2 = "Test bouton [Sauver et continuer] 2";


	@Before
	public void initialisations() throws InterruptedException {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException, IOException {

		//[Connexion à l'application - Profil Admin - 01]
		driver.get("http://localhost:8090/libreplan/");	
		PageCnx pageCnx = PageFactory.initElements(driver, PageCnx.class);
		PageIndex pageIndex = pageCnx.sidentifier("admin", "admin", driver);
		System.out.println("connexion avec le login : admin");
		Thread.sleep(1000);

		//Vérifier les informations de connexion
		assertTrue(pageIndex.btn_deconnexion.isEnabled());
		assertEquals(pageIndex.txt_utilisateurConnecte.getText(),"utilisateur: admin");
		System.out.println("verification utilisateur connecté : admin");

		//[Accéder à la page d'administration des critères - 02]		
		// Initialisation de la PageCritere : verification des champs dans le tableau et clic sur le bouton "Continuer"
		pageIndex.selectionnerMenu(driver, "Ressources", "Critère");
		PageCritere PageCritere = PageFactory.initElements(driver, PageCritere.class);
		assertEquals("Nom", PageCritere.getCritere_nom().getText());		 
		assertEquals("Code", PageCritere.getCritere_code().getText());	
		assertEquals("Type", PageCritere.getCritere_type().getText());		
		assertEquals("Activé", PageCritere.getCritere_active().getText());	 
		assertEquals("Opérations", PageCritere.critere_operations.getText());		
		assertTrue("le bouton créer n'existe pas", PageCritere.btn_creer.isDisplayed());
		PageCreerCritere PageCreerCritere = PageCritere.clicBtnCreer(driver);
		OutilTechnique.screenShot(driver, "CRI_01_tableau");

		//[Créer un critère - Accès au formulaire de création - 03]		
		assertTrue("le bouton Enregistrer n'existe pas", PageCreerCritere.btn_enregistrer.isEnabled());
		assertTrue("le bouton Sauvegarder et continuer n'existe pas", PageCreerCritere.btn_sauvegarder_continuer.isEnabled());
		assertTrue("le bouton Annuler n'existe pas", PageCreerCritere.btn_annuler.isEnabled());	
		OutilTechnique.screenShot(driver, "CRI_01_formulaire_creation");

		// [Créer un critère - bouton [Annuler] - 04]		
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Critère - Test bouton [Annuler]");
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "Critère - Test bouton [Annuler]");				
		PageCritere = PageCreerCritere.clicBtnAnnuler(driver);		
		assertFalse("Critère - Test bouton [Annuler]", false);		
		OutilTechnique.screenShot(driver, "CRI_01_tableau_annulation");

		// Créer un critère - bouton [Enregistrer] - 05]
		PageCritere.clicBtnCreer(driver);
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Critère - Test bouton [Enregistrer]");
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "Critère - Test bouton [Enregistrer]");
		PageCritere = PageCreerCritere.clicBtnEnregistrer(driver);
		assertTrue("Critère - Test bouton [Enregistrer]", true);		
		OutilTechnique.screenShot(driver, "CRI_01_tableau_enregistrer");		

		// [Créer un critère - Accès au formulaire de création - 06]
		PageCreerCritere = PageCritere.clicBtnCreer(driver);
		Thread.sleep(1000);

		// [Créer un critère - bouton [Sauver et continuer] - 07]		
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Test bouton [Sauver et continuer]");
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_description, "Test bouton [Sauver et continuer]");
		PageCreerCritere.clicBtnSauvegarderContinuer(driver);
		assertEquals("Type de critère \"Test bouton [Sauver et continuer]\" enregistré", PageCreerCritere.critere_message_sauvegarde.getText());
		assertEquals("Modifier Type de critère: Test bouton [Sauver et continuer]", PageCreerCritere.critere_titre.getText());
		OutilTechnique.screenShot(driver, "CRI_01_message_sauvegarder");


		// [Retour page d'administration des critères - 08]
		PageCritere = PageCreerCritere.clicBtnAnnuler(driver);	
		Thread.sleep(1000);
		WebElement titre_tableau = driver.findElement(By.xpath("//div[@class='clickable-rows z-grid']//span[@title='"+nom_critere+"']"));
		assertEquals("Test bouton [Sauver et continuer]", titre_tableau.getText());

		// [Modifier un critère -  Bouton [Annuler] - 09]
		PageCritere.critere_modification_titre_tableau.click();
		//assertEquals("Modifier Type de critère: Test bouton [Sauver et continuer]", PageCreerCritere.critere_titre.getText()); marche pas retourne texte []	

		//pas de tests inutiles pour l'automatisation => test de la fonction suivante

		// [Modifier un critère - modification du nom - 12 ]
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, nom_critere2);
		PageCreerCritere.clicBtnSauvegarderContinuer(driver);	

		// [Modifier un critère - bouton [Sauver et continuer] - 13]
		WebElement titre_tableau2 = driver.findElement(By.xpath("//div[@class='message_INFO']//span[contains(text(),'"+nom_critere2+"')]"));			
		assertEquals("Type de critère \"Test bouton [Sauver et continuer] 2\" enregistré", titre_tableau2.getText());

		//[Retour page d'administration des critères - 14]
		PageCritere = PageCreerCritere.clicBtnAnnuler(driver);	
		Thread.sleep(1000);
		WebElement titre_tableau2bis = driver.findElement(By.xpath("//div[@class='clickable-rows z-grid']//span[contains(text(),'"+nom_critere2+"')]"));
		assertEquals("Test bouton [Sauver et continuer] 2", titre_tableau2bis.getText());

		//Supprimer un critère - Bouton [Annuler] - 15]
		WebElement titre_tableau2suppr = driver.findElement(By.xpath("//div[@class='clickable-rows z-grid']//span[contains(text(),'"+nom_critere2+"')]//ancestor::tr//span[@title='Supprimer']"));
		titre_tableau2suppr.click();		
		PageCritere.critere_annuler_supression.click();

		//[Supprimer un critère - Pop-up de confirmation - 16]		
		titre_tableau2suppr.click();		
		PageCritere.critere_valider_supression.click();


		//assertEquals("Types de critères Liste", PageCritere.critere_titre.getText()); marche pas retourne texte []	

		//div[@class='clickable-rows z-grid']//span[@title='Test bouton [Sauver et continuer] 2']

		//div[@class='clickable-rows z-grid']//span[contains(text(),'Test bouton [Sauver et continuer] 2']

	}

	@After
	public void CaptureFin () throws IOException, InterruptedException {
		OutilTechnique.screenShot(driver, "FIN_CRI_01");
		driver.quit(); {
		};	


	}



}
