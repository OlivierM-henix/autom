package org.autom5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageCritere {
	
	@FindBy (xpath="//table[@id='eVDP_5-box']//td[@class='z-button-cm']")
	WebElement btn_creer;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Nom')]")
	WebElement critère_nom;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Code')]")
	WebElement critère_code;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Type')]")
	WebElement critère_type;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Activité')]")
	WebElement critère_activite;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Opérations')]")
	WebElement critère_operations;	
	
	
	
	public PageCreerCritere clicBtnCreer(WebDriver driver) {
		btn_creer.click();
		return PageFactory.initElements(driver, PageCreerCritere.class);
	}
		
}


