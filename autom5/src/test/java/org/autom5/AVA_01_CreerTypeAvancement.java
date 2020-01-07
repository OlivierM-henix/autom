package org.autom5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.autom5.OutilTechnique;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AVA_01_CreerTypeAvancement extends TestCase {
	WebDriver driver;
	ENavigateur chrome;
	
	@Before
	public void setUp(){
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	
	@Test
	public void testApp() throws IOException, InterruptedException{
		Logger logger = LoggerFactory.getLogger("ERROR");
		logger.info("AVA_01 - Début du test.");
		driver.get("http://localhost:8080/libreplan");
		PageCnx pge = PageFactory.initElements(driver, PageCnx.class);
		pge.sidentifier("admin","admin",driver);
		
		PageIndex pgi = PageFactory.initElements(driver, PageIndex.class);
		pgi.selectionnerMenu(driver,"Ressources","Types d'avancement");
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='Créer']/../../..")).click();
		OutilTechnique.remplirChampTexte(driver.findElement(By.xpath("//span[@class='z-label'][.=\"Nom d'unité\"]/../../../td[2]/*/input")),"testAutomatisé");
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='Enregistrer']/../../..")).click();
		
		if(driver.findElement(By.xpath("//span[@class='z-label'][.='testAutomatisé']")).isDisplayed()) {
			logger.info("AVA_01 - Test réussi, suppression des données.");
		}else {
			logger.error("AVA_01 - ÉCHEC DU TEST !");
			OutilTechnique.screenShot(driver,"ECHEC_TESTAUTO_AVA_01");
		}

		driver.findElement(By.xpath("//span[@class='z-label'][.='testAutomatisé']/../../../td[4]/*/*/*/*/*/*/*/*/*[3]/*/*/*/*[2]/*[2]/img")).click();
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='OK']")).click();
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	@After
	public void tearDown (){
		driver.quit();
	}
}
