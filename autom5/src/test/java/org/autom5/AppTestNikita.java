package org.autom5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
		pgi.selectionnerMenu(driver,"Coût","Feuille de temps");
		


		driver.quit();
	}
}
