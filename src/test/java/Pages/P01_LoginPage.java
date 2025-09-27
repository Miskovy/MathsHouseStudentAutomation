package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Hooks;

public class P01_LoginPage {
    public WebElement skipButton(){return Hooks.driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Skip\"]"));}
    public WebElement loginTitle(){return Hooks.driver.findElement(By.xpath("//android.view.View[@content-desc=\"Welcome Back\"]"));}
    public WebElement emailTxt(){return Hooks.driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]"));}
    public WebElement emailTxtHovered(){return Hooks.driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]"));}
    public WebElement passwordTxt(){return Hooks.driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]"));}
    public WebElement passwordTxtHovered(){return Hooks.driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));}
    public WebElement loginButton(){return Hooks.driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Login\"]"));}
}
