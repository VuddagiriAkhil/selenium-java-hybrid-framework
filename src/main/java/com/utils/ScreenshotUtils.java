package com.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String captureScreenshot(
            WebDriver driver, String testName) {

        try {
            Path directory = Paths.get("test-output", "screenshots");
            Files.createDirectories(directory);

            String fileName = testName + "_"
                    + System.currentTimeMillis() + ".png";

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Path destination = directory.resolve(fileName);

            Files.copy(source.toPath(), destination,
                    StandardCopyOption.REPLACE_EXISTING);

            return destination.toAbsolutePath().toString();

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to capture screenshot", e);
        }
    }
}