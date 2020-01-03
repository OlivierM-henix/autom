package org.autom5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;




public class CRI_01_Creation {
	
	WebDriver driver;
	

	//Before choix du navigateur 
	
	
	@Test
	public void test() {
		
		
		//choix du navigateur		
		driver = OutilTechnique.choisirNavigateur(ENavigateur.firefox);
		driver.get("http://localhost:8090/libreplan");
		
		//Inserer Methode de connexion à la page index
		
		//Selection du menu 
		PageAbstract.selectionnerMenu(driver,"Ressources","Criteres");
		
				PageCritere PageCritere = PageFactory.initElements(driver, PageCritere.class);
		assertEquals("Nom", PageCritere.critere_nom.getText());
		assertEquals("Code", PageCritere.critere_code.getText());
		assertEquals("Type", PageCritere.critere_type.getText());
		assertEquals("Activité", PageCritere.critere_activite.getText());
		assertEquals("Opérations", PageCritere.critere_operations.getText());
		assertTrue(PageCritere.btn_creer.isEnabled());
		
		//Capture d'écran		
		
		PageCreerCritere PageCreerCritere = PageCritere.clicBtnCreer(driver);
		
		assertTrue(PageCreerCritere.btn_enregistrer.isEnabled());
		assertTrue(PageCreerCritere.btn_sauvegarder_continuer.isEnabled());
		assertTrue(PageCreerCritere.btn_annuler.isEnabled());
		assertEquals("Modifier", PageCreerCritere.creer_critere_modifier.getText());
				
		//Capture d'écran
		OutilTechnique.remplirChampTexte(PageCreerCritere.champs_critere_nom, "Critère - Test bouton");
		assertEquals("PARTICIPANT", PageCreerCritere.type_creer_critere.getText());		
						
	}

}
