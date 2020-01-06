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
		
		new PageCnx().sidentifier (String login, String password, WebDriver driver);
		
		PageAbstract.selectionnerMenu(driver,"Configuration","Comptes utilisateurs");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='Créer']/../../..")).click();
		
		// Parfois, popup d'erreur ! z-button-cm
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='Continuer']")).click();
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='Créer']/../../..")).click();
		
		OutilTechnique.remplirChampTexte(driver.findElement(By.xpath("//span[@class='z-label'][.=\"Nom d'utilisateur\"]/../../../td[2]/*/input")),"testAutomatisé");
		OutilTechnique.remplirChampTexte(driver.findElement(By.xpath("//span[@class='z-label'][.=\"Mot de passe\"]/../../../td[2]/*/input")),"motdepasse");
		OutilTechnique.remplirChampTexte(driver.findElement(By.xpath("//span[@class='z-label'][.=\"Confirmation du mot de passe\"]/../../../td[2]/*/input")),"motdepasse");
		
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='Enregistrer']/../../..")).click();
		
		// Faire toutes les vérif...

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@class='z-label'][.='testAutomatisé']/../../../td[4]/*/*/*/*/*/*/*/*/*[3]/*/*/*/*[2]/*[2]/img")).click();
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='OK']")).click();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.quit();
	}
}
