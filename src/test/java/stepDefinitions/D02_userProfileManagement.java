package stepDefinitions;

import Pages.P02_Dashboard;
import Pages.P03_EditProfilePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D02_userProfileManagement {
    P02_Dashboard dashboard = new P02_Dashboard();
    P03_EditProfilePage editProfilePage = new P03_EditProfilePage();
    @When("the user is in the profile page")
    public void press_the_profile_icon(){
        dashboard.userProfileButton().click();
    }
    @And("the user presses the edit icon")
    public void press_the_edit_button() throws InterruptedException {
        Thread.sleep(2000);
        editProfilePage.EditButton().click();
    }
    @When("the user changes his name to {string}")
    public void change_first_name(String Firstname) throws InterruptedException {
        Thread.sleep(1000);
        editProfilePage.firstNameTxt().click();
        editProfilePage.firstNameTxt().clear();
        Thread.sleep(500);
        editProfilePage.firstNameTxt().sendKeys(Firstname);
    }
    @And("the user changes his last name to {string}")
    public void change_last_name(String Lastname) throws InterruptedException {
        Thread.sleep(500);
        editProfilePage.lastNameTxt().click();
        editProfilePage.lastNameTxt().clear();
        Thread.sleep(500);
        editProfilePage.lastNameTxt().sendKeys(Lastname);
    }
    @And("the user saves the changes")
    public void user_saves_changes() throws InterruptedException {
        WebElement saveChangesBtn =  Hooks.driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().description(\"Save changes\"));"
                )
        );

        saveChangesBtn.click();

    }
    @Then("the user name {string} should be displayed")
    public void assert_name_changes(String Username) throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement nameElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId(Username)  // matches content-desc directly
                )
        );

        // Get the actual value of content-desc
        String actualName = nameElement.getAttribute("content-desc");

        // Debug log
        System.out.println("Expected: " + Username + " | Actual: " + actualName);

        // Assertion
        Assert.assertEquals(actualName, Username, "The displayed user name does not match!");
    }
    @When("the user changes his email to {string}")
    public void change_email(String email) throws InterruptedException {
        Thread.sleep(9000);
        WebElement emailTxt =  Hooks.driver.findElement(
                new AppiumBy.ByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().className(\\\"android.widget.EditText\\\").instance(5))"
                )
        );
        emailTxt.click();
        Thread.sleep(500);
        emailTxt.sendKeys(email);
    }
}
