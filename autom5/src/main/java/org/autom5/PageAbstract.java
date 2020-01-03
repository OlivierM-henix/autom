package org.autom5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageAbstract {
	
	@FindBy(xpath="//a[@href=\"/libreplan/j_spring_security_logout\"]")
	WebElement btn_deconnexion;

	
	public static void selectionnerMenu(WebDriver driver, String ogl,String btn) {
		Actions action = new Actions (driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement b = driver.findElement(By.xpath("//button[@class='z-menu-btn'][contains(text(),'Ressources')]/../../../../.."));
		wait.until(ExpectedConditions.elementToBeClickable(b));
		
        action.moveToElement(b).build().perform();
        
        WebElement a = driver.findElement(By.xpath("//a[@class='z-menu-item-cnt'][contains(text(),'"+btn+"')]"));
        
        wait.until(ExpectedConditions.elementToBeClickable(a));
        a.click();
	} // PAR EXEMPLE : selectionnerMenu(driver,"Ressources","Machines");
}