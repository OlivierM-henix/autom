package org.autom5;

import org.openqa.selenium.By;

public abstract class PageAbstract {
	public static <WebDriver> void selectionnerMenu(WebDriver driver, String ogl,String btn) {
		WebElement a = driver.findElement(By.xpath("//button[@class='z-menu-btn'][contains(text(),"+ogl+"])");
		WebElement b = driver.findElement(By.xpath("//button[@class='z-menu-item-cnt'][contains(text(),"+btn+"])");
	}
}