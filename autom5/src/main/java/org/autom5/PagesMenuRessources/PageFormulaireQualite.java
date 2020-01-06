package org.autom5.PagesMenuRessources;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageFormulaireQualite {

	@FindBy(xpath="//div[@class='clickable-rows z-grid']//div[(text()='Nom')]")
	public
	WebElement cln_nom;
	
	@FindBy(xpath="//div[@class='clickable-rows z-grid']//div[(text()='Description')]")
	public
	WebElement cln_description;
	
	@FindBy(xpath="//div[@class='clickable-rows z-grid']//div[(text()='Opérations')]")
	public
	WebElement cln_operations;
	
	@FindBy(xpath="//div[@class=\"z-window-embedded\"]//input[@class=\"z-textbox\"]")
	public
	WebElement champ_filtre;
	
	@FindBy(xpath="//div[@class=\"z-window-embedded\"]//td[text()=\"Filtre\"]")
	public
	WebElement btn_filtre;
	
	@FindBy(xpath="//table[@class=\"z-button-focus\"]//td[text()=\"Créer\"]")
	public
	WebElement btn_creer;
	
}

