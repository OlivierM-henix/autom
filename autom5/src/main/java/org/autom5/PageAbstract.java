package org.autom5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageAbstract {
	
	@FindBy(xpath="//a[text()=\"[Déconnexion]\"]")
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
}


