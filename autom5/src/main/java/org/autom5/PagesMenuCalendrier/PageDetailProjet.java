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

	@FindBy (xpath="//table[@id='aLKAea-box']//img") public static 
	WebElement icone_disquetteenregistrer;
	//table[@id='aLKAea-box']//img



	public  PageDetailProjet() {
		WebElement b = driver.findElement(By.xpath("//table[@id='aLKAea-box']//img"));
		Actions action = new Actions(driver);
		action.moveToElement(b).perform();

	}


	public class Test {

		public void main(String[] args) {
			List<String> l = new LinkedList<String>();
			l.add("WBS (tâches)");
			l.add("Données générales");
			l.add("Coût");
			l.add("Libellés");
			l.add("Exigence de critère");
			l.add("Matériels");
			l.add("Formulaire qualité des tâches");
			l.add("Autorisation");

			for(int i = 0; i < l.size(); i++)
				System.out.println("Élément à l'index " + i + " = " + l.get(i));
		}
	}


	
	}	

}
