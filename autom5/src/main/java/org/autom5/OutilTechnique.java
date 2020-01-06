package org.autom5;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	
	//nommer la capture en fonction de son cas de test + fonctionnalite ex: "CRI_01_connexion" 
	//commande OutilTechnique.screenShot(driver, "CRI_01_connexion");
	//ex nommage attendu : CRI_01_connexion - 2019-05-01 : 18:54:08)

	public static WebElement obtenir_lgn_i (WebDriver driver, String xpath_tableau, int i) {
		WebElement lgn_i = driver.findElement(By.xpath(""+xpath_tableau+"//tr["+i+"]"));
		return lgn_i;
	}

	public static WebElement obtenir_cellule_i_j (WebDriver driver, String xpath_tableau, int i, int j) {
		WebElement cellue_i_j = driver.findElement(By.xpath(""+xpath_tableau+"//tr["+i+"]/td["+j+"]"));
		return cellue_i_j;
	}

	public static WebElement obtenir_champ_i_j (WebDriver driver, String xpath_tableau, int i, int j) {
		WebElement champ_i_j = driver.findElement(By.xpath(""+xpath_tableau+"//tr["+i+"]/td["+j+"]//input"));
		return champ_i_j;
	}
	

}