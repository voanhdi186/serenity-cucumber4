package GoBear;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public RemoteWebDriver driver;
//    public RemoteWebElement element;

    public BasePage(){

   }

   public void waitUntilElementVisible(By element)
   {
       System.out.println("Wait for: " + element);
       WebDriverWait wait = new WebDriverWait(driver, 20);
       wait.until(ExpectedConditions.visibilityOfElementLocated(element));
   }

   public void waitUntilElemenClickable(By element)
   {
       System.out.println("Wait for: " + element);
       WebDriverWait wait = new WebDriverWait(driver, 20);
       wait.until(ExpectedConditions.elementToBeClickable(element));
   }

   public void clickOn(By element){
        waitUntilElemenClickable(element);
        driver.findElement(element).click();
   }

    public void selectItem(By element) {
        waitUntilElementVisible(element);
        driver.findElement(element).click();
    }

    public void selectDate(String date) {
//       TODO: create method to pick a given date
        System.out.println(".......Pick date: " + date + ".........");
    }

    public void clickOnButtonHasText(String text) {
//       TODO: create method to click on button with text
    }

    public void waitUntilPageAjaxLoadCompleted(){
//        TODO: define page load and ajax loaded completely
    }

    public void executeJScript(String script){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript(script);
    }

    public void closeDriver(){
        driver.close();
   }
}