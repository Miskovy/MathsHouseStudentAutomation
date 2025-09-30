package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.HelperMethods;
import stepDefinitions.Hooks;

public class P03_EditProfilePage {
    HelperMethods helperMethods = new HelperMethods();
    // Before Edit Button
    public WebElement EditButton(){return Hooks.driver.findElement(By.xpath("//android.widget.Button"));}
    //After Edit Button
    public WebElement UploadPhotoButton(){return Hooks.driver.findElement(By.xpath("//android.view.View[@content-desc=\"Tap to change photo\"]"));}
    public WebElement galleryButton(){return Hooks.driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Gallery\"]"));}
    public WebElement firstNameTxt(){return Hooks.driver.findElement(By.xpath("(//android.widget.EditText)[1]"));}
    public WebElement lastNameTxt(){return Hooks.driver.findElement(By.xpath("(//android.widget.EditText)[2]"));}
    public WebElement successMessage(){return Hooks.driver.findElement(By.xpath("//android.view.View[@content-desc=\"Profile updated successfully!\"]"));}
    public WebElement passwordTxt() throws InterruptedException {
        return Hooks.driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[4]"));
    }
    public WebElement FirstImageInGallery(){return Hooks.driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.documentsui:id/icon_thumb\"])[1]"));}
    public WebElement nicknameTxt(){return Hooks.driver.findElement(By.xpath("(//android.widget.EditText)[3]"));}
}
