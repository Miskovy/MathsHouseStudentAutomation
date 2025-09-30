package stepDefinitions;

import Pages.P01_LoginPage;
import Pages.P02_Dashboard;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D01_StudentLogin {
P01_LoginPage loginPage = new P01_LoginPage();
P02_Dashboard dashboard = new P02_Dashboard();
@When("the user is in the login page")
    public void assert_the_login_page() throws InterruptedException {
    Thread.sleep(3000);
    System.out.println("Splash screen is done");
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(loginPage.skipButton()));
    System.out.println("Skip Button is Visible");
    loginPage.skipButton().click();
    Assert.assertTrue(loginPage.loginTitle().isDisplayed());
}
@And("the user types {string} in the email")
    public void enter_student_email(String email) throws InterruptedException {
    loginPage.emailTxt().click();
    Thread.sleep(1000);
    loginPage.emailTxtHovered().sendKeys(email);
}
@And("the user types {string} in the password")
    public void enter_student_password(String password) throws InterruptedException {
    loginPage.passwordTxtHovered().click();
    Thread.sleep(1000);
    loginPage.passwordTxtHovered().sendKeys(password);
    loginPage.loginButton().click();
}
@Then("the user is able to login successfully")
    public void assert_login_student_success(){
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    By dashboardTitleLocator = By.xpath("//android.view.View[@content-desc=\"Dashboard\"]");
    Assert.assertTrue(
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTitleLocator)).isDisplayed()
    );
}
}
