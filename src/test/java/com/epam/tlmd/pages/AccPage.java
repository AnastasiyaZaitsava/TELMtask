package com.epam.tlmd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccPage extends AbstractPage{
	private final String BASE_URL = "http://acc.telemundo.com/";
	
	@FindBy(xpath = "//a[contains(text(), 'Series Y Novelas')]")
	WebElement novelasButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Súper Series')]")
	WebElement seriesButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Shows')]")
	WebElement showsButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Entretenimiento')]")
	WebElement entretButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Videos')]")
	WebElement videosButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Noticias')]")
	WebElement noticiasButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Deportes')]")
	WebElement deportesButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Mujer')]")
	WebElement mujerButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Comunidad')]")
	WebElement comunidadButton;

	public AccPage(WebDriver driver) {
		super(driver);
	}

	public void openPage() {
	    driver.navigate().to(BASE_URL);
	}
	
	public void goToNovelas() {
		novelasButton.click();
	}
	public void goToSeries() {
	    seriesButton.click();
	}
	public void goToShows() {
	    showsButton.click();
	}
	public void goToEntretenimiento() {
	    entretButton.click();
	}
	public void goToVideos() {
	    videosButton.click();
	}
	public void goToDeportes() {
	    deportesButton.click();
	}
	public void goToMujer() {
	    mujerButton.click();
	}
	public void goToComunidad() {
	    comunidadButton.click();
	}
	public void goToNoticias() {
	    driver.navigate().to(BASE_URL);
	}
	public boolean checkTitle(){
		String title = driver.getTitle();
		if (title.contains("Telemundo")){
			return true;
		}
		else{
			return false;
		}
	}
}
