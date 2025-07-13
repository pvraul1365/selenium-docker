package com.rperezv365.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * AbstractPage
 * 
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 22/06/2025 - 18:36
 * @since 1.17
 */
public abstract class AbstractPage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Default timeout of 10 seconds
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isAt();
}
