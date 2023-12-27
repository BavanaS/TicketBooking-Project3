package org.example;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Movie
{
    public void enterMovie(WebDriver driver, String movie) throws InterruptedException
    {
        driver.findElement(By.xpath("//span[@class='bwc__sc-1nbn7v6-8 hbuyht']")).click();

        WebElement searchBar=driver.findElement(By.xpath("//input[@placeholder='Search for Movies, Events, Plays, Sports and Activities']"));
        searchBar.click();
        searchBar.sendKeys(movie);
        Thread.sleep(2000);

        List<WebElement> suggestion=driver.findElements(By.xpath("//div[@class='bwc__sc-3t17w7-58 fjWgDR']"));
        for(WebElement i: suggestion)
        {
                Assert.assertEquals(i.getText(),movie);

        }
        searchBar.clear();
    }

    public void selectMovie(WebDriver driver, String movie)
    {
        List<WebElement> movieSelect=driver.findElements(By.xpath("//span[@class='bwc__sc-3t17w7-45 bjOabr']"));
        for(WebElement i: movieSelect)
        {
            Assert.assertEquals(i.getText(),movie);
                i.click();
               break;

        }
    }
}
