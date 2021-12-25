package com.example.learing_selinium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utils.Utils;


public class Youtube {

    WebDriver driver;
    FluentWait wait;    //The wait is used here in order to make the waiting process invisible outside this class

    public Youtube(WebDriver driver) {
        this.driver = driver;

        //indica site para entrar
        driver.get("https://www.youtube.com/");

        //initiates the wait
        wait = (FluentWait) Utils.initWait(driver);

        //accepts terms
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ytd-app/ytd-consent-bump-v2-lightbox/tp-yt-paper-dialog/div[4]/div[2]/div[5]/div[2]/ytd-button-renderer[2]/a/tp-yt-paper-button/yt-formatted-string")));
        WebElement acTerms = driver.findElement(By.xpath("/html/body/ytd-app/ytd-consent-bump-v2-lightbox/tp-yt-paper-dialog/div[4]/div[2]/div[5]/div[2]/ytd-button-renderer[2]/a/tp-yt-paper-button/yt-formatted-string"));
        acTerms.click();

    }

    public void seach4Video(String search) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div[1]/div[1]/input")));
        WebElement searchBox = driver.findElement(By.xpath("/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div[1]/div[1]/input"));
        searchBox.click();
        searchBox.sendKeys(search + "\n");


        //selects video
        //style-scope ytd-item-section-renderer
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/ytd-thumbnail/a/yt-img-shadow/img")));
        WebElement firstVideo = driver.findElement(By.xpath("/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/ytd-thumbnail/a/yt-img-shadow/img"));
        firstVideo.click();

    }
}
