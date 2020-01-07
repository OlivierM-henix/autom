package org.autom5.PagesMenuRessources;

import org.autom5.OutilTechnique;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFormulaireCalendrier {
	
	@FindBy (xpath="//td[@class='z-button-cm'][text()='Enregistrer']")
	public
	WebElement btn_enregistrer;
			
	@FindBy (xpath="//span[@class='saveandcontinue-button global-action z-button']")
	public
	WebElement btn_sauvegarder_continuer;
	
	@FindBy (xpath="//span[@class='cancel-button global-action z-button']")
	public
	WebElement btn_annuler;	
	
	@FindBy (xpath="//span[@class='z-label'][text()='Nom']/ancestor::tr//input[@class='z-textbox']")
	public
	WebElement champs_calendrier_nom;
	
	@FindBy (xpath="//tr[@class='calendar-data z-row z-grid-odd']//span[text()='Dérivé du calendrier Calendrier - Test 1']")
	public
	WebElement type_calendrier;
	
	@FindBy (xpath="//div[@class='message_WARNING']//span[text()='Calendrier - Test 1 existe déjà']")
	public
	WebElement erreur1_calendrier;
	
	@FindBy (xpath="//div[@class='message_INFO']//span[text()='Calendrier - Test Calendrier Dérivé']")
	public
	WebElement validation_calendrier;
	
		
	
	public PageCalendrier clicBtnAnnuler(WebDriver driver) {
		btn_annuler.click();
		return PageFactory.initElements(driver, PageCalendrier.class);
	}
	
	public PageCalendrier clicBtnEnregistrer(WebDriver driver) {
		btn_enregistrer.click();
		return PageFactory.initElements(driver, PageCalendrier.class);
	}
	
	public PageCalendrier clicBtnSauvegarderContinuer(WebDriver driver) {
		btn_sauvegarder_continuer.click();
		return PageFactory.initElements(driver, PageCalendrier.class);
	}
	
	
	

	
	

}
