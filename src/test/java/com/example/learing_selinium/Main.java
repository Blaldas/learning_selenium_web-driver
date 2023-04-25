package com.example.learing_selinium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static utils.Utils.initWebDriver;

public class Main {


    public static void main(String [] args){
        WebDriver driver = initWebDriver();



        Facebook facebookPage = new Facebook(driver);
      //  facebookPage.changeWaitPolling(1000);
     //   facebookPage.changeWaitTimeOut(10);

          facebookPage.login("src/credentials");
  //      System.out.println("Login done successfully");
        while(true) {
     //       facebookPage.sendMessage2Friend("rita", "teste de selinium");
     //       System.out.println("Message sent successfully");
        }

        //Youtube youtubePage = new Youtube(driver);
        //youtubePage.seach4Video("pyron gets the highlight");


    }


}
