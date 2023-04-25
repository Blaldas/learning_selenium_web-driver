package com.example.learing_selinium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utils.Utils;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Facebook {

    WebDriver driver;
    Utils utils;


    /**
     * @param driver the webDriver
     *               Opens the facebook page and accpts terms
     */
    public Facebook(WebDriver driver) {

        this.driver = driver;
        utils = new Utils(driver);

        //goes to the website - to be improved
        utils.goToWebsite("https://www.facebook.com/");

        //accepts terms
        Utils.clickByXpath("//button[@data-testid='cookie-policy-manage-dialog-accept-button']");


        //initiates the wait
      //  wait = (FluentWait) Utils.initWait(driver);
    }

    /**
     * @param credentialsPath path to file composed by:
     *                        line 1: email
     *                        line 2: password
     * @return TRUE if successfully logged in, FALSE otherwise
     */
    public void login(String credentialsPath) {
        //gets pass and email
        List<String> creds = null;
        try {
            creds = Utils.readCredentials(credentialsPath);
        } catch (FileNotFoundException e) {
            driver.quit();
            e.printStackTrace();
        }
        //introduces email and pass
        Utils.inputOnElement("//input[@name='email']", creds.get(0));
        Utils.inputOnElement("//input[@name='pass']", creds.get(1));

        //clicks to login
        Utils.clickByXpath("//button[@name='login']");

        System.exit(0);
        Utils.waitForElement("//div[@data-pagelet='TopOfHome']");

    }

/*
    /**
     * @param seconds maximun time to some intem in the site to load
     *                This method is not necessary and should only be used in cases where the default timeout is not enought to let the site load

    public void changeWaitTimeOut(int seconds) {
        wait.withTimeout(Duration.ofSeconds(seconds));
    }


    public void changeWaitPolling(int milliseconds) {
        wait.pollingEvery(Duration.ofMillis(milliseconds));
    }

    /**
     * @param friendName the friend's name (must result in the friend appearing as the first result from the Facebook's chat search)
     * @param msg        the message to be send
     * @return TRUE if no errors occurred, FALSE otherwise
     * <p>
     * This method is used to send some message to a friend using the facebook chat
     *
    public boolean sendMessage2Friend(String friendName, String msg) {

        try {
            //searches for friend
        //    WebElement btnSearch = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div[1]/div[1]/div/div[3]/div/div/div[1]/div/div[2]/div/div[1]/div/div/div/div/span/div/div[2]/div/div[2]/div/div/div/span[2]/div/div"));
         //   btnSearch.click();


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div[5]/div/div[1]/div[1]/div[1]/div/div/div/div/div/div[2]/div/div/div[2]/div[1]/div/div[1]/input")));

            WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[5]/div/div[1]/div[1]/div[1]/div/div/div/div/div/div[2]/div/div/div[2]/div[1]/div/div[1]/input"));
            searchBox.sendKeys(friendName);

            //clicks on friend from list
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div[5]/div/div[1]/div[1]/div[1]/div/div/div/div/div/div[2]/div/div/div[2]/div[2]/div/div[1]/ul/li[1]/ul/li[1]/div/a/div/div[2]/div/div/span/span/span\n")));
            WebElement initChat = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[5]/div/div[1]/div[1]/div[1]/div/div/div/div/div/div[2]/div/div/div[2]/div[2]/div/div[1]/ul/li[1]/ul/li[1]/div/a/div/div[2]/div/div/span/span/span\n"));
            initChat.click();

            //writes mesage
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div[5]/div/div[1]/div[1]/div[1]/div/div/div/div/div/div[1]/div[1]")));
            WebElement chatMessage = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[5]/div/div[1]/div[1]/div[1]/div/div/div/div/div/div[3]/div/div/div[2]/form/div/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div"));
            chatMessage.sendKeys(msg + "\n");

            System.out.println("Message sent successfully!");
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
*/
}
