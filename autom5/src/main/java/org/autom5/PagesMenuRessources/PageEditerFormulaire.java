package org.autom5.PagesMenuRessources;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageEditerFormulaire {
	//WebElements dans le formulaire :
	
		@FindBy(xpath="//tbody[@class=\"z-rows\"]//span[text()=\"Nom\"]")
		public
		WebElement lgn_nom;
		
		@FindBy(xpath="//tbody[@class=\"z-rows\"]//span[text()=\"Description\"]")
		public
		WebElement lgn_description;
		
		@FindBy(xpath="//table[@class=\"z-button-focus\"]//td[text()=\"Type de formulaire qualité\"]")
		public
		WebElement lgn_type;
		
		@FindBy(xpath="//table[@class=\"z-button-focus\"]//td[text()=\"Avancement du rapport\"]")
		public
		WebElement lgn_avancement;
		
		@FindBy(xpath="//tbody[@class=\"z-rows\"]//input[@class=\"focus-element z-textbox z-textbox-text-invalid\"]")
		public
		WebElement champ_nom;
		
		@FindBy(xpath="//tbody[@class=\"z-rows\"]//textarea[@class=\"z-textbox\"]")
		public
		WebElement champ_description;
		
		@FindBy(xpath="//tbody[@class=\"z-rows\"]//select")
		public
		WebElement select_type;
		Select select = new Select(select_type);
		
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
		
		
}
