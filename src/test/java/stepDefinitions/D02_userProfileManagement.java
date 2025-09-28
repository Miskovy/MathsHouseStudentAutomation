package stepDefinitions;

import Pages.P02_Dashboard;
import Pages.P03_EditProfilePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class D02_userProfileManagement {
    P02_Dashboard dashboard = new P02_Dashboard();
    P03_EditProfilePage editProfilePage = new P03_EditProfilePage();
    @When("the user is in the profile page")
    public void press_the_profile_icon(){
        dashboard.userProfileButton().click();
    }
    @And("the user presses the edit icon")
    public void press_the_edit_button() throws InterruptedException {
        Thread.sleep(1000);
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
        ((AndroidDriver) Hooks.driver).pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(500);
        editProfilePage.saveChangesButton().click();
    }
    @Then("the name is changed to {string} and the last name to {string}")
    public void assert_name_changes(String firstName , String lastName){

    }
}
