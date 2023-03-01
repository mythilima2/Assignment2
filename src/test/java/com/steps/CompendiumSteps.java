package com.steps;

import com.pagefile.CompendiumHomepage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CompendiumSteps {
    public WebDriver driver;
    CompendiumHomepage compendiumHomepage;

    @Before
    public void launch() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://compendiumdev.co.uk/");
        driver.manage().window().maximize();
        compendiumHomepage = new CompendiumHomepage(driver);
    }

    @Given("User should launch url")
    public void user_should_launch_url() {
        System.out.println("user should launch url");
    }

    @When("user goes to homepage")
    public void user_goes_to_homepage() {
        System.out.println("user goes to homepage");

    }

    @Then("click on contact")
    public void click_on_contact() {
        compendiumHomepage.clickingOnContact();
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));

        System.out.println("click on contact");

    }

    @Then("Fill the details")
    public void fill_the_details() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));

        compendiumHomepage.detailsEntering();
        Assert.assertTrue(compendiumHomepage.verifyPage());
        //  System.out.println("fill the details");
    }

    @Then("Verify the form")
    public void verify_the_form() {
        {
            System.out.println("verify the form");
        }
    }
}
