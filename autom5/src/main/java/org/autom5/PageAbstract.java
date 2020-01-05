package org.autom5;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageAbstract {

	@FindBy(xpath="//a[text()=\"[DÃ©connexion]\"]")
	WebElement btn_deconnexion;

	@FindBy(xpath="//td[@class=\"usuario\"][2]")
	WebElement txt_utilisateurConnecte;

	@FindBy(xpath="//button[contains(.,\"Calendrier\")]")
	WebElement btn_calendrier;


	public void selectionnerMenu(WebDriver driver, String ogl,String btn) {
		Actions action = new Actions (driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement b = driver.findElement(By.xpath("//button[@class='z-menu-btn'][contains(text(),'Ressources')]/../../../../.."));

		action.moveToElement(b).build().perform();
		System.out.println("Je hover sur : "+b);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement a = driver.findElement(By.xpath("//a[@class='z-menu-item-cnt'][contains(text(),'"+btn+"')]"));
		System.out.println("Je clique sur : "+a);
		a.click();

		//        return PageFactory.initElements(driver, PageAbstract.class);
	} // PAR EXEMPLE : selectionnerMenu(driver,"Ressources","Machines");


	public static void captureEcran(WebDriver webdriver,String fileWithPath) throws Exception{
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);	 	
		
		
		//Il faut Ajouter une incrémentation pour le numero des capture d'écran + 
		//repertoire de stockage à ajouter dans la classe test, par exemple : PageAbstract.captureEcran(driver, "c:/TEST/test.png") ; ;
		
	}
	
	public static void screenShot(WebDriver driver, String nom_capture) throws IOException, InterruptedException {
	    File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File dest = new File(".\\src\\test\\"+nom_capture+ "-" + timestamp() + ".png");
	    FileUtils.copyFile(scr, dest);
	    Thread.sleep(1000);
	}

	public static String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss").format(new Date());
	} 
	
	//Verifier le chemin du dossier de stockage
	//nommer la capture en fonction de son test ex: "CRI_01_connexion" 
	//commande PageAbstract.screenShot(driver, "CRI_01_connexion")
	//ex nommage attendu : CRI_01_connexion - 2019-05-01 : 18:54:08)


}


