package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.FileNotFoundException;

import java.time.Duration;
import java.util.*;


public class Utils {

    public static WebDriver initWebDriver(){
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
        System.setProperty("webdriver.chrome.driver", "C:/Users/marcdomingues/Downloads/chromedriver.exe");
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

    /**
     * Used to initialize the wait.
     * The wait is private and has limmited acess.
     * The wait is used here in order to make the waiting process invisible outside this class
     */
    public static Wait initWait(WebDriver driver){
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(NoSuchElementException.class);

        return wait;
    }

}
