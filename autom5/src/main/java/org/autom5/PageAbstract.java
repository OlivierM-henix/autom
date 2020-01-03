package org.autom5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public abstract class PageAbstract {
	
	@FindBy(xpath="//a[text()=\"[Déconnexion]\"]")
	WebElement btn_deconnexion;
	
	@FindBy(xpath="//td[@class=\"usuario\"][2]")
	WebElement txt_utilisateurConnecte;

	
	public static void selectionnerMenu(WebDriver driver, String ogl,String btn) {
		Actions action = new Actions (driver);
        action.moveToElement(driver.findElement(By.xpath("//button[@class='z-menu-btn'][contains(text(),"+ogl+"]"))).build().perform();
		driver.findElement(By.xpath("//button[@class='z-menu-item-cnt'][contains(text(),"+btn+"]")).click();
	} // PAR EXEMPLE : selectionnerMenu(driver,"Ressources","Machines");
}