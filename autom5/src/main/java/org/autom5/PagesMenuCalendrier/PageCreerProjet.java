package org.autom5.PagesMenuCalendrier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCreerProjet {


	WebDriver driver;

	//Popup qui s'affiche: créer un projet - Nom champ de saisie non renseigné
	//LABEL NOM
	@FindBy (xpath="//span[contains(text(),'Nom')]") public 
	WebElement label_nomprojet;	

	//Popup qui s'affiche: créer un projet - Nom champ de saisie non renseigné
	//CHAMP DE SAISIE NOM - NON RENSEIGNE
	@FindBy (xpath="//input[contains(@class,'z-textbox z-textbox-text-invalid']") public
	WebElement input_nomprojet;	

	//Modèle : Liste déroulante non renseignée
	//LABEL MODELE 
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

	@FindBy (xpath="//label[contains(text(),'Générer le code')]") public
	WebElement labelcheckbox_codeprojet;	

	//CHAMP VALEUR DATE DEBUT
	@FindBy (xpath="//span[contains(text(),'Date de début')]") public
	WebElement label_datedebut_projet;	

	//CHAMP VALEUR DATE DEBUT
	@FindBy (xpath="//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']") public
	WebElement datedebut_projet;	

	//DATE DE DEBUT 3 : champ de saisie de date associé à un calendrier. 
	//BOUTON CALENDRIER
	@FindBy (xpath="//i[@class='z-datebox-btn z-datebox-btn-clk']") public
	WebElement bouton_datedebutprojet;  

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

	//CALENDRIER 2 : Liste déroulante avec pour valeur par défaut "Default"</p> 
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
