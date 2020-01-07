package org.autom5.PagesMenuCalendrier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCreerProjet {

	WebDriver driver;

	@FindBy (xpath="//span[contains(text(),'Nom')]") public 
	WebElement txt_nomprojet;	

	@FindBy (xpath="//input[contains(@class,'z-textbox z-textbox-text-invalid']") public
	WebElement input_nomprojet;	

	@FindBy (xpath="//span[contains(text(),'Mod�le')]") public
	WebElement txt_modeleprojet;	

	@FindBy (xpath="//input[contains(@id,'v7-real')]") public
	WebElement input_modeleprojet;	
	
	@FindBy (xpath="//span[contains(text(),'Code')]") public
	WebElement label_codeprojet;	

	@FindBy (xpath="//td[@class=\"z-row-inner\"]//input[1]") public
	WebElement input_codeprojet;	

	@FindBy (xpath="//label[contains(text(),'G�n�rer le code')]") public
	WebElement labelcheckbox_codeprojet;	

	@FindBy (xpath="//div[@class='z-row-cnt z-overflow-hidden']//table//span[@class='z-checkbox']//input") public
	WebElement checkbox_codeprojet;
	
	@FindBy (xpath="//span[contains(text(),'Date de d�but')]") public
	WebElement label_datedebut_projet;	

	@FindBy (xpath="//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']") public
	WebElement datedebut_projet;	

	@FindBy (xpath="//i[@class='z-datebox-btn z-datebox-btn-clk']") public
	WebElement bouton_datedebutprojet;  

	@FindBy (xpath="//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']") public
	WebElement datedebutprojet;
	
	@FindBy (xpath="//i[@class='z-datebox-btn z-datebox-btn-clk']") public
	WebElement label_dateecheance_projet;		  

	@FindBy (xpath="//td[contains(., 'Ech�ance')]/following-sibling::td[1]/div//input[@type='text'][1]") public
	WebElement input_dateecheanceprojet;		  

	@FindBy (xpath="//i[@class='z-datebox-btn z-datebox-btn-clk']") public
	WebElement bouton_dateecheanceprojet;		  

	@FindBy (xpath="//span[contains(text(),'Client')]") public
	WebElement label_clientprojet;				  

	@FindBy (xpath="//td[contains(., 'Client')]/following-sibling::td[1]//input") public
	WebElement input_clientprojet;				  

	@FindBy (xpath="//td[contains(., 'Client')]/following-sibling::td[1]//i[contains(@class,'btn')]") public
	WebElement bouton_clientprojet;			

	@FindBy (xpath="//div[@class='z-row-cnt z-overflow-hidden']//span[@class='z-label'][contains(text(),'Calendrier')]") public
	WebElement label_calendrierprojet;							   

	@FindBy (xpath="//td[contains(., 'Calendrier')]/following-sibling::td[1]//i[contains(@class,'combobox')]/input") public
	WebElement combobox_calendrierprojet;							   			 

	@FindBy (xpath="//td[contains(text(),'Accepter')]") public
	WebElement bouton_accepterprojet;							   

	@FindBy (xpath="//td[contains(text(),'Annuler')]") public
	WebElement bouton_annulerprojet;							  
}
