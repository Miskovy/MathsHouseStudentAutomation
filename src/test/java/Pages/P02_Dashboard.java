package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Hooks;

public class P02_Dashboard {
    public WebElement dashboardTitle(){return Hooks.driver.findElement(By.xpath("//android.view.View[@content-desc=\"Dashboard\"]"));
    }
    public WebElement HomeButton(){return Hooks.driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]"));}
    public WebElement myCategoriesButton(){return Hooks.driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]"));}
    public WebElement packagesButton(){return Hooks.driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]"));}
    public WebElement progressButton(){return Hooks.driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[5]"));}
    public WebElement userProfileButton(){return Hooks.driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]"));}
    public WebElement rechargeButton(){return Hooks.driver.findElement(By.xpath("//android.view.View[@content-desc=\"Wallet\n" +
            "recharge your Wallet\"]"));}
    public WebElement notificationsButton(){return Hooks.driver.findElement(By.xpath("//android.widget.Button"));}
}
