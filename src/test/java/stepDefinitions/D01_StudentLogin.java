package stepDefinitions;

import Pages.P01_LoginPage;
import io.cucumber.java.en.When;

import org.testng.Assert;

public class D01_StudentLogin {
P01_LoginPage loginPage = new P01_LoginPage();
@When("the user is in the login page")
    public void assert_the_login_page(){

    Assert.assertTrue(loginPage.loginTitle.isDisplayed());
}
}
