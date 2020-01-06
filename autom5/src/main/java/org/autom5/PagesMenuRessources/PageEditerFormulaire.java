package org.autom5.PagesMenuRessources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageEditerFormulaire {
	//WebElements dans le formulaire :

	@FindBy(xpath="//span[text()=\"Nom\"]")
	public
	WebElement lgn_nom;

	@FindBy(xpath="//span[text()=\"Description\"]")
	public
	WebElement lgn_description;

	@FindBy(xpath="//span[text()=\"Type de formulaire qualité\"]")
	public
	WebElement lgn_type;

	@FindBy(xpath="//span[text()=\"Avancement du rapport\"]")
	public
	WebElement lgn_avancement;

	@FindBy(xpath="//div[@class=\"z-grid-body\"]//tr[1]/td[2]")
	public
	WebElement champ_nom;

	@FindBy(xpath=""
			+ "//div[@class=\"z-grid-body\"]//tr[2]/td[2]")
	public
	WebElement champ_description;

	@FindBy(xpath="//select")
	public
	WebElement select_type;

	//		@FindBy(xpath="//tbody[@class=\"z-rows\"]//select/option[text()=\"par pourcentage\"]")
	//		public
	//		WebElement select_type_0;
	//	
	//		@FindBy(xpath="//tbody[@class=\"z-rows\"]//select/option[text()=\"par élément\"]")
	//		public
	//		WebElement select_type_1;

	@FindBy(xpath="//input[@type=\"checkbox\"]")
	public
	WebElement checkbox_avancement;

	//WebElement dans la section "Liste"

	@FindBy(xpath="//td[text()=\"Nouvel élément du formulaire qualité\"]")
	public
	WebElement btn_nvlelement;

	@FindBy(xpath="//div[@class=\"z-panel\"]//div[@class=\"z-grid\"]//tbody[2]//div[text()=\"Nom\"]")
	public
	WebElement cln_nom;

	@FindBy(xpath="//div[@class=\"z-panel\"]//div[@class=\"z-grid\"]//tbody[2]//div[text()=\"Position\"]")
	public
	WebElement cln_position;

	@FindBy(xpath="//div[@class=\"z-panel\"]//div[@class=\"z-grid\"]//tbody[2]//div[text()=\"Opérations\"]")
	public
	WebElement cln_operations;

	//Boutons
	@FindBy(xpath="//td[text()=\"Enregistrer\"]")
	public
	WebElement btn_enregistrer;

	@FindBy(xpath="//td[text()=\"Sauver et continuer\"]")
	public
	WebElement btn_sauver_continuer;

	@FindBy(xpath="Annuler")
	public
	WebElement btn_annuler;
}
