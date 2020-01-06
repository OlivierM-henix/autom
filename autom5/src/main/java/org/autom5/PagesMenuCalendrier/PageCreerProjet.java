package org.autom5.PagesMenuCalendrier;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageCreerProjet {


	WebDriver driver;

	//Accéder au formulaire de création d'un projet
	//Cliquer sur l'icône "Créer un nouveau projet" (1ère icône "+" située en dessous du logo "LibrePlan")
	//icône créer un projet

	//Popup qui s'affiche: créer un projet - Nom champ de saisie non renseigné
	//LABEL NOM
	@FindBy (xpath="//span[contains(text(),'Nom')]") public 
	WebElement label_nomprojet;	

	//Popup qui s'affiche: créer un projet - Nom champ de saisie non renseigné
	//CHAMP DE SAISIE NOM - NON RENSEIGNE
	@FindBy (xpath="//td[contains(., 'Nom')]/following-sibling::td[1]") public
	WebElement input_nomprojet;	




	//Modèle : Liste déroulante non renseignée
	//LABEL MODELE 
	/**
	 * @return the label_nomprojet
	 */
	public  WebElement getLabel_nomprojet() {
		return label_nomprojet;
	}
	/**
	 * @param label_nomprojet the label_nomprojet to set
	 */
	public void setLabel_nomprojet(WebElement label_nomprojet) {
		this.label_nomprojet = label_nomprojet;
	}
	/**
	 * @return the label_modeleprojet
	 */
	public WebElement getLabel_modeleprojet() {
		return label_modeleprojet;
	}
	/**
	 * @param label_modeleprojet the label_modeleprojet to set
	 */
	public void setLabel_modeleprojet(WebElement label_modeleprojet) {
		this.label_modeleprojet = label_modeleprojet;
	}
	/**
	 * @return the label_codeprojet
	 */
	public WebElement getLabel_codeprojet() {
		return label_codeprojet;
	}
	/**
	 * @param label_codeprojet the label_codeprojet to set
	 */
	public void setLabel_codeprojet(WebElement label_codeprojet) {
		this.label_codeprojet = label_codeprojet;
	}
	/**
	 * @return the labelcheckbox_codeprojet
	 */
	public WebElement getLabelcheckbox_codeprojet() {
		return labelcheckbox_codeprojet;
	}
	/**
	 * @param labelcheckbox_codeprojet the labelcheckbox_codeprojet to set
	 */
	public void setLabelcheckbox_codeprojet(WebElement labelcheckbox_codeprojet) {
		this.labelcheckbox_codeprojet = labelcheckbox_codeprojet;
	}
	/**
	 * @return the label_clientprojet
	 */
	public WebElement getLabel_clientprojet() {
		return label_clientprojet;
	}
	/**
	 * @param label_clientprojet the label_clientprojet to set
	 */
	public void setLabel_clientprojet(WebElement label_clientprojet) {
		this.label_clientprojet = label_clientprojet;
	}
	/**
	 * @return the label_calendrierprojet
	 */
	public WebElement getLabel_calendrierprojet() {
		return label_calendrierprojet;
	}
	/**
	 * @param label_calendrierprojet the label_calendrierprojet to set
	 */
	public void setLabel_calendrierprojet(WebElement label_calendrierprojet) {
		this.label_calendrierprojet = label_calendrierprojet;
	}
	@FindBy (xpath="//span[contains(text(),'Modèle')]") public
	//id dynamique attention, prendre une partie de l'id ? 
	WebElement label_modeleprojet;	


	//Modèle : Liste déroulante non renseignée
	//LISTE DEROULANTE MODELE non renseignée
	@FindBy (xpath="//input[contains(@id,'v7-real')]") public
	//id dynamique attention, prendre une partie de l'id ? 
	WebElement input_modeleprojet;	



	//Code 1 : Code : Champ de saisie renseigné avec une valeur par défaut non modifiable et grisé. 
	//La case "Générer le code" associée à ce champ est cochée par défaut</p> 
	//LABEL CODE 
	@FindBy (xpath="//span[contains(text(),'Code')]") public
	//id dynamique attention, prendre une partie de l'id ? 
	WebElement label_codeprojet;	



	//CODE 2: Champ de saisie renseigné avec une valeur par défaut non modifiable et grisé
	//CHAMP SAISIE CODE GRISE VALEUR PAR DEFAUT NON MODIFIABLE + GRISé
	@FindBy (xpath="//input[contains(@value,'ORDER')]") public
	// ALTERNATIVE AVEC objet code dans le XPATH
	// @FindBy (xpath="//td[contains(., 'Code')]/following-sibling::td[1]/div//td[1]//input[@type='text']\")
	WebElement input_codeprojet;	

	//CODE 3: Champ de saisie renseigné avec une valeur par défaut non modifiable et grisé
	// CHECKBOX ASSOCIEE à "GENERER LE CODE"
	@FindBy (xpath="//div[@class='z-row-cnt z-overflow-hidden']//table//span[@class='z-checkbox']//input") public
	WebElement checkbox_codeprojet;	

	public WebElement checkbox = driver.findElement(By.xpath("//div[@class='z-row-cnt z-overflow-hidden']//table//span[@class='z-checkbox']//input"));
	//checkbox.click();
	List<WebElement> checkboxOptions = driver.findElements(By.xpath("/../.."));
	//checkboxOptions.get(0).isSelected();
	//checkboxOptions.get(1).getAttribute("value");
	//checkboxOptions.get(1).click();




	//CODE 4 : Champ de saisie renseigné avec une valeur par défaut non modifiable et grisé
	// CHECKBOX ASSOCIEE à GENERER LE CODE
	/**
	 * @return the checkboxOptions
	 */
	public List<WebElement> getCheckboxOptions() {
		return checkboxOptions;
	}
	/**
	 * @param checkboxOptions the checkboxOptions to set
	 */
	public void setCheckboxOptions(List<WebElement> checkboxOptions) {
		this.checkboxOptions = checkboxOptions;
	}


	@FindBy (xpath="//label[contains(text(),'Générer le code')]") public
	WebElement labelcheckbox_codeprojet;	




	//DATE DE DEBUT 1 : champ de saisie de date associé à un calendrier. 
	//Par défaut, la date affichée est la date du jour. 
	//Le format de la date correspond à l'exemple suivant : "25 janv. 2017"
	//LABEL DATE DEBUT PROJET
	//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']
	//CHAMP VALEUR DATE DEBUT
	@FindBy (xpath="//span[contains(text(),'Date de début')]") public
	WebElement label_datedebut_projet;	

	//DATE DE DEBUT 2 : champ de saisie de date associé à un calendrier. 
	//Par défaut, la date affichée est la date du jour. 
	//Le format de la date correspond à l'exemple suivant : "25 janv. 2017"
	//DATE DEBUT PROJET
	//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']
	//CHAMP VALEUR DATE DEBUT
	@FindBy (xpath="//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']") public
	WebElement datedebut_projet;	

	//DATE DE DEBUT 3 : champ de saisie de date associé à un calendrier. 
	//Par défaut, la date affichée est la date du jour. 
	//Le format de la date correspond à l'exemple suivant : "25 janv. 2017"
	//BOUTON CALENDRIER
	//@FindBy (xpath="//i[@class='z-datebox-btn z-datebox-btn-clk']") public
	//WebElement bouton_datedebutprojet;  

	public WebElement datedebutprojet = driver.findElement(By.xpath("//i[@class='z-datebox-btn z-datebox-btn-clk']"));
	Select select = new Select(datedebutprojet);

	//ECHEANCE 1 : champ de saisie de date associé à un calendrier. 
	//Par défaut, le champ n'est pas renseigné 
	@FindBy (xpath="//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']") public
	WebElement label_dateecheance_projet;		  

	//ECHEANCE 2 : champ de saisie de date associé à un calendrier. 
	//Par défaut, le champ n'est pas renseigné 
	//CHAMP VALEUR DATE ECHEANCE
	@FindBy (xpath="//td[contains(., 'Echéance')]/following-sibling::td[1]/div//input[@type='text'][1]") public
	WebElement input_dateecheanceprojet;		  

	//ECHEANCE 3 : champ de saisie de date associé à un calendrier. 
	//Par défaut, le champ n'est pas renseigné 
	//BOUTON CALENDRIER
	@FindBy (xpath="//i[@class='z-datebox-btn z-datebox-btn-clk']") public
	WebElement bouton_dateecheanceprojet;		  

	//CLIENT 1 : Champ de saisie non renseigné. 
	//LABEL CLIENT
	@FindBy (xpath="//span[contains(text(),'Client')]") public
	WebElement label_clientprojet;				  

	//CLIENT 2 : Champ de saisie non renseigné. 
	//CHAMP DE SAISIE
	@FindBy (xpath="//td[contains(., 'Client')]/following-sibling::td[1]//input") public
	WebElement input_clientprojet;				  

	//CLIENT 3 : Champ de saisie non renseigné. 
	//BOUTON RECHERCHE
	@FindBy (xpath="//td[contains(., 'Client')]/following-sibling::td[1]//i[contains(@class,'btn')]") public
	WebElement bouton_clientprojet;			

	//CALENDRIER 1 : Liste déroulante avec pour valeur par défaut "Default"</p> 
	//LABEL CALENDRIER
	@FindBy (xpath="//div[@class='z-row-cnt z-overflow-hidden']//span[@class='z-label'][contains(text(),'Calendrier')]") public
	WebElement label_calendrierprojet;							   
	//div[@class='z-row-cnt z-overflow-hidden']//span[@class='z-label'][contains(text(),'Calendrier')]			 

	//CALENDRIER 2 : Liste déroulante avec pour valeur par défaut "Default"</p> 
	//COMBOBOX CALENDRIER
	@FindBy (xpath="//td[contains(., 'Calendrier')]/following-sibling::td[1]//i[contains(@class,'combobox')]/input") public
	WebElement combobox_calendrierprojet;							   
	//div[@class='z-row-cnt z-overflow-hidden']//span[@class='z-label'][contains(text(),'Calendrier')]			 

	//BOUTON ACCEPTER : 
	//
	@FindBy (xpath="//td[contains(text(),'Accepter')]") public
	WebElement bouton_accepterprojet;							   

	//BOUTON ANNULER : 
	//
	/**
	 * @return the input_nomprojet
	 */
	public WebElement getInput_nomprojet() {
		return input_nomprojet;
	}
	/**
	 * @param input_nomprojet the input_nomprojet to set
	 */
	public void setInput_nomprojet(WebElement input_nomprojet) {
		this.input_nomprojet = input_nomprojet;
	}
	/**
	 * @return the input_modeleprojet
	 */
	public WebElement getInput_modeleprojet() {
		return input_modeleprojet;
	}
	/**
	 * @param input_modeleprojet the input_modeleprojet to set
	 */
	public void setInput_modeleprojet(WebElement input_modeleprojet) {
		this.input_modeleprojet = input_modeleprojet;
	}
	/**
	 * @return the input_codeprojet
	 */
	public WebElement getInput_codeprojet() {
		return input_codeprojet;
	}
	/**
	 * @param input_codeprojet the input_codeprojet to set
	 */
	public void setInput_codeprojet(WebElement input_codeprojet) {
		this.input_codeprojet = input_codeprojet;
	}
	/**
	 * @return the input_clientprojet
	 */
	public WebElement getInput_clientprojet() {
		return input_clientprojet;
	}
	/**
	 * @param input_clientprojet the input_clientprojet to set
	 */
	public void setInput_clientprojet(WebElement input_clientprojet) {
		this.input_clientprojet = input_clientprojet;
	}
	@FindBy (xpath="//td[contains(text(),'Annuler')]") public
	WebElement bouton_annulerprojet;							  
}
