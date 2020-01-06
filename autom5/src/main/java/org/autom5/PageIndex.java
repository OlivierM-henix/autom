package org.autom5;

import org.autom5.PagesMenuCalendrier.PageCreerProjet;
import org.autom5.PagesMenuRessources.PageCritere;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageIndex extends PageAbstract {


	@FindBy (xpath="//div[@class='z-tabs-header z-tabs-header-scroll']//ul[@class='z-tabs-cnt']") public
	WebElement MenuHorizontal;	
	//div[@class='z-tabs-header z-tabs-header-scroll']//ul[@class='z-tabs-cnt']	

	@FindBy (xpath="//td[contains(text(),'Détail du projet')]") public
	WebElement detailprojet;	


	//span[contains(text(),'WBS (tâches)')]
	@FindBy (xpath="//span[contains(text(),'WBS (tâches)')]") public 
	WebElement ong_WBStaches;	

	@FindBy (xpath="//span[@class='planner-icon z-button']//img") public
	WebElement btn_creerprojet;

	public PageCreerProjet creerprojet (WebDriver driver) {
		btn_creerprojet.click();
		return PageFactory.initElements(driver, PageCreerProjet.class);

	}







}