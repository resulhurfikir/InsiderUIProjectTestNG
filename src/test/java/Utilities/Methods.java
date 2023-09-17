package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;


public class Methods extends BaseClass {

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    public void clickFunction(WebElement element) {
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }


    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }


    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void jsClickFunction(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }


    public void switchNextPage() {
        String mainPage = getDriver().getWindowHandle();
        Set<String> windowsIds = getDriver().getWindowHandles();
        for (
                String id : windowsIds) {
            if (!id.equals(mainPage)) {
                getDriver().switchTo().window(id);
            } else {
                getDriver().switchTo().window(mainPage);
            }
        }
    }

    public static void waitForStale() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitUntilAttributeContains(WebElement element, String attribute, String value) {
        wait.until((ExpectedConditions.attributeContains(element, attribute, value)));
    }


}
