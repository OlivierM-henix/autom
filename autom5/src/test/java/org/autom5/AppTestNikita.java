package org.autom5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.autom5.PageAbstract;
import org.autom5.OutilTechnique;


/**
 * Unit test for simple App.
 */
public class AppTestNikita extends TestCase {
	WebDriver driver;
	ENavigateur chrome;
    public void testApp() {
    	driver = OutilTechnique.choisirNavigateur(chrome);
		driver.get("http://localhost:8091/libreplan");
		PageCnx page_cnx = PageFactory.initElements(driver, PageCnx.class);
		
		PageIndex page_ind = page_cnx.sidentifier();
		page_ind.selectionnerMenu(driver,"Ressources","Machines");
    }
}
