package org.autom5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class PageAbstract {
	
	@FindBy(xpath="//a[@href=\"/libreplan/j_spring_security_logout\"]")
	WebElement btn_deconnexion;

	
	public static void selectionnerMenu(WebDriver driver, String ogl,String btn) {
		driver.findElement(By.xpath("//button[@class='z-menu-btn'][contains(text(),"+ogl+"]")).click();
		driver.findElement(By.xpath("//button[@class='z-menu-item-cnt'][contains(text(),"+btn+"]")).click();
	} // PAR EXEMPLE : selectionnerMenu(driver,"Ressources","Machines");
}