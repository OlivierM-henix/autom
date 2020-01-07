package org.autom5.PagesMenuCalendrier;

import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;



public class PageDetailProjet {

	WebDriver driver;



	@FindBy (xpath="//img[contains(@src, 'back.png')]") public static 
	WebElement icone_annuler;
	
	@FindBy (xpath="//img[contains(@src, 'save.png')]") public static 
	WebElement icone_enregistrer;
	
	
	@FindBy (xpath="//div[contains(text(),'Confirmer la fen�tre de sortie')]") public static 
	WebElement popupdiv_annulation;
	
	//div[contains(text(),'Confirmer la fen�tre de sortie')]
	
	@FindBy (xpath="//span[contains(text(),'Les modifications non enregistr�es seront perdues. �tes-vous s�r ?')]") public static 
	WebElement message_popupdiv_annulation;
	
	//span[contains(text(),'Les modifications non enregistr�es seront perdues.')]
	
	@FindBy (xpath="//td[contains(text(),'OK')]") public static 
	WebElement popupdiv_boutonok;
	//td[contains(text(),'OK')]
	
	@FindBy (xpath="//table[@class='z-button-clk']//td[@class='z-button-cm'][contains(text(),'Annuler')]") public static 
	WebElement popupdiv_boutonannuler;
	
	
	

	public  PageDetailProjet() {
		WebElement b = driver.findElement(By.xpath("//table[@id='aLKAea-box']//img"));
		Actions action = new Actions(driver);
		action.moveToElement(b).perform();

	}


	public class Test {

		public void main(String[] args) {
			List<String> l = new LinkedList<String>();
			l.add("WBS (t�ches)");
			l.add("Donn�es g�n�rales");
			l.add("Co�t");
			l.add("Libell�s");
			l.add("Exigence de crit�re");
			l.add("Mat�riels");
			l.add("Formulaire qualit� des t�ches");
			l.add("Autorisation");

			for(int i = 0; i < l.size(); i++)
				System.out.println("�l�ment � l'index " + i + " = " + l.get(i));
		}
	}


	
	}	

}
