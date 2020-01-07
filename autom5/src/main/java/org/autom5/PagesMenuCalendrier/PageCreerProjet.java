package org.autom5.PagesMenuCalendrier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCreerProjet {


	WebDriver driver;

<<<<<<< HEAD
	//Popup qui s'affiche: cr�er un projet - Nom champ de saisie non renseign�
=======
	//Acc�der au formulaire de cr�ation d'un projet
	//Cliquer sur l'ic�ne "Cr�er un nouveau projet" (1�re ic�ne "+" situ�e en dessous du logo "LibrePlan")
	//ic�ne cr�er un projet

	//Popup qui s'affiche: cr�er un projet - Nom champ de saisie non renseign�
>>>>>>> 465f361bd5ee5ec36a8562f2b3002365a1097672
	//LABEL NOM
	@FindBy (xpath="//span[contains(text(),'Nom')]") public 
	WebElement label_nomprojet;	

	//Popup qui s'affiche: cr�er un projet - Nom champ de saisie non renseign�
	//CHAMP DE SAISIE NOM - NON RENSEIGNE
	@FindBy (xpath="//input[contains(@class,'z-textbox z-textbox-text-invalid']") public
	WebElement input_nomprojet;	

<<<<<<< HEAD
	//Mod�le : Liste d�roulante non renseign�e
	//LABEL MODELE 
	@FindBy (xpath="//span[contains(text(),'Mod�le')]") public
	//id dynamique attention, prendre une partie de l'id ? 
	WebElement label_modeleprojet;	

	//Mod�le : Liste d�roulante non renseign�e
	//LISTE DEROULANTE MODELE non renseign�e
=======



	//Mod�le : Liste d�roulante non renseign�e
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


	//Mod�le : Liste d�roulante non renseign�e
	//LISTE DEROULANTE MODELE non renseign�e
>>>>>>> 465f361bd5ee5ec36a8562f2b3002365a1097672
	@FindBy (xpath="//input[contains(@id,'v7-real')]") public
	//id dynamique attention, prendre une partie de l'id ? 
	WebElement input_modeleprojet;	

<<<<<<< HEAD
	//Code 1 : Code : Champ de saisie renseign� avec une valeur par d�faut non modifiable et gris�. 
	//La case "G�n�rer le code" associ�e � ce champ est coch�e par d�faut</p> 
=======


	//Code 1 : Code : Champ de saisie renseign� avec une valeur par d�faut non modifiable et gris�. 
	//La case "G�n�rer le code" associ�e � ce champ est coch�e par d�faut</p> 
>>>>>>> 465f361bd5ee5ec36a8562f2b3002365a1097672
	//LABEL CODE 
	@FindBy (xpath="//span[contains(text(),'Code')]") public
	//id dynamique attention, prendre une partie de l'id ? 
	WebElement label_codeprojet;	

<<<<<<< HEAD
	//CODE 2: Champ de saisie renseign� avec une valeur par d�faut non modifiable et gris�
	//CHAMP SAISIE CODE GRISE VALEUR PAR DEFAUT NON MODIFIABLE + GRIS�
	@FindBy (xpath="//input[contains(@value,'ORDER')]") public
=======


	//CODE 2: Champ de saisie renseign� avec une valeur par d�faut non modifiable et gris�
	//CHAMP SAISIE CODE GRISE VALEUR PAR DEFAUT NON MODIFIABLE + GRIS�
	@FindBy (xpath="//td[@class=\"z-row-inner\"]//input[1]") public
>>>>>>> 465f361bd5ee5ec36a8562f2b3002365a1097672
	// ALTERNATIVE AVEC objet code dans le XPATH
	// @FindBy (xpath="//td[contains(., 'Code')]/following-sibling::td[1]/div//td[1]//input[@type='text']\")
	WebElement input_codeprojet;	

	//CODE 3: Champ de saisie renseign� avec une valeur par d�faut non modifiable et gris�
	// CHECKBOX ASSOCIEE � "GENERER LE CODE"
	@FindBy (xpath="//label[text()=\"Générer le code\"]") public
	WebElement checkbox_codeprojet;	

<<<<<<< HEAD
	@FindBy (xpath="//label[contains(text(),'G�n�rer le code')]") public
	WebElement labelcheckbox_codeprojet;	

=======
//	List<WebElement> checkboxOptions = driver.findElements(By.xpath("/../.."));
	//checkboxOptions.get(0).isSelected();
	//checkboxOptions.get(1).getAttribute("value");
	//checkboxOptions.get(1).click();




	//CODE 4 : Champ de saisie renseign� avec une valeur par d�faut non modifiable et gris�
	// CHECKBOX ASSOCIEE � GENERER LE CODE
	/**
	 * @return the checkboxOptions
	 */
//	public List<WebElement> getCheckboxOptions() {
//		return checkboxOptions;
//	}
//	/**
//	 * @param checkboxOptions the checkboxOptions to set
//	 */
//	public void setCheckboxOptions(List<WebElement> checkboxOptions) {
//		this.checkboxOptions = checkboxOptions;
//	}


	@FindBy (xpath="//label[contains(text(),'G�n�rer le code')]") public
	WebElement labelcheckbox_codeprojet;	




	//DATE DE DEBUT 1 : champ de saisie de date associ� � un calendrier. 
	//Par d�faut, la date affich�e est la date du jour. 
	//Le format de la date correspond � l'exemple suivant : "25 janv. 2017"
	//LABEL DATE DEBUT PROJET
	//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']
>>>>>>> 465f361bd5ee5ec36a8562f2b3002365a1097672
	//CHAMP VALEUR DATE DEBUT
	@FindBy (xpath="//span[contains(text(),'Date de d�but')]") public
	WebElement label_datedebut_projet;	

<<<<<<< HEAD
=======
	//DATE DE DEBUT 2 : champ de saisie de date associ� � un calendrier. 
	//Par d�faut, la date affich�e est la date du jour. 
	//Le format de la date correspond � l'exemple suivant : "25 janv. 2017"
	//DATE DEBUT PROJET
	//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']
>>>>>>> 465f361bd5ee5ec36a8562f2b3002365a1097672
	//CHAMP VALEUR DATE DEBUT
	@FindBy (xpath="//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']") public
	WebElement datedebut_projet;	

<<<<<<< HEAD
	//DATE DE DEBUT 3 : champ de saisie de date associ� � un calendrier. 
	//BOUTON CALENDRIER
	@FindBy (xpath="//i[@class='z-datebox-btn z-datebox-btn-clk']") public
	WebElement bouton_datedebutprojet;  
=======
	//DATE DE DEBUT 3 : champ de saisie de date associ� � un calendrier. 
	//Par d�faut, la date affich�e est la date du jour. 
	//Le format de la date correspond � l'exemple suivant : "25 janv. 2017"
	//BOUTON CALENDRIER
	//@FindBy (xpath="//i[@class='z-datebox-btn z-datebox-btn-clk']") public
	//WebElement bouton_datedebutprojet;  

//	public WebElement datedebutprojet = driver.findElement(By.xpath("//i[@class='z-datebox-btn z-datebox-btn-clk']"));
//	Select select = new Select(datedebutprojet);
>>>>>>> 465f361bd5ee5ec36a8562f2b3002365a1097672

	@FindBy (xpath="//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']") public
	WebElement datedebutprojet;
	
	//ECHEANCE 1 : champ de saisie de date associ� � un calendrier. 
	//Par d�faut, le champ n'est pas renseign� 
	@FindBy (xpath="//i[@class='z-datebox-btn z-datebox-btn-clk']") public
	WebElement label_dateecheance_projet;		  

	//ECHEANCE 2 : champ de saisie de date associ� � un calendrier. 
	//Par d�faut, le champ n'est pas renseign� 
	//CHAMP VALEUR DATE ECHEANCE
	@FindBy (xpath="//td[contains(., 'Ech�ance')]/following-sibling::td[1]/div//input[@type='text'][1]") public
	WebElement input_dateecheanceprojet;		  

	//ECHEANCE 3 : champ de saisie de date associ� � un calendrier. 
	//Par d�faut, le champ n'est pas renseign� 
	//BOUTON CALENDRIER
	@FindBy (xpath="//i[@class='z-datebox-btn z-datebox-btn-clk']") public
	WebElement bouton_dateecheanceprojet;		  

	//CLIENT 1 : Champ de saisie non renseign�. 
	//LABEL CLIENT
	@FindBy (xpath="//span[contains(text(),'Client')]") public
	WebElement label_clientprojet;				  

	//CLIENT 2 : Champ de saisie non renseign�. 
	//CHAMP DE SAISIE
	@FindBy (xpath="//td[contains(., 'Client')]/following-sibling::td[1]//input") public
	WebElement input_clientprojet;				  

	//CLIENT 3 : Champ de saisie non renseign�. 
	//BOUTON RECHERCHE
	@FindBy (xpath="//td[contains(., 'Client')]/following-sibling::td[1]//i[contains(@class,'btn')]") public
	WebElement bouton_clientprojet;			

	//CALENDRIER 1 : Liste d�roulante avec pour valeur par d�faut "Default"</p> 
	//LABEL CALENDRIER
	@FindBy (xpath="//div[@class='z-row-cnt z-overflow-hidden']//span[@class='z-label'][contains(text(),'Calendrier')]") public
	WebElement label_calendrierprojet;							   

	//CALENDRIER 2 : Liste d�roulante avec pour valeur par d�faut "Default"</p> 
	//COMBOBOX CALENDRIER
	@FindBy (xpath="//td[contains(., 'Calendrier')]/following-sibling::td[1]//i[contains(@class,'combobox')]/input") public
	WebElement combobox_calendrierprojet;							   			 

	//BOUTON ACCEPTER : 
	//
	@FindBy (xpath="//td[contains(text(),'Accepter')]") public
	WebElement bouton_accepterprojet;							   

	//BOUTON ANNULER : 
	//
	@FindBy (xpath="//td[contains(text(),'Annuler')]") public
	WebElement bouton_annulerprojet;							  
}
