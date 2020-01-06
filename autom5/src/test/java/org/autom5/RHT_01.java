package org.autom5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.TestCase;

import java.util.concurrent.TimeUnit;

import org.autom5.OutilTechnique;

public class RHT_01 extends TestCase {
	WebDriver driver;
	ENavigateur chrome;
	public void testApp(){
    	driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.get("http://localhost:8080/libreplan");
		
		PageCnx pge = PageFactory.initElements(driver, PageCnx.class);
		pge.sidentifier("admin","admin",driver);
		
		PageIndex pgi = PageFactory.initElements(driver, PageIndex.class);
		pgi.selectionnerMenu(driver,"Coût","Feuille de temps");
		
		Select drp = new Select(driver.findElement(By.xpath("//td[@class='z-button-cm'][.='Nouvelle feuille de temps']/../../../../../../td[3]/*")));
		drp.selectByVisibleText("Default");
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='Nouvelle feuille de temps']")).click();
		try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
		String fnm = driver.findElement(By.xpath("//input[@class='z-textbox z-textbox-disd z-textbox-text-disd']")).getAttribute("value");
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='Enregistrer']/../../..")).click();
		
		// Faire toutes les vérif de création
		
		try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
		driver.findElement(By.xpath("//span[@class='z-label'][.='"+fnm+"']/../../../td[6]//span[@title='Supprimer']//img")).click();
		try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
		driver.findElement(By.xpath("//td[@class='z-button-cm'][.='OK']")).click();
		try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
		
		// Faire les vérifs de suppression
		
		driver.quit();
	}
}
