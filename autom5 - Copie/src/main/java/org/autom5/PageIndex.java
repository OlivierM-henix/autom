package org.autom5;

import org.autom5.PagesMenuCalendrier.PageCreerProjet;
import org.autom5.PagesMenuRessources.PageCritere;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageIndex extends PageAbstract {
	
	
	
		@FindBy (xpath="//td[contains(text(),'Détail du projet')]") public
		WebElement detailprojet;	
	
	
	
	  @FindBy (xpath="//span[@class='planner-icon z-button']//img") public
	  WebElement btn_creerprojet;
	
	  public PageCreerProjet creerprojet (WebDriver driver) {
			btn_creerprojet.click();
			return PageFactory.initElements(driver, PageCreerProjet.class);

	  }
			
		
			
		
			
			
}