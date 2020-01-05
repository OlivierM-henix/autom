package org.autom5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.TestCase;

import org.autom5.OutilTechnique;


/**
 * Unit test for simple App.
 */
public class AppTestNikita extends TestCase {
	WebDriver driver;
	ENavigateur chrome;
	public void testApp(){
    	driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.get("http://localhost:8081/libreplan");
		PageCnx page_cnx = PageFactory.initElements(driver, PageCnx.class);
		
		PageIndex page_ind = page_cnx.sidentifier("admin","admin",driver);
		page_ind.selectionnerMenu(driver,"Ressources","Types");
		page_ind.selectionnerMenu(driver,"Coût","Feuille de temps");
    }
}
