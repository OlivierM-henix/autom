package org.autom5;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.autom5.PagesMenuRessources.PageFormulaireQualite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FQU_01 extends PageAbstract{

	WebDriver driver;

	@Before
	public void initialisations() throws InterruptedException {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void fermerNavigateur () {
		driver.quit();
	}


	@Test
	public void test() throws InterruptedException {
		//PAS 1 Accéder à l’application et se connecter en tant que admin/admin
		driver.get("http://localhost:8090/libreplan/");	
		PageCnx pageCnx = PageFactory.initElements(driver, PageCnx.class);
		PageIndex pageIndex = pageCnx.sidentifier("admin", "admin", driver);

		//PAS 1 Vérifier la bonne connexion
		assertTrue(pageIndex.btn_deconnexion.isEnabled());
		assertTrue(pageIndex.btn_calendrier.isEnabled());
		assertEquals(pageIndex.txt_utilisateurConnecte.getText(),"utilisateur: admin");
		
		//PAS 2 Se rendre sur la page à tester l'aide de la méthode selectionnerMenu de la PageAbstract: exemple avec Ressources / Formulaires Qualité

		pageIndex.selectionnerMenu(driver, "Ressources", "Formulaires qualité");
		PageFormulaireQualite pageFormulaireQualite = PageFactory.initElements(driver, PageFormulaireQualite.class);
	
		//PAS 2 Vérifier la bonne connexion
		assertTrue(pageFormulaireQualite.cln_nom.getText().equals("Nom"));
		assertTrue(pageFormulaireQualite.cln_description.getText().equals("Description"));
		assertTrue(pageFormulaireQualite.cln_operations.getText().equals("Opérations"));
		assertTrue(pageFormulaireQualite.champ_filtre.isDisplayed());
		assertTrue(pageFormulaireQualite.btn_filtre.isDisplayed());
		Thread.sleep(5000);
		
		//PAS 3 
		// Remarque : impossible de clicquer droit sur btn_creer
		pageFormulaireQualite.btn_creer.click();
		
		
	}
}