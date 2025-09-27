package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Hooks;

public class P01_LoginPage {
    public WebElement skipButton = Hooks.driver.findElement(By.xpath("//*[@id=\"screenshotContainer\"]/div[2]/div/div/div/div/div[9]"));
    public WebElement loginTitle = Hooks.driver.findElement(By.xpath("//*[@id=\"screenshotContainer\"]/div[2]/div/div/div/div/div[13]"));
    public WebElement emailTxt = Hooks.driver.findElement(By.xpath("//*[@id=\"screenshotContainer\"]/div[2]/div/div/div/div/div[14]"));
    public WebElement passwordTxt = Hooks.driver.findElement(By.xpath("//*[@id=\"screenshotContainer\"]/div[2]/div/div/div/div/div[15]"));
    public WebElement loginButton = Hooks.driver.findElement(By.xpath("//*[@id=\"screenshotContainer\"]/div[2]/div/div/div/div/div[18]"));
}
