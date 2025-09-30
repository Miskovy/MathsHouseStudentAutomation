package stepDefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class HelperMethods {
    public static WebElement getEditTextBeneathLabel(AppiumDriver driver, String labelText) {
        try {
            // First, try to locate label by content-desc
            List<WebElement> labels = driver.findElements(
                    new AppiumBy.ByAndroidUIAutomator(
                            "new UiSelector().descriptionContains(\"" + labelText + "\")"
                    )
            );

            if (labels.isEmpty()) {
                // Fallback: try to locate by visible text
                labels = driver.findElements(
                        new AppiumBy.ByAndroidUIAutomator(
                                "new UiSelector().textContains(\"" + labelText + "\")"
                        )
                );
            }

            if (labels.isEmpty()) {
                // Fallback with scroll
                driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().textContains(\"" + labelText + "\"))"
                ));
                labels = driver.findElements(
                       new AppiumBy.ByAndroidUIAutomator("new UiSelector().textContains(\"" + labelText + "\")")
                );
            }

            if (labels.isEmpty()) {
                throw new NoSuchElementException("Could not locate label with text/desc: " + labelText);
            }

            // Assume the first match is correct
            WebElement label = labels.get(0);

            // Now try to find sibling EditText in the same parent
            WebElement parent = label.findElement(By.xpath(".."));
            List<WebElement> editTexts = parent.findElements(AppiumBy.className("android.widget.EditText"));

            if (!editTexts.isEmpty()) {
                return editTexts.get(0);
            } else {
                throw new NoSuchElementException("No EditText under label: " + labelText);
            }
        } catch (Exception e) {
            throw new NoSuchElementException("Could not locate EditText under label '" + labelText + "', cause: " + e.getMessage());
        }
    }




    public WebElement scrollAndFindEmailBox() {
        int maxScrolls = 10;

        for (int i = 0; i < maxScrolls; i++) {
            List<WebElement> editTexts = Hooks.driver.findElements(By.className("android.widget.EditText"));

            // pick last one if it looks like email
            for (WebElement e : editTexts) {
                String value = e.getAttribute("text");
                if (value != null && value.contains("@")) {
                    return e; // found email box
                }
            }

            // scroll further
            Hooks.driver.findElement(
                    new AppiumBy.ByAndroidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
                    )
            );
        }

        throw new NoSuchElementException("Could not find email EditText after scrolling.");
    }

    public static WebElement scrollToNthEditText(int targetIndex, int maxScrolls) {

        for (int i = 0; i < maxScrolls; i++) {
            try {
                // Get all EditTexts currently on screen
                List<WebElement> editTexts = Hooks.driver.findElements(By.className("android.widget.EditText"));

                // If we have enough elements and target is visible
                if (editTexts.size() > targetIndex) {
                    return editTexts.get(targetIndex);
                }

                // Scroll down if not found
                Hooks.driver.findElement(
                        new AppiumBy.ByAndroidUIAutomator(
                                "new UiScrollable(new UiSelector().scrollable(true))" +
                                        ".scrollForward()"
                        )
                );
            } catch (Exception e) {
                System.out.println("Scrolling... attempt " + (i + 1));
            }
        }

        throw new NoSuchElementException("Could not find EditText at index " + targetIndex + " after scrolling " + maxScrolls + " times.");
    }
    public static WebElement scrollToPasswordField(int maxScrolls) {

        for (int i = 0; i < maxScrolls; i++) {
            try {
                // Try to find password field
                List<WebElement> passwordFields = Hooks.driver.findElements(
                        new AppiumBy.ByAndroidUIAutomator(
                                "new UiSelector().className(\"android.widget.EditText\").password(true)"
                        )
                );

                if (!passwordFields.isEmpty()) {
                    return passwordFields.get(0); // first password field
                }

                // If not found yet, scroll down
                Hooks.driver.findElement(
                        new AppiumBy.ByAndroidUIAutomator(
                                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
                        )
                );
            } catch (Exception e) {
                System.out.println("Scrolling attempt " + (i + 1));
            }
        }

        throw new NoSuchElementException("Could not find password EditText after " + maxScrolls + " scrolls.");
    }
    public static WebElement scrollToConfirmPasswordField(int maxScrolls) {
        WebElement password = scrollToPasswordField(maxScrolls);

        // Get all EditTexts currently visible
        List<WebElement> editTexts = Hooks.driver.findElements(By.className("android.widget.EditText"));

        // Find password’s index
        int index = editTexts.indexOf(password);
        if (index != -1 && index + 1 < editTexts.size()) {
            return editTexts.get(index + 1); // confirm password is next
        }
        throw new NoSuchElementException("Confirm password field not found near password field.");
    }
    public static void scrollScreen(String direction, double scrollRatio) {
        Dimension size = Hooks.driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;

        int startX, startY, endX, endY;

        switch (direction.toLowerCase()) {
            case "up":
                startX = width / 2;
                startY = (int) (height * (1 - scrollRatio));
                endX = startX;
                endY = (int) (height * scrollRatio);
                break;

            case "down":
                startX = width / 2;
                startY = (int) (height * scrollRatio);
                endX = startX;
                endY = (int) (height * (1 - scrollRatio));
                break;

            case "left":
                startY = height / 2;
                startX = (int) (width * (1 - scrollRatio));
                endY = startY;
                endX = (int) (width * scrollRatio);
                break;

            case "right":
                startY = height / 2;
                startX = (int) (width * scrollRatio);
                endY = startY;
                endX = (int) (width * (1 - scrollRatio));
                break;

            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }

        // perform gesture
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Hooks.driver.perform(Collections.singletonList(swipe));
    }
    public static void pressBackButton(int times) {

        for (int i = 0; i < times; i++) {
            Hooks.driver.navigate().back();
            try {
                Thread.sleep(500); // small delay to allow UI to update
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
