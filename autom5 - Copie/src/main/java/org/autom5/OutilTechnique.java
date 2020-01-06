package org.autom5;
<<<<<<< HEAD

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
=======
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
>>>>>>> b92251123f3bf6bf0e9b0a3bdf58dd67eafaec33
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
	
<<<<<<< HEAD
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
	System.out.println(aujourdhui); 
	System.out.println(demain); 
	System.out.println(hier); 
	System.out.println(dansUnMois); 
	LocalDateTime maintenant = LocalDateTime.now(); 
	LocalDateTime avant = maintenant.minusHours(4) 
	        .plusMinutes(30) 
	        .minusWeeks(7); 
	System.out.println(maintenant); 
	System.out.println(avant);
	
	
	public class CalendarCalc {
		 
	    public void main(String[] args) {
	        //utiliser le calendrier par défaut
	        Calendar calendar = Calendar.getInstance();
	 
	Calendar.add(Calendar.DATE, 7);
	
=======
	
	public static void screenShot(WebDriver driver, String nom_capture) throws IOException, InterruptedException {
	    File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File dest = new File("C:\\Temp\\ScreenshotsSelenium\\"+nom_capture+"-"+timestamp()+".png");
	    System.out.println(dest);
	    FileUtils.copyFile(scr, dest);
	    Thread.sleep(1000);
	}

	public static String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dds.HH.mm.ss").format(new Date());
	} 
	
	//Verifier le chemin du dossier de stockage
	//nommer la capture en fonction de son cas de test + fonctionnalitï¿½ ex: "CRI_01_connexion" 
	//commande OutilTechnique.screenShot(driver, "CRI_01_connexion");
	//ex nommage attendu : CRI_01_connexion - 2019-05-01 : 18:54:08)

>>>>>>> b92251123f3bf6bf0e9b0a3bdf58dd67eafaec33
}