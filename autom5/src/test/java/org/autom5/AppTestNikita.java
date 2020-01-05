package org.autom5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.TestCase;

import java.util.concurrent.TimeUnit;

import org.autom5.OutilTechnique;

public class AppTestNikita extends TestCase {
	WebDriver driver;
	ENavigateur chrome;
	public void testApp(){
    	driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
<<<<<<< HEAD
		driver.get("http://localhost:8081/libreplan");
=======
		driver.get("http://localhost:8080/libreplan");
>>>>>>> aa89ffcb649aaee4687c321a80970fc58b0c2022
		PageCnx page_cnx = PageFactory.initElements(driver, PageCnx.class);
		
		PageIndex page_ind = page_cnx.sidentifier("admin","admin",driver);
		page_ind.selectionnerMenu(driver,"Ressources","Types d'avancement");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='Créer']/../../..")).click();
		
		OutilTechnique.remplirChampTexte(driver.findElement(By.xpath("//span[@class='z-label'][.=\"Nom d'unité\"]/../../../td[2]/*/input")),"testAutomatisé");
		
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='Enregistrer']/../../..")).click();
		
		// Faire toutes les vérif...

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='z-label'][.='testAutomatisé']/../../../td[4]/*/*/*/*/*/*/*/*/*[3]/*/*/*/*[2]/*[2]/img")).click();
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='OK']")).click();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.quit();
	}
}
