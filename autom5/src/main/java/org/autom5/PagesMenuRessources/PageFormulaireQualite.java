package org.autom5.PagesMenuRessources;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}


//La page contient :
//
//- un tableau avec les colonnes suivantes :
//
//Nom
//Description
//Opérations
//- un champ de saisie "Filtrer les formulaires qualité par: nom" associé à un bouton [Filtre]
//
// 
//
//- un bouton [Créer]

//Les entetes de colonne 1, 2 et 3 : tr[@id="hZ3Qt4"]/th