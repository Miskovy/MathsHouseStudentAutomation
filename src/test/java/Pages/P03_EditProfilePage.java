package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Hooks;

public class P03_EditProfilePage {
    //Before Edit Button
    public WebElement EditButton(){return Hooks.driver.findElement(By.xpath("//android.widget.Button"));}
    //After Edit Button
    public WebElement firstNameTxt(){return Hooks.driver.findElement(By.xpath("(//android.widget.EditText)[1]"));}
    public WebElement firstNameTxtHovered(){return Hooks.driver.findElement(By.xpath(""));}
    public WebElement lastNameTxt(){return Hooks.driver.findElement(By.xpath("(//android.widget.EditText)[2]"));}
    public WebElement saveChangesButton(){return Hooks.driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Save changes\"]"));}
}
