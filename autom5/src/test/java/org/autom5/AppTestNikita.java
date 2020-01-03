package org.autom5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.projet_selenium.Outils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.autom5.PageAbstract;
import org.autom5.OutilTechnique;

/**
 * Unit test for simple App.
 */
public class AppTestNikita 
    extends TestCase
{
    /**
     * Rigourous Test :-)
     * @param  
     */
    public void testApp() {
    	driver = OutilTechnique.choisirNavigateur(chrome);
		driver.get("http://localhost:8091/libreplan");
		PageIndex page_index = PageFactory.initElements(driver, pageClassToProxy)
		OutilTechnique.selectionnerMenu(driver,"Ressources","Machines");
    }
}
