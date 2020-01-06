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
		driver.get("http://localhost:8080/libreplan");
		
		PageCnx pge = PageFactory.initElements(driver, PageCnx.class);
		pge.sidentifier("admin","admin",driver);
		
		PageIndex pgi = PageFactory.initElements(driver, PageIndex.class);
		pgi.selectionnerMenu(driver,"Ressources","Machines");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='Créer']/../../..")).click();
		
		OutilTechnique.remplirChampTexte(driver.findElement(By.xpath("//span[@class='z-label'][.=\"Nom\"]/../../../td[2]/*/input")),"testAutomatisé");
		OutilTechnique.remplirChampTexte(driver.findElement(By.xpath("//span[@class='z-label'][.=\"Description\"]/../../../td[2]/*/input")),"descriptionAutomatisée");
		
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='Enregistrer']/../../..")).click();
		
		// Faire toutes les vérif d'échec de création...
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='z-label'][.='testAutomatisé']/../../../td[5]/*/*/*/*/*/*/*/*/*[3]/*/*/*/*[2]/*[2]/img")).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='OK']")).click();
		
		// Faire toutes les vérifs de suppression...
		try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
		driver.quit();
	}
}
