package org.autom5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCreerCritere {
	
	@FindBy (xpath="//table[@id='eVDPh6-box']//td[@class='z-button-cm']")
	WebElement btn_enregistrer;
	
	@FindBy (xpath="//table[@id='eVDPh6-box']//td[@class='z-button-cm']")
	WebElement btn_sauvegarder_continuer;
	
	@FindBy (xpath="//table[@id='eVDPh6-box']//td[@class='z-button-cm']")
	WebElement btn_annuler;
	
	@FindBy (xpath="//li[@id='eVDP45']//span[text()=\"Modifier\"]")
	WebElement creer_critere_modifier;
	
	@FindBy (xpath="//input[@id='a35Xe5']")
	WebElement champs_critere_nom;
	
	@FindBy (xpath="//textarea[@id='lKcYt5']")
	WebElement champs_critere_description;
	
	@FindBy (xpath="//td[(text()='PARTICIPANT')]/ancestor::i/descendant::input']")
	WebElement type_creer_critere;

	public PageCritere clicBtnAnnuler(WebDriver driver) {
		btn_annuler.click();
		return PageFactory.initElements(driver, PageCritere.class);
	}
	
	public PageCritere clicBtnEnregistrer(WebDriver driver) {
		btn_annuler.click();
		return PageFactory.initElements(driver, PageCritere.class);
	}
	
	
}
