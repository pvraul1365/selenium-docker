package com.rperezv365.pages.flightreservation;

import com.rperezv365.pages.AbstractPage;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * FlightsSelectionPage
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 25/06/2025 - 17:18
 * @since 1.17
 */
public class FlightsSelectionPage extends AbstractPage {

    @FindBy(name = "departure-flight")
    private List<WebElement> departureFlightsOptions;

    @FindBy(name = "arrival-flight")
    private List<WebElement> arrivalFlightsOptions;

    @FindBy(id = "confirm-flights")
    private WebElement confirmFlightsButton;

    public FlightsSelectionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        super.wait.until(ExpectedConditions.visibilityOf(this.confirmFlightsButton));

        return this.confirmFlightsButton.isDisplayed();
    }

    public void selectFlights() {
        int random = ThreadLocalRandom.current().nextInt(0, departureFlightsOptions.size());
        this.departureFlightsOptions.get(random).click();
        this.arrivalFlightsOptions.get(random).click();
    }

    public void confirmFlights() {
        this.confirmFlightsButton.click();
    }

}
