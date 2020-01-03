package org.autom5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCnx {
	@FindBy(xpath="//@name[.=\"j_username\"]")
	WebElement champ_login;

	@FindBy(xpath="//@name[.=\"j_password\"]")
	WebElement champ_password;


public PageIndex sidentifier (String login, String password, WebDriver driver){
	OutilTechnique.remplirChampTexte(champ_login, "admin");
	OutilTechnique.remplirChampTexte(champ_password, "admin");
	return PageFactory.initElements(driver, PageIndex.class);
}
}