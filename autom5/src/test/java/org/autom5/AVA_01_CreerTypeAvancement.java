package org.autom5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.TestCase;

import java.util.concurrent.TimeUnit;

import org.autom5.OutilTechnique;

public class AVA_01_CreerTypeAvancement extends TestCase {
	WebDriver driver;
	ENavigateur chrome;
	public void testApp(){
    	driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.get("http://localhost:8080/libreplan");
		
		PageCnx pge = PageFactory.initElements(driver, PageCnx.class);
		pge.sidentifier("admin","admin",driver);
		
		PageAbstract.selectionnerMenu(driver,"Ressources","Types d'avancement");
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
