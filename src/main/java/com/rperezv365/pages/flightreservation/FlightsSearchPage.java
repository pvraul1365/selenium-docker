package com.rperezv365.pages.flightreservation;

import com.rperezv365.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * FlightsSearchPage
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 23/06/2025 - 11:07
 * @since 1.17
 */
public class FlightsSearchPage  extends AbstractPage {

    @FindBy(id = "passengers")
    private WebElement passengersSelect;

    @FindBy(id = "search-flights")
    private WebElement searchFlightsButton;

    public FlightsSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        super.wait.until(ExpectedConditions.visibilityOf(this.passengersSelect));
        return this.passengersSelect.isDisplayed();
    }

    public void selectPassengers(String numberOfPassengers) {
        Select passengers = new Select(this.passengersSelect);
        passengers.selectByValue(numberOfPassengers);
    }

    public void searchFlights() {
        this.searchFlightsButton.click();
    }
}
