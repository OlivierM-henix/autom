package org.autom5.PagesMenuRessources;

import org.autom5.PageAbstract;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageCritere extends PageAbstract {
	
	String btn = "Test bouton [Sauver et continuer]";
	
	@FindBy (xpath="//span[@class='create-button global-action z-button']")
	public
	WebElement btn_creer;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Nom')]")
	public
	WebElement critere_nom;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Code')]")
	public
	WebElement critere_code;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Type')]")
	public
	WebElement critere_type;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Activé')]")
	public
	WebElement critere_active;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//div[(text()='Opérations')]")
	public
	WebElement critere_operations;				
	
	@FindBy (xpath="//div[@class='z-window-embedded-hl']//div[contains(text(), 'Liste')]") 
	public
	WebElement critere_titre;
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//span[@title=\"Test bouton [Sauver et continuer]\"]") 
	public
	WebElement critere_selection_titre_tableau;
	
		
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//span[@title=\"Test bouton [Sauver et continuer]\"]//ancestor::tr//span[@title='Supprimer']") 
	public
	WebElement critere_supression_titre_tableau;
	
	@FindBy (xpath="//div[@class=\"z-window-modal-cm\"]//td[@class='z-button-cm'][text()='OK']")
	public
	WebElement critere_valider_supression;	
	
	@FindBy (xpath="//div[@class=\"z-window-modal-cm\"]//td[@class='z-button-cm'][text()='Annuler']")
	public
	WebElement critere_annuler_supression;	
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//span[@title=\"Test bouton [Sauver et continuer]\"]//ancestor::tr//span[@title='Modifier']") 
	public
	WebElement critere_modification_titre_tableau;
	
	
	//methode verif disparation pop up en try and catch
	
	
	
	public PageCreerCritere clicBtnCreer(WebDriver driver) {
		btn_creer.click();
		return PageFactory.initElements(driver, PageCreerCritere.class);
	}



	public WebElement getCritere_nom() {
		return critere_nom;
	}



	public void setCritere_nom(WebElement critere_nom) {
		this.critere_nom = critere_nom;
	}



	public WebElement getCritere_code() {
		return critere_code;
	}



	public void setCritere_code(WebElement critere_code) {
		this.critere_code = critere_code;
	}



	public WebElement getCritere_type() {
		return critere_type;
	}



	public void setCritere_type(WebElement critere_type) {
		this.critere_type = critere_type;
	}



	public WebElement getCritere_active() {
		return critere_active;
	}



	public void setCritere_active(WebElement critere_active) {
		this.critere_active = critere_active;
	}
		
}


