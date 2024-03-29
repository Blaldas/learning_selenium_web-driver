package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;

import java.time.Duration;
import java.util.*;


public class Utils {

    static WebDriver driver;
    static WebDriverWait waitDriver;

    //wait for getElement
    private static int defaultWait = 3;


    private Utils() {
    }

    public Utils(WebDriver driver) {
        this.driver = driver;
        waitDriver = new WebDriverWait(driver, 30);
    }

    public static WebDriver initWebDriver() {
        //Create a map to store  preferences
        Map<String, Object> prefs = new HashMap<String, Object>();

        //add key and value to map as follow to switch off browser notification
        //Pass the argument 1 to allow and 2 to block
        prefs.put("profile.default_content_setting_values.notifications", 2);

        //Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // set ExperimentalOption - prefs
        options.setExperimentalOption("prefs", prefs);

        //define localização do webdriver e inicializa webdriver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        return new ChromeDriver(options);
    }

    public static List<String> readCredentials(String filePathAndName) throws FileNotFoundException {
        List<String> credList = new ArrayList<>();


        File f = new File(filePathAndName);
        Scanner scanner = new Scanner(f);

        credList.add(scanner.nextLine());   //email
        credList.add(scanner.nextLine());   //pass


        return credList;
    }


    public static WebElement getElementByXpath(String xpath) {
        List<WebElement> elementsList = driver.findElements(By.xpath(xpath));
        if (elementsList.size() == 0) {
            waitForElement(xpath);
            elementsList = driver.findElements(By.xpath(xpath));
            System.out.println("fail");
            if (elementsList.size() == 0) {
                Assert.fail("The element with the following xpath was not found:\n" + xpath);
            }
        }
        return elementsList.get(0);
    }


    private static void quitWebDriver() {
        driver.quit();
    }

    public static void clickByXpath(String xpath) {
        WebElement element = getElementByXpath(xpath);

        Actions actions = new Actions(driver);
        try {
            actions.click(element);
            actions.perform();
        } catch (Exception e) {
            Assert.fail("It was not possible to click on the element with the following xpath: " + xpath);
        }
    }

    public static void goToWebsite(String website) {
        driver.get(website);
    }

    public static void inputOnElement(String xpath, String input) {
        WebElement element = getElementByXpath(xpath);

        Actions actions = new Actions(driver);
        try {
            actions.sendKeys(element, input);
            actions.perform();
        } catch (Exception e) {
            Assert.fail("It was not possible to write input on the element with the following xpath: " + xpath);
        }
    }

    public static void waitForElement(String xpath) {
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void waitXSeconds(int seconds) {
        waitXMiliseconds(seconds * 1000);
    }

    public static void waitXMiliseconds(int mil) {
        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
            Assert.fail(e.getMessage());
        }
    }
}
