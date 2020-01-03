package org.autom5;

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
		driver.get("http://localhost:8090/libreplan");
		//Inserer Methode de connexion à la page index
		
		
		//Inserer Methode de selection du menu : selectionnerMenu(driver,"Ressources","Criteres");
		
		
		//PageCritere PageCritere = PageFactory.initElements(driver, PageCritere.class);
		//assertEquals("Nom", PageCritere.critere_nom.getText());
		//assertEquals("Nom", PageCritere.critere_code.getText());
		//assertEquals("Nom", PageCritere.critere_type.getText());
		//assertEquals("Nom", PageCritere.critere_activite.getText());
		//assertEquals("Nom", PageCritere.critere_operations.getText());
		//assertTrue(PageCritere.btn_creer.isEnabled());
		//driver.PageCritere.btn_creer.click();
				
	}

}
