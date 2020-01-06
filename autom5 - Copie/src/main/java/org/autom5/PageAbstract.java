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

public abstract class PageAbstract {

	@FindBy(xpath="//a[text()=\"[Déconnexion]\"]")
	WebElement btn_deconnexion;

	@FindBy(xpath="//td[@class=\"usuario\"][2]")
	WebElement txt_utilisateurConnecte;

	@FindBy(xpath="//button[contains(.,\"Calendrier\")]")
	WebElement btn_calendrier;


	public static void selectionnerMenu(WebDriver driver, String ogl,String btn) {
		Actions action = new Actions (driver);
<<<<<<< HEAD
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement b = driver.findElement(By.xpath("//button[@class='z-menu-btn'][contains(text(),'"+ogl+"')]/../../../../.."));
		
        action.moveToElement(b).build().perform();
        System.out.println("Je hover sur : "+b);
        try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        WebElement a = driver.findElement(By.xpath("//a[@class='z-menu-item-cnt'][.=\" "+btn+"\"]"));
        System.out.println("Je clique sur : "+a);
        a.click();
        
//        return PageFactory.initElements(driver, PageAbstract.class);
=======
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		
		WebElement b = driver.findElement(By.xpath("//button[@class='z-menu-btn'][contains(text(),\""+ogl+"\")]/../../../../.."));
		action.moveToElement(b).build().perform();
		System.out.println("selection de l'onglet : "+ogl);
		
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		
		WebElement a = driver.findElement(By.xpath("//a[@class='z-menu-item-cnt'][contains(text(),\""+btn+"\")]"));
		System.out.println("selection du sous-menu : "+btn);
		a.click();

		//        return PageFactory.initElements(driver, PageAbstract.class);
>>>>>>> b92251123f3bf6bf0e9b0a3bdf58dd67eafaec33
	} // PAR EXEMPLE : selectionnerMenu(driver,"Ressources","Machines");
	
	
	

}


