package org.autom5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCnx {
	@FindBy(xpath="//div/input[@name=\"j_username\"]")
	WebElement champ_login;

	@FindBy(xpath="//div/input[@name=\"j_password\"]")
	WebElement champ_password;
	
	@FindBy(xpath="//div/input[@name=\"button\"]")
	WebElement btn_login;


public PageIndex sidentifier (String login, String password, WebDriver driver){
	OutilTechnique.remplirChampTexte(champ_login, "admin");
	OutilTechnique.remplirChampTexte(champ_password, "admin");
	btn_login.click();
	return PageFactory.initElements(driver, PageIndex.class);
}
}