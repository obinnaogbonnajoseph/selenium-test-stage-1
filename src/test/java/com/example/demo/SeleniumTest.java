package com.example.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SeleniumTest {
    @Test
    public static void main(String[] args) throws InterruptedException {
        // setup chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // open browser to the api
        driver.get("http://localhost:8080/animal");
        // get the input elements and write to them
        var textElement = driver.findElement(By.id("animalText"));
        var adjectiveElement = driver.findElement(By.id("adjective"));
        textElement.sendKeys("Dog");
        adjectiveElement.sendKeys("Cute");
        // submit 5 times;
        int count = 0;
        while(count < 5) {
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            ++count;
        }
        // display conclusion message
        var conclusionMessageText = driver
                .findElement(By.className("conclusionMessage")).getText();
        System.out.println(conclusionMessageText);
        Thread.sleep(5000);
        driver.quit();
    }
}
