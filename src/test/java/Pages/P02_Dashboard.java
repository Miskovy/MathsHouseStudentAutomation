package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Hooks;

public class P02_Dashboard {
    public WebElement dashboardTitle(){return Hooks.driver.findElement(By.xpath("//android.view.View[@content-desc=\"Dashboard\"]"));
    }
}
