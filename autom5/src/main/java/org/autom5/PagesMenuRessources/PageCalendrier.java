package org.autom5.PagesMenuRessources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCalendrier {
	
	@FindBy (xpath="//span[@class='create-button global-action z-button']")
	public
	WebElement btn_creer;
	
	@FindBy (xpath="//div[@class='z-dottree-header']//div[(text()='Nom')]")
	public
	WebElement calendrier_nom;
	
	@FindBy (xpath="//div[@class='z-dottree-header']//div[(text()='Hérité de la date')]")
	public
	WebElement calendrier_date;
	
	@FindBy (xpath="//div[@class='z-dottree-header']//div[(text()='Héritages à jour')]")
	public
	WebElement calendrier_heritages;	
	
	@FindBy (xpath="//div[@class='z-dottree-header']//div[(text()='Opérations')]")
	public
	WebElement calendrier_operations;				
	
	@FindBy (xpath="//div[@class='z-window-embedded-hl']//div[contains(text(), 'Liste')]") 
	public
	WebElement calendrier_titre;
	
	@FindBy (xpath="//div[@class='z-dottree']//span[@class][text()='Calendrier - Test 1']") 
	public
	WebElement calendrier_tableau_test1;
	
	@FindBy (xpath="//div[@class='z-dottree']//span[@class][text()='Calendrier - Test 1']//ancestor::tr//span[@title='Supprimer']") 
	public
	WebElement calendrier_supression_titre_tableau;
	
	@FindBy (xpath="//div[@class='z-dottree']//span[@class][text()='Calendrier - Test 1']//ancestor::tr//span[@title='Modifier']") 
	public
	WebElement calendrier_modification_titre_tableau;
	
	@FindBy (xpath="//div[@class='z-dottree']//span[@class][text()='Calendrier - Test 1']//ancestor::tr//span[@title='Créer une dérive']") 
	public
	WebElement calendrier_derive_titre_tableau;
	
	@FindBy (xpath="//div[@class='z-dottree']//span[@class][text()='Calendrier - Test 1']//ancestor::tr//span[@title='Créer une copie']") 
	public
	WebElement calendrier_copie_titre_tableau;
	
	
	
	public PageFormulaireCalendrier clicBtnCreer(WebDriver driver) {
		btn_creer.click();
		return PageFactory.initElements(driver, PageFormulaireCalendrier.class);
	}
	

}
