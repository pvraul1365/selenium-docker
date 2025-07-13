package com.rperezv365.pages.vendorportal;

import com.rperezv365.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DashBoardPage
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 28/06/2025 - 14:15
 * @since 1.17
 */
public class DashBoardPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(DashBoardPage.class);

    @FindBy(id = "monthly-earning")
    private WebElement monthlyEarningElement;

    @FindBy(id = "annual-earning")
    private WebElement annualEarningElement;

    @FindBy(id = "profit-margin")
    private WebElement profitMarginElement;

    @FindBy(id = "available-inventory")
    private WebElement availableInventoryElement;

    @FindBy(css = "#dataTable_filter input")
    private WebElement searchInput;

    @FindBy(id = "dataTable_info")
    private WebElement searchResultsCountElement;

    @FindBy(css = "img.img-profile")
    private WebElement userProfilePictureElement;

    // prefer id / name / css
    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(css = "#logoutModal a")
    private WebElement modalLogoutButton;

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        super.wait.until(ExpectedConditions.visibilityOf(monthlyEarningElement));
        return monthlyEarningElement.isDisplayed();
    }

    public String getMonthlyEarning() {
        return monthlyEarningElement.getText();
    }

    public String getAnnualEarning() {
        return annualEarningElement.getText();
    }

    public String getProfitMargin() {
        return profitMarginElement.getText();
    }

    public String getAvailableInventory() {
        return availableInventoryElement.getText();
    }

    public void searchOrderHistoryBy(String keyword) {
        searchInput.sendKeys(keyword);
    }

    public int getSearchResultsCount() {
        String resultsText = searchResultsCountElement.getText();
        String[] parts = resultsText.split(" ");
        int count = Integer.parseInt(parts[5]);
        log.info("Search results count: {}", count);

        return count;
    }

    public void logout(){
        userProfilePictureElement.click();
        super.wait.until(ExpectedConditions.visibilityOf(logoutLink));
        logoutLink.click();
        super.wait.until(ExpectedConditions.visibilityOf(modalLogoutButton));
        modalLogoutButton.click();
    }

}
