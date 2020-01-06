package org.autom5;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OutilTechnique {

	public static WebDriver driver;

	static WebDriver choisirNavigateur(ENavigateur nav) {
		switch (nav) {
		case firefox:
			System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver-v0.24.0-win64/geckodriver.exe");
			driver = new FirefoxDriver();
			return driver;

		case chrome:
			System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
			return driver;
		default:
			return null;
		}

	}

	public static void remplirChampTexte(WebElement e, String s) {
		e.clear();
		e.sendKeys(s);

	}
	
	public static String formatdate() {
        Date maintenant = (Date) Calendar.getInstance().getTime();
        String dateaujformatcourt = new SimpleDateFormat("dd M YYYY").format(maintenant);
        //System.out.println(dateaujformatcourt);
        return (dateaujformatcourt);
    }
	
	
	LocalDate aujourdhui = LocalDate.now(); 
	LocalDate demain = aujourdhui.plusDays(1);
	LocalDate hier = aujourdhui.minusDays(1); 
	LocalDate dansUnMois = aujourdhui.plusMonths(1); // Calcule correctement les jours du mois. 
	

	public class CalendarCalc {
		 
	    public void main(String[] args) {
	        //utiliser le calendrier par défaut
	        Calendar calendar = Calendar.getInstance();
	 
}
	}
}