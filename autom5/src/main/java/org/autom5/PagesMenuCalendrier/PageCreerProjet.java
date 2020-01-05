package org.autom5.PagesMenuCalendrier;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCreerProjet {
	
	
	
	
	//Acc�der au formulaire de cr�ation d'un projet
	
	
	//Cliquer sur l'ic�ne "Cr�er un nouveau projet" (1�re ic�ne "+" situ�e en dessous du logo "LibrePlan")
	
	  //ic�ne cr�er un projet
	  @FindBy (xpath="//span[@class='planner-icon z-button']//img") public
	  WebElement btn_creerprojet;	
	
	  
	  
	  //Popup qui s'affiche: cr�er un projet - Nom champ de saisie non renseign�
	  //LABEL NOM
	  @FindBy (xpath="//span[contains(text(),'Nom')]") public
	  WebElement label_nomprojet;	
	  	  
	  //Popup qui s'affiche: cr�er un projet - Nom champ de saisie non renseign�
	  //CHAMP DE SAISIE NOM - NON RENSEIGNE
	  @FindBy (xpath="//td[contains(., 'Nom')]/following-sibling::td[1]") public
	  WebElement input_nomprojet;	
	
	  
	  
	  
	  //Mod�le : Liste d�roulante non renseign�e
	  //LABEL MODELE 
	  @FindBy (xpath="//span[contains(text(),'Mod�le')]") public
	 //id dynamique attention, prendre une partie de l'id ? 
	  WebElement label_modeleprojet;	
	
	  	    
	  //Mod�le : Liste d�roulante non renseign�e
	  //LISTE DEROULANTE MODELE non renseign�e
	  @FindBy (xpath="//input[contains(@id,'v7-real')]") public
	 //id dynamique attention, prendre une partie de l'id ? 
	  WebElement input_modeleprojet;	
	
	
	  
	  //Code 1 : Code : Champ de saisie renseign� avec une valeur par d�faut non modifiable et gris�. 
	  //La case "G�n�rer le code" associ�e � ce champ est coch�e par d�faut</p> 
	  //LABEL CODE 
	  @FindBy (xpath="//span[contains(text(),'Code')]") public
	 //id dynamique attention, prendre une partie de l'id ? 
	  WebElement label_codeprojet;	
	
	  	   
	  
	  //CODE 2: Champ de saisie renseign� avec une valeur par d�faut non modifiable et gris�
	  //CHAMP SAISIE CODE GRISE VALEUR PAR DEFAUT NON MODIFIABLE + GRIS�
	  @FindBy (xpath="//input[contains(@value,'ORDER')]") public
	 	  // ALTERNATIVE AVEC objet code dans le XPATH
	  // @FindBy (xpath="//td[contains(., 'Code')]/following-sibling::td[1]/div//td[1]//input[@type='text']\")
	 	  WebElement input_codeprojet;	
	
	  //CODE 3: Champ de saisie renseign� avec une valeur par d�faut non modifiable et gris�
	  // CHECKBOX ASSOCIEE � "GENERER LE CODE"
	  @FindBy (xpath="//div[@class='z-row-cnt z-overflow-hidden']//table//span[@class='z-checkbox']//input") public
	  WebElement checkbox_codeprojet;	
	  
	  
	  //CODE 4 : Champ de saisie renseign� avec une valeur par d�faut non modifiable et gris�
	  // CHECKBOX ASSOCIEE � GENERER LE CODE
	  @FindBy (xpath="//label[contains(text(),'G�n�rer le code')]") public
	  WebElement labelcheckbox_codeprojet;	
	  
	  
	  
	  	
	  
	  
	//DATE DE DEBUT 1 : champ de saisie de date associ� � un calendrier. 
	//Par d�faut, la date affich�e est la date du jour. 
	//Le format de la date correspond � l'exemple suivant : "25 janv. 2017"
		//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']
	  //CHAMP VALEUR DATE DEBUT
	  @FindBy (xpath="//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']") public
	  WebElement datedebut_codeprojet;	
	  
	//DATE DE DEBUT 2 : champ de saisie de date associ� � un calendrier. 
		//Par d�faut, la date affich�e est la date du jour. 
		//Le format de la date correspond � l'exemple suivant : "25 janv. 2017"
	  //BOUTON CALENDRIER
		@FindBy (xpath="//i[@class='z-datebox-btn z-datebox-btn-clk']") public
		WebElement bouton_datedebutprojet;  
	  
	  
	  
	  
	  
	//ECHEANCE 1 : champ de saisie de date associ� � un calendrier. 
		//Par d�faut, le champ n'est pas renseign� 
		  @FindBy (xpath="//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']") public
		  WebElement dateecheance_projet;		  
	  
		  
			//ECHEANCE 2 : champ de saisie de date associ� � un calendrier. 
				//Par d�faut, le champ n'est pas renseign� 
		  //BOUTON CALENDRIER
				  @FindBy (xpath="//td[contains(., 'Ech�ance')]/following-sibling::td[1]/div//input[@type='text'][1]") public
				  WebElement bouton_echeanceprojet;		  
		  
				  
				  
				  
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
					 WebElement input_clientprojet;			
				  
					 
					//CALENDRIER 1 : Liste d�roulante avec pour valeur par d�faut "Default"</p> 
						
					 //LABEL CALENDRIER
					  @FindBy (xpath="//div[@class='z-row-cnt z-overflow-hidden']//span[@class='z-label'][contains(text(),'Calendrier')]") public
					  WebElement label_calendrierprojet;							   
					//div[@class='z-row-cnt z-overflow-hidden']//span[@class='z-label'][contains(text(),'Calendrier')]			 
					 
					  
					  
					  
					//CALENDRIER 2 : Liste d�roulante avec pour valeur par d�faut "Default"</p> 
						
					//COMBOBOX CALENDRIER
					 @FindBy (xpath="//td[contains(., 'Calendrier')]/following-sibling::td[1]//i[contains(@class,'combobox')]/input") public
					 WebElement label_calendrierprojet;							   
						//div[@class='z-row-cnt z-overflow-hidden']//span[@class='z-label'][contains(text(),'Calendrier')]			 
					
					  
					 
					 
					//BOUTON ACCEPTER : 
						
						//
				 @FindBy (xpath="//td[contains(text(),'Accepter')]") public
				 WebElement bouton_accepterprojet;							   
				 		 
				 
					//BOUTON ANNULER : 
						
						//
				 @FindBy (xpath="//td[contains(text(),'Annuler')]") public
				 WebElement bouton_annulerprojet;							   
				 		 	
					 
				
				 
				 
				 
				//td[contains(text(),'Annuler')]
				 
				 
				//span[contains(text(),'Client')]
		  
	  
	//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']
	  
	  
	
	<p>Affichage d'une pop-up "Cr�er un nouveau projet" contenant les �l�ments suivants :</p> 
	<p>�</p> 
	<p>- Nom : Champ de saisie non renseign�</p> 
	<p>- Mod�le : Liste d�roulante non renseign�e</p> 
	<p>- Code : Champ de saisie renseign� avec une valeur par d�faut non modifiable et gris�. La case "G�n�rer le code" associ�e � ce champ est coch�e par d�faut</p> 
	<p>- Date de d�but : champ de saisie de date associ� � un calendrier. Par d�faut, la date affich�e est la date du jour. Le format de la date correspond � l'exemple suivant : "25 janv. 2017"</p> 
	<p>- Ech�ance : champ de saisie de date associ� � un calendrier. Par d�faut, le champ n'est pas renseign�.</p> 
	<p>- Client : Champ de saisie non renseign�</p> 
	<p>- Calendrier : Liste d�roulante avec pour valeur par d�faut "Default"</p> 
	<p>- Boutons [Accepter] et [Annuler]</p> 

	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @FindBy (xpath="//table[@id='lKcYh6-box']//td[@class='z-button-cm']") public
	 * WebElement btn_enregistrer;
	 * 
	 * @FindBy
	 * (xpath="//span[@class='saveandcontinue-button global-action z-button']")
	 * public WebElement btn_sauvegarder_continuer;
	 * 
	 * @FindBy (xpath="//span[@class='cancel-button global-action z-button']")
	 * public WebElement btn_annuler;
	 * 
	 * @FindBy (xpath="//li[@id='eVDP45']//span[text()=\"Modifier\"]") public
	 * WebElement creer_critere_modifier;
	 * 
	 * @FindBy (xpath="//input[@id='a35Xe5']") public WebElement champs_critere_nom;
	 * 
	 * @FindBy (xpath="//textarea[@id='lKcYt5']") public WebElement
	 * champs_critere_description;
	 * 
	 * // On constate que le code xml est différent pour 2 champs tetes de même
	 * nature : textarea et input
	 * 
	 * @FindBy
	 * (xpath="//td[(text()='PARTICIPANT')]/ancestor::i/descendant::input']") public
	 * WebElement type_creer_critere;
	 * 
	 * 
	 * public PageCritere clicBtnAnnuler(WebDriver driver) { btn_annuler.click();
	 * return PageFactory.initElements(driver, PageCritere.class); }
	 * 
	 * public PageCritere clicBtnEnregistrer(WebDriver driver) {
	 * btn_enregistrer.click(); return PageFactory.initElements(driver,
	 * PageCritere.class); }
	 * 
	 * public PageCritere clicBtnSauvegarderContinuer(WebDriver driver) {
	 * btn_sauvegarder_continuer.click(); return PageFactory.initElements(driver,
	 * PageCritere.class); }
	 */
	
}
