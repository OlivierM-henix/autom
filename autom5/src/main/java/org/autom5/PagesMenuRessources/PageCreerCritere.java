package org.autom5.PagesMenuRessources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCreerCritere {
	
	@FindBy (xpath="//table[@id='lKcYh6-box']//td[@class='z-button-cm']")
	public
	WebElement btn_enregistrer;
			
	@FindBy (xpath="//span[@class='saveandcontinue-button global-action z-button']")
	public
	WebElement btn_sauvegarder_continuer;
	
		@FindBy (xpath="//span[@class='cancel-button global-action z-button']")
	public
	WebElement btn_annuler;	
	
	@FindBy (xpath="//li[@id='eVDP45']//span[text()=\"Modifier\"]")
	public
	WebElement creer_critere_modifier;
	
	@FindBy (xpath="//input[@id='a35Xe5']")
	public
	WebElement champs_critere_nom;
	
	@FindBy (xpath="//textarea[@id='lKcYt5']")
	public
	WebElement champs_critere_description;
	
	// On constate que le code xml est différent pour 2 champs tetes de même nature : textarea et input
	
	@FindBy (xpath="//td[(text()='PARTICIPANT')]/ancestor::i/descendant::input']")
	public
	WebElement type_creer_critere;
	
	
	public PageCritere clicBtnAnnuler(WebDriver driver) {
		btn_annuler.click();
		return PageFactory.initElements(driver, PageCritere.class);
	}
	
	public PageCritere clicBtnEnregistrer(WebDriver driver) {
		btn_enregistrer.click();
		return PageFactory.initElements(driver, PageCritere.class);
	}
	
	public PageCritere clicBtnSauvegarderContinuer(WebDriver driver) {
		btn_sauvegarder_continuer.click();
		return PageFactory.initElements(driver, PageCritere.class);
	}
	
	
}
