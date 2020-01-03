package org.seleniumProject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Libreplan1 
{
	WebDriver driver;
	
	String login="j2ee";
	String pwd="j2ee";
	
	@Test
	public void premierTest()
	{ 
	driver = OutilTechnique.choisirNavigateur(ENavigateur.chrome);
	//driver.get("http://localhost:8090/libreplan") ;
	
	
	
			//Accéder à l’application Libreplan et se connecter en tant que admin / admin
			driver.get("http://localhost:8090/libreplan");
			
			//selectionner le champ login de la page Accueil
			WebElement champ_login = driver.findElement(By.xpath("//input[contains(text(),'j_username')"));
			OutilTechnique.remplirChamp(champ_login, login);
			
			//Selectionner le champ pwd de la page accueil
			WebElement champ_pwd = driver.findElement(By.xpath("//input[contains(text(),'j_password')"));
			OutilTechnique.remplirChamp(champ_pwd, pwd);
			
			//Cliquer sur le bouton "Se connecter"
			driver.findElement(By.name("button")).click();
			System.out.println("connecté en tant que admin/admin");

			
			
			String title = driver.getTitle() ;
			System.out.println(title);
			//assertEquals("LibrePlan: Calendrier", title) ;	
			
			//driver.findElement(by css="Calendrier&nbsp");
			//assertEquals("Calendrier", c
			//assertTrue(PageLogin_Libreplan.onglet_calendrier.isEnabled);
				
			
			//WebDriverWait wait = new WebDriverWait(driver, 5); 
			//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//[contains(text(),'Calendrier')]")));
			//element.click();
			
			//driver.findElement(By.xpath("//contains(text(),'Calendrier')]")).isDisplayed();
			driver.findElement(By.xpath("//button[contains(@class='Calendrier')"));
				
			
			
			
			
			
	}	
	

	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
