package com.driver;

import com.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER =
            new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void initDriver() {
        if (DRIVER.get() == null) {
            String browser = ConfigReader.getProperty("browser");

            if ("chrome".equalsIgnoreCase(browser)) {
                DRIVER.set(new ChromeDriver());
            } else {
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser);
            }
        }
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();

        if (driver == null) {
            throw new IllegalStateException(
                    "WebDriver is not initialized.");
        }

        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();

        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            DRIVER.remove();
        }
    }
}