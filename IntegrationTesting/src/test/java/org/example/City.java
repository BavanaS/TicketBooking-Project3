package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class City
{
    public void enterCity(WebDriver driver,String city) throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Search for your city']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search for your city']")).sendKeys(city);

    }
    public void selectCity(WebDriver driver) throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='bwc__sc-ttnkwg-14 flGQbT']")).click();
    }
}
