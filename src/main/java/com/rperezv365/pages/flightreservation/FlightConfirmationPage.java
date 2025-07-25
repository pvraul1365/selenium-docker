package com.rperezv365.pages.flightreservation;

import com.rperezv365.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FlightConfirmationPage
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 25/06/2025 - 17:51
 * @since 1.17
 */
public class FlightConfirmationPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(FlightConfirmationPage.class);

    @FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(1) .col:nth-child(2)")
    private WebElement flightConfirmationElement;

    @FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(3) .col:nth-child(2)")
    private WebElement totalPriceElement;

    public FlightConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        super.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationElement));

        return this.flightConfirmationElement.isDisplayed();
    }

    public String getPrice(){
        String confirmation = this.flightConfirmationElement.getText();
        String price = this.totalPriceElement.getText();
        log.info("Flight confirmation# : {}", confirmation);
        log.info("Total price : {}", price);

        return price;
    }
}
