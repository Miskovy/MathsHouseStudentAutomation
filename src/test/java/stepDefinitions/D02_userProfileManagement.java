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
import java.util.List;

public class D02_userProfileManagement {
    P02_Dashboard dashboard = new P02_Dashboard();
    P03_EditProfilePage editProfilePage = new P03_EditProfilePage();
    HelperMethods helperMethods = new HelperMethods();
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
        Thread.sleep(500);
        WebElement emailTxt = helperMethods.scrollAndFindEmailBox();
        emailTxt.click();
        Thread.sleep(500);
        emailTxt.clear();
        emailTxt.sendKeys(email);
    }
    @Then("the email {string} should be displayed")
    public void assert_the_changed_email(String email) throws InterruptedException {
        Thread.sleep(5000);
        WebElement emailTxt = Hooks.driver.findElement(
                AppiumBy.accessibilityId(email)
        );
        Assert.assertTrue(emailTxt.isDisplayed());
    }
    @When("the user changes his password to {string}")
    public void user_change_password(String password) throws InterruptedException {
        HelperMethods.scrollScreen("down",1.0);
        Thread.sleep(2000);
        editProfilePage.passwordTxt().click();
        Thread.sleep(500);
        editProfilePage.passwordTxt().sendKeys(password);
    }
    @And("the user confirms the password {string}")
    public void user_confirm_password(String password) throws InterruptedException {
        HelperMethods.pressBackButton(1);
        HelperMethods.scrollScreen("down",1.0);
        Thread.sleep(500);
        WebElement confirmPasswordTxt = Hooks.driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[5]"));
        confirmPasswordTxt.click();
        Thread.sleep(100);
        confirmPasswordTxt.sendKeys(password);
    }
    @Then("the success message updated profile should be displayed")
    public void updated_profile_assert_success() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        Assert.assertTrue(
                wait.until(ExpectedConditions.visibilityOf(editProfilePage.successMessage())).isDisplayed()
        );
    }
    @When("the user changes his phone number to {string}")
    public void user_change_phone_number(String phoneNum) throws InterruptedException {
        WebElement phoneLabel = Hooks.driver.findElement(
                 new AppiumBy.ByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().description(\"Phone\"))"
                )
        );
        List<WebElement> textBoxes = Hooks.driver.findElements(AppiumBy.className("android.widget.EditText"));
        WebElement PhoneNumberTxt = textBoxes.getFirst();  // index 0 = first
        System.out.println("Phone label found: " + phoneLabel.isDisplayed());
        System.out.println(PhoneNumberTxt.getText());
        PhoneNumberTxt.click();
        PhoneNumberTxt.clear();
        PhoneNumberTxt.sendKeys(phoneNum);
    }
    @Then("the phone number {string} should be displayed")
    public void assert_Phone_number_changed(String PhoneNum) throws InterruptedException {
        Thread.sleep(5000);
        WebElement PhoneNumberTxt = Hooks.driver.findElement(
                AppiumBy.accessibilityId(PhoneNum)
        );
        Assert.assertTrue(PhoneNumberTxt.isDisplayed());
    }
    @When("the user presses the change photo")
    public void the_user_edit_photo() throws InterruptedException {
        editProfilePage.UploadPhotoButton().click();
        Thread.sleep(500);
        editProfilePage.galleryButton().click();
    }
    @And("the user chooses the image source")
    public void choosing_image_profile() throws InterruptedException {
        Thread.sleep(500);
        editProfilePage.FirstImageInGallery().click();
        Thread.sleep(5000);
    }
@When("the user changes his nickname to {string}")
    public void user_change_nickname(String nickName) throws InterruptedException {
        Thread.sleep(500);
        editProfilePage.nicknameTxt().click();
        Thread.sleep(500);
        editProfilePage.nicknameTxt().clear();
        editProfilePage.nicknameTxt().sendKeys(nickName);
}
@Then("the nickname should be displayed {string}")
    public void nickname_assert(String nickName){
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    WebElement nickNameElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.accessibilityId(nickName)  // matches content-desc directly
            )
    );
    Assert.assertTrue(nickNameElement.isDisplayed());
}
}
