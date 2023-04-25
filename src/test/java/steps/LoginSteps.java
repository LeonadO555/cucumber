package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    private WebDriver driver;

    By emailField =By.cssSelector("[placeholder=\"Email\"]");
    By passwordField =By.cssSelector("[placeholder=\"Password\"]");
    By loginButton =By.xpath("//*[@type=\"submit\"]");
    By contactsTable =By.id("contacts-list");

    @Given("Navigate to Login Page")
    public void navigateToLoginPage(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://phonebook.telran-edu.de:8080/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("Fill fields valid data")
    public void fillLoginForm(){
        fillField(emailField);
        fillField(passwordField);
    }

    @And("Click on Login button")
    public void clickOnLoginButton(){
        click(loginButton);
    }

    @Then("Check displayed Contact page")
    public void checkDisplayedContactPage(){
        driver.findElement(contactsTable).isDisplayed();
    }

    private void fillField(By locator) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys("test@gmail.com");
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }
}



