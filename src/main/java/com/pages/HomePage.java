
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.config.ConfigReader;
import com.utils.WaitUtils;

public class HomePage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    private final By heading = By.cssSelector("h1");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void open() {
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isHeadingDisplayed() {
        return waitUtils.waitForVisibility(heading).isDisplayed();
    }
}
