package org.autom5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageCritere extends PageAbstract {
	
	@FindBy (xpath="//table[@id='eVDP_5-box']//td[@class='z-button-cm']")
	WebElement btn_creer;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Nom')]")
	WebElement critere_nom;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Code')]")
	WebElement critere_code;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Type')]")
	WebElement critere_type;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Activité')]")
	WebElement critere_activite;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Opérations')]")
	WebElement critere_operations;	
	
	
	
	public PageCreerCritere clicBtnCreer(WebDriver driver) {
		btn_creer.click();
		return PageFactory.initElements(driver, PageCreerCritere.class);
	}
		
}


