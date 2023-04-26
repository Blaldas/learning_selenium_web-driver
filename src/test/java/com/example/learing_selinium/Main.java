package com.example.learing_selinium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Utils;

import java.util.HashMap;
import java.util.Map;

import static utils.Utils.initWebDriver;

public class Main {


    public static void main(String[] args) {
        WebDriver driver = initWebDriver();


        Facebook facebookPage = new Facebook(driver);
        //  facebookPage.changeWaitPolling(1000);
        //   facebookPage.changeWaitTimeOut(10);

        facebookPage.login("src/credentials");
        System.out.println("Login done successfully");
        facebookPage.openFriendChat("Erica Oliveira");
        while (true) {
            Utils.waitXMiliseconds(100);
            facebookPage.sendChatMsg("Test");
        }

        //Youtube youtubePage = new Youtube(driver);
        //youtubePage.seach4Video("pyron gets the highlight");


    }


}
