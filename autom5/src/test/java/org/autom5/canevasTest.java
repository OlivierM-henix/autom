package org.autom5;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class canevasTest{

	WebDriver driver;

	@Before
	public void initialisations() {
		driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Accéder à l’application et se connecter en tant que admin/admin
		driver.get("http://localhost:8090/libreplan/");	
		PageCnx pageCnx = PageFactory.initElements(driver, PageCnx.class);
		PageIndex pageIndex = pageCnx.sidentifier("admin", "admin", driver);
		
		//Vérifier la bonne connexion
		assertTrue(btn_deconnexion.isDisplayed)
	}


	@After
	public void fermerNavigateur () {
		driver.quit();
	}


	@Test
	public void test() throws InterruptedException {

		Thread.sleep(2000);;
	}
}
