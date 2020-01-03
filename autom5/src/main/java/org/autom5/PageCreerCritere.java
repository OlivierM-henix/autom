package org.autom5;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCreerCritere {
	
	@FindBy (xpath="//table[@id='eVDPh6-box']//td[@class='z-button-cm']")
	WebElement btn_enregistrer;
	
	@FindBy (xpath="//table[@id='eVDPh6-box']//td[@class='z-button-cm']")
	WebElement btn_sauvegarder_continuer;
	
	@FindBy (xpath="//table[@id='eVDPh6-box']//td[@class='z-button-cm']")
	WebElement btn_annuler;
	
	
	@FindBy (xpath="//li[@id='eVDP45']//span[text()=\"Modifier\"]")
	WebElement creer_critere_modifier;
	
	
	
}
