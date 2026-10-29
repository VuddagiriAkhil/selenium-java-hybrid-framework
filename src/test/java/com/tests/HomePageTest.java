package com.tests;
import org.testng.annotations.Listeners;
import com.listeners.TestListener;
import com.base.BaseTest;
import com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import com.listeners.TestListener;
@Listeners(TestListener.class)


public class HomePageTest extends BaseTest {


    @Test
    public void verifySeleniumHomePage() {
        HomePage homePage = new HomePage(driver);

        homePage.open();

        Assert.assertTrue(
            homePage.getTitle().toLowerCase().contains("selenium"),
            "Page title should contain Selenium");

        Assert.assertTrue(
            homePage.isHeadingDisplayed(),
            "Page heading should be displayed");
    }
}